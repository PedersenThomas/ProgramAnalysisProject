// $ANTLR 3.4 .\\src\\thelang\\TheLang.g 2015-09-18 13:08:15

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



    // $ANTLR start "bexpr"
    // .\\src\\thelang\\TheLang.g:74:1: bexpr returns [BooleanExpression value] : b1= bexpr1 ( OR b2= bexpr1 )* ;
    public final BooleanExpression bexpr() throws RecognitionException {
        BooleanExpression value = null;


        BooleanExpression b1 =null;

        BooleanExpression b2 =null;


        try {
            // .\\src\\thelang\\TheLang.g:74:41: (b1= bexpr1 ( OR b2= bexpr1 )* )
            // .\\src\\thelang\\TheLang.g:75:2: b1= bexpr1 ( OR b2= bexpr1 )*
            {
            pushFollow(FOLLOW_bexpr1_in_bexpr412);
            b1=bexpr1();

            state._fsp--;


             value = b1; 

            // .\\src\\thelang\\TheLang.g:76:3: ( OR b2= bexpr1 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==OR) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:76:4: OR b2= bexpr1
            	    {
            	    match(input,OR,FOLLOW_OR_in_bexpr424); 

            	    pushFollow(FOLLOW_bexpr1_in_bexpr428);
            	    b2=bexpr1();

            	    state._fsp--;


            	     value = new BooleanOperation(value, BooleanOperator.Or, b2); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
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
    // $ANTLR end "bexpr"



    // $ANTLR start "bexpr1"
    // .\\src\\thelang\\TheLang.g:79:1: bexpr1 returns [BooleanExpression value] : b1= bexpr2 ( AND b2= bexpr2 )* ;
    public final BooleanExpression bexpr1() throws RecognitionException {
        BooleanExpression value = null;


        BooleanExpression b1 =null;

        BooleanExpression b2 =null;


        try {
            // .\\src\\thelang\\TheLang.g:80:2: (b1= bexpr2 ( AND b2= bexpr2 )* )
            // .\\src\\thelang\\TheLang.g:80:4: b1= bexpr2 ( AND b2= bexpr2 )*
            {
            pushFollow(FOLLOW_bexpr2_in_bexpr1457);
            b1=bexpr2();

            state._fsp--;


             value = b1; 

            // .\\src\\thelang\\TheLang.g:81:5: ( AND b2= bexpr2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==AND) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:81:6: AND b2= bexpr2
            	    {
            	    match(input,AND,FOLLOW_AND_in_bexpr1472); 

            	    pushFollow(FOLLOW_bexpr2_in_bexpr1476);
            	    b2=bexpr2();

            	    state._fsp--;


            	     value = new BooleanOperation(value, BooleanOperator.And, b2); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
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
    // $ANTLR end "bexpr1"



    // $ANTLR start "bexpr2"
    // .\\src\\thelang\\TheLang.g:84:1: bexpr2 returns [BooleanExpression value] : ( NOT b= bexpr | TRUE | FALSE | LPAREN c= bexpr RPAREN );
    public final BooleanExpression bexpr2() throws RecognitionException {
        BooleanExpression value = null;


        BooleanExpression b =null;

        BooleanExpression c =null;


        try {
            // .\\src\\thelang\\TheLang.g:85:2: ( NOT b= bexpr | TRUE | FALSE | LPAREN c= bexpr RPAREN )
            int alt3=4;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt3=1;
                }
                break;
            case TRUE:
                {
                alt3=2;
                }
                break;
            case FALSE:
                {
                alt3=3;
                }
                break;
            case LPAREN:
                {
                alt3=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:85:4: NOT b= bexpr
                    {
                    match(input,NOT,FOLLOW_NOT_in_bexpr2499); 

                    pushFollow(FOLLOW_bexpr_in_bexpr2503);
                    b=bexpr();

                    state._fsp--;


                     value = new NotBooleanExpression(b); 

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:86:7: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_bexpr2523); 

                     value = new BooleanConstant(true); 

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:87:7: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_bexpr2550); 

                     value = new BooleanConstant(false); 

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:88:7: LPAREN c= bexpr RPAREN
                    {
                    match(input,LPAREN,FOLLOW_LPAREN_in_bexpr2576); 

                    pushFollow(FOLLOW_bexpr_in_bexpr2580);
                    c=bexpr();

                    state._fsp--;


                    match(input,RPAREN,FOLLOW_RPAREN_in_bexpr2582); 

                     value = c; 

                    }
                    break;

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
    // $ANTLR end "bexpr2"



    // $ANTLR start "skipStmt"
    // .\\src\\thelang\\TheLang.g:91:1: skipStmt returns [SkipStatement value] : SKIP SEMI ;
    public final SkipStatement skipStmt() throws RecognitionException {
        SkipStatement value = null;


        try {
            // .\\src\\thelang\\TheLang.g:92:2: ( SKIP SEMI )
            // .\\src\\thelang\\TheLang.g:92:4: SKIP SEMI
            {
            match(input,SKIP,FOLLOW_SKIP_in_skipStmt602); 

            match(input,SEMI,FOLLOW_SEMI_in_skipStmt604); 

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



    // $ANTLR start "ifStmt"
    // .\\src\\thelang\\TheLang.g:95:1: ifStmt returns [IfStatement value] : IF b= bexpr THEN (t= stmt )+ ELSE (f= stmt )+ FI ;
    public final IfStatement ifStmt() throws RecognitionException {
        IfStatement value = null;


        BooleanExpression b =null;

        Statement t =null;

        Statement f =null;


        try {
            // .\\src\\thelang\\TheLang.g:95:36: ( IF b= bexpr THEN (t= stmt )+ ELSE (f= stmt )+ FI )
            // .\\src\\thelang\\TheLang.g:96:2: IF b= bexpr THEN (t= stmt )+ ELSE (f= stmt )+ FI
            {
            match(input,IF,FOLLOW_IF_in_ifStmt622); 

            pushFollow(FOLLOW_bexpr_in_ifStmt626);
            b=bexpr();

            state._fsp--;


            match(input,THEN,FOLLOW_THEN_in_ifStmt628); 

            // .\\src\\thelang\\TheLang.g:96:19: (t= stmt )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==IF||LA4_0==SKIP) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:96:19: t= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt632);
            	    t=stmt();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            match(input,ELSE,FOLLOW_ELSE_in_ifStmt635); 

            // .\\src\\thelang\\TheLang.g:96:32: (f= stmt )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==IF||LA5_0==SKIP) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:96:32: f= stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt639);
            	    f=stmt();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            match(input,FI,FOLLOW_FI_in_ifStmt642); 

             value = new IfStatement(b, t, f); 

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
    // $ANTLR end "ifStmt"



    // $ANTLR start "stmt"
    // .\\src\\thelang\\TheLang.g:99:1: stmt returns [Statement value] : (s= skipStmt |i= ifStmt );
    public final Statement stmt() throws RecognitionException {
        Statement value = null;


        SkipStatement s =null;

        IfStatement i =null;


        try {
            // .\\src\\thelang\\TheLang.g:100:2: (s= skipStmt |i= ifStmt )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==SKIP) ) {
                alt6=1;
            }
            else if ( (LA6_0==IF) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:100:4: s= skipStmt
                    {
                    pushFollow(FOLLOW_skipStmt_in_stmt663);
                    s=skipStmt();

                    state._fsp--;


                     value = s; 

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:101:7: i= ifStmt
                    {
                    pushFollow(FOLLOW_ifStmt_in_stmt675);
                    i=ifStmt();

                    state._fsp--;


                     value = i; 

                    }
                    break;

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
    // .\\src\\thelang\\TheLang.g:104:1: program returns [Program value] : PROGRAM s= stmt END ;
    public final Program program() throws RecognitionException {
        Program value = null;


        Statement s =null;


        try {
            // .\\src\\thelang\\TheLang.g:105:2: ( PROGRAM s= stmt END )
            // .\\src\\thelang\\TheLang.g:105:4: PROGRAM s= stmt END
            {
            match(input,PROGRAM,FOLLOW_PROGRAM_in_program692); 

            pushFollow(FOLLOW_stmt_in_program696);
            s=stmt();

            state._fsp--;


            match(input,END,FOLLOW_END_in_program698); 

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


 

    public static final BitSet FOLLOW_bexpr1_in_bexpr412 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_OR_in_bexpr424 = new BitSet(new long[]{0x0000100108002000L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr428 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1457 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_bexpr1472 = new BitSet(new long[]{0x0000100108002000L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1476 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_NOT_in_bexpr2499 = new BitSet(new long[]{0x0000100108002000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_bexpr2523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_bexpr2550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_bexpr2576 = new BitSet(new long[]{0x0000100108002000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2580 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_bexpr2582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_in_skipStmt602 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_skipStmt604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStmt622 = new BitSet(new long[]{0x0000100108002000L});
    public static final BitSet FOLLOW_bexpr_in_ifStmt626 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_THEN_in_ifStmt628 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt632 = new BitSet(new long[]{0x0000040000080400L});
    public static final BitSet FOLLOW_ELSE_in_ifStmt635 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt639 = new BitSet(new long[]{0x0000040000084000L});
    public static final BitSet FOLLOW_FI_in_ifStmt642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program692 = new BitSet(new long[]{0x0000040000080000L});
    public static final BitSet FOLLOW_stmt_in_program696 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_END_in_program698 = new BitSet(new long[]{0x0000000000000002L});

}