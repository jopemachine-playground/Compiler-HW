package cnu.compiler19.hw3;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class Translator {
    enum OPTIONS {
        PRETTYPRINT, ERROR
    }
    private static OPTIONS getOption(String[] args){
        if (args.length < 1)
            return OPTIONS.PRETTYPRINT;

        if (args[0].startsWith("-p")
                || args[0].startsWith("-P"))
            return OPTIONS.PRETTYPRINT;

        return OPTIONS.ERROR;
    }

    public static void main(String[] args) throws Exception
    {
        CharStream codeCharStream = CharStreams.fromFileName("test.c");
        MiniCLexer lexer = new MiniCLexer(codeCharStream);
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MiniCParser parser = new MiniCParser( tokens );
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        switch (getOption(args)) {
            case PRETTYPRINT :
                walker.walk(new MiniCPrintListener(), tree );
                break;
            default:
                break;
        }
    }
}