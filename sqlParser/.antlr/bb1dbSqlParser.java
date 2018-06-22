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
		TABLE_KW=7, AUTO_KW=8, DROP_KW=9, ALTER_KW=10, ADD_KW=11, INSERT_KW=12, 
		INTO_KW=13, VALUES_KW=14, IDENTIFIER=15, STRING=16, NUMBER=17, WS=18;
	public static final int
		RULE_prog = 0, RULE_cTab = 1, RULE_dTab = 2, RULE_aTab = 3, RULE_aTabColumn = 4, 
		RULE_insert = 5, RULE_insertCols = 6, RULE_insertVals = 7, RULE_tableName = 8, 
		RULE_columnName = 9, RULE_value = 10;
	public static final String[] ruleNames = {
		"prog", "cTab", "dTab", "aTab", "aTabColumn", "insert", "insertCols", 
		"insertVals", "tableName", "columnName", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", null, null, "'create'", "'table'", "'auto'", 
		"'drop'", "'alter'", "'add'", "'insert'", "'into'", "'values'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "COMMENT_LINE", "COMMENT_BLOCK", "CREATE_KW", 
		"TABLE_KW", "AUTO_KW", "DROP_KW", "ALTER_KW", "ADD_KW", "INSERT_KW", "INTO_KW", 
		"VALUES_KW", "IDENTIFIER", "STRING", "NUMBER", "WS"
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
		public InsertContext insert() {
			return getRuleContext(InsertContext.class,0);
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
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE_KW:
				{
				setState(22);
				cTab();
				}
				break;
			case DROP_KW:
				{
				setState(23);
				dTab();
				}
				break;
			case ALTER_KW:
				{
				setState(24);
				aTab();
				}
				break;
			case INSERT_KW:
				{
				setState(25);
				insert();
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
			setState(28);
			match(CREATE_KW);
			setState(29);
			match(TABLE_KW);
			setState(30);
			tableName();
			setState(31);
			match(T__0);
			setState(32);
			columnName();
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AUTO_KW) {
				{
				setState(33);
				match(AUTO_KW);
				}
			}

			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(36);
				match(T__1);
				setState(37);
				columnName();
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(43);
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
			setState(45);
			match(DROP_KW);
			setState(46);
			match(TABLE_KW);
			setState(47);
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
			setState(49);
			match(ALTER_KW);
			setState(50);
			match(TABLE_KW);
			setState(51);
			tableName();
			setState(52);
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
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_KW:
				{
				setState(54);
				match(ADD_KW);
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
			case DROP_KW:
				{
				setState(63);
				match(DROP_KW);
				setState(64);
				columnName();
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(65);
					match(T__1);
					setState(66);
					columnName();
					}
					}
					setState(71);
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

	public static class InsertContext extends ParserRuleContext {
		public TerminalNode INSERT_KW() { return getToken(bb1dbSqlParser.INSERT_KW, 0); }
		public TerminalNode INTO_KW() { return getToken(bb1dbSqlParser.INTO_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public InsertColsContext insertCols() {
			return getRuleContext(InsertColsContext.class,0);
		}
		public InsertValsContext insertVals() {
			return getRuleContext(InsertValsContext.class,0);
		}
		public InsertContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert; }
	}

	public final InsertContext insert() throws RecognitionException {
		InsertContext _localctx = new InsertContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_insert);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(INSERT_KW);
			setState(75);
			match(INTO_KW);
			setState(76);
			tableName();
			setState(77);
			insertCols();
			setState(78);
			insertVals();
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

	public static class InsertColsContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public InsertColsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertCols; }
	}

	public final InsertColsContext insertCols() throws RecognitionException {
		InsertColsContext _localctx = new InsertColsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_insertCols);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(81);
			columnName();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(82);
				match(T__1);
				setState(83);
				columnName();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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

	public static class InsertValsContext extends ParserRuleContext {
		public TerminalNode VALUES_KW() { return getToken(bb1dbSqlParser.VALUES_KW, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public InsertValsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertVals; }
	}

	public final InsertValsContext insertVals() throws RecognitionException {
		InsertValsContext _localctx = new InsertValsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_insertVals);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(VALUES_KW);
			setState(92);
			match(T__0);
			setState(93);
			value();
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(94);
				match(T__1);
				setState(95);
				value();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(bb1dbSqlParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
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
		enterRule(_localctx, 18, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
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

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(bb1dbSqlParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(bb1dbSqlParser.NUMBER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==NUMBER) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24p\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\3\2\3\2\3\2\5\2\35\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3%\n\3\3\3"+
		"\3\3\7\3)\n\3\f\3\16\3,\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\6\3\6\7\6F\n\6\f"+
		"\6\16\6I\13\6\5\6K\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\7\bW\n"+
		"\b\f\b\16\bZ\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tc\n\t\f\t\16\tf\13\t"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26"+
		"\2\3\3\2\22\23\2n\2\34\3\2\2\2\4\36\3\2\2\2\6/\3\2\2\2\b\63\3\2\2\2\n"+
		"J\3\2\2\2\fL\3\2\2\2\16R\3\2\2\2\20]\3\2\2\2\22i\3\2\2\2\24k\3\2\2\2\26"+
		"m\3\2\2\2\30\35\5\4\3\2\31\35\5\6\4\2\32\35\5\b\5\2\33\35\5\f\7\2\34\30"+
		"\3\2\2\2\34\31\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35\3\3\2\2\2\36\37"+
		"\7\b\2\2\37 \7\t\2\2 !\5\22\n\2!\"\7\3\2\2\"$\5\24\13\2#%\7\n\2\2$#\3"+
		"\2\2\2$%\3\2\2\2%*\3\2\2\2&\'\7\4\2\2\')\5\24\13\2(&\3\2\2\2),\3\2\2\2"+
		"*(\3\2\2\2*+\3\2\2\2+-\3\2\2\2,*\3\2\2\2-.\7\5\2\2.\5\3\2\2\2/\60\7\13"+
		"\2\2\60\61\7\t\2\2\61\62\5\22\n\2\62\7\3\2\2\2\63\64\7\f\2\2\64\65\7\t"+
		"\2\2\65\66\5\22\n\2\66\67\5\n\6\2\67\t\3\2\2\289\7\r\2\29>\5\24\13\2:"+
		";\7\4\2\2;=\5\24\13\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?K\3\2\2"+
		"\2@>\3\2\2\2AB\7\13\2\2BG\5\24\13\2CD\7\4\2\2DF\5\24\13\2EC\3\2\2\2FI"+
		"\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2J8\3\2\2\2JA\3\2\2\2K"+
		"\13\3\2\2\2LM\7\16\2\2MN\7\17\2\2NO\5\22\n\2OP\5\16\b\2PQ\5\20\t\2Q\r"+
		"\3\2\2\2RS\7\3\2\2SX\5\24\13\2TU\7\4\2\2UW\5\24\13\2VT\3\2\2\2WZ\3\2\2"+
		"\2XV\3\2\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\5\2\2\\\17\3\2\2\2]^\7"+
		"\20\2\2^_\7\3\2\2_d\5\26\f\2`a\7\4\2\2ac\5\26\f\2b`\3\2\2\2cf\3\2\2\2"+
		"db\3\2\2\2de\3\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\5\2\2h\21\3\2\2\2ij\7\21"+
		"\2\2j\23\3\2\2\2kl\7\21\2\2l\25\3\2\2\2mn\t\2\2\2n\27\3\2\2\2\n\34$*>"+
		"GJXd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}