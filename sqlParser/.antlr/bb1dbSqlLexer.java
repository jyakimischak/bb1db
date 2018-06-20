// Generated from /home/jyakimischak/projects/bb1db/sqlParser/bb1dbSql.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class bb1dbSqlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, COMMENT_LINE=4, COMMENT_BLOCK=5, CREATE_KW=6, 
		TABLE_KW=7, AUTO_KW=8, DROP_KW=9, ALTER_KW=10, ADD_KW=11, IDENTIFIER=12, 
		STRING=13, WS=14;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "COMMENT_LINE", "COMMENT_BLOCK", "CREATE_KW", 
		"TABLE_KW", "AUTO_KW", "DROP_KW", "ALTER_KW", "ADD_KW", "IDENTIFIER", 
		"STRING", "WS"
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


	public bb1dbSqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "bb1dbSql.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\20{\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\7\5*\n\5\f\5\16\5-\13\5\3\5\3\5\3\5\5\5\62\n\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\7\6:\n\6\f\6\16\6=\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\7\rg\n"+
		"\r\f\r\16\rj\13\r\3\16\3\16\7\16n\n\16\f\16\16\16q\13\16\3\16\3\16\3\17"+
		"\6\17v\n\17\r\17\16\17w\3\17\3\17\4+;\2\20\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\3\2\7\4\2\f\f\17\17\5\2C\\c"+
		"|~~\5\2\62;C\\c|\3\2$$\5\2\13\f\17\17\"\"\2\u0080\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7#\3\2\2\2\t%\3\2\2\2\13\65"+
		"\3\2\2\2\rC\3\2\2\2\17J\3\2\2\2\21P\3\2\2\2\23U\3\2\2\2\25Z\3\2\2\2\27"+
		"`\3\2\2\2\31d\3\2\2\2\33k\3\2\2\2\35u\3\2\2\2\37 \7*\2\2 \4\3\2\2\2!\""+
		"\7.\2\2\"\6\3\2\2\2#$\7+\2\2$\b\3\2\2\2%&\7/\2\2&\'\7/\2\2\'+\3\2\2\2"+
		"(*\13\2\2\2)(\3\2\2\2*-\3\2\2\2+,\3\2\2\2+)\3\2\2\2,\61\3\2\2\2-+\3\2"+
		"\2\2./\7\17\2\2/\62\7\f\2\2\60\62\t\2\2\2\61.\3\2\2\2\61\60\3\2\2\2\62"+
		"\63\3\2\2\2\63\64\b\5\2\2\64\n\3\2\2\2\65\66\7\61\2\2\66\67\7,\2\2\67"+
		";\3\2\2\28:\13\2\2\298\3\2\2\2:=\3\2\2\2;<\3\2\2\2;9\3\2\2\2<>\3\2\2\2"+
		"=;\3\2\2\2>?\7,\2\2?@\7\61\2\2@A\3\2\2\2AB\b\6\2\2B\f\3\2\2\2CD\7e\2\2"+
		"DE\7t\2\2EF\7g\2\2FG\7c\2\2GH\7v\2\2HI\7g\2\2I\16\3\2\2\2JK\7v\2\2KL\7"+
		"c\2\2LM\7d\2\2MN\7n\2\2NO\7g\2\2O\20\3\2\2\2PQ\7c\2\2QR\7w\2\2RS\7v\2"+
		"\2ST\7q\2\2T\22\3\2\2\2UV\7f\2\2VW\7t\2\2WX\7q\2\2XY\7r\2\2Y\24\3\2\2"+
		"\2Z[\7c\2\2[\\\7n\2\2\\]\7v\2\2]^\7g\2\2^_\7t\2\2_\26\3\2\2\2`a\7c\2\2"+
		"ab\7f\2\2bc\7f\2\2c\30\3\2\2\2dh\t\3\2\2eg\t\4\2\2fe\3\2\2\2gj\3\2\2\2"+
		"hf\3\2\2\2hi\3\2\2\2i\32\3\2\2\2jh\3\2\2\2ko\7$\2\2ln\n\5\2\2ml\3\2\2"+
		"\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3\2\2\2rs\7$\2\2s\34\3\2"+
		"\2\2tv\t\6\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xy\3\2\2\2yz\b\17"+
		"\2\2z\36\3\2\2\2\n\2+\61;fhow\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}