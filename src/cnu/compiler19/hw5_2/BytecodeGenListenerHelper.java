package cnu.compiler19.hw5_2;

import cnu.compiler19.hw5_2.MiniCParser.ExprContext;
import cnu.compiler19.hw5_2.MiniCParser.Fun_declContext;
import cnu.compiler19.hw5_2.MiniCParser.If_stmtContext;
import cnu.compiler19.hw5_2.MiniCParser.Local_declContext;
import cnu.compiler19.hw5_2.MiniCParser.ParamContext;
import cnu.compiler19.hw5_2.MiniCParser.ParamsContext;
import cnu.compiler19.hw5_2.MiniCParser.Type_specContext;
import cnu.compiler19.hw5_2.MiniCParser.Var_declContext;

public class BytecodeGenListenerHelper {
	
	// <boolean functions>
	
	static boolean isFunDecl(MiniCParser.ProgramContext ctx, int i) {
		return ctx.getChild(i).getChild(0) instanceof MiniCParser.Fun_declContext;
	}
	
	// type_spec IDENT '[' ']'
	static boolean isArrayParamDecl(ParamContext param) {
		return param.getChildCount() == 4;
	}
	
	// global vars
	static int initVal(Var_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	// var_decl	: type_spec IDENT '=' LITERAL ';
	static boolean isDeclWithInit(Var_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	// var_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static boolean isArrayDecl(Var_declContext ctx) {
		return ctx.getChildCount() == 6;
	}

	// <local vars>
	// local_decl	: type_spec IDENT '[' LITERAL ']' ';'
	static int initVal(Local_declContext ctx) {
		return Integer.parseInt(ctx.LITERAL().getText());
	}

	static boolean isArrayDecl(Local_declContext ctx) {
		return ctx.getChildCount() == 6;
	}
	
	static boolean isDeclWithInit(Local_declContext ctx) {
		return ctx.getChildCount() == 5 ;
	}
	
	static boolean isVoidF(Fun_declContext ctx) {
			// <Fill in>
		return ctx.getChild(0).getText() == "void";
	}
	
	static boolean isIntReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 3;
	}


	static boolean isVoidReturn(MiniCParser.Return_stmtContext ctx) {
		return ctx.getChildCount() == 2;
	}
	
	// <information extraction>
	static String getStackSize(Fun_declContext ctx) {
		return "32";
	}
	static String getLocalVarSize(Fun_declContext ctx) {
		return "32";
	}


	static String getTypeText(Type_specContext typespec) {
			// <Fill in>
		return typespec.getText();
	}

	// params
	static String getParamName(ParamContext param) {
		// <Fill in>
		return param.getChild(1).getText();
	}
	
	static String getParamTypesText(ParamsContext params) {
		String typeText = "";
		
		for(int i = 0; i < params.param().size(); i++) {
			MiniCParser.Type_specContext typespec = (MiniCParser.Type_specContext)  params.param(i).getChild(0);
			typeText += getTypeText(typespec); // + ";";
		}
		return typeText;
	}
	
	static String getLocalVarName(Local_declContext local_decl) {
		// <Fill in>
		return local_decl.getChild(1).getText();
	}
	
	static String getFunName(Fun_declContext ctx) {
		// <Fill in>
		return ctx.getChild(1).getText();
	}
	
	static String getFunName(ExprContext ctx) {
		// <Fill in>
		return ctx.getChild(0).getText();
	}
	
	static boolean noElse(If_stmtContext ctx) {
		return ctx.ELSE() == null;
	}
	
	static String getFunProlog() {
		 return
			".class public Test\n" +
			".super java/lang/Object\n" +
			"; strandard initializer\n" +
			"aload_0\n" +
		 	"invokenonvirtual java/lang/Object/<init>()V\n" +
		 	"return\n" +
		 	".end method" + "\n";
	}
	
	static String getCurrentClassName() {
		return "Test";
	}
}
