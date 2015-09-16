// $ANTLR 3.4 .\\src\\thelang\\TheLang.g 2015-09-16 16:08:54

package thelang;

import ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class TheLangParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "COLON", "COMMENT", "DIV", "DO", "ELSE", "END", "EQ", "FALSE", "FI", "GE", "GT", "HIGH", "IDENTIFIER", "IF", "INT", "INTEGER", "LBRACE", "LBRACKET", "LE", "LETTER", "LOW", "LPAREN", "LT", "MINUS", "MUL", "NEQ", "NOT", "OD", "OR", "PLUS", "PROGRAM", "RBRACE", "RBRACKET", "READ", "RPAREN", "SEMI", "SKIP", "THEN", "TRUE", "WHILE", "WRITE", "WS"
    };

    public static final int EOF=-1;
    public static final int AND=4;
    public static final int ASSIGN=5;
    public static final int COLON=6;
    public static final int COMMENT=7;
    public static final int DIV=8;
    public static final int DO=9;
    public static final int ELSE=10;
    public static final int END=11;
    public static final int EQ=12;
    public static final int FALSE=13;
    public static final int FI=14;
    public static final int GE=15;
    public static final int GT=16;
    public static final int HIGH=17;
    public static final int IDENTIFIER=18;
    public static final int IF=19;
    public static final int INT=20;
    public static final int INTEGER=21;
    public static final int LBRACE=22;
    public static final int LBRACKET=23;
    public static final int LE=24;
    public static final int LETTER=25;
    public static final int LOW=26;
    public static final int LPAREN=27;
    public static final int LT=28;
    public static final int MINUS=29;
    public static final int MUL=30;
    public static final int NEQ=31;
    public static final int NOT=32;
    public static final int OD=33;
    public static final int OR=34;
    public static final int PLUS=35;
    public static final int PROGRAM=36;
    public static final int RBRACE=37;
    public static final int RBRACKET=38;
    public static final int READ=39;
    public static final int RPAREN=40;
    public static final int SEMI=41;
    public static final int SKIP=42;
    public static final int THEN=43;
    public static final int TRUE=44;
    public static final int WHILE=45;
    public static final int WRITE=46;
    public static final int WS=47;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TheLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TheLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return TheLangParser.tokenNames; }
    public String getGrammarFileName() { return ".\\src\\thelang\\TheLang.g"; }



    // $ANTLR start "skipStmt"
    // .\\src\\thelang\\TheLang.g:75:1: skipStmt returns [SkipStatement value] : SKIP SEMI ;
    public final SkipStatement skipStmt() throws RecognitionException {
        SkipStatement value = null;


        try {
            // .\\src\\thelang\\TheLang.g:76:2: ( SKIP SEMI )
            // .\\src\\thelang\\TheLang.g:76:4: SKIP SEMI
            {
            match(input,SKIP,FOLLOW_SKIP_in_skipStmt410); 

            match(input,SEMI,FOLLOW_SEMI_in_skipStmt412); 

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



    // $ANTLR start "stmt"
    // .\\src\\thelang\\TheLang.g:79:1: stmt returns [Statement value] : s= skipStmt ;
    public final Statement stmt() throws RecognitionException {
        Statement value = null;


        SkipStatement s =null;


        try {
            // .\\src\\thelang\\TheLang.g:80:2: (s= skipStmt )
            // .\\src\\thelang\\TheLang.g:80:4: s= skipStmt
            {
            pushFollow(FOLLOW_skipStmt_in_stmt433);
            s=skipStmt();

            state._fsp--;


             value = s

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



    // $ANTLR start "program"
    // .\\src\\thelang\\TheLang.g:83:1: program returns [Program value] : PROGRAM s= stmt END ;
    public final Program program() throws RecognitionException {
        Program value = null;


        Statement s =null;


        try {
            // .\\src\\thelang\\TheLang.g:84:2: ( PROGRAM s= stmt END )
            // .\\src\\thelang\\TheLang.g:84:4: PROGRAM s= stmt END
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program450); 

            pushFollow(FOLLOW_stmt_in_program454);
            s=stmt();

            state._fsp--;


            match(input,END,FOLLOW_END_in_program456); 

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

    // Delegated rules


 

    public static final BitSet FOLLOW_SKIP_in_skipStmt410 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_skipStmt412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program450 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_stmt_in_program454 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_END_in_program456 = new BitSet(new long[]{0x0000000000000002L});

}