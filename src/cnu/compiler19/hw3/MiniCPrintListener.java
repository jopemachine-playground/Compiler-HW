package cnu.compiler19.hw3;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MiniCPrintListener extends MiniCBaseListener {

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();

    boolean isBinaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 3 &&
                ctx.getChild(1) != ctx.expr();
    }

    @Override
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {

        String s = newTexts.get(ctx);
        newTexts.put(ctx, s);

    }

    @Override
    public void enterExpr(MiniCParser.ExprContext ctx) {
        //System.out.println("enterExpr: " + ctx.getText());

        String s1 = null, s2 = null, s3 = null;

        if(isBinaryOperation(ctx)){
//            s1 = ctx.getChild(0).getText();
//            s2 = ctx.getChild(1).getText();
//            s3 = ctx.getChild(2).getText();

            newTexts.put(ctx.getChild(0), ctx.getChild(0).getText());
            newTexts.put(ctx.getChild(2), ctx.getChild(2).getText());
        }
    }


    @Override
    public void exitExpr(MiniCParser.ExprContext ctx) {

        String s1 = null, s2 = null, op = null;
//        String s1_d, s2_d, s3_d;

        if(isBinaryOperation(ctx)){
            s1 = newTexts.get(ctx.getChild(0));
            s2 = newTexts.get(ctx.getChild(2));

//            s1_d = ctx.getChild(0).getText();
//            s2_d = ctx.getChild(1).getText();
//            s3_d = ctx.getChild(2).getText();

            op = ctx.getChild(1).getText();
            newTexts.put(ctx, s1 + " " + op + " " + s2);
        }
    }


    @Override
    public void exitStmt(MiniCParser.StmtContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(newTexts.get(ctx));
    }

    @Override
    public void exitProgram(MiniCParser.ProgramContext ctx) {
        System.out.println(ctx.getText());
        System.out.println(newTexts.get(ctx));

    }
}
