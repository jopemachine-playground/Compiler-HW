package cnu.compiler19.hw3;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MiniCPrintListener extends MiniCBaseListener {

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();

    boolean isArrayDecl(MiniCParser.Var_declContext ctx){
        if(ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("[") && ctx.getChild(4).getText().equals("]");
    }

    boolean isInitAndAssignStmt(MiniCParser.Var_declContext ctx){
        if (ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("=");
    }

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

        // *** Debugging ***
        // String s = ctx.getText();
        // String s1 = ctx.getChild(0).getText();
        // String s2 = ctx.getChild(1).getText();
        // String s3 = ctx.getChild(2).getText();
        // String s4 = ctx.getChild(3).getText();
        // String s5 = ctx.getChild(4).getText();

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


    boolean isArrayDecl(MiniCParser.Local_declContext ctx){
        if(ctx.getChildCount() < 5) return false;
        return ctx.getChild(2).getText().equals("[") && ctx.getChild(4).getText().equals("]");
    }

    boolean isInitAndAssignStmt(MiniCParser.Local_declContext ctx){
       if (ctx.getChildCount() < 5) return false;
       return ctx.getChild(2).getText().equals("=");
    }

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

        // *** Debugging ***
        // String s = ctx.getText();
        // String s1 = ctx.getChild(0).getText();
        // String s2 = ctx.getChild(1).getText();
        // String s3 = ctx.getChild(2).getText();
        // String s4 = ctx.getChild(3).getText();
        // String s5 = ctx.getChild(4).getText();

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

    boolean isUnaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 2 &&
                ctx.getChild(1) != ctx.expr();
    }

    boolean isBinaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 3 &&
                ctx.getChild(1) != ctx.expr();
    }

    boolean isFunctionCall(MiniCParser.ExprContext ctx) {
        if (ctx.getChildCount() < 3) return false;
        return ctx.getChild(1).getText().equals("(") &&
                ctx.getChild(2) != ctx.expr();
    }


    @Override
    public void enterExpr(MiniCParser.ExprContext ctx) {
        String s1 = null, s2 = null, op = null;

       if(isBinaryOperation(ctx)){
            s1 = ctx.getChild(0).getText();
            op = ctx.getChild(1).getText();
            s2 = ctx.getChild(2).getText();

            // *** Debugging ***
            // String s1_d, s2_d, s3_d;
            // s1_d = ctx.getChild(0).getText();
            // s2_d = ctx.getChild(1).getText();
            // s3_d = ctx.getChild(2).getText();

            newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
            newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());
       }
        else if(isUnaryOperation(ctx)){
            op = ctx.getChild(0).getText();
            s1 = ctx.getChild(1).getText();

            newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
            newTexts.put(ctx.getChild(1), ctx.getChild(1).getText());
       }
    }

    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {

        String s1 = null, s2 = null, op = null;

        if(isBinaryOperation(ctx)){
            s1 = newTexts.get(ctx.getChild(0));
            op = ctx.getChild(1).getText();
            s2 = newTexts.get(ctx.getChild(2));

            // *** Debugging ***
            // String s1_d, s2_d, s3_d;
            // s1_d = ctx.getChild(0).getText();
            // s2_d = ctx.getChild(1).getText();
            // s3_d = ctx.getChild(2).getText();

            newTexts.put(ctx, s1 + " " + op + " " + s2);
        }
        else if(isUnaryOperation(ctx)){
            op = newTexts.get(ctx.getChild(0));
            s1 = newTexts.get(ctx.getChild(1));

            newTexts.put(ctx, op + s1);
        }
        else if(isFunctionCall(ctx)){

            String args = newTexts.get(ctx.getChild(2));

            newTexts.put(ctx, ctx.getChild(0).getText() + args);
        }
    }
    @Override
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {

        String a1 = ctx.getChild(0).getText();
        String a2 = ctx.getChild(1).getText();

        String s = ctx.getChild(0).getText();

        String ss = ctx.getText();
        newTexts.put(ctx, newTexts.get(ctx.getChild(0)) + ";");
    }


    @Override
    public void exitStmt(MiniCParser.StmtContext ctx) {
//        System.out.println(ctx.getText());

        // System.out.println(newTexts.get(ctx.getChild(0)));
    }

    boolean isExprStmt(MiniCParser.Compound_stmtContext ctx, int index){
        return newTexts.get(ctx.getChild(index).getChild(0)) != null;
    }

    boolean isNormalStmt(MiniCParser.Compound_stmtContext ctx, int index){
//        String ss = ctx.getChild(index).getChild(0).getText();
        return newTexts.get(ctx.getChild(index).getChild(0)) == null;
    }

    @Override
    public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
//        System.out.println(ctx.getChildCount());
        int nodeNum = ctx.getChildCount();
        int stmtNum = nodeNum - 2;

        String a1 = ctx.getChild(0).getText();
        String a2 = ctx.getChild(1).getText();
        String a3 = ctx.getChild(2).getText();
//        String a4 = ctx.getChild(3).getText();
        String s = ctx.getText();
        String sss;
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

    @Override
    public void exitIf_stmt(MiniCParser.If_stmtContext ctx) {
        String s  = ctx.getText();
        String a1 = ctx.getChild(0).getText();
        String a2 = ctx.getChild(1).getText();
        String a3 = ctx.getChild(2).getText();
        String a4 = ctx.getChild(3).getText();
        String a5 = ctx.getChild(4).getText();

        newTexts.put(ctx, "if (" + newTexts.get(ctx.getChild(2)) + ")\n" + newTexts.get(ctx.getChild(4).getChild(0)));
    }

    @Override
    public void exitWhile_stmt(MiniCParser.While_stmtContext ctx) {
        newTexts.put(ctx, "while (" + newTexts.get(ctx.getChild(2)) + ")\n" + newTexts.get(ctx.getChild(4).getChild(0)));
    }

    @Override
    public void exitFun_decl(MiniCParser.Fun_declContext ctx) {
        String s  = ctx.getText();
        String a1 = ctx.getChild(0).getText();
        String a2 = ctx.getChild(1).getText();
        String a3 = ctx.getChild(2).getText();
        String a4 = ctx.getChild(3).getText();
        String a5 = ctx.getChild(4).getText();
        String a6 = ctx.getChild(5).getText();

        newTexts.put(ctx, ctx.getChild(0).getText() + " " + ctx.getChild(1).getText() + "(" + ctx.getChild(3).getText() + ")\n" + newTexts.get(ctx.getChild(5)));

    }

    @Override
    public void exitArgs(MiniCParser.ArgsContext ctx) {

        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("(");
        for (int i = 0; i < ctx.getChildCount(); i++){
            if (i % 2 == 1) strBuilder.append(", ");
            else strBuilder.append(ctx.getChild(i).getText());
        }
        strBuilder.append(")");

        newTexts.put(ctx, strBuilder.toString());
    }

    @Override
    public void exitProgram(MiniCParser.ProgramContext ctx) {
        for (int i = 0; i < ctx.getChildCount(); i++){
            System.out.println(newTexts.get(ctx.getChild(i).getChild(0)));
        }
    }
}
