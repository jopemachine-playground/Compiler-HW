package cnu.compiler19.hw2;

import org.antlr.v4.runtime.*;

public class TestMiniC {
    public static void main(String[] args) throws Exception {

        MiniCLexer lexer = new MiniCLexer( new ANTLRFileStream("test.c"));
        CommonTokenStream tokens = new CommonTokenStream( lexer );
        MiniCParser parser = new MiniCParser( tokens );
        MiniCParser.ProgramContext tree = parser.program();

    }
}