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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, COMMENT_LINE=6, COMMENT_BLOCK=7, 
		CREATE_KW=8, TABLE_KW=9, AUTO_KW=10, DROP_KW=11, ALTER_KW=12, ADD_KW=13, 
		INSERT_KW=14, INTO_KW=15, VALUES_KW=16, SELECT_KW=17, FROM_KW=18, WHERE_KW=19, 
		INNER_KW=20, OUTER_KW=21, LEFT_KW=22, RIGHT_KW=23, FULL_KW=24, CROSS_KW=25, 
		JOIN_KW=26, ON_KW=27, NOT_KW=28, AND_KW=29, OR_KW=30, IDENTIFIER=31, EQ=32, 
		NE=33, GT=34, GTEQ=35, LT=36, LTEQ=37, STRING=38, NUMBER=39, WS=40;
	public static final int
		RULE_prog = 0, RULE_cTab = 1, RULE_dTab = 2, RULE_aTab = 3, RULE_aTabColumn = 4, 
		RULE_insert = 5, RULE_insertCols = 6, RULE_insertVals = 7, RULE_select = 8, 
		RULE_selectColumns = 9, RULE_selectFrom = 10, RULE_selectJoin = 11, RULE_selectWhere = 12, 
		RULE_condition = 13, RULE_tableName = 14, RULE_columnName = 15, RULE_value = 16, 
		RULE_selectColumnName = 17;
	public static final String[] ruleNames = {
		"prog", "cTab", "dTab", "aTab", "aTabColumn", "insert", "insertCols", 
		"insertVals", "select", "selectColumns", "selectFrom", "selectJoin", "selectWhere", 
		"condition", "tableName", "columnName", "value", "selectColumnName"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "','", "')'", "'*'", "'.'", null, null, "'create'", "'table'", 
		"'auto'", "'drop'", "'alter'", "'add'", "'insert'", "'into'", "'values'", 
		"'select'", "'from'", "'where'", "'inner'", "'outer'", "'left'", "'right'", 
		"'full'", "'cross'", "'join'", "'on'", "'not'", "'and'", "'or'", null, 
		"'='", "'<>'", "'>'", "'>='", "'<'", "'<='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "COMMENT_LINE", "COMMENT_BLOCK", "CREATE_KW", 
		"TABLE_KW", "AUTO_KW", "DROP_KW", "ALTER_KW", "ADD_KW", "INSERT_KW", "INTO_KW", 
		"VALUES_KW", "SELECT_KW", "FROM_KW", "WHERE_KW", "INNER_KW", "OUTER_KW", 
		"LEFT_KW", "RIGHT_KW", "FULL_KW", "CROSS_KW", "JOIN_KW", "ON_KW", "NOT_KW", 
		"AND_KW", "OR_KW", "IDENTIFIER", "EQ", "NE", "GT", "GTEQ", "LT", "LTEQ", 
		"STRING", "NUMBER", "WS"
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
		public SelectContext select() {
			return getRuleContext(SelectContext.class,0);
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
			setState(41);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CREATE_KW:
				{
				setState(36);
				cTab();
				}
				break;
			case DROP_KW:
				{
				setState(37);
				dTab();
				}
				break;
			case ALTER_KW:
				{
				setState(38);
				aTab();
				}
				break;
			case INSERT_KW:
				{
				setState(39);
				insert();
				}
				break;
			case SELECT_KW:
				{
				setState(40);
				select();
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
			setState(43);
			match(CREATE_KW);
			setState(44);
			match(TABLE_KW);
			setState(45);
			tableName();
			setState(46);
			match(T__0);
			setState(47);
			columnName();
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AUTO_KW) {
				{
				setState(48);
				match(AUTO_KW);
				}
			}

			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(51);
				match(T__1);
				setState(52);
				columnName();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
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
			setState(60);
			match(DROP_KW);
			setState(61);
			match(TABLE_KW);
			setState(62);
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
			setState(64);
			match(ALTER_KW);
			setState(65);
			match(TABLE_KW);
			setState(66);
			tableName();
			setState(67);
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
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_KW:
				{
				setState(69);
				match(ADD_KW);
				setState(70);
				columnName();
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(71);
					match(T__1);
					setState(72);
					columnName();
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DROP_KW:
				{
				setState(78);
				match(DROP_KW);
				setState(79);
				columnName();
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(80);
					match(T__1);
					setState(81);
					columnName();
					}
					}
					setState(86);
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
			setState(89);
			match(INSERT_KW);
			setState(90);
			match(INTO_KW);
			setState(91);
			tableName();
			setState(92);
			insertCols();
			setState(93);
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
			setState(95);
			match(T__0);
			setState(96);
			columnName();
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(97);
				match(T__1);
				setState(98);
				columnName();
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
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
			setState(106);
			match(VALUES_KW);
			setState(107);
			match(T__0);
			setState(108);
			value();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(109);
				match(T__1);
				setState(110);
				value();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(116);
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

	public static class SelectContext extends ParserRuleContext {
		public SelectColumnsContext selectColumns() {
			return getRuleContext(SelectColumnsContext.class,0);
		}
		public SelectFromContext selectFrom() {
			return getRuleContext(SelectFromContext.class,0);
		}
		public SelectWhereContext selectWhere() {
			return getRuleContext(SelectWhereContext.class,0);
		}
		public SelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select; }
	}

	public final SelectContext select() throws RecognitionException {
		SelectContext _localctx = new SelectContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_select);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			selectColumns();
			setState(119);
			selectFrom();
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE_KW) {
				{
				setState(120);
				selectWhere();
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

	public static class SelectColumnsContext extends ParserRuleContext {
		public TerminalNode SELECT_KW() { return getToken(bb1dbSqlParser.SELECT_KW, 0); }
		public List<SelectColumnNameContext> selectColumnName() {
			return getRuleContexts(SelectColumnNameContext.class);
		}
		public SelectColumnNameContext selectColumnName(int i) {
			return getRuleContext(SelectColumnNameContext.class,i);
		}
		public SelectColumnsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectColumns; }
	}

	public final SelectColumnsContext selectColumns() throws RecognitionException {
		SelectColumnsContext _localctx = new SelectColumnsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_selectColumns);
		int _la;
		try {
			setState(134);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(123);
				match(SELECT_KW);
				setState(124);
				match(T__3);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(SELECT_KW);
				setState(126);
				selectColumnName();
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(127);
					match(T__1);
					setState(128);
					selectColumnName();
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class SelectFromContext extends ParserRuleContext {
		public TerminalNode FROM_KW() { return getToken(bb1dbSqlParser.FROM_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<SelectJoinContext> selectJoin() {
			return getRuleContexts(SelectJoinContext.class);
		}
		public SelectJoinContext selectJoin(int i) {
			return getRuleContext(SelectJoinContext.class,i);
		}
		public SelectFromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectFrom; }
	}

	public final SelectFromContext selectFrom() throws RecognitionException {
		SelectFromContext _localctx = new SelectFromContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_selectFrom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(FROM_KW);
			setState(137);
			tableName();
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INNER_KW) | (1L << LEFT_KW) | (1L << RIGHT_KW) | (1L << FULL_KW) | (1L << CROSS_KW) | (1L << JOIN_KW))) != 0)) {
				{
				{
				setState(138);
				selectJoin();
				}
				}
				setState(143);
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

	public static class SelectJoinContext extends ParserRuleContext {
		public TerminalNode JOIN_KW() { return getToken(bb1dbSqlParser.JOIN_KW, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode ON_KW() { return getToken(bb1dbSqlParser.ON_KW, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode INNER_KW() { return getToken(bb1dbSqlParser.INNER_KW, 0); }
		public TerminalNode LEFT_KW() { return getToken(bb1dbSqlParser.LEFT_KW, 0); }
		public TerminalNode OUTER_KW() { return getToken(bb1dbSqlParser.OUTER_KW, 0); }
		public TerminalNode RIGHT_KW() { return getToken(bb1dbSqlParser.RIGHT_KW, 0); }
		public TerminalNode FULL_KW() { return getToken(bb1dbSqlParser.FULL_KW, 0); }
		public TerminalNode CROSS_KW() { return getToken(bb1dbSqlParser.CROSS_KW, 0); }
		public SelectJoinContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectJoin; }
	}

	public final SelectJoinContext selectJoin() throws RecognitionException {
		SelectJoinContext _localctx = new SelectJoinContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_selectJoin);
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==INNER_KW) {
					{
					setState(144);
					match(INNER_KW);
					}
				}

				setState(147);
				match(JOIN_KW);
				setState(148);
				tableName();
				setState(149);
				match(ON_KW);
				setState(150);
				condition(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(LEFT_KW);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER_KW) {
					{
					setState(153);
					match(OUTER_KW);
					}
				}

				setState(156);
				match(JOIN_KW);
				setState(157);
				tableName();
				setState(158);
				match(ON_KW);
				setState(159);
				condition(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(161);
				match(RIGHT_KW);
				setState(163);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER_KW) {
					{
					setState(162);
					match(OUTER_KW);
					}
				}

				setState(165);
				match(JOIN_KW);
				setState(166);
				tableName();
				setState(167);
				match(ON_KW);
				setState(168);
				condition(0);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				match(FULL_KW);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OUTER_KW) {
					{
					setState(171);
					match(OUTER_KW);
					}
				}

				setState(174);
				match(JOIN_KW);
				setState(175);
				tableName();
				setState(176);
				match(ON_KW);
				setState(177);
				condition(0);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CROSS_KW) {
					{
					setState(179);
					match(CROSS_KW);
					}
				}

				setState(182);
				match(JOIN_KW);
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

	public static class SelectWhereContext extends ParserRuleContext {
		public TerminalNode WHERE_KW() { return getToken(bb1dbSqlParser.WHERE_KW, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public SelectWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectWhere; }
	}

	public final SelectWhereContext selectWhere() throws RecognitionException {
		SelectWhereContext _localctx = new SelectWhereContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_selectWhere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(WHERE_KW);
			setState(186);
			condition(0);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<SelectColumnNameContext> selectColumnName() {
			return getRuleContexts(SelectColumnNameContext.class);
		}
		public SelectColumnNameContext selectColumnName(int i) {
			return getRuleContext(SelectColumnNameContext.class,i);
		}
		public TerminalNode EQ() { return getToken(bb1dbSqlParser.EQ, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NOT_KW() { return getToken(bb1dbSqlParser.NOT_KW, 0); }
		public TerminalNode NE() { return getToken(bb1dbSqlParser.NE, 0); }
		public TerminalNode GT() { return getToken(bb1dbSqlParser.GT, 0); }
		public TerminalNode GTEQ() { return getToken(bb1dbSqlParser.GTEQ, 0); }
		public TerminalNode LT() { return getToken(bb1dbSqlParser.LT, 0); }
		public TerminalNode LTEQ() { return getToken(bb1dbSqlParser.LTEQ, 0); }
		public TerminalNode AND_KW() { return getToken(bb1dbSqlParser.AND_KW, 0); }
		public TerminalNode OR_KW() { return getToken(bb1dbSqlParser.OR_KW, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
	}

	public final ConditionContext condition() throws RecognitionException {
		return condition(0);
	}

	private ConditionContext condition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
		ConditionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_condition, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(189);
				match(T__0);
				setState(190);
				condition(0);
				setState(191);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(193);
					match(NOT_KW);
					}
				}

				setState(196);
				selectColumnName();
				setState(197);
				match(EQ);
				setState(200);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(198);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(199);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(202);
					match(NOT_KW);
					}
				}

				setState(205);
				selectColumnName();
				setState(206);
				match(NE);
				setState(209);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(207);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(208);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(211);
					match(NOT_KW);
					}
				}

				setState(214);
				selectColumnName();
				setState(215);
				match(GT);
				setState(218);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(216);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(217);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 5:
				{
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(220);
					match(NOT_KW);
					}
				}

				setState(223);
				selectColumnName();
				setState(224);
				match(GTEQ);
				setState(227);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(225);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(226);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 6:
				{
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(229);
					match(NOT_KW);
					}
				}

				setState(232);
				selectColumnName();
				setState(233);
				match(LT);
				setState(236);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(234);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(235);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 7:
				{
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NOT_KW) {
					{
					setState(238);
					match(NOT_KW);
					}
				}

				setState(241);
				selectColumnName();
				setState(242);
				match(LTEQ);
				setState(245);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STRING:
				case NUMBER:
					{
					setState(243);
					value();
					}
					break;
				case IDENTIFIER:
					{
					setState(244);
					selectColumnName();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(257);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(255);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
					case 1:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(249);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(250);
						match(AND_KW);
						setState(251);
						condition(3);
						}
						break;
					case 2:
						{
						_localctx = new ConditionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_condition);
						setState(252);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(253);
						match(OR_KW);
						setState(254);
						condition(2);
						}
						break;
					}
					} 
				}
				setState(259);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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

	public static class TableNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(bb1dbSqlParser.IDENTIFIER, 0); }
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
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
		enterRule(_localctx, 30, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
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
		enterRule(_localctx, 32, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
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

	public static class SelectColumnNameContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(bb1dbSqlParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(bb1dbSqlParser.IDENTIFIER, i);
		}
		public SelectColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectColumnName; }
	}

	public final SelectColumnNameContext selectColumnName() throws RecognitionException {
		SelectColumnNameContext _localctx = new SelectColumnNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_selectColumnName);
		try {
			setState(270);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(IDENTIFIER);
				setState(268);
				match(T__4);
				setState(269);
				match(IDENTIFIER);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\5\2,\n\2\3\3\3\3\3\3\3\3\3\3\3\3\5\3\64"+
		"\n\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\6\3\6\3\6\3\6\7\6"+
		"U\n\6\f\6\16\6X\13\6\5\6Z\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\7\bf\n\b\f\b\16\bi\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\tr\n\t\f\t\16\t"+
		"u\13\t\3\t\3\t\3\n\3\n\3\n\5\n|\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u0084\n\13\f\13\16\13\u0087\13\13\5\13\u0089\n\13\3\f\3\f\3\f\7\f\u008e"+
		"\n\f\f\f\16\f\u0091\13\f\3\r\5\r\u0094\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\5\r\u009d\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00a6\n\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\5\r\u00af\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b7\n\r\3\r"+
		"\5\r\u00ba\n\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00c5"+
		"\n\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3\17\5\17\u00ce\n\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00d4\n\17\3\17\5\17\u00d7\n\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00dd\n\17\3\17\5\17\u00e0\n\17\3\17\3\17\3\17\3\17\5\17\u00e6\n"+
		"\17\3\17\5\17\u00e9\n\17\3\17\3\17\3\17\3\17\5\17\u00ef\n\17\3\17\5\17"+
		"\u00f2\n\17\3\17\3\17\3\17\3\17\5\17\u00f8\n\17\5\17\u00fa\n\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u0102\n\17\f\17\16\17\u0105\13\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u0111\n\23\3\23\2\3\34"+
		"\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\3\3\2()\2\u012d\2+\3"+
		"\2\2\2\4-\3\2\2\2\6>\3\2\2\2\bB\3\2\2\2\nY\3\2\2\2\f[\3\2\2\2\16a\3\2"+
		"\2\2\20l\3\2\2\2\22x\3\2\2\2\24\u0088\3\2\2\2\26\u008a\3\2\2\2\30\u00b9"+
		"\3\2\2\2\32\u00bb\3\2\2\2\34\u00f9\3\2\2\2\36\u0106\3\2\2\2 \u0108\3\2"+
		"\2\2\"\u010a\3\2\2\2$\u0110\3\2\2\2&,\5\4\3\2\',\5\6\4\2(,\5\b\5\2),\5"+
		"\f\7\2*,\5\22\n\2+&\3\2\2\2+\'\3\2\2\2+(\3\2\2\2+)\3\2\2\2+*\3\2\2\2,"+
		"\3\3\2\2\2-.\7\n\2\2./\7\13\2\2/\60\5\36\20\2\60\61\7\3\2\2\61\63\5 \21"+
		"\2\62\64\7\f\2\2\63\62\3\2\2\2\63\64\3\2\2\2\649\3\2\2\2\65\66\7\4\2\2"+
		"\668\5 \21\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2;"+
		"9\3\2\2\2<=\7\5\2\2=\5\3\2\2\2>?\7\r\2\2?@\7\13\2\2@A\5\36\20\2A\7\3\2"+
		"\2\2BC\7\16\2\2CD\7\13\2\2DE\5\36\20\2EF\5\n\6\2F\t\3\2\2\2GH\7\17\2\2"+
		"HM\5 \21\2IJ\7\4\2\2JL\5 \21\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2"+
		"NZ\3\2\2\2OM\3\2\2\2PQ\7\r\2\2QV\5 \21\2RS\7\4\2\2SU\5 \21\2TR\3\2\2\2"+
		"UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2WZ\3\2\2\2XV\3\2\2\2YG\3\2\2\2YP\3\2\2\2"+
		"Z\13\3\2\2\2[\\\7\20\2\2\\]\7\21\2\2]^\5\36\20\2^_\5\16\b\2_`\5\20\t\2"+
		"`\r\3\2\2\2ab\7\3\2\2bg\5 \21\2cd\7\4\2\2df\5 \21\2ec\3\2\2\2fi\3\2\2"+
		"\2ge\3\2\2\2gh\3\2\2\2hj\3\2\2\2ig\3\2\2\2jk\7\5\2\2k\17\3\2\2\2lm\7\22"+
		"\2\2mn\7\3\2\2ns\5\"\22\2op\7\4\2\2pr\5\"\22\2qo\3\2\2\2ru\3\2\2\2sq\3"+
		"\2\2\2st\3\2\2\2tv\3\2\2\2us\3\2\2\2vw\7\5\2\2w\21\3\2\2\2xy\5\24\13\2"+
		"y{\5\26\f\2z|\5\32\16\2{z\3\2\2\2{|\3\2\2\2|\23\3\2\2\2}~\7\23\2\2~\u0089"+
		"\7\6\2\2\177\u0080\7\23\2\2\u0080\u0085\5$\23\2\u0081\u0082\7\4\2\2\u0082"+
		"\u0084\5$\23\2\u0083\u0081\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2"+
		"\2\2\u0085\u0086\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0088"+
		"}\3\2\2\2\u0088\177\3\2\2\2\u0089\25\3\2\2\2\u008a\u008b\7\24\2\2\u008b"+
		"\u008f\5\36\20\2\u008c\u008e\5\30\r\2\u008d\u008c\3\2\2\2\u008e\u0091"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\27\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\7\26\2\2\u0093\u0092\3\2\2\2\u0093\u0094\3"+
		"\2\2\2\u0094\u0095\3\2\2\2\u0095\u0096\7\34\2\2\u0096\u0097\5\36\20\2"+
		"\u0097\u0098\7\35\2\2\u0098\u0099\5\34\17\2\u0099\u00ba\3\2\2\2\u009a"+
		"\u009c\7\30\2\2\u009b\u009d\7\27\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3"+
		"\2\2\2\u009d\u009e\3\2\2\2\u009e\u009f\7\34\2\2\u009f\u00a0\5\36\20\2"+
		"\u00a0\u00a1\7\35\2\2\u00a1\u00a2\5\34\17\2\u00a2\u00ba\3\2\2\2\u00a3"+
		"\u00a5\7\31\2\2\u00a4\u00a6\7\27\2\2\u00a5\u00a4\3\2\2\2\u00a5\u00a6\3"+
		"\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a8\7\34\2\2\u00a8\u00a9\5\36\20\2"+
		"\u00a9\u00aa\7\35\2\2\u00aa\u00ab\5\34\17\2\u00ab\u00ba\3\2\2\2\u00ac"+
		"\u00ae\7\32\2\2\u00ad\u00af\7\27\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3"+
		"\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\5\36\20\2"+
		"\u00b2\u00b3\7\35\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00ba\3\2\2\2\u00b5"+
		"\u00b7\7\33\2\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3"+
		"\2\2\2\u00b8\u00ba\7\34\2\2\u00b9\u0093\3\2\2\2\u00b9\u009a\3\2\2\2\u00b9"+
		"\u00a3\3\2\2\2\u00b9\u00ac\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\31\3\2\2"+
		"\2\u00bb\u00bc\7\25\2\2\u00bc\u00bd\5\34\17\2\u00bd\33\3\2\2\2\u00be\u00bf"+
		"\b\17\1\2\u00bf\u00c0\7\3\2\2\u00c0\u00c1\5\34\17\2\u00c1\u00c2\7\5\2"+
		"\2\u00c2\u00fa\3\2\2\2\u00c3\u00c5\7\36\2\2\u00c4\u00c3\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\5$\23\2\u00c7\u00ca\7\""+
		"\2\2\u00c8\u00cb\5\"\22\2\u00c9\u00cb\5$\23\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00fa\3\2\2\2\u00cc\u00ce\7\36\2\2\u00cd\u00cc\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d0\5$\23\2\u00d0"+
		"\u00d3\7#\2\2\u00d1\u00d4\5\"\22\2\u00d2\u00d4\5$\23\2\u00d3\u00d1\3\2"+
		"\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00fa\3\2\2\2\u00d5\u00d7\7\36\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d9\5$"+
		"\23\2\u00d9\u00dc\7$\2\2\u00da\u00dd\5\"\22\2\u00db\u00dd\5$\23\2\u00dc"+
		"\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00fa\3\2\2\2\u00de\u00e0\7\36"+
		"\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\5$\23\2\u00e2\u00e5\7%\2\2\u00e3\u00e6\5\"\22\2\u00e4\u00e6\5$"+
		"\23\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6\u00fa\3\2\2\2\u00e7"+
		"\u00e9\7\36\2\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00eb\5$\23\2\u00eb\u00ee\7&\2\2\u00ec\u00ef\5\"\22\2\u00ed"+
		"\u00ef\5$\23\2\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00fa\3\2"+
		"\2\2\u00f0\u00f2\7\36\2\2\u00f1\u00f0\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\5$\23\2\u00f4\u00f7\7\'\2\2\u00f5\u00f8\5\""+
		"\22\2\u00f6\u00f8\5$\23\2\u00f7\u00f5\3\2\2\2\u00f7\u00f6\3\2\2\2\u00f8"+
		"\u00fa\3\2\2\2\u00f9\u00be\3\2\2\2\u00f9\u00c4\3\2\2\2\u00f9\u00cd\3\2"+
		"\2\2\u00f9\u00d6\3\2\2\2\u00f9\u00df\3\2\2\2\u00f9\u00e8\3\2\2\2\u00f9"+
		"\u00f1\3\2\2\2\u00fa\u0103\3\2\2\2\u00fb\u00fc\f\4\2\2\u00fc\u00fd\7\37"+
		"\2\2\u00fd\u0102\5\34\17\5\u00fe\u00ff\f\3\2\2\u00ff\u0100\7 \2\2\u0100"+
		"\u0102\5\34\17\4\u0101\u00fb\3\2\2\2\u0101\u00fe\3\2\2\2\u0102\u0105\3"+
		"\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\35\3\2\2\2\u0105"+
		"\u0103\3\2\2\2\u0106\u0107\7!\2\2\u0107\37\3\2\2\2\u0108\u0109\7!\2\2"+
		"\u0109!\3\2\2\2\u010a\u010b\t\2\2\2\u010b#\3\2\2\2\u010c\u0111\7!\2\2"+
		"\u010d\u010e\7!\2\2\u010e\u010f\7\7\2\2\u010f\u0111\7!\2\2\u0110\u010c"+
		"\3\2\2\2\u0110\u010d\3\2\2\2\u0111%\3\2\2\2$+\639MVYgs{\u0085\u0088\u008f"+
		"\u0093\u009c\u00a5\u00ae\u00b6\u00b9\u00c4\u00ca\u00cd\u00d3\u00d6\u00dc"+
		"\u00df\u00e5\u00e8\u00ee\u00f1\u00f7\u00f9\u0101\u0103\u0110";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}