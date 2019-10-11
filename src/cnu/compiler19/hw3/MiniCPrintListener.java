package cnu.compiler19.hw3;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MiniCPrintListener extends MiniCBaseListener {

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();

    // *** Description *** : exitVar_decl
    boolean isArrayDecl(MiniCParser.Var_declContext ctx){
        if(ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("[") && ctx.getChild(4).getText().equals("]");
    }

    // *** Description *** : exitVar_decl
    boolean isInitAndAssignStmt(MiniCParser.Var_declContext ctx){
        if (ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("=");
    }

    // *** Description *** : exitVar_decl
    boolean isLocalVariableDecl(MiniCParser.Var_declContext ctx){
        return ctx.getChildCount() == 3;
    }

    @Override
    public void exitVar_decl(MiniCParser.Var_declContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : type_spec
        // ** ctx.getChild(1) : IDENT
        // ** ctx.getChild(2) : [ or = or ;
        // ** ctx.getChild(3) : IDENT or null
        // ** ctx.getChild(4) : ] or null or ;
        // ** ctx.getChild(5) : ;

        if(isInitAndAssignStmt(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " = " + ctx.getChild(3).getText() + ";");
        }
        else if(isArrayDecl(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + "[" + ctx.getChild(3).getText() + "];");
        }
        else if(isLocalVariableDecl(ctx)) {
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + ";");
        }
    }

    // *** Description *** : exitLocal_decl
    boolean isArrayDecl(MiniCParser.Local_declContext ctx){
        if(ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("[") && ctx.getChild(4).getText().equals("]");
    }

    // *** Description *** : exitLocal_decl
    boolean isInitAndAssignStmt(MiniCParser.Local_declContext ctx){
       if (ctx.getChildCount() < 5) return false;
       return ctx.getChild(2).getText().equals("=");
    }

    // *** Description *** : exitLocal_decl
    boolean isLocalVariableDecl(MiniCParser.Local_declContext ctx){
       return ctx.getChildCount() == 3;
    }

    @Override
    public void exitLocal_decl(MiniCParser.Local_declContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : type_spec
        // ** ctx.getChild(1) : IDENT
        // ** ctx.getChild(2) : [ or = or ;
        // ** ctx.getChild(3) : IDENT or null
        // ** ctx.getChild(4) : ] or null or ;
        // ** ctx.getChild(5) : ;

        if(isInitAndAssignStmt(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + " = " + ctx.getChild(3).getText() + ";");
        }
        else if(isArrayDecl(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + "[" + ctx.getChild(3).getText() + "];");
        }
        else if(isLocalVariableDecl(ctx)) {
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + ";");
        }
    }

    // *** Description *** : enterExpr, exitExpr
    boolean isUnaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 2 &&
                ctx.getChild(1) != ctx.expr();
    }

    // *** Description *** : enterExpr, exitExpr
    boolean isBinaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 3 &&
                ctx.getChild(1) != ctx.expr();
    }

    // *** Description *** : enterExpr, exitExpr
    boolean isFunctionCall(MiniCParser.ExprContext ctx) {
        if (ctx.getChildCount() < 3) return false;
        return ctx.getChild(1).getText().equals("(") &&
                ctx.getChild(2) != ctx.expr();
    }

    // *** Description *** : enterExpr, exitExpr
    boolean hasParentheses(MiniCParser.ExprContext ctx){
        if (ctx.getChildCount() < 2) return false;
        return ctx.getChild(0).getText().equals("(");
    }

    // *** Description *** : enterExpr, exitExpr
    boolean isArrayAssignStmt(MiniCParser.ExprContext ctx){
        if (ctx.getChildCount() < 4) return false;
        return ctx.getChild(1).getText().equals("[") &&
                ctx.getChild(4).getText().equals("=");
    }

    @Override
    public void enterExpr(MiniCParser.ExprContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : UnaryOperator or IDENT or ( or FunctionName
        // ** ctx.getChild(1) : BinaryOperator or (
        // ** ctx.getChild(2) : IDENT(args)
        // ** ctx.getChild(3) : ) or null

       if(isBinaryOperation(ctx)){
            newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
            newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());
       }
        else if(isUnaryOperation(ctx)){
            newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
            newTexts.put(ctx.getChild(1), ctx.getChild(1).getText());
       }
        else if(isArrayAssignStmt(ctx)){
            newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());
            newTexts.put(ctx.getChild(5), ctx.getChild(5).getText());
       }
    }

    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {

        // *** Description ***
        // ** ctx.getChild(0) : UnaryOperator or IDENT or (
        // ** ctx.getChild(1) : BinaryOperator or (
        // ** ctx.getChild(2) : IDENT(args)
        // ** ctx.getChild(3) : ) or null

        if(hasParentheses(ctx)){
            newTexts.put(ctx, "(" + newTexts.get(ctx.getChild(1)) + ")");
            return;
        }

        if(isBinaryOperation(ctx)){
            newTexts.put(ctx, newTexts.get(ctx.getChild(0)) + " " + ctx.getChild(1).getText() + " " + newTexts.get(ctx.getChild(2)));
        }
        else if(isUnaryOperation(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + newTexts.get(ctx.getChild(1)));
        }
        else if(isFunctionCall(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + newTexts.get(ctx.getChild(2)));
        }
        else if(isArrayAssignStmt(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + "[" + newTexts.get(ctx.getChild(2)) + "] = " + newTexts.get(ctx.getChild(5)));
        }

    }

    @Override
    public void enterExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : expr
        // ** ctx.getChild(1) : ;

        newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
    }

    @Override
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : expr
        // ** ctx.getChild(1) : ;

        newTexts.put(ctx, newTexts.get(ctx.getChild(0)) + ";");
    }

    // *** Description *** : exitParam
    boolean hasArrayOperator(MiniCParser.ParamContext ctx){
        if (ctx.getChildCount() < 3) return false;
        return ctx.getChild(2).getText().equals("[");
    }

    @Override
    public void exitParam(MiniCParser.ParamContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : type_spec
        // ** ctx.getChild(1) : IDENT
        // ** ctx.getChild(2) : [ or null
        // ** ctx.getChild(3) : ] or null

        if(hasArrayOperator(ctx)){
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + "[]");
        }
        else {
            newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText());
        }
    }

    @Override
    public void exitParams(MiniCParser.ParamsContext ctx) {
        // *** Description ***
        // ** ctx.getChild(2k) : param
        // ** ctx.getChild(2k - 1) : ,

        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < ctx.getChildCount(); i++){
            if(i % 2 == 1) strBuilder.append(", ");
            else strBuilder.append(newTexts.get(ctx.getChild(i)));
        }

        newTexts.put(ctx, strBuilder.toString());
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
                strBuilder.append("...." + str + "\n");
            }
        }

        newTexts.put(ctx, "{\n" + strBuilder.toString() + "}\n");
    }

    // *** Description *** : exitIf_stmt
    boolean hasElseStmt(MiniCParser.If_stmtContext ctx){
        return ctx.getChildCount() > 5;
    }

    // *** Description *** : exitIf_stmt
    boolean hasBracket(MiniCParser.If_stmtContext ctx){
        if (ctx.getChildCount() < 4) return false;
        String s = newTexts.get(ctx.getChild(4));
        return ctx.getChild(4).getText().equals("{");
    }

    @Override
    public void enterIf_stmt(MiniCParser.If_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : if
        // ** ctx.getChild(1) : (
        // ** ctx.getChild(2) : expr
        // ** ctx.getChild(3) : )
        // ** ctx.getChild(4) : stmt
        // ** ctx.getChild(5) : else or null
        // ** ctx.getChild(6) : stmt or null

        newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());

    }

    @Override
    public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : if
        // ** ctx.getChild(1) : (
        // ** ctx.getChild(2) : expr
        // ** ctx.getChild(3) : )
        // ** ctx.getChild(4) : stmt
        // ** ctx.getChild(5) : else or null
        // ** ctx.getChild(6) : stmt or null

        // if 뒤에 중괄호 안 나올때와 중괄호 나올 때를 어떻게 구분하지??
        // MiniC.g4는 못 바꿈.

        int a = ctx.getChild(4).getChild(0).getChildCount();

        if(hasElseStmt(ctx)){
            newTexts.put(ctx, "if (" + newTexts.get(ctx.getChild(2)) + ")\n"
                    + newTexts.get(ctx.getChild(4).getChild(0))
                    + "else\n" + newTexts.get(ctx.getChild(6).getChild(0)));
        }
        else{
            newTexts.put(ctx, "if (" + newTexts.get(ctx.getChild(2)) + ")\n"
                    + newTexts.get(ctx.getChild(4).getChild(0)));
        }
    }

    @Override
    public void enterWhile_stmt(MiniCParser.While_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : while
        // ** ctx.getChild(1) : (
        // ** ctx.getChild(2) : expr
        // ** ctx.getChild(3) : )
        // ** ctx.getChild(4) : stmt

        newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());

    }

    @Override
    public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : while
        // ** ctx.getChild(1) : (
        // ** ctx.getChild(2) : expr
        // ** ctx.getChild(3) : )
        // ** ctx.getChild(4) : stmt

        newTexts.put(ctx, "while (" + newTexts.get(ctx.getChild(2)) + ")\n"
                + newTexts.get(ctx.getChild(4).getChild(0)));
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

        newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText()
                + "(" + newTexts.get(ctx.getChild(3)) + ")\n" + newTexts.get(ctx.getChild(5)));
    }

    @Override
    public void enterArgs(MiniCParser.ArgsContext ctx) {
        // *** Description ***
        // ** ctx.getChild(2k) : ,
        // ** ctx.getChild(2k - 1) : params

        for (int i = 0; i < ctx.getChildCount(); i++){
            if (i % 2 == 1) continue;
            else newTexts.put(ctx.getChild(i), ctx.getChild(i).getText());
        }
    }

    @Override
    public void exitArgs(MiniCParser.ArgsContext ctx) {
        // *** Description ***
        // ** ctx.getChild(2k) : ,
        // ** ctx.getChild(2k - 1) : params

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("(");
        for (int i = 0; i < ctx.getChildCount(); i++){
            if (i % 2 == 1) strBuilder.append(", ");
            else strBuilder.append(newTexts.get(ctx.getChild(i)));
        }
        strBuilder.append(")");

        newTexts.put(ctx, strBuilder.toString());
    }

    // *** Description *** : enterReturn_stmt, exitReturn_stmt
    boolean hasExpr(MiniCParser.Return_stmtContext ctx){
        return !ctx.getChild(1).getText().equals(";");
    }

    @Override
    public void enterReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : return
        // ** ctx.getChild(1) : ; or expr
        // ** ctx.getChild(2) : ; or null

        if(hasExpr(ctx)){
            newTexts.put(ctx.getChild(1), ctx.getChild(1).getText());
        }
    }

    @Override
    public void exitReturn_stmt(MiniCParser.Return_stmtContext ctx) {
        // *** Description ***
        // ** ctx.getChild(0) : return
        // ** ctx.getChild(1) : ; or expr
        // ** ctx.getChild(2) : ; or null

        if (hasExpr(ctx)){
            newTexts.put(ctx, "return " + newTexts.get(ctx.getChild(1)) + ";");
        }
        else{
            newTexts.put(ctx, "return;");
        }

    }

    @Override
    public void exitProgram(MiniCParser.ProgramContext ctx) {
        // *** Description ***
        // print all string of newTexts

        for (int i = 0; i < ctx.getChildCount(); i++){
            System.out.println(newTexts.get(ctx.getChild(i).getChild(0)));
        }
    }
}
