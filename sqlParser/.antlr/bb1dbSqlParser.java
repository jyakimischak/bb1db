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
		T__0=1, T__1=2, T__2=3, COMMENT_LINE=4, COMMENT_BLOCK=5, CREATE_KW=6, 
		TABLE_KW=7, AUTO_KW=8, DROP_KW=9, ALTER_KW=10, ADD_KW=11, IDENTIFIER=12, 
		STRING=13, WS=14;
	public static final int
		RULE_prog = 0, RULE_cTab = 1, RULE_dTab = 2, RULE_aTab = 3, RULE_aTabColumn = 4, 
		RULE_tableName = 5, RULE_columnName = 6;
	public static final String[] ruleNames = {
		"prog", "cTab", "dTab", "aTab", "aTabColumn", "tableName", "columnName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", null, null, "'create'", "'table'", "'auto'", 
		"'drop'", "'alter'", "'add'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "COMMENT_LINE", "COMMENT_BLOCK", "CREATE_KW", 
		"TABLE_KW", "AUTO_KW", "DROP_KW", "ALTER_KW", "ADD_KW", "IDENTIFIER", 
		"STRING", "WS"
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
		public CTabContext cTab() {
			return getRuleContext(CTabContext.class,0);
		}
		public DTabContext dTab() {
			return getRuleContext(DTabContext.class,0);
		}
		public ATabContext aTab() {
			return getRuleContext(ATabContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(17);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE_KW:
				{
				setState(14);
				cTab();
				}
				break;
			case DROP_KW:
				{
				setState(15);
				dTab();
				}
				break;
			case ALTER_KW:
				{
				setState(16);
				aTab();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class CTabContext extends ParserRuleContext {
		public TerminalNode CREATE_KW() { return getToken(bb1dbSqlParser.CREATE_KW, 0); }
		public TerminalNode TABLE_KW() { return getToken(bb1dbSqlParser.TABLE_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode AUTO_KW() { return getToken(bb1dbSqlParser.AUTO_KW, 0); }
		public CTabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cTab; }
	}

	public final CTabContext cTab() throws RecognitionException {
		CTabContext _localctx = new CTabContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cTab);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			match(CREATE_KW);
			setState(20);
			match(TABLE_KW);
			setState(21);
			tableName();
			setState(22);
			match(T__0);
			setState(23);
			columnName();
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AUTO_KW) {
				{
				setState(24);
				match(AUTO_KW);
				}
			}

			setState(31);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(27);
				match(T__1);
				setState(28);
				columnName();
				}
				}
				setState(33);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(34);
			match(T__2);
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

	public static class DTabContext extends ParserRuleContext {
		public TerminalNode DROP_KW() { return getToken(bb1dbSqlParser.DROP_KW, 0); }
		public TerminalNode TABLE_KW() { return getToken(bb1dbSqlParser.TABLE_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DTabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dTab; }
	}

	public final DTabContext dTab() throws RecognitionException {
		DTabContext _localctx = new DTabContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_dTab);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(DROP_KW);
			setState(37);
			match(TABLE_KW);
			setState(38);
			tableName();
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

	public static class ATabContext extends ParserRuleContext {
		public TerminalNode ALTER_KW() { return getToken(bb1dbSqlParser.ALTER_KW, 0); }
		public TerminalNode TABLE_KW() { return getToken(bb1dbSqlParser.TABLE_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ATabColumnContext aTabColumn() {
			return getRuleContext(ATabColumnContext.class,0);
		}
		public ATabContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aTab; }
	}

	public final ATabContext aTab() throws RecognitionException {
		ATabContext _localctx = new ATabContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_aTab);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(ALTER_KW);
			setState(41);
			match(TABLE_KW);
			setState(42);
			tableName();
			setState(43);
			aTabColumn();
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

	public static class ATabColumnContext extends ParserRuleContext {
		public TerminalNode ADD_KW() { return getToken(bb1dbSqlParser.ADD_KW, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public TerminalNode DROP_KW() { return getToken(bb1dbSqlParser.DROP_KW, 0); }
		public ATabColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aTabColumn; }
	}

	public final ATabColumnContext aTabColumn() throws RecognitionException {
		ATabColumnContext _localctx = new ATabColumnContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_aTabColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_KW:
				{
				setState(45);
				match(ADD_KW);
				setState(46);
				columnName();
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(47);
					match(T__1);
					setState(48);
					columnName();
					}
					}
					setState(53);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DROP_KW:
				{
				setState(54);
				match(DROP_KW);
				setState(55);
				columnName();
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(56);
					match(T__1);
					setState(57);
					columnName();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(bb1dbSqlParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			match(IDENTIFIER);
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

	public static class ColumnNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(bb1dbSqlParser.IDENTIFIER, 0); }
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(IDENTIFIER);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20H\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\5\2\24\n\2\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\34\n\3\3\3\3\3\7\3 \n\3\f\3\16\3#\13\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6\64\n\6\f\6"+
		"\16\6\67\13\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\5\6B\n\6\3\7\3\7"+
		"\3\b\3\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2G\2\23\3\2\2\2\4\25\3\2\2\2\6&"+
		"\3\2\2\2\b*\3\2\2\2\nA\3\2\2\2\fC\3\2\2\2\16E\3\2\2\2\20\24\5\4\3\2\21"+
		"\24\5\6\4\2\22\24\5\b\5\2\23\20\3\2\2\2\23\21\3\2\2\2\23\22\3\2\2\2\24"+
		"\3\3\2\2\2\25\26\7\b\2\2\26\27\7\t\2\2\27\30\5\f\7\2\30\31\7\3\2\2\31"+
		"\33\5\16\b\2\32\34\7\n\2\2\33\32\3\2\2\2\33\34\3\2\2\2\34!\3\2\2\2\35"+
		"\36\7\4\2\2\36 \5\16\b\2\37\35\3\2\2\2 #\3\2\2\2!\37\3\2\2\2!\"\3\2\2"+
		"\2\"$\3\2\2\2#!\3\2\2\2$%\7\5\2\2%\5\3\2\2\2&\'\7\13\2\2\'(\7\t\2\2()"+
		"\5\f\7\2)\7\3\2\2\2*+\7\f\2\2+,\7\t\2\2,-\5\f\7\2-.\5\n\6\2.\t\3\2\2\2"+
		"/\60\7\r\2\2\60\65\5\16\b\2\61\62\7\4\2\2\62\64\5\16\b\2\63\61\3\2\2\2"+
		"\64\67\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66B\3\2\2\2\67\65\3\2\2\28"+
		"9\7\13\2\29>\5\16\b\2:;\7\4\2\2;=\5\16\b\2<:\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2>?\3\2\2\2?B\3\2\2\2@>\3\2\2\2A/\3\2\2\2A8\3\2\2\2B\13\3\2\2\2CD\7\16"+
		"\2\2D\r\3\2\2\2EF\7\16\2\2F\17\3\2\2\2\b\23\33!\65>A";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}