// Generated from /home/jyakimischak/projects/bb1db/sqlParser/bb1dbSql.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class bb1dbSqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		COMMENT_LINE=10, COMMENT_BLOCK=11, MSG_KW=12, SEG_KW=13, GRP_KW=14, TYP_KW=15, 
		TST_KW=16, XLATE_KW=17, EXPR_KW=18, SEG_PART_NAME=19, GRP_PART_NAME=20, 
		TYP_PART_NAME=21, MSG_SEG_GRP_TYP_XLATE_NAME=22, HL7_VER=23, HL7_SELECTOR=24, 
		CARDINALITY=25, STRING=26, WS=27;
	public static final int
		RULE_prog = 0, RULE_msgDef = 1, RULE_grpDef = 2, RULE_segDef = 3, RULE_typDef = 4, 
		RULE_grpPart = 5, RULE_segPart = 6, RULE_typStrPart = 7, RULE_typPart = 8, 
		RULE_xlateDef = 9, RULE_xlateOperationLhs = 10, RULE_xlateOperationRhs = 11;
	public static final String[] ruleNames = {
		"prog", "msgDef", "grpDef", "segDef", "typDef", "grpPart", "segPart", 
		"typStrPart", "typPart", "xlateDef", "xlateOperationLhs", "xlateOperationRhs"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'{'", "'}'", "';'", "'<'", "'>'", "'->'", 
		null, null, "'msg'", "'seg'", "'grp'", "'typ'", "'tST'", "'xlate'", "'expr'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "COMMENT_LINE", 
		"COMMENT_BLOCK", "MSG_KW", "SEG_KW", "GRP_KW", "TYP_KW", "TST_KW", "XLATE_KW", 
		"EXPR_KW", "SEG_PART_NAME", "GRP_PART_NAME", "TYP_PART_NAME", "MSG_SEG_GRP_TYP_XLATE_NAME", 
		"HL7_VER", "HL7_SELECTOR", "CARDINALITY", "STRING", "WS"
	};
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
	public String getGrammarFileName() { return "bb1dbSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public bb1dbSqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public List<MsgDefContext> msgDef() {
			return getRuleContexts(MsgDefContext.class);
		}
		public MsgDefContext msgDef(int i) {
			return getRuleContext(MsgDefContext.class,i);
		}
		public List<GrpDefContext> grpDef() {
			return getRuleContexts(GrpDefContext.class);
		}
		public GrpDefContext grpDef(int i) {
			return getRuleContext(GrpDefContext.class,i);
		}
		public List<SegDefContext> segDef() {
			return getRuleContexts(SegDefContext.class);
		}
		public SegDefContext segDef(int i) {
			return getRuleContext(SegDefContext.class,i);
		}
		public List<TypDefContext> typDef() {
			return getRuleContexts(TypDefContext.class);
		}
		public TypDefContext typDef(int i) {
			return getRuleContext(TypDefContext.class,i);
		}
		public List<XlateDefContext> xlateDef() {
			return getRuleContexts(XlateDefContext.class);
		}
		public XlateDefContext xlateDef(int i) {
			return getRuleContext(XlateDefContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MSG_KW) | (1L << SEG_KW) | (1L << GRP_KW) | (1L << TYP_KW) | (1L << XLATE_KW))) != 0)) {
				{
				setState(29);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MSG_KW:
					{
					setState(24);
					msgDef();
					}
					break;
				case GRP_KW:
					{
					setState(25);
					grpDef();
					}
					break;
				case SEG_KW:
					{
					setState(26);
					segDef();
					}
					break;
				case TYP_KW:
					{
					setState(27);
					typDef();
					}
					break;
				case XLATE_KW:
					{
					setState(28);
					xlateDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class MsgDefContext extends ParserRuleContext {
		public TerminalNode MSG_KW() { return getToken(bb1dbSqlParser.MSG_KW, 0); }
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public List<SegPartContext> segPart() {
			return getRuleContexts(SegPartContext.class);
		}
		public SegPartContext segPart(int i) {
			return getRuleContext(SegPartContext.class,i);
		}
		public List<GrpPartContext> grpPart() {
			return getRuleContexts(GrpPartContext.class);
		}
		public GrpPartContext grpPart(int i) {
			return getRuleContext(GrpPartContext.class,i);
		}
		public MsgDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_msgDef; }
	}

	public final MsgDefContext msgDef() throws RecognitionException {
		MsgDefContext _localctx = new MsgDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_msgDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			match(MSG_KW);
			setState(35);
			match(T__0);
			setState(36);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(37);
			match(T__1);
			setState(38);
			match(HL7_VER);
			setState(39);
			match(T__1);
			setState(40);
			match(STRING);
			setState(41);
			match(T__2);
			setState(42);
			match(T__3);
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(45);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SEG_PART_NAME:
					{
					setState(43);
					segPart();
					}
					break;
				case GRP_PART_NAME:
					{
					setState(44);
					grpPart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEG_PART_NAME || _la==GRP_PART_NAME );
			setState(49);
			match(T__4);
			setState(50);
			match(T__5);
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

	public static class GrpDefContext extends ParserRuleContext {
		public TerminalNode GRP_KW() { return getToken(bb1dbSqlParser.GRP_KW, 0); }
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public List<GrpPartContext> grpPart() {
			return getRuleContexts(GrpPartContext.class);
		}
		public GrpPartContext grpPart(int i) {
			return getRuleContext(GrpPartContext.class,i);
		}
		public List<SegPartContext> segPart() {
			return getRuleContexts(SegPartContext.class);
		}
		public SegPartContext segPart(int i) {
			return getRuleContext(SegPartContext.class,i);
		}
		public GrpDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grpDef; }
	}

	public final GrpDefContext grpDef() throws RecognitionException {
		GrpDefContext _localctx = new GrpDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_grpDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			match(GRP_KW);
			setState(53);
			match(T__0);
			setState(54);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(55);
			match(T__1);
			setState(56);
			match(HL7_VER);
			setState(57);
			match(T__1);
			setState(58);
			match(STRING);
			setState(59);
			match(T__2);
			setState(60);
			match(T__3);
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(63);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GRP_PART_NAME:
					{
					setState(61);
					grpPart();
					}
					break;
				case SEG_PART_NAME:
					{
					setState(62);
					segPart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SEG_PART_NAME || _la==GRP_PART_NAME );
			setState(67);
			match(T__4);
			setState(68);
			match(T__5);
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

	public static class SegDefContext extends ParserRuleContext {
		public TerminalNode SEG_KW() { return getToken(bb1dbSqlParser.SEG_KW, 0); }
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public List<TypPartContext> typPart() {
			return getRuleContexts(TypPartContext.class);
		}
		public TypPartContext typPart(int i) {
			return getRuleContext(TypPartContext.class,i);
		}
		public List<TypStrPartContext> typStrPart() {
			return getRuleContexts(TypStrPartContext.class);
		}
		public TypStrPartContext typStrPart(int i) {
			return getRuleContext(TypStrPartContext.class,i);
		}
		public SegDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segDef; }
	}

	public final SegDefContext segDef() throws RecognitionException {
		SegDefContext _localctx = new SegDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_segDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(SEG_KW);
			setState(71);
			match(T__0);
			setState(72);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(73);
			match(T__1);
			setState(74);
			match(HL7_VER);
			setState(75);
			match(T__1);
			setState(76);
			match(STRING);
			setState(77);
			match(T__2);
			setState(78);
			match(T__3);
			setState(81); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case TYP_PART_NAME:
					{
					setState(79);
					typPart();
					}
					break;
				case TST_KW:
					{
					setState(80);
					typStrPart();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(83); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TST_KW || _la==TYP_PART_NAME );
			setState(85);
			match(T__4);
			setState(86);
			match(T__5);
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

	public static class TypDefContext extends ParserRuleContext {
		public TerminalNode TYP_KW() { return getToken(bb1dbSqlParser.TYP_KW, 0); }
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public List<TypStrPartContext> typStrPart() {
			return getRuleContexts(TypStrPartContext.class);
		}
		public TypStrPartContext typStrPart(int i) {
			return getRuleContext(TypStrPartContext.class,i);
		}
		public TypDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typDef; }
	}

	public final TypDefContext typDef() throws RecognitionException {
		TypDefContext _localctx = new TypDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_typDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			match(TYP_KW);
			setState(89);
			match(T__0);
			setState(90);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(91);
			match(T__1);
			setState(92);
			match(HL7_VER);
			setState(93);
			match(T__1);
			setState(94);
			match(STRING);
			setState(95);
			match(T__2);
			setState(96);
			match(T__3);
			setState(98); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(97);
				typStrPart();
				}
				}
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==TST_KW );
			setState(102);
			match(T__4);
			setState(103);
			match(T__5);
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

	public static class GrpPartContext extends ParserRuleContext {
		public TerminalNode GRP_PART_NAME() { return getToken(bb1dbSqlParser.GRP_PART_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public List<TerminalNode> CARDINALITY() { return getTokens(bb1dbSqlParser.CARDINALITY); }
		public TerminalNode CARDINALITY(int i) {
			return getToken(bb1dbSqlParser.CARDINALITY, i);
		}
		public GrpPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grpPart; }
	}

	public final GrpPartContext grpPart() throws RecognitionException {
		GrpPartContext _localctx = new GrpPartContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_grpPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(GRP_PART_NAME);
			setState(106);
			match(T__6);
			setState(107);
			match(HL7_VER);
			setState(108);
			match(T__7);
			setState(109);
			match(T__0);
			setState(110);
			match(CARDINALITY);
			setState(111);
			match(T__1);
			setState(112);
			match(CARDINALITY);
			setState(113);
			match(T__2);
			setState(114);
			match(T__5);
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

	public static class SegPartContext extends ParserRuleContext {
		public TerminalNode SEG_PART_NAME() { return getToken(bb1dbSqlParser.SEG_PART_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public List<TerminalNode> CARDINALITY() { return getTokens(bb1dbSqlParser.CARDINALITY); }
		public TerminalNode CARDINALITY(int i) {
			return getToken(bb1dbSqlParser.CARDINALITY, i);
		}
		public SegPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segPart; }
	}

	public final SegPartContext segPart() throws RecognitionException {
		SegPartContext _localctx = new SegPartContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_segPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(SEG_PART_NAME);
			setState(117);
			match(T__6);
			setState(118);
			match(HL7_VER);
			setState(119);
			match(T__7);
			setState(120);
			match(T__0);
			setState(121);
			match(CARDINALITY);
			setState(122);
			match(T__1);
			setState(123);
			match(CARDINALITY);
			setState(124);
			match(T__2);
			setState(125);
			match(T__5);
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

	public static class TypStrPartContext extends ParserRuleContext {
		public TerminalNode TST_KW() { return getToken(bb1dbSqlParser.TST_KW, 0); }
		public List<TerminalNode> CARDINALITY() { return getTokens(bb1dbSqlParser.CARDINALITY); }
		public TerminalNode CARDINALITY(int i) {
			return getToken(bb1dbSqlParser.CARDINALITY, i);
		}
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public TypStrPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typStrPart; }
	}

	public final TypStrPartContext typStrPart() throws RecognitionException {
		TypStrPartContext _localctx = new TypStrPartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_typStrPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(TST_KW);
			setState(128);
			match(T__0);
			setState(129);
			match(CARDINALITY);
			setState(130);
			match(T__1);
			setState(131);
			match(CARDINALITY);
			setState(132);
			match(T__1);
			setState(133);
			match(STRING);
			setState(134);
			match(T__2);
			setState(135);
			match(T__5);
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

	public static class TypPartContext extends ParserRuleContext {
		public TerminalNode TYP_PART_NAME() { return getToken(bb1dbSqlParser.TYP_PART_NAME, 0); }
		public TerminalNode HL7_VER() { return getToken(bb1dbSqlParser.HL7_VER, 0); }
		public List<TerminalNode> CARDINALITY() { return getTokens(bb1dbSqlParser.CARDINALITY); }
		public TerminalNode CARDINALITY(int i) {
			return getToken(bb1dbSqlParser.CARDINALITY, i);
		}
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public TypPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typPart; }
	}

	public final TypPartContext typPart() throws RecognitionException {
		TypPartContext _localctx = new TypPartContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typPart);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(TYP_PART_NAME);
			setState(138);
			match(T__6);
			setState(139);
			match(HL7_VER);
			setState(140);
			match(T__7);
			setState(141);
			match(T__0);
			setState(142);
			match(CARDINALITY);
			setState(143);
			match(T__1);
			setState(144);
			match(CARDINALITY);
			setState(145);
			match(T__1);
			setState(146);
			match(STRING);
			setState(147);
			match(T__2);
			setState(148);
			match(T__5);
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

	public static class XlateDefContext extends ParserRuleContext {
		public TerminalNode XLATE_KW() { return getToken(bb1dbSqlParser.XLATE_KW, 0); }
		public List<TerminalNode> MSG_SEG_GRP_TYP_XLATE_NAME() { return getTokens(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME); }
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME(int i) {
			return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, i);
		}
		public List<TerminalNode> HL7_VER() { return getTokens(bb1dbSqlParser.HL7_VER); }
		public TerminalNode HL7_VER(int i) {
			return getToken(bb1dbSqlParser.HL7_VER, i);
		}
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public List<XlateOperationLhsContext> xlateOperationLhs() {
			return getRuleContexts(XlateOperationLhsContext.class);
		}
		public XlateOperationLhsContext xlateOperationLhs(int i) {
			return getRuleContext(XlateOperationLhsContext.class,i);
		}
		public List<XlateOperationRhsContext> xlateOperationRhs() {
			return getRuleContexts(XlateOperationRhsContext.class);
		}
		public XlateOperationRhsContext xlateOperationRhs(int i) {
			return getRuleContext(XlateOperationRhsContext.class,i);
		}
		public XlateDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xlateDef; }
	}

	public final XlateDefContext xlateDef() throws RecognitionException {
		XlateDefContext _localctx = new XlateDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_xlateDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(XLATE_KW);
			setState(151);
			match(T__0);
			setState(152);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(153);
			match(T__1);
			setState(154);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(155);
			match(T__6);
			setState(156);
			match(HL7_VER);
			setState(157);
			match(T__7);
			setState(158);
			match(T__1);
			setState(159);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(160);
			match(T__6);
			setState(161);
			match(HL7_VER);
			setState(162);
			match(T__7);
			setState(163);
			match(T__1);
			setState(164);
			match(STRING);
			setState(165);
			match(T__2);
			setState(166);
			match(T__3);
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				xlateOperationLhs();
				setState(168);
				match(T__8);
				setState(169);
				xlateOperationRhs();
				setState(170);
				match(T__5);
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==EXPR_KW || _la==MSG_SEG_GRP_TYP_XLATE_NAME );
			setState(176);
			match(T__4);
			setState(177);
			match(T__5);
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

	public static class XlateOperationLhsContext extends ParserRuleContext {
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_SELECTOR() { return getToken(bb1dbSqlParser.HL7_SELECTOR, 0); }
		public TerminalNode EXPR_KW() { return getToken(bb1dbSqlParser.EXPR_KW, 0); }
		public List<TerminalNode> STRING() { return getTokens(bb1dbSqlParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(bb1dbSqlParser.STRING, i);
		}
		public XlateOperationLhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xlateOperationLhs; }
	}

	public final XlateOperationLhsContext xlateOperationLhs() throws RecognitionException {
		XlateOperationLhsContext _localctx = new XlateOperationLhsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_xlateOperationLhs);
		int _la;
		try {
			setState(189);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MSG_SEG_GRP_TYP_XLATE_NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(179);
				match(MSG_SEG_GRP_TYP_XLATE_NAME);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==HL7_SELECTOR) {
					{
					setState(180);
					match(HL7_SELECTOR);
					}
				}

				}
				break;
			case EXPR_KW:
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(EXPR_KW);
				setState(184);
				match(T__0);
				setState(185);
				match(STRING);
				setState(186);
				match(T__1);
				setState(187);
				match(STRING);
				setState(188);
				match(T__2);
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

	public static class XlateOperationRhsContext extends ParserRuleContext {
		public TerminalNode MSG_SEG_GRP_TYP_XLATE_NAME() { return getToken(bb1dbSqlParser.MSG_SEG_GRP_TYP_XLATE_NAME, 0); }
		public TerminalNode HL7_SELECTOR() { return getToken(bb1dbSqlParser.HL7_SELECTOR, 0); }
		public XlateOperationRhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xlateOperationRhs; }
	}

	public final XlateOperationRhsContext xlateOperationRhs() throws RecognitionException {
		XlateOperationRhsContext _localctx = new XlateOperationRhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_xlateOperationRhs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			match(MSG_SEG_GRP_TYP_XLATE_NAME);
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==HL7_SELECTOR) {
				{
				setState(192);
				match(HL7_SELECTOR);
				}
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00c6\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\7\2 \n\2\f\2\16\2#\13\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\6\3\60\n\3\r\3\16\3\61\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4B\n\4\r\4\16\4C"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\6\5T\n\5\r\5"+
		"\16\5U\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6e\n\6\r"+
		"\6\16\6f\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\6\13\u00af\n\13\r\13\16\13\u00b0\3\13\3"+
		"\13\3\13\3\f\3\f\5\f\u00b8\n\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00c0\n\f\3"+
		"\r\3\r\5\r\u00c4\n\r\3\r\2\2\16\2\4\6\b\n\f\16\20\22\24\26\30\2\2\2\u00c9"+
		"\2!\3\2\2\2\4$\3\2\2\2\6\66\3\2\2\2\bH\3\2\2\2\nZ\3\2\2\2\fk\3\2\2\2\16"+
		"v\3\2\2\2\20\u0081\3\2\2\2\22\u008b\3\2\2\2\24\u0098\3\2\2\2\26\u00bf"+
		"\3\2\2\2\30\u00c1\3\2\2\2\32 \5\4\3\2\33 \5\6\4\2\34 \5\b\5\2\35 \5\n"+
		"\6\2\36 \5\24\13\2\37\32\3\2\2\2\37\33\3\2\2\2\37\34\3\2\2\2\37\35\3\2"+
		"\2\2\37\36\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3\3\2\2\2#!\3\2"+
		"\2\2$%\7\16\2\2%&\7\3\2\2&\'\7\30\2\2\'(\7\4\2\2()\7\31\2\2)*\7\4\2\2"+
		"*+\7\34\2\2+,\7\5\2\2,/\7\6\2\2-\60\5\16\b\2.\60\5\f\7\2/-\3\2\2\2/.\3"+
		"\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63\64\7\7"+
		"\2\2\64\65\7\b\2\2\65\5\3\2\2\2\66\67\7\20\2\2\678\7\3\2\289\7\30\2\2"+
		"9:\7\4\2\2:;\7\31\2\2;<\7\4\2\2<=\7\34\2\2=>\7\5\2\2>A\7\6\2\2?B\5\f\7"+
		"\2@B\5\16\b\2A?\3\2\2\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2DE\3\2"+
		"\2\2EF\7\7\2\2FG\7\b\2\2G\7\3\2\2\2HI\7\17\2\2IJ\7\3\2\2JK\7\30\2\2KL"+
		"\7\4\2\2LM\7\31\2\2MN\7\4\2\2NO\7\34\2\2OP\7\5\2\2PS\7\6\2\2QT\5\22\n"+
		"\2RT\5\20\t\2SQ\3\2\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2"+
		"\2\2WX\7\7\2\2XY\7\b\2\2Y\t\3\2\2\2Z[\7\21\2\2[\\\7\3\2\2\\]\7\30\2\2"+
		"]^\7\4\2\2^_\7\31\2\2_`\7\4\2\2`a\7\34\2\2ab\7\5\2\2bd\7\6\2\2ce\5\20"+
		"\t\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gh\3\2\2\2hi\7\7\2\2ij\7\b"+
		"\2\2j\13\3\2\2\2kl\7\26\2\2lm\7\t\2\2mn\7\31\2\2no\7\n\2\2op\7\3\2\2p"+
		"q\7\33\2\2qr\7\4\2\2rs\7\33\2\2st\7\5\2\2tu\7\b\2\2u\r\3\2\2\2vw\7\25"+
		"\2\2wx\7\t\2\2xy\7\31\2\2yz\7\n\2\2z{\7\3\2\2{|\7\33\2\2|}\7\4\2\2}~\7"+
		"\33\2\2~\177\7\5\2\2\177\u0080\7\b\2\2\u0080\17\3\2\2\2\u0081\u0082\7"+
		"\22\2\2\u0082\u0083\7\3\2\2\u0083\u0084\7\33\2\2\u0084\u0085\7\4\2\2\u0085"+
		"\u0086\7\33\2\2\u0086\u0087\7\4\2\2\u0087\u0088\7\34\2\2\u0088\u0089\7"+
		"\5\2\2\u0089\u008a\7\b\2\2\u008a\21\3\2\2\2\u008b\u008c\7\27\2\2\u008c"+
		"\u008d\7\t\2\2\u008d\u008e\7\31\2\2\u008e\u008f\7\n\2\2\u008f\u0090\7"+
		"\3\2\2\u0090\u0091\7\33\2\2\u0091\u0092\7\4\2\2\u0092\u0093\7\33\2\2\u0093"+
		"\u0094\7\4\2\2\u0094\u0095\7\34\2\2\u0095\u0096\7\5\2\2\u0096\u0097\7"+
		"\b\2\2\u0097\23\3\2\2\2\u0098\u0099\7\23\2\2\u0099\u009a\7\3\2\2\u009a"+
		"\u009b\7\30\2\2\u009b\u009c\7\4\2\2\u009c\u009d\7\30\2\2\u009d\u009e\7"+
		"\t\2\2\u009e\u009f\7\31\2\2\u009f\u00a0\7\n\2\2\u00a0\u00a1\7\4\2\2\u00a1"+
		"\u00a2\7\30\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4\7\31\2\2\u00a4\u00a5\7"+
		"\n\2\2\u00a5\u00a6\7\4\2\2\u00a6\u00a7\7\34\2\2\u00a7\u00a8\7\5\2\2\u00a8"+
		"\u00ae\7\6\2\2\u00a9\u00aa\5\26\f\2\u00aa\u00ab\7\13\2\2\u00ab\u00ac\5"+
		"\30\r\2\u00ac\u00ad\7\b\2\2\u00ad\u00af\3\2\2\2\u00ae\u00a9\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2"+
		"\2\2\u00b2\u00b3\7\7\2\2\u00b3\u00b4\7\b\2\2\u00b4\25\3\2\2\2\u00b5\u00b7"+
		"\7\30\2\2\u00b6\u00b8\7\32\2\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2"+
		"\u00b8\u00c0\3\2\2\2\u00b9\u00ba\7\24\2\2\u00ba\u00bb\7\3\2\2\u00bb\u00bc"+
		"\7\34\2\2\u00bc\u00bd\7\4\2\2\u00bd\u00be\7\34\2\2\u00be\u00c0\7\5\2\2"+
		"\u00bf\u00b5\3\2\2\2\u00bf\u00b9\3\2\2\2\u00c0\27\3\2\2\2\u00c1\u00c3"+
		"\7\30\2\2\u00c2\u00c4\7\32\2\2\u00c3\u00c2\3\2\2\2\u00c3\u00c4\3\2\2\2"+
		"\u00c4\31\3\2\2\2\17\37!/\61ACSUf\u00b0\u00b7\u00bf\u00c3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}