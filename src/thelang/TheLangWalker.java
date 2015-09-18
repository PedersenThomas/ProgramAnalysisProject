// $ANTLR 3.4 .\\src\\thelang\\TheLangWalker.g 2015-09-18 15:32:49

package thelang;

import ast.*;
import java.util.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TheLangWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ARRAY_ACCESS", "ASSIGN", "ASSIGNMENT_ARRAY", "ASSIGNMENT_VARIABLE", "BLOCK_DECLARATION", "BLOCK_STATEMENT", "BOOL_CONSTANT", "COLON", "COMMENT", "CONSTANT", "DECLARE_ARRAY", "DECLARE_VARIABLE", "DIV", "DO", "ELSE", "END", "EQ", "FALSE", "FI", "GE", "GT", "IDENTIFIER", "IF", "IF_STATEMENT", "INT", "INTEGER", "LBRACE", "LBRACKET", "LE", "LETTER", "LPAREN", "LT", "MINUS", "MUL", "NEQ", "NOT", "NOT_EXPRESSION", "OD", "OR", "PLUS", "PROGRAM", "RBRACE", "RBRACKET", "READ", "READ_ARRAY", "READ_VARIABLE", "RPAREN", "SEMI", "SKIP", "SKIP_STATEMENT", "THEN", "THEPROGRAM", "TRUE", "UNARY_MINUS", "VARIABLE", "WHILE", "WHILE_STATEMENT", "WRITE", "WRITE_EXPRESSION", "WS"
    };

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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public TheLangWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public TheLangWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TheLangWalker.tokenNames; }
    public String getGrammarFileName() { return ".\\src\\thelang\\TheLangWalker.g"; }



    // $ANTLR start "program"
    // .\\src\\thelang\\TheLangWalker.g:16:1: program returns [Program value] : ^( THEPROGRAM BLOCK_DECLARATION ^( BLOCK_STATEMENT s= stmts ) ) ;
    public final Program program() throws RecognitionException {
        Program value = null;


        List<Statement> s =null;


        try {
            // .\\src\\thelang\\TheLangWalker.g:17:2: ( ^( THEPROGRAM BLOCK_DECLARATION ^( BLOCK_STATEMENT s= stmts ) ) )
            // .\\src\\thelang\\TheLangWalker.g:17:4: ^( THEPROGRAM BLOCK_DECLARATION ^( BLOCK_STATEMENT s= stmts ) )
            {
            match(input,THEPROGRAM,FOLLOW_THEPROGRAM_in_program46); 

            match(input, Token.DOWN, null); 
            match(input,BLOCK_DECLARATION,FOLLOW_BLOCK_DECLARATION_in_program48); 

            match(input,BLOCK_STATEMENT,FOLLOW_BLOCK_STATEMENT_in_program51); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_stmts_in_program55);
            s=stmts();

            state._fsp--;


            match(input, Token.UP, null); 


            match(input, Token.UP, null); 


             value = new Program(null, s); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "program"



    // $ANTLR start "stmts"
    // .\\src\\thelang\\TheLangWalker.g:20:1: stmts returns [List<Statement> value] : (s= stmt )+ ;
    public final List<Statement> stmts() throws RecognitionException {
        List<Statement> value = null;


        Statement s =null;



            	value = new ArrayList<Statement>();
            
        try {
            // .\\src\\thelang\\TheLangWalker.g:25:2: ( (s= stmt )+ )
            // .\\src\\thelang\\TheLangWalker.g:25:4: (s= stmt )+
            {
            // .\\src\\thelang\\TheLangWalker.g:25:4: (s= stmt )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==SKIP_STATEMENT) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // .\\src\\thelang\\TheLangWalker.g:25:5: s= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_stmts88);
            	    s=stmt();

            	    state._fsp--;


            	     value.add(s); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "stmts"



    // $ANTLR start "stmt"
    // .\\src\\thelang\\TheLangWalker.g:28:1: stmt returns [Statement value] : s= skipStmt ;
    public final Statement stmt() throws RecognitionException {
        Statement value = null;


        SkipStatement s =null;


        try {
            // .\\src\\thelang\\TheLangWalker.g:29:2: (s= skipStmt )
            // .\\src\\thelang\\TheLangWalker.g:29:4: s= skipStmt
            {
            pushFollow(FOLLOW_skipStmt_in_stmt110);
            s=skipStmt();

            state._fsp--;


             value = s; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "stmt"



    // $ANTLR start "skipStmt"
    // .\\src\\thelang\\TheLangWalker.g:32:1: skipStmt returns [SkipStatement value] : SKIP_STATEMENT ;
    public final SkipStatement skipStmt() throws RecognitionException {
        SkipStatement value = null;


        try {
            // .\\src\\thelang\\TheLangWalker.g:33:2: ( SKIP_STATEMENT )
            // .\\src\\thelang\\TheLangWalker.g:33:4: SKIP_STATEMENT
            {
            match(input,SKIP_STATEMENT,FOLLOW_SKIP_STATEMENT_in_skipStmt130); 

             value = new SkipStatement(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return value;
    }
    // $ANTLR end "skipStmt"

    // Delegated rules


 

    public static final BitSet FOLLOW_THEPROGRAM_in_program46 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCK_DECLARATION_in_program48 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_BLOCK_STATEMENT_in_program51 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_stmts_in_program55 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_stmt_in_stmts88 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_STATEMENT_in_skipStmt130 = new BitSet(new long[]{0x0000000000000002L});

}