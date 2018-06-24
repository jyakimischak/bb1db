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
		TABLE_KW=7, AUTO_KW=8, DROP_KW=9, ALTER_KW=10, ADD_KW=11, INSERT_KW=12, 
		INTO_KW=13, VALUES_KW=14, IDENTIFIER=15, STRING=16, NUMBER=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "COMMENT_LINE", "COMMENT_BLOCK", "CREATE_KW", 
		"TABLE_KW", "AUTO_KW", "DROP_KW", "ALTER_KW", "ADD_KW", "INSERT_KW", "INTO_KW", 
		"VALUES_KW", "IDENTIFIER", "STRING", "NUMBER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u00b3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\7\5\62\n\5\f\5"+
		"\16\5\65\13\5\3\5\3\5\3\5\5\5:\n\5\3\5\3\5\3\6\3\6\3\6\3\6\7\6B\n\6\f"+
		"\6\16\6E\13\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\7\20\u0082"+
		"\n\20\f\20\16\20\u0085\13\20\3\21\3\21\3\21\3\21\7\21\u008b\n\21\f\21"+
		"\16\21\u008e\13\21\3\21\3\21\3\22\5\22\u0093\n\22\3\22\6\22\u0096\n\22"+
		"\r\22\16\22\u0097\3\22\5\22\u009b\n\22\3\22\6\22\u009e\n\22\r\22\16\22"+
		"\u009f\3\22\5\22\u00a3\n\22\3\22\7\22\u00a6\n\22\f\22\16\22\u00a9\13\22"+
		"\5\22\u00ab\n\22\3\23\6\23\u00ae\n\23\r\23\16\23\u00af\3\23\3\23\4\63"+
		"C\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\3\2\b\4\2\f\f\17\17\5\2C\\c|~~\5\2\62;C\\c|\3"+
		"\2))\3\2\62;\5\2\13\f\17\17\"\"\2\u00c0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)"+
		"\3\2\2\2\7+\3\2\2\2\t-\3\2\2\2\13=\3\2\2\2\rK\3\2\2\2\17R\3\2\2\2\21X"+
		"\3\2\2\2\23]\3\2\2\2\25b\3\2\2\2\27h\3\2\2\2\31l\3\2\2\2\33s\3\2\2\2\35"+
		"x\3\2\2\2\37\177\3\2\2\2!\u0086\3\2\2\2#\u00aa\3\2\2\2%\u00ad\3\2\2\2"+
		"\'(\7*\2\2(\4\3\2\2\2)*\7.\2\2*\6\3\2\2\2+,\7+\2\2,\b\3\2\2\2-.\7/\2\2"+
		"./\7/\2\2/\63\3\2\2\2\60\62\13\2\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\64"+
		"\3\2\2\2\63\61\3\2\2\2\649\3\2\2\2\65\63\3\2\2\2\66\67\7\17\2\2\67:\7"+
		"\f\2\28:\t\2\2\29\66\3\2\2\298\3\2\2\2:;\3\2\2\2;<\b\5\2\2<\n\3\2\2\2"+
		"=>\7\61\2\2>?\7,\2\2?C\3\2\2\2@B\13\2\2\2A@\3\2\2\2BE\3\2\2\2CD\3\2\2"+
		"\2CA\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7,\2\2GH\7\61\2\2HI\3\2\2\2IJ\b\6\2"+
		"\2J\f\3\2\2\2KL\7e\2\2LM\7t\2\2MN\7g\2\2NO\7c\2\2OP\7v\2\2PQ\7g\2\2Q\16"+
		"\3\2\2\2RS\7v\2\2ST\7c\2\2TU\7d\2\2UV\7n\2\2VW\7g\2\2W\20\3\2\2\2XY\7"+
		"c\2\2YZ\7w\2\2Z[\7v\2\2[\\\7q\2\2\\\22\3\2\2\2]^\7f\2\2^_\7t\2\2_`\7q"+
		"\2\2`a\7r\2\2a\24\3\2\2\2bc\7c\2\2cd\7n\2\2de\7v\2\2ef\7g\2\2fg\7t\2\2"+
		"g\26\3\2\2\2hi\7c\2\2ij\7f\2\2jk\7f\2\2k\30\3\2\2\2lm\7k\2\2mn\7p\2\2"+
		"no\7u\2\2op\7g\2\2pq\7t\2\2qr\7v\2\2r\32\3\2\2\2st\7k\2\2tu\7p\2\2uv\7"+
		"v\2\2vw\7q\2\2w\34\3\2\2\2xy\7x\2\2yz\7c\2\2z{\7n\2\2{|\7w\2\2|}\7g\2"+
		"\2}~\7u\2\2~\36\3\2\2\2\177\u0083\t\3\2\2\u0080\u0082\t\4\2\2\u0081\u0080"+
		"\3\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		" \3\2\2\2\u0085\u0083\3\2\2\2\u0086\u008c\7)\2\2\u0087\u0088\7)\2\2\u0088"+
		"\u008b\7)\2\2\u0089\u008b\n\5\2\2\u008a\u0087\3\2\2\2\u008a\u0089\3\2"+
		"\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008f\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090\7)\2\2\u0090\"\3\2\2\2"+
		"\u0091\u0093\7/\2\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095"+
		"\3\2\2\2\u0094\u0096\t\6\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u00ab\3\2\2\2\u0099\u009b\7/"+
		"\2\2\u009a\u0099\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c"+
		"\u009e\t\6\2\2\u009d\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u009d\3\2"+
		"\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3\7\60\2\2\u00a2"+
		"\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\t\6"+
		"\2\2\u00a5\u00a4\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u0092\3\2"+
		"\2\2\u00aa\u009a\3\2\2\2\u00ab$\3\2\2\2\u00ac\u00ae\t\7\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\b\23\2\2\u00b2&\3\2\2\2\22\2\639C\u0081\u0083"+
		"\u008a\u008c\u0092\u0097\u009a\u009f\u00a2\u00a7\u00aa\u00af\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}