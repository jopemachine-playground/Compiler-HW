// Generated from C:/Compiler-HW/src/cnu/compiler19/hw2\MiniC.g4 by ANTLR 4.7.2
package cnu.compiler19.hw2;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, VOID=20, INT=21, WHILE=22, IF=23, ELSE=24, RETURN=25, 
		OR=26, AND=27, LE=28, GE=29, EQ=30, NE=31, IDENT=32, LITERAL=33, DecimalConstant=34, 
		OctalConstant=35, HexadecimalConstant=36, WS=37;
	public static final int
		RULE_program = 0, RULE_decl = 1, RULE_var_decl = 2, RULE_type_spec = 3, 
		RULE_fun_decl = 4, RULE_params = 5, RULE_param = 6, RULE_stmt = 7, RULE_expr_stmt = 8, 
		RULE_while_stmt = 9, RULE_compound_stmt = 10, RULE_local_decl = 11, RULE_if_stmt = 12, 
		RULE_return_stmt = 13, RULE_expr = 14, RULE_args = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decl", "var_decl", "type_spec", "fun_decl", "params", "param", 
			"stmt", "expr_stmt", "while_stmt", "compound_stmt", "local_decl", "if_stmt", 
			"return_stmt", "expr", "args"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'='", "'('", "')'", "','", "'{'", "'}'", 
			"'-'", "'+'", "'--'", "'++'", "'*'", "'/'", "'%'", "'<'", "'>'", "'!'", 
			"'void'", "'int'", "'while'", "'if'", "'else'", "'return'", "'or'", "'and'", 
			"'<='", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "VOID", "INT", "WHILE", 
			"IF", "ELSE", "RETURN", "OR", "AND", "LE", "GE", "EQ", "NE", "IDENT", 
			"LITERAL", "DecimalConstant", "OctalConstant", "HexadecimalConstant", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MiniC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MiniCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<DeclContext> decl() {
			return getRuleContexts(DeclContext.class);
		}
		public DeclContext decl(int i) {
			return getRuleContext(DeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				decl();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VOID || _la==INT );

			    System.out.println("201502085 Rule 0");

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Fun_declContext fun_decl() {
			return getRuleContext(Fun_declContext.class,0);
		}
		public DeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitDecl(this);
		}
	}

	public final DeclContext decl() throws RecognitionException {
		DeclContext _localctx = new DeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decl);
		try {
			setState(45);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(39);
				var_decl();

				    System.out.println("201502085 Rule 1-1");

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				fun_decl();

				    System.out.println("201502085 Rule 1-2");

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decl);
		try {
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				type_spec();
				setState(48);
				match(IDENT);
				setState(49);
				match(T__0);

				    System.out.println("201502085 Rule 2-1");

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52);
				type_spec();
				setState(53);
				match(IDENT);
				setState(54);
				match(T__1);
				setState(55);
				match(T__2);
				setState(56);
				match(T__0);

				    System.out.println("201502085 Rule 2-2");

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(59);
				type_spec();
				setState(60);
				match(IDENT);
				setState(61);
				match(T__3);
				setState(62);
				match(LITERAL);
				setState(63);
				match(T__0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(65);
				type_spec();
				setState(66);
				match(IDENT);
				setState(67);
				match(T__1);
				setState(68);
				match(LITERAL);
				setState(69);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Type_specContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public TerminalNode INT() { return getToken(MiniCParser.INT, 0); }
		public Type_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterType_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitType_spec(this);
		}
	}

	public final Type_specContext type_spec() throws RecognitionException {
		Type_specContext _localctx = new Type_specContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !(_la==VOID || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Fun_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Fun_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fun_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterFun_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitFun_decl(this);
		}
	}

	public final Fun_declContext fun_decl() throws RecognitionException {
		Fun_declContext _localctx = new Fun_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fun_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			type_spec();
			setState(76);
			match(IDENT);
			setState(77);
			match(T__4);
			setState(78);
			params();
			setState(79);
			match(T__5);
			setState(80);
			compound_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public TerminalNode VOID() { return getToken(MiniCParser.VOID, 0); }
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParams(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_params);
		int _la;
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				param();
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(83);
					match(T__6);
					setState(84);
					param();
					}
					}
					setState(89);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90);
				match(VOID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitParam(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				type_spec();
				setState(95);
				match(IDENT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				type_spec();
				setState(98);
				match(IDENT);
				setState(99);
				match(T__1);
				setState(100);
				match(T__2);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitStmt(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_stmt);
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				expr_stmt();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				compound_stmt();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				if_stmt();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				while_stmt();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				return_stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr_stmt(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			expr(0);
			setState(112);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MiniCParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(WHILE);
			setState(115);
			match(T__4);
			setState(116);
			expr(0);
			setState(117);
			match(T__5);
			setState(118);
			stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Compound_stmtContext extends ParserRuleContext {
		public List<Local_declContext> local_decl() {
			return getRuleContexts(Local_declContext.class);
		}
		public Local_declContext local_decl(int i) {
			return getRuleContext(Local_declContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitCompound_stmt(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_compound_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__7);
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VOID || _la==INT) {
				{
				{
				setState(121);
				local_decl();
				}
				}
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__18) | (1L << WHILE) | (1L << IF) | (1L << RETURN) | (1L << IDENT) | (1L << LITERAL))) != 0)) {
				{
				{
				setState(127);
				stmt();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Local_declContext extends ParserRuleContext {
		public Type_specContext type_spec() {
			return getRuleContext(Type_specContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public Local_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterLocal_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitLocal_decl(this);
		}
	}

	public final Local_declContext local_decl() throws RecognitionException {
		Local_declContext _localctx = new Local_declContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_local_decl);
		try {
			setState(152);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				type_spec();
				setState(136);
				match(IDENT);
				setState(137);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				type_spec();
				setState(140);
				match(IDENT);
				setState(141);
				match(T__3);
				setState(142);
				match(LITERAL);
				setState(143);
				match(T__0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(145);
				type_spec();
				setState(146);
				match(IDENT);
				setState(147);
				match(T__1);
				setState(148);
				match(LITERAL);
				setState(149);
				match(T__2);
				setState(150);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MiniCParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MiniCParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_if_stmt);
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				match(IF);
				setState(155);
				match(T__4);
				setState(156);
				expr(0);
				setState(157);
				match(T__5);
				setState(158);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				match(IF);
				setState(161);
				match(T__4);
				setState(162);
				expr(0);
				setState(163);
				match(T__5);
				setState(164);
				stmt();
				setState(165);
				match(ELSE);
				setState(166);
				stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MiniCParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_stmt);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				match(RETURN);
				setState(171);
				match(T__0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(172);
				match(RETURN);
				setState(173);
				expr(0);
				setState(174);
				match(T__0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public TerminalNode LITERAL() { return getToken(MiniCParser.LITERAL, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(MiniCParser.IDENT, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode EQ() { return getToken(MiniCParser.EQ, 0); }
		public TerminalNode NE() { return getToken(MiniCParser.NE, 0); }
		public TerminalNode LE() { return getToken(MiniCParser.LE, 0); }
		public TerminalNode GE() { return getToken(MiniCParser.GE, 0); }
		public TerminalNode AND() { return getToken(MiniCParser.AND, 0); }
		public TerminalNode OR() { return getToken(MiniCParser.OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(179);
				match(LITERAL);
				}
				break;
			case 2:
				{
				setState(180);
				match(T__4);
				setState(181);
				expr(0);
				setState(182);
				match(T__5);
				}
				break;
			case 3:
				{
				setState(184);
				match(IDENT);
				}
				break;
			case 4:
				{
				setState(185);
				match(IDENT);
				setState(186);
				match(T__1);
				setState(187);
				expr(0);
				setState(188);
				match(T__2);
				}
				break;
			case 5:
				{
				setState(190);
				match(IDENT);
				setState(191);
				match(T__4);
				setState(192);
				args();
				setState(193);
				match(T__5);
				}
				break;
			case 6:
				{
				setState(195);
				match(T__9);
				setState(196);
				expr(20);
				}
				break;
			case 7:
				{
				setState(197);
				match(T__10);
				setState(198);
				expr(19);
				}
				break;
			case 8:
				{
				setState(199);
				match(T__11);
				setState(200);
				expr(18);
				}
				break;
			case 9:
				{
				setState(201);
				match(T__12);
				setState(202);
				expr(17);
				}
				break;
			case 10:
				{
				setState(203);
				match(T__18);
				setState(204);
				expr(5);
				}
				break;
			case 11:
				{
				setState(205);
				match(IDENT);
				setState(206);
				match(T__3);
				setState(207);
				expr(2);
				}
				break;
			case 12:
				{
				setState(208);
				match(IDENT);
				setState(209);
				match(T__1);
				setState(210);
				expr(0);
				setState(211);
				match(T__2);
				setState(212);
				match(T__3);
				setState(213);
				expr(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(256);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(217);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(218);
						match(T__13);
						setState(219);
						expr(17);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(220);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(221);
						match(T__14);
						setState(222);
						expr(16);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(223);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(224);
						match(T__15);
						setState(225);
						expr(15);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(226);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(227);
						match(T__10);
						setState(228);
						expr(14);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(229);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(230);
						match(T__9);
						setState(231);
						expr(13);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(232);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(233);
						match(EQ);
						setState(234);
						expr(12);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(235);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(236);
						match(NE);
						setState(237);
						expr(11);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(238);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(239);
						match(LE);
						setState(240);
						expr(10);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(241);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(242);
						match(T__16);
						setState(243);
						expr(9);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(244);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(245);
						match(GE);
						setState(246);
						expr(8);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(247);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(248);
						match(T__17);
						setState(249);
						expr(7);
						}
						break;
					case 12:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(250);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(251);
						match(AND);
						setState(252);
						expr(5);
						}
						break;
					case 13:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(253);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(254);
						match(OR);
						setState(255);
						expr(4);
						}
						break;
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MiniCListener ) ((MiniCListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_args);
		int _la;
		try {
			setState(270);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__18:
			case IDENT:
			case LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				expr(0);
				setState(266);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(262);
					match(T__6);
					setState(263);
					expr(0);
					}
					}
					setState(268);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 16);
		case 1:
			return precpred(_ctx, 15);
		case 2:
			return precpred(_ctx, 14);
		case 3:
			return precpred(_ctx, 13);
		case 4:
			return precpred(_ctx, 12);
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\6\2$\n"+
		"\2\r\2\16\2%\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\60\n\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\5\4J\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\7\7X\n\7\f\7\16\7[\13\7\3\7\3\7\5\7_\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\5\bi\n\b\3\t\3\t\3\t\3\t\3\t\5\tp\n\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\7\f}\n\f\f\f\16\f\u0080\13\f\3\f\7\f\u0083\n\f"+
		"\f\f\16\f\u0086\13\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u009b\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ab\n\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17\u00b3\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\5\20\u00da\n\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u0103\n\20\f\20\16\20\u0106\13\20\3\21\3\21\3\21\7\21\u010b"+
		"\n\21\f\21\16\21\u010e\13\21\3\21\5\21\u0111\n\21\3\21\2\3\36\22\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\26\27\2\u012f\2#\3\2\2\2\4"+
		"/\3\2\2\2\6I\3\2\2\2\bK\3\2\2\2\nM\3\2\2\2\f^\3\2\2\2\16h\3\2\2\2\20o"+
		"\3\2\2\2\22q\3\2\2\2\24t\3\2\2\2\26z\3\2\2\2\30\u009a\3\2\2\2\32\u00aa"+
		"\3\2\2\2\34\u00b2\3\2\2\2\36\u00d9\3\2\2\2 \u0110\3\2\2\2\"$\5\4\3\2#"+
		"\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\b\2\1\2(\3\3\2"+
		"\2\2)*\5\6\4\2*+\b\3\1\2+\60\3\2\2\2,-\5\n\6\2-.\b\3\1\2.\60\3\2\2\2/"+
		")\3\2\2\2/,\3\2\2\2\60\5\3\2\2\2\61\62\5\b\5\2\62\63\7\"\2\2\63\64\7\3"+
		"\2\2\64\65\b\4\1\2\65J\3\2\2\2\66\67\5\b\5\2\678\7\"\2\289\7\4\2\29:\7"+
		"\5\2\2:;\7\3\2\2;<\b\4\1\2<J\3\2\2\2=>\5\b\5\2>?\7\"\2\2?@\7\6\2\2@A\7"+
		"#\2\2AB\7\3\2\2BJ\3\2\2\2CD\5\b\5\2DE\7\"\2\2EF\7\4\2\2FG\7#\2\2GH\7\5"+
		"\2\2HJ\3\2\2\2I\61\3\2\2\2I\66\3\2\2\2I=\3\2\2\2IC\3\2\2\2J\7\3\2\2\2"+
		"KL\t\2\2\2L\t\3\2\2\2MN\5\b\5\2NO\7\"\2\2OP\7\7\2\2PQ\5\f\7\2QR\7\b\2"+
		"\2RS\5\26\f\2S\13\3\2\2\2TY\5\16\b\2UV\7\t\2\2VX\5\16\b\2WU\3\2\2\2X["+
		"\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z_\3\2\2\2[Y\3\2\2\2\\_\7\26\2\2]_\3\2\2\2"+
		"^T\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_\r\3\2\2\2`a\5\b\5\2ab\7\"\2\2bi\3\2\2"+
		"\2cd\5\b\5\2de\7\"\2\2ef\7\4\2\2fg\7\5\2\2gi\3\2\2\2h`\3\2\2\2hc\3\2\2"+
		"\2i\17\3\2\2\2jp\5\22\n\2kp\5\26\f\2lp\5\32\16\2mp\5\24\13\2np\5\34\17"+
		"\2oj\3\2\2\2ok\3\2\2\2ol\3\2\2\2om\3\2\2\2on\3\2\2\2p\21\3\2\2\2qr\5\36"+
		"\20\2rs\7\3\2\2s\23\3\2\2\2tu\7\30\2\2uv\7\7\2\2vw\5\36\20\2wx\7\b\2\2"+
		"xy\5\20\t\2y\25\3\2\2\2z~\7\n\2\2{}\5\30\r\2|{\3\2\2\2}\u0080\3\2\2\2"+
		"~|\3\2\2\2~\177\3\2\2\2\177\u0084\3\2\2\2\u0080~\3\2\2\2\u0081\u0083\5"+
		"\20\t\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\13"+
		"\2\2\u0088\27\3\2\2\2\u0089\u008a\5\b\5\2\u008a\u008b\7\"\2\2\u008b\u008c"+
		"\7\3\2\2\u008c\u009b\3\2\2\2\u008d\u008e\5\b\5\2\u008e\u008f\7\"\2\2\u008f"+
		"\u0090\7\6\2\2\u0090\u0091\7#\2\2\u0091\u0092\7\3\2\2\u0092\u009b\3\2"+
		"\2\2\u0093\u0094\5\b\5\2\u0094\u0095\7\"\2\2\u0095\u0096\7\4\2\2\u0096"+
		"\u0097\7#\2\2\u0097\u0098\7\5\2\2\u0098\u0099\7\3\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0089\3\2\2\2\u009a\u008d\3\2\2\2\u009a\u0093\3\2\2\2\u009b"+
		"\31\3\2\2\2\u009c\u009d\7\31\2\2\u009d\u009e\7\7\2\2\u009e\u009f\5\36"+
		"\20\2\u009f\u00a0\7\b\2\2\u00a0\u00a1\5\20\t\2\u00a1\u00ab\3\2\2\2\u00a2"+
		"\u00a3\7\31\2\2\u00a3\u00a4\7\7\2\2\u00a4\u00a5\5\36\20\2\u00a5\u00a6"+
		"\7\b\2\2\u00a6\u00a7\5\20\t\2\u00a7\u00a8\7\32\2\2\u00a8\u00a9\5\20\t"+
		"\2\u00a9\u00ab\3\2\2\2\u00aa\u009c\3\2\2\2\u00aa\u00a2\3\2\2\2\u00ab\33"+
		"\3\2\2\2\u00ac\u00ad\7\33\2\2\u00ad\u00b3\7\3\2\2\u00ae\u00af\7\33\2\2"+
		"\u00af\u00b0\5\36\20\2\u00b0\u00b1\7\3\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ac"+
		"\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3\35\3\2\2\2\u00b4\u00b5\b\20\1\2\u00b5"+
		"\u00da\7#\2\2\u00b6\u00b7\7\7\2\2\u00b7\u00b8\5\36\20\2\u00b8\u00b9\7"+
		"\b\2\2\u00b9\u00da\3\2\2\2\u00ba\u00da\7\"\2\2\u00bb\u00bc\7\"\2\2\u00bc"+
		"\u00bd\7\4\2\2\u00bd\u00be\5\36\20\2\u00be\u00bf\7\5\2\2\u00bf\u00da\3"+
		"\2\2\2\u00c0\u00c1\7\"\2\2\u00c1\u00c2\7\7\2\2\u00c2\u00c3\5 \21\2\u00c3"+
		"\u00c4\7\b\2\2\u00c4\u00da\3\2\2\2\u00c5\u00c6\7\f\2\2\u00c6\u00da\5\36"+
		"\20\26\u00c7\u00c8\7\r\2\2\u00c8\u00da\5\36\20\25\u00c9\u00ca\7\16\2\2"+
		"\u00ca\u00da\5\36\20\24\u00cb\u00cc\7\17\2\2\u00cc\u00da\5\36\20\23\u00cd"+
		"\u00ce\7\25\2\2\u00ce\u00da\5\36\20\7\u00cf\u00d0\7\"\2\2\u00d0\u00d1"+
		"\7\6\2\2\u00d1\u00da\5\36\20\4\u00d2\u00d3\7\"\2\2\u00d3\u00d4\7\4\2\2"+
		"\u00d4\u00d5\5\36\20\2\u00d5\u00d6\7\5\2\2\u00d6\u00d7\7\6\2\2\u00d7\u00d8"+
		"\5\36\20\3\u00d8\u00da\3\2\2\2\u00d9\u00b4\3\2\2\2\u00d9\u00b6\3\2\2\2"+
		"\u00d9\u00ba\3\2\2\2\u00d9\u00bb\3\2\2\2\u00d9\u00c0\3\2\2\2\u00d9\u00c5"+
		"\3\2\2\2\u00d9\u00c7\3\2\2\2\u00d9\u00c9\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9"+
		"\u00cd\3\2\2\2\u00d9\u00cf\3\2\2\2\u00d9\u00d2\3\2\2\2\u00da\u0104\3\2"+
		"\2\2\u00db\u00dc\f\22\2\2\u00dc\u00dd\7\20\2\2\u00dd\u0103\5\36\20\23"+
		"\u00de\u00df\f\21\2\2\u00df\u00e0\7\21\2\2\u00e0\u0103\5\36\20\22\u00e1"+
		"\u00e2\f\20\2\2\u00e2\u00e3\7\22\2\2\u00e3\u0103\5\36\20\21\u00e4\u00e5"+
		"\f\17\2\2\u00e5\u00e6\7\r\2\2\u00e6\u0103\5\36\20\20\u00e7\u00e8\f\16"+
		"\2\2\u00e8\u00e9\7\f\2\2\u00e9\u0103\5\36\20\17\u00ea\u00eb\f\r\2\2\u00eb"+
		"\u00ec\7 \2\2\u00ec\u0103\5\36\20\16\u00ed\u00ee\f\f\2\2\u00ee\u00ef\7"+
		"!\2\2\u00ef\u0103\5\36\20\r\u00f0\u00f1\f\13\2\2\u00f1\u00f2\7\36\2\2"+
		"\u00f2\u0103\5\36\20\f\u00f3\u00f4\f\n\2\2\u00f4\u00f5\7\23\2\2\u00f5"+
		"\u0103\5\36\20\13\u00f6\u00f7\f\t\2\2\u00f7\u00f8\7\37\2\2\u00f8\u0103"+
		"\5\36\20\n\u00f9\u00fa\f\b\2\2\u00fa\u00fb\7\24\2\2\u00fb\u0103\5\36\20"+
		"\t\u00fc\u00fd\f\6\2\2\u00fd\u00fe\7\35\2\2\u00fe\u0103\5\36\20\7\u00ff"+
		"\u0100\f\5\2\2\u0100\u0101\7\34\2\2\u0101\u0103\5\36\20\6\u0102\u00db"+
		"\3\2\2\2\u0102\u00de\3\2\2\2\u0102\u00e1\3\2\2\2\u0102\u00e4\3\2\2\2\u0102"+
		"\u00e7\3\2\2\2\u0102\u00ea\3\2\2\2\u0102\u00ed\3\2\2\2\u0102\u00f0\3\2"+
		"\2\2\u0102\u00f3\3\2\2\2\u0102\u00f6\3\2\2\2\u0102\u00f9\3\2\2\2\u0102"+
		"\u00fc\3\2\2\2\u0102\u00ff\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2"+
		"\2\2\u0104\u0105\3\2\2\2\u0105\37\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u010c"+
		"\5\36\20\2\u0108\u0109\7\t\2\2\u0109\u010b\5\36\20\2\u010a\u0108\3\2\2"+
		"\2\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0111"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0111\3\2\2\2\u0110\u0107\3\2\2\2\u0110"+
		"\u010f\3\2\2\2\u0111!\3\2\2\2\23%/IY^ho~\u0084\u009a\u00aa\u00b2\u00d9"+
		"\u0102\u0104\u010c\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}