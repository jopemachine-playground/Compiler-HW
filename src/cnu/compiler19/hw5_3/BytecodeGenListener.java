package cnu.compiler19.hw5_3;

import org.antlr.v4.runtime.tree.*;

import cnu.compiler19.hw5_3.MiniCParser.ParamsContext;

import static cnu.compiler19.hw5_3.BytecodeGenListenerHelper.*;
import static cnu.compiler19.hw5_3.SymbolTable.*;

import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BytecodeGenListener extends MiniCBaseListener implements ParseTreeListener {
	ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
	SymbolTable symbolTable = new SymbolTable();

	int tab = 0;
	int label = 0;

	// program	: decl+
	@Override
	public void enterFun_decl(MiniCParser.Fun_declContext ctx) {
		symbolTable.initFunDecl();

		String fname = getFunName(ctx);
		ParamsContext params;

		if (fname.equals("main")) {
			symbolTable.putLocalVar("args", Type.INTARRAY);
		} else {
			symbolTable.putFunSpecStr(ctx);
			params = (ParamsContext) ctx.getChild(3);
			symbolTable.putParams(params);
		}
	}

	// var_decl	: type_spec IDENT ';' | type_spec IDENT '=' LITERAL ';'|type_spec IDENT '[' LITERAL ']' ';'
	@Override
	public void enterVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();

		if (isArrayDecl(ctx)) {
			symbolTable.putGlobalVar(varName, Type.INTARRAY);
		}
		else if (isDeclWithInit(ctx)) {
			symbolTable.putGlobalVarWithInitVal(varName, Type.INT, initVal(ctx));
		}
		else  { // simple decl
			symbolTable.putGlobalVar(varName, Type.INT);
		}
	}


	@Override
	public void enterLocal_decl(MiniCParser.Local_declContext ctx) {

		String declTypeStr = ctx.getChild(0).getText();
		Type declType = null;

		if (isArrayDecl(ctx)) {
			symbolTable.putLocalVar(getLocalVarName(ctx), Type.INTARRAY);
		}
		else if (isDeclWithInit(ctx)) {

			symbolTable.putLocalVarWithInitVal(getLocalVarName(ctx), Type.INT, initVal(ctx));

		}
		else  { // simple decl

			switch (declTypeStr){
				case "int":
					declType = Type.INT;
					break;
				case "double":
					declType = Type.DOUBLE;
					break;
				case "char":
					declType = Type.CHAR;
					break;
			}

			symbolTable.putLocalVar(getLocalVarName(ctx), declType);

		}
	}


	@Override
	public void exitProgram(MiniCParser.ProgramContext ctx) {
		String classProlog = getFunProlog();

		String fun_decl = "", var_decl = "";

		for(int i = 0; i < ctx.getChildCount(); i++) {
			if(isFunDecl(ctx, i))
				fun_decl += newTexts.get(ctx.decl(i));
			else
				var_decl += newTexts.get(ctx.decl(i));
		}

		newTexts.put(ctx, classProlog + var_decl + fun_decl);

		// 컴파일된 j 파일을 콘솔에 출력
		System.out.println(newTexts.get(ctx));

		// 테스트를 위한 Test.j 파일 생성
		File file = new File(System.getProperty("user.dir") + "\\" + "Test.j");

		try {
		  FileWriter fw = new FileWriter(file);
		  fw.write(newTexts.get(ctx));
		  fw.close();
		} catch (IOException e) {
		  e.printStackTrace();
		}
	}

	// decl	: var_decl | fun_decl
	@Override
	public void exitDecl(MiniCParser.DeclContext ctx) {
		String decl = "";
		if(ctx.getChildCount() == 1)
		{
			if(ctx.var_decl() != null)
				// var_decl
				decl += newTexts.get(ctx.var_decl());
			else
				// fun_decl
				decl += newTexts.get(ctx.fun_decl());
		}
		newTexts.put(ctx, decl);
	}

	// stmt	: expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt
	@Override
	public void exitStmt(MiniCParser.StmtContext ctx) {
		String stmt = "";
		// ctx의 타입에 따라 알맞은 Stmt를 붙여 newTexts에 넣어놓는다.
		if(ctx.getChildCount() > 0)
		{
			if(ctx.expr_stmt() != null) {
				stmt += newTexts.get(ctx.expr_stmt());
			}
			else if(ctx.compound_stmt() != null) {
				stmt += newTexts.get(ctx.compound_stmt());
			}
			else if(ctx.if_stmt() != null){
				stmt += newTexts.get(ctx.if_stmt());
			}
			else if(ctx.while_stmt() != null){
				stmt += newTexts.get(ctx.while_stmt());
			}
			else if(ctx.return_stmt() != null){
				stmt += newTexts.get(ctx.return_stmt());
			}
		}
		newTexts.put(ctx, stmt);
	}

	// expr_stmt	: expr ';'

	@Override
	public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
		String stmt = "";

		if(ctx.getChildCount() == 2)
		{
			stmt += newTexts.get(ctx.expr());
		}

		// rtrim
		String result = stmt.replaceAll("\\s+$","");

		newTexts.put(ctx, result);
	}

	// while_stmt	: WHILE '(' expr ')' stmt
	@Override
	public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
		// *** Description ***
		// ** ctx.getChild(0) : while
		// ** ctx.getChild(1) : (
		// ** ctx.getChild(2) : expr
		// ** ctx.getChild(3) : )
		// ** ctx.getChild(4) : stmt

		String res = "";

		String condExpr= newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt());

		String lend = symbolTable.newLabel();
		String lstart = symbolTable.newLabel();

		res +=
				// 조건이 거짓일 될 때 돌아올 start lbl
				lstart + ":\n"
				// 조건
				+ condExpr
				// 조건 검사	 후 거짓이면 end로 jump
                + "ifeq\t" + lend + "\n"
				// 참이면 thenStmt가 실행되고, 반복
				+ thenStmt
                + "goto\t" + lstart + "\n"
				// 거짓일 때 점프하는 label
				+ lend + ":";

		newTexts.put(ctx, res);

	}

	@Override
	public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
		// *** Description ***
		// ** ctx.getChild(0) : type_decl
		// ** ctx.getChild(1) : IDENT(FunctionName)
		// ** ctx.getChild(2) : (
		// ** ctx.getChild(3) : params
		// ** ctx.getChild(4) : )
		// ** ctx.getChild(5) : compound_stmts

        String res = "";
        String voidRet = "";
		String funcBody = newTexts.get(ctx.getChild(5));

		// void 함수에 return 문이 없는 경우 붙여줘야 함
		if(ctx.compound_stmt().getChild(ctx.compound_stmt().getChildCount() - 2).getText().startsWith("return") == false){
			voidRet = "return\n";
		}

		res = funcHeader(ctx, ctx.getChild(1).getText()) + funcBody + voidRet + ".end method" + "\n";

		newTexts.put(ctx, res);
	}

	private String funcHeader(MiniCParser.Fun_declContext ctx, String fname) {
		return ".method public static " + symbolTable.getFunSpecStr(fname) + "\n" +
				".limit stack " + getStackSize(ctx) + "\n" +
				".limit locals " + getLocalVarSize(ctx) + "\n";
	}

	@Override
	public void exitVar_decl(MiniCParser.Var_declContext ctx) {
		String varName = ctx.IDENT().getText();
		String varDecl = "";

		if (isDeclWithInit(ctx)) {
			varDecl += "putfield " + varName + "\n";
			// v. initialization => Later! skip now..:
		}

		newTexts.put(ctx, varDecl);
	}

	@Override
	public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
		String varDecl = "";

		String vId = symbolTable.getVarId(ctx);

		if (isDeclWithInit(ctx)) {

			String rhsValue = ctx.getChild(3).getText();

			String typePrev = null;

			// 변수로 초기화 할 경우
			String var = symbolTable.getVarId(rhsValue);

			if(var != null){
				typePrev = SymbolTable.typeToPrev.get(symbolTable.getVarType(rhsValue));
				varDecl += "load_" + var + "\n";
			}
			else {
				// 정수 값으로 초기화 할 경우
				String declType = ctx.getChild(0).getText();

				switch (declType){
					case "int":
					    typePrev = "i";
						varDecl += "ldc " + rhsValue + "\n";
						break;
					case "char":
						break;
					case "double":
					    typePrev = "d";
						varDecl += "ldc " + rhsValue + "\n";
						break;
				}
			}

			varDecl += typePrev + "store_" + vId + "\n";
		}
		else if(ctx.getChild(2).getText().equals("[") &&
				ctx.getChild(4).getText().equals("]"))
		{
			// 배열의 경우
			String arrType = ctx.getChild(0).getText();
			String arrSize = ctx.getChild(3).getText();

			varDecl += "sipush	" + arrSize  + "\n"
					+  "newarray	" + arrType + "\n"
			 		+  "astore_" + vId;
		}
		// 선언만 하는 경우
		else {

		}

		newTexts.put(ctx, varDecl);
	}


	// *** Description *** : exitCompound_stmt
	boolean isExprStmt(MiniCParser.Compound_stmtContext ctx, int index){
		return newTexts.get(ctx.getChild(index).getChild(0)) != null;
	}

	// *** Description *** : exitCompound_stmt
	boolean isNormalStmt(MiniCParser.Compound_stmtContext ctx, int index){
		return newTexts.get(ctx.getChild(index).getChild(0)) == null;
	}

	@Override
	public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
		// <(3) Fill here>
		// *** Description ***
		// ** ctx.getChild(0) : {
		// ** ctx.getChild(1) : statement or local_decl
		// ** ctx.getChild(...) : statement or local_decl
		// ** ctx.getChild(stmtNum) : statement or local_decl
		// ** ctx.getChild(stmtNum + 1) : }

		int nodeNum = ctx.getChildCount();
		int stmtNum = nodeNum - 2;

		StringBuilder strBuilder = new StringBuilder();

		for (int i = 0; i < stmtNum; i++){

			ParseTree node = null;

			if(isNormalStmt(ctx, i + 1)){
				node = ctx.getChild(i + 1);
			}
			else if(isExprStmt(ctx, i + 1)){
				node = ctx.getChild(i + 1).getChild(0);
			}

			String[] content = newTexts.get(node).split("\n");

			for (String str : content) {
				if(str == "") continue;
				strBuilder.append(str + "\n");
			}
		}

		newTexts.put(ctx, strBuilder.toString());
	}

	// if_stmt	: IF '(' expr ')' stmt | IF '(' expr ')' stmt ELSE stmt;
	@Override
	public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
		String stmt = "";
		String condExpr= newTexts.get(ctx.expr());
		String thenStmt = newTexts.get(ctx.stmt(0));

		String lend = symbolTable.newLabel();
		String lelse = symbolTable.newLabel();

		if(noElse(ctx)) {
			stmt +=
					// cond가 참이면 1을 로드, 거짓이면 0을 로드
					condExpr
					// 거짓이면 lend로 jump
					+ "ifeq\t" + lend + "\n"
					// 참이면 thenStmt가 실행됨
					+ thenStmt
					// 거짓일 때 점프하는 label
					+ lend + ":";
		}
		else {
			String elseStmt = newTexts.get(ctx.stmt(1));

			stmt +=
					// cond가 참이면 1을 로드, 거짓이면 0을 로드
					condExpr
					// 거짓이면 else로 jump
					+ "ifeq\t" + lelse + "\n"
					// 참이면 thenStmt 실행
					+ thenStmt
					// 실행 후 end 라벨로 이동
					+ "goto\t" + lend + "\n"
					// 거짓일 때 실행되는 else 라벨
					+ lelse + ":\n"
					// else Stmt
					+ elseStmt
					// end 라벨
					+ lend + ":\n";
		}

		newTexts.put(ctx, stmt);
	}

	// return_stmt	: RETURN ';' | RETURN expr ';'
	@Override
	public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
		// *** Description ***
		// ** ctx.getChild(0) : return
		// ** ctx.getChild(1) : ; or expr
		// ** ctx.getChild(2) : ; or null

		String typePrev = SymbolTable.typeToPrev.get(symbolTable.getVarType(ctx.getChild(1).getText()));

		// Void. 리턴할 값이 따로 없음
		if (typePrev == "") {
			newTexts.put(ctx, "return" + "\n");
		}
		else {
			// 변수를 리턴하는 경우
			String loadedVal = symbolTable.getVarId(ctx.getChild(1).getText());

			newTexts.put(ctx,
					typePrev + "load_" + loadedVal + "\n" +
							typePrev + "return" + "\n");
		}
	}

	@Override
	public void exitExpr(MiniCParser.ExprContext ctx) {
		String expr = "";

//		System.out.println(ctx.getChild(0).getText());
//		System.out.println(ctx.getText());

		if(ctx.getChildCount() <= 0) {
			newTexts.put(ctx, "");
			return;
		}

		if(ctx.getChildCount() == 1) { // IDENT | LITERAL
			if(ctx.IDENT() != null) {

				String idName = ctx.IDENT().getText();

				String typePrev = SymbolTable.typeToPrev.get(symbolTable.getVarType(idName));

				if(typePrev != null){
					expr += typePrev + "load_" + symbolTable.getVarId(idName) + "\n";
				}

				//else	// Type int array => Later! skip now..
				//	expr += "           lda " + symbolTable.get(ctx.IDENT().getText()).value + " \n";
			}
			else if (ctx.LITERAL() != null) {

//				String vId = symbolTable.getVarId(ctx.getChild(1).getText());
				String literal = ctx.LITERAL().getText();

				// char
				if(literal.startsWith("'") && literal.endsWith("'")){
					int charValue = literal.charAt(1);
					expr += "sipush " + charValue + "\n";
				}
				else {
					expr += "sipush " + literal + " \n";
				}
			}
		}

		else if(ctx.getChildCount() == 2) {
			// UnaryOperation
			expr = handleUnaryExpr(ctx, "");
		}

		else if(ctx.getChildCount() == 3) {

			if(ctx.getChild(0).getText().equals("(")) {
				// '(' expr ')'
				expr = newTexts.get(ctx.expr(0));
			}

			else if(ctx.getChild(1).getText().equals("=")) {

				Type type = symbolTable.getVarType(ctx.getChild(0).getText());
				String typePrev = typeToPrev.get(type);

				// IDENT '=' expr
				if(typePrev != null) {
					expr += newTexts.get(ctx.expr(0)) + typePrev + "store_"	+ symbolTable.getVarId(ctx.IDENT().getText()) + "\n";
				}

			}
			else {
				// binary operation
				expr = handleBinExpr(ctx, "");
			}
		}
		// IDENT '(' args ')' |  IDENT '[' expr ']'
		else if(ctx.getChildCount() == 4) {
			if(ctx.args() != null){
				// function calls
				expr = handleFunCall(ctx, expr);
			} else {
				// expr
				// Arrays: TODO

			}
		}
		// IDENT '[' expr ']' '=' expr
		else { // Arrays: TODO			*/

			String vId = symbolTable.getVarId(ctx.getChild(0).getText());
			String index = ctx.getChild(2).getText();
			String value = ctx.getChild(5).getText();

			expr += "aload_" + vId + "\n" +
					"sipush    " + index + "\n" +
					"bipush    " + value + "\n" +
					"iastore" + "\n";
		}

		newTexts.put(ctx, expr);
	}

	private String handleUnaryExpr(MiniCParser.ExprContext ctx, String expr) {

		String l1 = symbolTable.newLabel();
		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();

		expr += newTexts.get(ctx.expr(0));

		switch(ctx.getChild(0).getText()) {

			case "-":
				expr += "ineg \n";
				break;

			case "--":
				expr += "ldc 1" + "\n"
						+ "isub" + "\n";
				break;

			case "++":
				expr += "ldc 1" + "\n"
						+ "iadd" + "\n";
				break;

			case "!":
				expr += "ifeq " + l2 + "\n"
						+ l1 + ": " + "ldc 0" + "\n"
						+ "goto " + lend + "\n"
						+ l2 + ": " + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;
		}

		return expr;
	}

	private String handleBinExpr(MiniCParser.ExprContext ctx, String expr) {

		String l2 = symbolTable.newLabel();
		String lend = symbolTable.newLabel();

		expr += newTexts.get(ctx.expr(0));
		expr += newTexts.get(ctx.expr(1));

		String typePrev = null;

		Type firstOperandType = symbolTable.getVarType(ctx.getChild(0).getText());

		if(firstOperandType == Type.DOUBLE) {
			typePrev = "d";
		}
		else {
			String secondOperand = ctx.getChild(2).getText();

			// 피연산자를 i로 두는 경우
			try {
				Integer.parseInt(secondOperand);
				typePrev = "i";
			}
			// 피연산자를 d로 두는 경우
			catch(NumberFormatException e) {
				Double.parseDouble(secondOperand);
				typePrev = "d";
			}
		}

		switch (ctx.getChild(1).getText()) {

			case "*":
				expr += typePrev + "mul \n";
				break;

			case "/":
				expr += typePrev + "div \n";
				break;

			case "%":
				expr += typePrev + "rem \n";
				break;

			case "+":
				expr += typePrev + "add \n";
				break;

			case "-":
				expr += typePrev + "sub \n";
				break;

			case "==":
				expr += typePrev + "sub " + "\n"
						+ "ifeq\t" + l2 + "\n"
						+ "ldc 0" + "\n"
						+ "goto\t" + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

			case "!=":
				expr += typePrev + "sub " + "\n"
						+ "ifne\t" + l2 + "\n"
						+ "ldc 0" + "\n"
						+ "goto\t" + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

			// <, <=, >, >= 의 경우 모두 같은 로직에서 명령어만 다르므로
			// <의 경우만 주석을 달았습니다.
			case "<":
				expr +=
						// push된 두 값을 뺌
						typePrev + "sub " + "\n"
						// 뺀 결과가 0보다 작다면 l2로 점프
						+ "iflt\t" + l2 + "\n"
						// 뺀 결과가 0보다 크거나 같다면 식이 거짓이므로 0을 로드
						+ "ldc 0" + "\n"
						// 0을 로드하고 end label로 이동
						+ "goto\t" + lend + "\n"
						// l2 라벨. 1을 로드
						+ l2 + ": \n" + "ldc 1" + "\n"
						// lend 라벨.
						+ lend + ": " + "\n";
				break;

			case "<=":
				expr += typePrev + "sub " + "\n"
						+ "ifle\t" + l2 + "\n"
						+ "ldc 0" + "\n"
						+ "goto\t" + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

			case ">=":
				expr += typePrev + "sub " + "\n"
						+ "ifge\t" + l2 + "\n"
						+ "ldc 0" + "\n"
						+ "goto\t" + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

			case ">":
				expr += typePrev + "sub " + "\n"
						+ "ifgt\t" + l2 + "\n"
						+ "ldc 0" + "\n"
						+ "goto\t" + lend + "\n"
						+ l2 + ": \n" + "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

			case "and":
				expr +=
						// 0이 아니면, 즉 참(1) 일때 end로 이동. 1을 그대로 top에 갖고 있으니,
						// 다음 조건이 실행됨
						"ifne\t" + lend + "\n"
						// pop
						+ "pop" + "\n"
						// 0. 거짓.
						+ "ldc 0" + "\n"
						// 참일 땐 빠져나감
						+ lend + ": " + "\n";
				break;

			case "or":
				expr +=
						"ifeq\t" + lend + "\n"
						+ "pop" + "\n"
						+ "ldc 1" + "\n"
						+ lend + ": " + "\n";
				break;

		}
		return expr;
	}

	private String handleFunCall(MiniCParser.ExprContext ctx, String expr) {
		String fname = getFunName(ctx);

		if (fname.equals("_print")) {
			expr = "getstatic java/lang/System/out Ljava/io/PrintStream;" + "\n"
					+ newTexts.get(ctx.args())
					+ "invokevirtual " + symbolTable.getFunSpecStr("_print") + "\n";
		} else {
			expr = newTexts.get(ctx.args())
					+ "invokestatic " + getCurrentClassName()+ "/" + symbolTable.getFunSpecStr(fname) + "\n";
		}
		return expr;
	}

	// args	: expr (',' expr)* | ;
	@Override
	public void exitArgs(MiniCParser.ArgsContext ctx) {

		String argsStr = "";

		for (int i = 0; i < ctx.expr().size(); i++) {
			argsStr += newTexts.get(ctx.expr(i));
		}

		newTexts.put(ctx, argsStr);
	}

}


