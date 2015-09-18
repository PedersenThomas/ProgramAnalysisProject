// $ANTLR 3.4 .\\src\\thelang\\TheLang.g 2015-09-18 15:05:58

package thelang;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TheLangLexer extends Lexer {
    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ARRAY_ACCESS=5;
    public static final int ASSIGN=6;
    public static final int ASSIGNMENT_ARRAY=7;
    public static final int ASSIGNMENT_VARIABLE=8;
    public static final int BLOCK_DECLARATION=9;
    public static final int BLOCK_STATEMENT=10;
    public static final int BOOL_CONSTANT=11;
    public static final int COLON=12;
    public static final int COMMENT=13;
    public static final int CONSTANT=14;
    public static final int DECLARE_ARRAY=15;
    public static final int DECLARE_VARIABLE=16;
    public static final int DIV=17;
    public static final int DO=18;
    public static final int ELSE=19;
    public static final int END=20;
    public static final int EQ=21;
    public static final int FALSE=22;
    public static final int FI=23;
    public static final int GE=24;
    public static final int GT=25;
    public static final int IDENTIFIER=26;
    public static final int IF=27;
    public static final int IF_STATEMENT=28;
    public static final int INT=29;
    public static final int INTEGER=30;
    public static final int LBRACE=31;
    public static final int LBRACKET=32;
    public static final int LE=33;
    public static final int LETTER=34;
    public static final int LPAREN=35;
    public static final int LT=36;
    public static final int MINUS=37;
    public static final int MUL=38;
    public static final int NEQ=39;
    public static final int NOT=40;
    public static final int NOT_EXPRESSION=41;
    public static final int OD=42;
    public static final int OR=43;
    public static final int PLUS=44;
    public static final int PROGRAM=45;
    public static final int RBRACE=46;
    public static final int RBRACKET=47;
    public static final int READ=48;
    public static final int READ_ARRAY=49;
    public static final int READ_VARIABLE=50;
    public static final int RPAREN=51;
    public static final int SEMI=52;
    public static final int SKIP=53;
    public static final int SKIP_STATEMENT=54;
    public static final int THEN=55;
    public static final int THEPROGRAM=56;
    public static final int TRUE=57;
    public static final int UNARY_MINUS=58;
    public static final int VARIABLE=59;
    public static final int WHILE=60;
    public static final int WHILE_STATEMENT=61;
    public static final int WRITE=62;
    public static final int WRITE_EXPRESSION=63;
    public static final int WS=64;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public TheLangLexer() {} 
    public TheLangLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public TheLangLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return ".\\src\\thelang\\TheLang.g"; }

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:12:5: ( '&' )
            // .\\src\\thelang\\TheLang.g:12:7: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "ASSIGN"
    public final void mASSIGN() throws RecognitionException {
        try {
            int _type = ASSIGN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:13:8: ( ':=' )
            // .\\src\\thelang\\TheLang.g:13:10: ':='
            {
            match(":="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ASSIGN"

    // $ANTLR start "COLON"
    public final void mCOLON() throws RecognitionException {
        try {
            int _type = COLON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:14:7: ( ':' )
            // .\\src\\thelang\\TheLang.g:14:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COLON"

    // $ANTLR start "DIV"
    public final void mDIV() throws RecognitionException {
        try {
            int _type = DIV;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:15:5: ( '/' )
            // .\\src\\thelang\\TheLang.g:15:7: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DIV"

    // $ANTLR start "DO"
    public final void mDO() throws RecognitionException {
        try {
            int _type = DO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:16:4: ( 'do' )
            // .\\src\\thelang\\TheLang.g:16:6: 'do'
            {
            match("do"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DO"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:17:6: ( 'else' )
            // .\\src\\thelang\\TheLang.g:17:8: 'else'
            {
            match("else"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:18:5: ( 'end' )
            // .\\src\\thelang\\TheLang.g:18:7: 'end'
            {
            match("end"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:19:4: ( '=' )
            // .\\src\\thelang\\TheLang.g:19:6: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:20:7: ( 'false' )
            // .\\src\\thelang\\TheLang.g:20:9: 'false'
            {
            match("false"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "FI"
    public final void mFI() throws RecognitionException {
        try {
            int _type = FI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:21:4: ( 'fi' )
            // .\\src\\thelang\\TheLang.g:21:6: 'fi'
            {
            match("fi"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FI"

    // $ANTLR start "GE"
    public final void mGE() throws RecognitionException {
        try {
            int _type = GE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:22:4: ( '>=' )
            // .\\src\\thelang\\TheLang.g:22:6: '>='
            {
            match(">="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GE"

    // $ANTLR start "GT"
    public final void mGT() throws RecognitionException {
        try {
            int _type = GT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:23:4: ( '>' )
            // .\\src\\thelang\\TheLang.g:23:6: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "GT"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:24:4: ( 'if' )
            // .\\src\\thelang\\TheLang.g:24:6: 'if'
            {
            match("if"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:25:5: ( 'int' )
            // .\\src\\thelang\\TheLang.g:25:7: 'int'
            {
            match("int"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "LBRACE"
    public final void mLBRACE() throws RecognitionException {
        try {
            int _type = LBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:26:8: ( '{' )
            // .\\src\\thelang\\TheLang.g:26:10: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACE"

    // $ANTLR start "LBRACKET"
    public final void mLBRACKET() throws RecognitionException {
        try {
            int _type = LBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:27:10: ( '[' )
            // .\\src\\thelang\\TheLang.g:27:12: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LBRACKET"

    // $ANTLR start "LE"
    public final void mLE() throws RecognitionException {
        try {
            int _type = LE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:28:4: ( '<=' )
            // .\\src\\thelang\\TheLang.g:28:6: '<='
            {
            match("<="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LE"

    // $ANTLR start "LPAREN"
    public final void mLPAREN() throws RecognitionException {
        try {
            int _type = LPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:29:8: ( '(' )
            // .\\src\\thelang\\TheLang.g:29:10: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LPAREN"

    // $ANTLR start "LT"
    public final void mLT() throws RecognitionException {
        try {
            int _type = LT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:30:4: ( '<' )
            // .\\src\\thelang\\TheLang.g:30:6: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LT"

    // $ANTLR start "MINUS"
    public final void mMINUS() throws RecognitionException {
        try {
            int _type = MINUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:31:7: ( '-' )
            // .\\src\\thelang\\TheLang.g:31:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MINUS"

    // $ANTLR start "MUL"
    public final void mMUL() throws RecognitionException {
        try {
            int _type = MUL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:32:5: ( '*' )
            // .\\src\\thelang\\TheLang.g:32:7: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MUL"

    // $ANTLR start "NEQ"
    public final void mNEQ() throws RecognitionException {
        try {
            int _type = NEQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:33:5: ( '!=' )
            // .\\src\\thelang\\TheLang.g:33:7: '!='
            {
            match("!="); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NEQ"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:34:5: ( '!' )
            // .\\src\\thelang\\TheLang.g:34:7: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "OD"
    public final void mOD() throws RecognitionException {
        try {
            int _type = OD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:35:4: ( 'od' )
            // .\\src\\thelang\\TheLang.g:35:6: 'od'
            {
            match("od"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OD"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:36:4: ( '|' )
            // .\\src\\thelang\\TheLang.g:36:6: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "PLUS"
    public final void mPLUS() throws RecognitionException {
        try {
            int _type = PLUS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:37:6: ( '+' )
            // .\\src\\thelang\\TheLang.g:37:8: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PLUS"

    // $ANTLR start "PROGRAM"
    public final void mPROGRAM() throws RecognitionException {
        try {
            int _type = PROGRAM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:38:9: ( 'program' )
            // .\\src\\thelang\\TheLang.g:38:11: 'program'
            {
            match("program"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PROGRAM"

    // $ANTLR start "RBRACE"
    public final void mRBRACE() throws RecognitionException {
        try {
            int _type = RBRACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:39:8: ( '}' )
            // .\\src\\thelang\\TheLang.g:39:10: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACE"

    // $ANTLR start "RBRACKET"
    public final void mRBRACKET() throws RecognitionException {
        try {
            int _type = RBRACKET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:40:10: ( ']' )
            // .\\src\\thelang\\TheLang.g:40:12: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RBRACKET"

    // $ANTLR start "READ"
    public final void mREAD() throws RecognitionException {
        try {
            int _type = READ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:41:6: ( 'read' )
            // .\\src\\thelang\\TheLang.g:41:8: 'read'
            {
            match("read"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "READ"

    // $ANTLR start "RPAREN"
    public final void mRPAREN() throws RecognitionException {
        try {
            int _type = RPAREN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:42:8: ( ')' )
            // .\\src\\thelang\\TheLang.g:42:10: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RPAREN"

    // $ANTLR start "SEMI"
    public final void mSEMI() throws RecognitionException {
        try {
            int _type = SEMI;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:43:6: ( ';' )
            // .\\src\\thelang\\TheLang.g:43:8: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SEMI"

    // $ANTLR start "SKIP"
    public final void mSKIP() throws RecognitionException {
        try {
            int _type = SKIP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:44:6: ( 'skip' )
            // .\\src\\thelang\\TheLang.g:44:8: 'skip'
            {
            match("skip"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "SKIP"

    // $ANTLR start "THEN"
    public final void mTHEN() throws RecognitionException {
        try {
            int _type = THEN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:45:6: ( 'then' )
            // .\\src\\thelang\\TheLang.g:45:8: 'then'
            {
            match("then"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "THEN"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:46:6: ( 'true' )
            // .\\src\\thelang\\TheLang.g:46:8: 'true'
            {
            match("true"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:47:7: ( 'while' )
            // .\\src\\thelang\\TheLang.g:47:9: 'while'
            {
            match("while"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "WRITE"
    public final void mWRITE() throws RecognitionException {
        try {
            int _type = WRITE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:48:7: ( 'write' )
            // .\\src\\thelang\\TheLang.g:48:9: 'write'
            {
            match("write"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WRITE"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:155:9: ( '(*' ( options {greedy=false; } : . )* '*)' )
            // .\\src\\thelang\\TheLang.g:155:11: '(*' ( options {greedy=false; } : . )* '*)'
            {
            match("(*"); 



            // .\\src\\thelang\\TheLang.g:155:16: ( options {greedy=false; } : . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='*') ) {
                    int LA1_1 = input.LA(2);

                    if ( (LA1_1==')') ) {
                        alt1=2;
                    }
                    else if ( ((LA1_1 >= '\u0000' && LA1_1 <= '(')||(LA1_1 >= '*' && LA1_1 <= '\uFFFF')) ) {
                        alt1=1;
                    }


                }
                else if ( ((LA1_0 >= '\u0000' && LA1_0 <= ')')||(LA1_0 >= '+' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:155:43: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("*)"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:158:9: ( ( '0' | '1' .. '9' ( '0' .. '9' )* ) )
            // .\\src\\thelang\\TheLang.g:158:11: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            {
            // .\\src\\thelang\\TheLang.g:158:11: ( '0' | '1' .. '9' ( '0' .. '9' )* )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='0') ) {
                alt3=1;
            }
            else if ( ((LA3_0 >= '1' && LA3_0 <= '9')) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:158:12: '0'
                    {
                    match('0'); 

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:158:18: '1' .. '9' ( '0' .. '9' )*
                    {
                    matchRange('1','9'); 

                    // .\\src\\thelang\\TheLang.g:158:27: ( '0' .. '9' )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // .\\src\\thelang\\TheLang.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:160:12: ( LETTER ( LETTER | '0' .. '9' )* )
            // .\\src\\thelang\\TheLang.g:160:14: LETTER ( LETTER | '0' .. '9' )*
            {
            mLETTER(); 


            // .\\src\\thelang\\TheLang.g:160:21: ( LETTER | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // .\\src\\thelang\\TheLang.g:164:8: ( 'A' .. 'Z' | 'a' .. 'z' | '_' )
            // .\\src\\thelang\\TheLang.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // .\\src\\thelang\\TheLang.g:168:4: ( ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' ) )
            // .\\src\\thelang\\TheLang.g:168:6: ( ' ' | '\\r' | '\\t' | '\\u000C' | '\\n' )
            {
            if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             skip(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WS"

    public void mTokens() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:1:8: ( AND | ASSIGN | COLON | DIV | DO | ELSE | END | EQ | FALSE | FI | GE | GT | IF | INT | LBRACE | LBRACKET | LE | LPAREN | LT | MINUS | MUL | NEQ | NOT | OD | OR | PLUS | PROGRAM | RBRACE | RBRACKET | READ | RPAREN | SEMI | SKIP | THEN | TRUE | WHILE | WRITE | COMMENT | INTEGER | IDENTIFIER | WS )
        int alt5=41;
        alt5 = dfa5.predict(input);
        switch (alt5) {
            case 1 :
                // .\\src\\thelang\\TheLang.g:1:10: AND
                {
                mAND(); 


                }
                break;
            case 2 :
                // .\\src\\thelang\\TheLang.g:1:14: ASSIGN
                {
                mASSIGN(); 


                }
                break;
            case 3 :
                // .\\src\\thelang\\TheLang.g:1:21: COLON
                {
                mCOLON(); 


                }
                break;
            case 4 :
                // .\\src\\thelang\\TheLang.g:1:27: DIV
                {
                mDIV(); 


                }
                break;
            case 5 :
                // .\\src\\thelang\\TheLang.g:1:31: DO
                {
                mDO(); 


                }
                break;
            case 6 :
                // .\\src\\thelang\\TheLang.g:1:34: ELSE
                {
                mELSE(); 


                }
                break;
            case 7 :
                // .\\src\\thelang\\TheLang.g:1:39: END
                {
                mEND(); 


                }
                break;
            case 8 :
                // .\\src\\thelang\\TheLang.g:1:43: EQ
                {
                mEQ(); 


                }
                break;
            case 9 :
                // .\\src\\thelang\\TheLang.g:1:46: FALSE
                {
                mFALSE(); 


                }
                break;
            case 10 :
                // .\\src\\thelang\\TheLang.g:1:52: FI
                {
                mFI(); 


                }
                break;
            case 11 :
                // .\\src\\thelang\\TheLang.g:1:55: GE
                {
                mGE(); 


                }
                break;
            case 12 :
                // .\\src\\thelang\\TheLang.g:1:58: GT
                {
                mGT(); 


                }
                break;
            case 13 :
                // .\\src\\thelang\\TheLang.g:1:61: IF
                {
                mIF(); 


                }
                break;
            case 14 :
                // .\\src\\thelang\\TheLang.g:1:64: INT
                {
                mINT(); 


                }
                break;
            case 15 :
                // .\\src\\thelang\\TheLang.g:1:68: LBRACE
                {
                mLBRACE(); 


                }
                break;
            case 16 :
                // .\\src\\thelang\\TheLang.g:1:75: LBRACKET
                {
                mLBRACKET(); 


                }
                break;
            case 17 :
                // .\\src\\thelang\\TheLang.g:1:84: LE
                {
                mLE(); 


                }
                break;
            case 18 :
                // .\\src\\thelang\\TheLang.g:1:87: LPAREN
                {
                mLPAREN(); 


                }
                break;
            case 19 :
                // .\\src\\thelang\\TheLang.g:1:94: LT
                {
                mLT(); 


                }
                break;
            case 20 :
                // .\\src\\thelang\\TheLang.g:1:97: MINUS
                {
                mMINUS(); 


                }
                break;
            case 21 :
                // .\\src\\thelang\\TheLang.g:1:103: MUL
                {
                mMUL(); 


                }
                break;
            case 22 :
                // .\\src\\thelang\\TheLang.g:1:107: NEQ
                {
                mNEQ(); 


                }
                break;
            case 23 :
                // .\\src\\thelang\\TheLang.g:1:111: NOT
                {
                mNOT(); 


                }
                break;
            case 24 :
                // .\\src\\thelang\\TheLang.g:1:115: OD
                {
                mOD(); 


                }
                break;
            case 25 :
                // .\\src\\thelang\\TheLang.g:1:118: OR
                {
                mOR(); 


                }
                break;
            case 26 :
                // .\\src\\thelang\\TheLang.g:1:121: PLUS
                {
                mPLUS(); 


                }
                break;
            case 27 :
                // .\\src\\thelang\\TheLang.g:1:126: PROGRAM
                {
                mPROGRAM(); 


                }
                break;
            case 28 :
                // .\\src\\thelang\\TheLang.g:1:134: RBRACE
                {
                mRBRACE(); 


                }
                break;
            case 29 :
                // .\\src\\thelang\\TheLang.g:1:141: RBRACKET
                {
                mRBRACKET(); 


                }
                break;
            case 30 :
                // .\\src\\thelang\\TheLang.g:1:150: READ
                {
                mREAD(); 


                }
                break;
            case 31 :
                // .\\src\\thelang\\TheLang.g:1:155: RPAREN
                {
                mRPAREN(); 


                }
                break;
            case 32 :
                // .\\src\\thelang\\TheLang.g:1:162: SEMI
                {
                mSEMI(); 


                }
                break;
            case 33 :
                // .\\src\\thelang\\TheLang.g:1:167: SKIP
                {
                mSKIP(); 


                }
                break;
            case 34 :
                // .\\src\\thelang\\TheLang.g:1:172: THEN
                {
                mTHEN(); 


                }
                break;
            case 35 :
                // .\\src\\thelang\\TheLang.g:1:177: TRUE
                {
                mTRUE(); 


                }
                break;
            case 36 :
                // .\\src\\thelang\\TheLang.g:1:182: WHILE
                {
                mWHILE(); 


                }
                break;
            case 37 :
                // .\\src\\thelang\\TheLang.g:1:188: WRITE
                {
                mWRITE(); 


                }
                break;
            case 38 :
                // .\\src\\thelang\\TheLang.g:1:194: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 39 :
                // .\\src\\thelang\\TheLang.g:1:202: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 40 :
                // .\\src\\thelang\\TheLang.g:1:210: IDENTIFIER
                {
                mIDENTIFIER(); 


                }
                break;
            case 41 :
                // .\\src\\thelang\\TheLang.g:1:221: WS
                {
                mWS(); 


                }
                break;

        }

    }


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\2\uffff\1\41\1\uffff\2\36\1\uffff\1\36\1\50\1\36\2\uffff\1\54\1"+
        "\56\2\uffff\1\60\1\36\2\uffff\1\36\2\uffff\1\36\2\uffff\3\36\5\uffff"+
        "\1\71\3\36\1\75\2\uffff\1\76\1\36\6\uffff\1\100\7\36\1\uffff\1\36"+
        "\1\111\1\36\2\uffff\1\113\1\uffff\7\36\1\123\1\uffff\1\36\1\uffff"+
        "\1\36\1\126\1\127\1\130\1\131\2\36\1\uffff\1\134\1\36\4\uffff\1"+
        "\136\1\137\1\uffff\1\36\2\uffff\1\141\1\uffff";
    static final String DFA5_eofS =
        "\142\uffff";
    static final String DFA5_minS =
        "\1\11\1\uffff\1\75\1\uffff\1\157\1\154\1\uffff\1\141\1\75\1\146"+
        "\2\uffff\1\75\1\52\2\uffff\1\75\1\144\2\uffff\1\162\2\uffff\1\145"+
        "\2\uffff\1\153\2\150\5\uffff\1\60\1\163\1\144\1\154\1\60\2\uffff"+
        "\1\60\1\164\6\uffff\1\60\1\157\1\141\1\151\1\145\1\165\2\151\1\uffff"+
        "\1\145\1\60\1\163\2\uffff\1\60\1\uffff\1\147\1\144\1\160\1\156\1"+
        "\145\1\154\1\164\1\60\1\uffff\1\145\1\uffff\1\162\4\60\2\145\1\uffff"+
        "\1\60\1\141\4\uffff\2\60\1\uffff\1\155\2\uffff\1\60\1\uffff";
    static final String DFA5_maxS =
        "\1\175\1\uffff\1\75\1\uffff\1\157\1\156\1\uffff\1\151\1\75\1\156"+
        "\2\uffff\1\75\1\52\2\uffff\1\75\1\144\2\uffff\1\162\2\uffff\1\145"+
        "\2\uffff\1\153\2\162\5\uffff\1\172\1\163\1\144\1\154\1\172\2\uffff"+
        "\1\172\1\164\6\uffff\1\172\1\157\1\141\1\151\1\145\1\165\2\151\1"+
        "\uffff\1\145\1\172\1\163\2\uffff\1\172\1\uffff\1\147\1\144\1\160"+
        "\1\156\1\145\1\154\1\164\1\172\1\uffff\1\145\1\uffff\1\162\4\172"+
        "\2\145\1\uffff\1\172\1\141\4\uffff\2\172\1\uffff\1\155\2\uffff\1"+
        "\172\1\uffff";
    static final String DFA5_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\2\uffff\1\10\3\uffff\1\17\1\20\2\uffff"+
        "\1\24\1\25\2\uffff\1\31\1\32\1\uffff\1\34\1\35\1\uffff\1\37\1\40"+
        "\3\uffff\1\47\1\50\1\51\1\2\1\3\5\uffff\1\13\1\14\2\uffff\1\21\1"+
        "\23\1\46\1\22\1\26\1\27\10\uffff\1\5\3\uffff\1\12\1\15\1\uffff\1"+
        "\30\10\uffff\1\7\1\uffff\1\16\7\uffff\1\6\2\uffff\1\36\1\41\1\42"+
        "\1\43\2\uffff\1\11\1\uffff\1\44\1\45\1\uffff\1\33";
    static final String DFA5_specialS =
        "\142\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\37\1\uffff\2\37\22\uffff\1\37\1\20\4\uffff\1\1\1\uffff\1"+
            "\15\1\30\1\17\1\23\1\uffff\1\16\1\uffff\1\3\12\35\1\2\1\31\1"+
            "\14\1\6\1\10\2\uffff\32\36\1\13\1\uffff\1\26\1\uffff\1\36\1"+
            "\uffff\3\36\1\4\1\5\1\7\2\36\1\11\5\36\1\21\1\24\1\36\1\27\1"+
            "\32\1\33\2\36\1\34\3\36\1\12\1\22\1\25",
            "",
            "\1\40",
            "",
            "\1\42",
            "\1\43\1\uffff\1\44",
            "",
            "\1\45\7\uffff\1\46",
            "\1\47",
            "\1\51\7\uffff\1\52",
            "",
            "",
            "\1\53",
            "\1\55",
            "",
            "",
            "\1\57",
            "\1\61",
            "",
            "",
            "\1\62",
            "",
            "",
            "\1\63",
            "",
            "",
            "\1\64",
            "\1\65\11\uffff\1\66",
            "\1\67\11\uffff\1\70",
            "",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\72",
            "\1\73",
            "\1\74",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\77",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "",
            "\1\110",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\112",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\124",
            "",
            "\1\125",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\132",
            "\1\133",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\1\135",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "",
            "\1\140",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            ""
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( AND | ASSIGN | COLON | DIV | DO | ELSE | END | EQ | FALSE | FI | GE | GT | IF | INT | LBRACE | LBRACKET | LE | LPAREN | LT | MINUS | MUL | NEQ | NOT | OD | OR | PLUS | PROGRAM | RBRACE | RBRACKET | READ | RPAREN | SEMI | SKIP | THEN | TRUE | WHILE | WRITE | COMMENT | INTEGER | IDENTIFIER | WS );";
        }
    }
 

}