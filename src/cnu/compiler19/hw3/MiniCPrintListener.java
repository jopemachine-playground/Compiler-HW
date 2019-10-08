package cnu.compiler19.hw3;

import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class MiniCPrintListener extends MiniCBaseListener {

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<>();

    boolean isBinaryOperation(MiniCParser.ExprContext ctx){
        return ctx.getChildCount() == 3 &&
                ctx.getChild(1) != ctx.expr();
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
    public void exitExpr_stmt(MiniCParser.Expr_stmtContext ctx) {

//        String a1 = ctx.getChild(0).getText();
//        String a2 = ctx.getChild(1).getText();
//
//        String s = ctx.getChild(0).getText();

//        String ss = ctx.getText();
        newTexts.put(ctx, newTexts.get(ctx.getChild(0)) + ";");
    }


    @Override
    public void exitStmt(MiniCParser.StmtContext ctx) {
//        System.out.println(ctx.getText());

        // System.out.println(newTexts.get(ctx.getChild(0)));
    }

    @Override
    public void exitCompound_stmt(MiniCParser.Compound_stmtContext ctx) {
//        System.out.println(ctx.getChildCount());
        String a1 = ctx.getChild(0).getText();
        String a2 = ctx.getChild(1).getText();
        String a3 = ctx.getChild(2).getText();
        String s = ctx.getText();

        String[] content = newTexts.get(ctx.getChild(1).getChild(0)).split("\n");
        StringBuilder builder = new StringBuilder();
        for (String str : content){
            builder.append("...." + str + "\n");
        }

        newTexts.put(ctx, "{\n" + builder.toString() + "}");
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
    public void exitProgram(MiniCParser.ProgramContext ctx) {

        System.out.println(newTexts.get(ctx.getChild(0).getChild(0)));

    }
}
