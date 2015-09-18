// $ANTLR 3.4 .\\src\\thelang\\TheLang.g 2015-09-18 15:32:49

package thelang;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class TheLangParser extends Parser {
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
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public TheLangParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public TheLangParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
        this.state.ruleMemo = new HashMap[47+1];
         

    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return TheLangParser.tokenNames; }
    public String getGrammarFileName() { return ".\\src\\thelang\\TheLang.g"; }


    public static class aexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr"
    // .\\src\\thelang\\TheLang.g:90:1: aexpr : aexpr1 ( ( PLUS | MINUS ) ^ aexpr1 )* ;
    public final TheLangParser.aexpr_return aexpr() throws RecognitionException {
        TheLangParser.aexpr_return retval = new TheLangParser.aexpr_return();
        retval.start = input.LT(1);

        int aexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set2=null;
        TheLangParser.aexpr1_return aexpr11 =null;

        TheLangParser.aexpr1_return aexpr13 =null;


        CommonTree set2_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:90:7: ( aexpr1 ( ( PLUS | MINUS ) ^ aexpr1 )* )
            // .\\src\\thelang\\TheLang.g:90:9: aexpr1 ( ( PLUS | MINUS ) ^ aexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr1_in_aexpr516);
            aexpr11=aexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr11.getTree());

            // .\\src\\thelang\\TheLang.g:90:16: ( ( PLUS | MINUS ) ^ aexpr1 )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==MINUS||LA1_0==PLUS) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:90:17: ( PLUS | MINUS ) ^ aexpr1
            	    {
            	    set2=(Token)input.LT(1);

            	    set2=(Token)input.LT(1);

            	    if ( input.LA(1)==MINUS||input.LA(1)==PLUS ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set2)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_aexpr1_in_aexpr528);
            	    aexpr13=aexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr13.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 1, aexpr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr"


    public static class aexpr1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr1"
    // .\\src\\thelang\\TheLang.g:92:1: aexpr1 : aexpr2 ( ( MUL | DIV ) ^ aexpr2 )* ;
    public final TheLangParser.aexpr1_return aexpr1() throws RecognitionException {
        TheLangParser.aexpr1_return retval = new TheLangParser.aexpr1_return();
        retval.start = input.LT(1);

        int aexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set5=null;
        TheLangParser.aexpr2_return aexpr24 =null;

        TheLangParser.aexpr2_return aexpr26 =null;


        CommonTree set5_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:92:8: ( aexpr2 ( ( MUL | DIV ) ^ aexpr2 )* )
            // .\\src\\thelang\\TheLang.g:92:10: aexpr2 ( ( MUL | DIV ) ^ aexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr2_in_aexpr1539);
            aexpr24=aexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr24.getTree());

            // .\\src\\thelang\\TheLang.g:92:17: ( ( MUL | DIV ) ^ aexpr2 )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==DIV||LA2_0==MUL) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:92:18: ( MUL | DIV ) ^ aexpr2
            	    {
            	    set5=(Token)input.LT(1);

            	    set5=(Token)input.LT(1);

            	    if ( input.LA(1)==DIV||input.LA(1)==MUL ) {
            	        input.consume();
            	        if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(
            	        (CommonTree)adaptor.create(set5)
            	        , root_0);
            	        state.errorRecovery=false;
            	        state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    pushFollow(FOLLOW_aexpr2_in_aexpr1551);
            	    aexpr26=aexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr26.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 2, aexpr1_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr1"


    public static class aexpr2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr2"
    // .\\src\\thelang\\TheLang.g:94:1: aexpr2 : ( MINUS aexpr3 -> ^( UNARY_MINUS aexpr3 ) | aexpr3 );
    public final TheLangParser.aexpr2_return aexpr2() throws RecognitionException {
        TheLangParser.aexpr2_return retval = new TheLangParser.aexpr2_return();
        retval.start = input.LT(1);

        int aexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MINUS7=null;
        TheLangParser.aexpr3_return aexpr38 =null;

        TheLangParser.aexpr3_return aexpr39 =null;


        CommonTree MINUS7_tree=null;
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleSubtreeStream stream_aexpr3=new RewriteRuleSubtreeStream(adaptor,"rule aexpr3");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:94:8: ( MINUS aexpr3 -> ^( UNARY_MINUS aexpr3 ) | aexpr3 )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==MINUS) ) {
                alt3=1;
            }
            else if ( (LA3_0==IDENTIFIER||LA3_0==INTEGER||LA3_0==LPAREN) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:94:10: MINUS aexpr3
                    {
                    MINUS7=(Token)match(input,MINUS,FOLLOW_MINUS_in_aexpr2562); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS7);


                    pushFollow(FOLLOW_aexpr3_in_aexpr2564);
                    aexpr38=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr3.add(aexpr38.getTree());

                    // AST REWRITE
                    // elements: aexpr3
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 94:23: -> ^( UNARY_MINUS aexpr3 )
                    {
                        // .\\src\\thelang\\TheLang.g:94:26: ^( UNARY_MINUS aexpr3 )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(UNARY_MINUS, "UNARY_MINUS")
                        , root_1);

                        adaptor.addChild(root_1, stream_aexpr3.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:95:10: aexpr3
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr3_in_aexpr2583);
                    aexpr39=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr39.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 3, aexpr2_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr2"


    public static class aexpr3_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "aexpr3"
    // .\\src\\thelang\\TheLang.g:98:1: aexpr3 : ( IDENTIFIER -> ^( VARIABLE IDENTIFIER ) | IDENTIFIER LBRACKET aexpr RBRACKET -> ^( ARRAY_ACCESS IDENTIFIER aexpr ) | INTEGER -> ^( CONSTANT INTEGER ) | LPAREN aexpr RPAREN -> aexpr );
    public final TheLangParser.aexpr3_return aexpr3() throws RecognitionException {
        TheLangParser.aexpr3_return retval = new TheLangParser.aexpr3_return();
        retval.start = input.LT(1);

        int aexpr3_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER10=null;
        Token IDENTIFIER11=null;
        Token LBRACKET12=null;
        Token RBRACKET14=null;
        Token INTEGER15=null;
        Token LPAREN16=null;
        Token RPAREN18=null;
        TheLangParser.aexpr_return aexpr13 =null;

        TheLangParser.aexpr_return aexpr17 =null;


        CommonTree IDENTIFIER10_tree=null;
        CommonTree IDENTIFIER11_tree=null;
        CommonTree LBRACKET12_tree=null;
        CommonTree RBRACKET14_tree=null;
        CommonTree INTEGER15_tree=null;
        CommonTree LPAREN16_tree=null;
        CommonTree RPAREN18_tree=null;
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");
        RewriteRuleSubtreeStream stream_aexpr=new RewriteRuleSubtreeStream(adaptor,"rule aexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:98:8: ( IDENTIFIER -> ^( VARIABLE IDENTIFIER ) | IDENTIFIER LBRACKET aexpr RBRACKET -> ^( ARRAY_ACCESS IDENTIFIER aexpr ) | INTEGER -> ^( CONSTANT INTEGER ) | LPAREN aexpr RPAREN -> aexpr )
            int alt4=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1==LBRACKET) ) {
                    alt4=2;
                }
                else if ( (LA4_1==EOF||LA4_1==AND||(LA4_1 >= DIV && LA4_1 <= DO)||LA4_1==EQ||(LA4_1 >= GE && LA4_1 <= GT)||LA4_1==LE||(LA4_1 >= LT && LA4_1 <= NEQ)||(LA4_1 >= OR && LA4_1 <= PLUS)||LA4_1==RBRACKET||(LA4_1 >= RPAREN && LA4_1 <= SEMI)||LA4_1==THEN) ) {
                    alt4=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 1, input);

                    throw nvae;

                }
                }
                break;
            case INTEGER:
                {
                alt4=3;
                }
                break;
            case LPAREN:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:98:10: IDENTIFIER
                    {
                    IDENTIFIER10=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aexpr3599); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER10);


                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 98:45: -> ^( VARIABLE IDENTIFIER )
                    {
                        // .\\src\\thelang\\TheLang.g:98:48: ^( VARIABLE IDENTIFIER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(VARIABLE, "VARIABLE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:99:7: IDENTIFIER LBRACKET aexpr RBRACKET
                    {
                    IDENTIFIER11=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aexpr3639); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER11);


                    LBRACKET12=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_aexpr3641); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET12);


                    pushFollow(FOLLOW_aexpr_in_aexpr3643);
                    aexpr13=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr13.getTree());

                    RBRACKET14=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_aexpr3645); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET14);


                    // AST REWRITE
                    // elements: IDENTIFIER, aexpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 99:42: -> ^( ARRAY_ACCESS IDENTIFIER aexpr )
                    {
                        // .\\src\\thelang\\TheLang.g:99:45: ^( ARRAY_ACCESS IDENTIFIER aexpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ARRAY_ACCESS, "ARRAY_ACCESS")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, stream_aexpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:100:10: INTEGER
                    {
                    INTEGER15=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_aexpr3666); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER15);


                    // AST REWRITE
                    // elements: INTEGER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 100:45: -> ^( CONSTANT INTEGER )
                    {
                        // .\\src\\thelang\\TheLang.g:100:48: ^( CONSTANT INTEGER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_INTEGER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:101:10: LPAREN aexpr RPAREN
                    {
                    LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_aexpr3712); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN16);


                    pushFollow(FOLLOW_aexpr_in_aexpr3714);
                    aexpr17=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr17.getTree());

                    RPAREN18=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_aexpr3716); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN18);


                    // AST REWRITE
                    // elements: aexpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 101:45: -> aexpr
                    {
                        adaptor.addChild(root_0, stream_aexpr.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 4, aexpr3_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "aexpr3"


    public static class bexpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr"
    // .\\src\\thelang\\TheLang.g:104:1: bexpr : bexpr1 ( OR ^ bexpr1 )* ;
    public final TheLangParser.bexpr_return bexpr() throws RecognitionException {
        TheLangParser.bexpr_return retval = new TheLangParser.bexpr_return();
        retval.start = input.LT(1);

        int bexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR20=null;
        TheLangParser.bexpr1_return bexpr119 =null;

        TheLangParser.bexpr1_return bexpr121 =null;


        CommonTree OR20_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:104:7: ( bexpr1 ( OR ^ bexpr1 )* )
            // .\\src\\thelang\\TheLang.g:104:9: bexpr1 ( OR ^ bexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr1_in_bexpr751);
            bexpr119=bexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr119.getTree());

            // .\\src\\thelang\\TheLang.g:104:16: ( OR ^ bexpr1 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==OR) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred9_TheLang()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:104:17: OR ^ bexpr1
            	    {
            	    OR20=(Token)match(input,OR,FOLLOW_OR_in_bexpr754); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR20_tree = 
            	    (CommonTree)adaptor.create(OR20)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(OR20_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_bexpr1_in_bexpr757);
            	    bexpr121=bexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr121.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 5, bexpr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr"


    public static class bexpr1_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr1"
    // .\\src\\thelang\\TheLang.g:107:1: bexpr1 : bexpr2 ( AND ^ bexpr2 )* ;
    public final TheLangParser.bexpr1_return bexpr1() throws RecognitionException {
        TheLangParser.bexpr1_return retval = new TheLangParser.bexpr1_return();
        retval.start = input.LT(1);

        int bexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token AND23=null;
        TheLangParser.bexpr2_return bexpr222 =null;

        TheLangParser.bexpr2_return bexpr224 =null;


        CommonTree AND23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:107:8: ( bexpr2 ( AND ^ bexpr2 )* )
            // .\\src\\thelang\\TheLang.g:107:10: bexpr2 ( AND ^ bexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr2_in_bexpr1774);
            bexpr222=bexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr222.getTree());

            // .\\src\\thelang\\TheLang.g:107:17: ( AND ^ bexpr2 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==AND) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred10_TheLang()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:107:18: AND ^ bexpr2
            	    {
            	    AND23=(Token)match(input,AND,FOLLOW_AND_in_bexpr1777); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND23_tree = 
            	    (CommonTree)adaptor.create(AND23)
            	    ;
            	    root_0 = (CommonTree)adaptor.becomeRoot(AND23_tree, root_0);
            	    }

            	    pushFollow(FOLLOW_bexpr2_in_bexpr1780);
            	    bexpr224=bexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr224.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 6, bexpr1_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr1"


    public static class bexpr2_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "bexpr2"
    // .\\src\\thelang\\TheLang.g:110:1: bexpr2 : ( aexpr opr ^ aexpr | NOT bexpr -> ^( NOT_EXPRESSION bexpr ) | TRUE -> ^( BOOL_CONSTANT TRUE ) | FALSE -> ^( BOOL_CONSTANT FALSE ) | LPAREN bexpr RPAREN -> bexpr );
    public final TheLangParser.bexpr2_return bexpr2() throws RecognitionException {
        TheLangParser.bexpr2_return retval = new TheLangParser.bexpr2_return();
        retval.start = input.LT(1);

        int bexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT28=null;
        Token TRUE30=null;
        Token FALSE31=null;
        Token LPAREN32=null;
        Token RPAREN34=null;
        TheLangParser.aexpr_return aexpr25 =null;

        TheLangParser.opr_return opr26 =null;

        TheLangParser.aexpr_return aexpr27 =null;

        TheLangParser.bexpr_return bexpr29 =null;

        TheLangParser.bexpr_return bexpr33 =null;


        CommonTree NOT28_tree=null;
        CommonTree TRUE30_tree=null;
        CommonTree FALSE31_tree=null;
        CommonTree LPAREN32_tree=null;
        CommonTree RPAREN34_tree=null;
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_TRUE=new RewriteRuleTokenStream(adaptor,"token TRUE");
        RewriteRuleTokenStream stream_FALSE=new RewriteRuleTokenStream(adaptor,"token FALSE");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleSubtreeStream stream_bexpr=new RewriteRuleSubtreeStream(adaptor,"rule bexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:110:8: ( aexpr opr ^ aexpr | NOT bexpr -> ^( NOT_EXPRESSION bexpr ) | TRUE -> ^( BOOL_CONSTANT TRUE ) | FALSE -> ^( BOOL_CONSTANT FALSE ) | LPAREN bexpr RPAREN -> bexpr )
            int alt7=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
            case INTEGER:
            case MINUS:
                {
                alt7=1;
                }
                break;
            case LPAREN:
                {
                int LA7_4 = input.LA(2);

                if ( (synpred11_TheLang()) ) {
                    alt7=1;
                }
                else if ( (true) ) {
                    alt7=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 4, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt7=2;
                }
                break;
            case TRUE:
                {
                alt7=3;
                }
                break;
            case FALSE:
                {
                alt7=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }

            switch (alt7) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:110:10: aexpr opr ^ aexpr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr_in_bexpr2798);
                    aexpr25=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr25.getTree());

                    pushFollow(FOLLOW_opr_in_bexpr2800);
                    opr26=opr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(opr26.getTree(), root_0);

                    pushFollow(FOLLOW_aexpr_in_bexpr2803);
                    aexpr27=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr27.getTree());

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:111:10: NOT bexpr
                    {
                    NOT28=(Token)match(input,NOT,FOLLOW_NOT_in_bexpr2814); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NOT.add(NOT28);


                    pushFollow(FOLLOW_bexpr_in_bexpr2816);
                    bexpr29=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bexpr.add(bexpr29.getTree());

                    // AST REWRITE
                    // elements: bexpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 111:20: -> ^( NOT_EXPRESSION bexpr )
                    {
                        // .\\src\\thelang\\TheLang.g:111:23: ^( NOT_EXPRESSION bexpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(NOT_EXPRESSION, "NOT_EXPRESSION")
                        , root_1);

                        adaptor.addChild(root_1, stream_bexpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:112:10: TRUE
                    {
                    TRUE30=(Token)match(input,TRUE,FOLLOW_TRUE_in_bexpr2835); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRUE.add(TRUE30);


                    // AST REWRITE
                    // elements: TRUE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 112:15: -> ^( BOOL_CONSTANT TRUE )
                    {
                        // .\\src\\thelang\\TheLang.g:112:18: ^( BOOL_CONSTANT TRUE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(BOOL_CONSTANT, "BOOL_CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_TRUE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:113:10: FALSE
                    {
                    FALSE31=(Token)match(input,FALSE,FOLLOW_FALSE_in_bexpr2854); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FALSE.add(FALSE31);


                    // AST REWRITE
                    // elements: FALSE
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 113:16: -> ^( BOOL_CONSTANT FALSE )
                    {
                        // .\\src\\thelang\\TheLang.g:113:19: ^( BOOL_CONSTANT FALSE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(BOOL_CONSTANT, "BOOL_CONSTANT")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_FALSE.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 5 :
                    // .\\src\\thelang\\TheLang.g:114:10: LPAREN bexpr RPAREN
                    {
                    LPAREN32=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_bexpr2873); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN32);


                    pushFollow(FOLLOW_bexpr_in_bexpr2875);
                    bexpr33=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_bexpr.add(bexpr33.getTree());

                    RPAREN34=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_bexpr2877); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN34);


                    // AST REWRITE
                    // elements: bexpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 114:30: -> bexpr
                    {
                        adaptor.addChild(root_0, stream_bexpr.nextTree());

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 7, bexpr2_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "bexpr2"


    public static class opr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "opr"
    // .\\src\\thelang\\TheLang.g:117:1: opr : ( GT | GE | LT | LE | EQ | NEQ );
    public final TheLangParser.opr_return opr() throws RecognitionException {
        TheLangParser.opr_return retval = new TheLangParser.opr_return();
        retval.start = input.LT(1);

        int opr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:117:5: ( GT | GE | LT | LE | EQ | NEQ )
            // .\\src\\thelang\\TheLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set35=(Token)input.LT(1);

            if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NEQ ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set35)
                );
                state.errorRecovery=false;
                state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 8, opr_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "opr"


    public static class decl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "decl"
    // .\\src\\thelang\\TheLang.g:125:1: decl : ( INT IDENTIFIER SEMI -> ^( DECLARE_VARIABLE IDENTIFIER ) | INT IDENTIFIER LBRACKET INTEGER RBRACKET SEMI -> ^( DECLARE_ARRAY ^( VARIABLE IDENTIFIER ) ^( CONSTANT INTEGER ) ) );
    public final TheLangParser.decl_return decl() throws RecognitionException {
        TheLangParser.decl_return retval = new TheLangParser.decl_return();
        retval.start = input.LT(1);

        int decl_StartIndex = input.index();

        CommonTree root_0 = null;

        Token INT36=null;
        Token IDENTIFIER37=null;
        Token SEMI38=null;
        Token INT39=null;
        Token IDENTIFIER40=null;
        Token LBRACKET41=null;
        Token INTEGER42=null;
        Token RBRACKET43=null;
        Token SEMI44=null;

        CommonTree INT36_tree=null;
        CommonTree IDENTIFIER37_tree=null;
        CommonTree SEMI38_tree=null;
        CommonTree INT39_tree=null;
        CommonTree IDENTIFIER40_tree=null;
        CommonTree LBRACKET41_tree=null;
        CommonTree INTEGER42_tree=null;
        CommonTree RBRACKET43_tree=null;
        CommonTree SEMI44_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");
        RewriteRuleTokenStream stream_INTEGER=new RewriteRuleTokenStream(adaptor,"token INTEGER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:125:6: ( INT IDENTIFIER SEMI -> ^( DECLARE_VARIABLE IDENTIFIER ) | INT IDENTIFIER LBRACKET INTEGER RBRACKET SEMI -> ^( DECLARE_ARRAY ^( VARIABLE IDENTIFIER ) ^( CONSTANT INTEGER ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==INT) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==IDENTIFIER) ) {
                    int LA8_2 = input.LA(3);

                    if ( (LA8_2==SEMI) ) {
                        alt8=1;
                    }
                    else if ( (LA8_2==LBRACKET) ) {
                        alt8=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:125:8: INT IDENTIFIER SEMI
                    {
                    INT36=(Token)match(input,INT,FOLLOW_INT_in_decl950); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT36);


                    IDENTIFIER37=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_decl952); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER37);


                    SEMI38=(Token)match(input,SEMI,FOLLOW_SEMI_in_decl954); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI38);


                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 125:28: -> ^( DECLARE_VARIABLE IDENTIFIER )
                    {
                        // .\\src\\thelang\\TheLang.g:125:31: ^( DECLARE_VARIABLE IDENTIFIER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(DECLARE_VARIABLE, "DECLARE_VARIABLE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:126:5: INT IDENTIFIER LBRACKET INTEGER RBRACKET SEMI
                    {
                    INT39=(Token)match(input,INT,FOLLOW_INT_in_decl968); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INT.add(INT39);


                    IDENTIFIER40=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_decl970); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER40);


                    LBRACKET41=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_decl972); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET41);


                    INTEGER42=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_decl974); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INTEGER.add(INTEGER42);


                    RBRACKET43=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_decl976); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET43);


                    SEMI44=(Token)match(input,SEMI,FOLLOW_SEMI_in_decl978); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI44);


                    // AST REWRITE
                    // elements: INTEGER, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 126:51: -> ^( DECLARE_ARRAY ^( VARIABLE IDENTIFIER ) ^( CONSTANT INTEGER ) )
                    {
                        // .\\src\\thelang\\TheLang.g:126:54: ^( DECLARE_ARRAY ^( VARIABLE IDENTIFIER ) ^( CONSTANT INTEGER ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(DECLARE_ARRAY, "DECLARE_ARRAY")
                        , root_1);

                        // .\\src\\thelang\\TheLang.g:126:70: ^( VARIABLE IDENTIFIER )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(VARIABLE, "VARIABLE")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        // .\\src\\thelang\\TheLang.g:126:93: ^( CONSTANT INTEGER )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(CONSTANT, "CONSTANT")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_INTEGER.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 9, decl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "decl"


    public static class stmts_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmts"
    // .\\src\\thelang\\TheLang.g:128:1: stmts : ( stmt )+ ;
    public final TheLangParser.stmts_return stmts() throws RecognitionException {
        TheLangParser.stmts_return retval = new TheLangParser.stmts_return();
        retval.start = input.LT(1);

        int stmts_StartIndex = input.index();

        CommonTree root_0 = null;

        TheLangParser.stmt_return stmt45 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:128:7: ( ( stmt )+ )
            // .\\src\\thelang\\TheLang.g:128:9: ( stmt )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // .\\src\\thelang\\TheLang.g:128:9: ( stmt )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= IDENTIFIER && LA9_0 <= IF)||LA9_0==READ||LA9_0==SKIP||LA9_0==WHILE||LA9_0==WRITE) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:128:9: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_stmts1004);
            	    stmt45=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt45.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 10, stmts_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmts"


    public static class stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmt"
    // .\\src\\thelang\\TheLang.g:130:1: stmt : ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt );
    public final TheLangParser.stmt_return stmt() throws RecognitionException {
        TheLangParser.stmt_return retval = new TheLangParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        CommonTree root_0 = null;

        TheLangParser.assignStmt_return assignStmt46 =null;

        TheLangParser.skipStmt_return skipStmt47 =null;

        TheLangParser.readStmt_return readStmt48 =null;

        TheLangParser.writeStmt_return writeStmt49 =null;

        TheLangParser.ifStmt_return ifStmt50 =null;

        TheLangParser.whileStmt_return whileStmt51 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:130:6: ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt )
            int alt10=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt10=1;
                }
                break;
            case SKIP:
                {
                alt10=2;
                }
                break;
            case READ:
                {
                alt10=3;
                }
                break;
            case WRITE:
                {
                alt10=4;
                }
                break;
            case IF:
                {
                alt10=5;
                }
                break;
            case WHILE:
                {
                alt10=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:130:8: assignStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assignStmt_in_stmt1014);
                    assignStmt46=assignStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignStmt46.getTree());

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:131:8: skipStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_skipStmt_in_stmt1023);
                    skipStmt47=skipStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, skipStmt47.getTree());

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:132:8: readStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_readStmt_in_stmt1032);
                    readStmt48=readStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStmt48.getTree());

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:133:8: writeStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_writeStmt_in_stmt1041);
                    writeStmt49=writeStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, writeStmt49.getTree());

                    }
                    break;
                case 5 :
                    // .\\src\\thelang\\TheLang.g:134:8: ifStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ifStmt_in_stmt1050);
                    ifStmt50=ifStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStmt50.getTree());

                    }
                    break;
                case 6 :
                    // .\\src\\thelang\\TheLang.g:135:8: whileStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_whileStmt_in_stmt1059);
                    whileStmt51=whileStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStmt51.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 11, stmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "stmt"


    public static class assignStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "assignStmt"
    // .\\src\\thelang\\TheLang.g:138:1: assignStmt : ( IDENTIFIER ASSIGN aexpr SEMI -> ^( ASSIGNMENT_VARIABLE IDENTIFIER aexpr ) | IDENTIFIER LBRACKET aexpr RBRACKET ASSIGN aexpr SEMI -> ^( ASSIGNMENT_ARRAY IDENTIFIER aexpr aexpr ) );
    public final TheLangParser.assignStmt_return assignStmt() throws RecognitionException {
        TheLangParser.assignStmt_return retval = new TheLangParser.assignStmt_return();
        retval.start = input.LT(1);

        int assignStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER52=null;
        Token ASSIGN53=null;
        Token SEMI55=null;
        Token IDENTIFIER56=null;
        Token LBRACKET57=null;
        Token RBRACKET59=null;
        Token ASSIGN60=null;
        Token SEMI62=null;
        TheLangParser.aexpr_return aexpr54 =null;

        TheLangParser.aexpr_return aexpr58 =null;

        TheLangParser.aexpr_return aexpr61 =null;


        CommonTree IDENTIFIER52_tree=null;
        CommonTree ASSIGN53_tree=null;
        CommonTree SEMI55_tree=null;
        CommonTree IDENTIFIER56_tree=null;
        CommonTree LBRACKET57_tree=null;
        CommonTree RBRACKET59_tree=null;
        CommonTree ASSIGN60_tree=null;
        CommonTree SEMI62_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_ASSIGN=new RewriteRuleTokenStream(adaptor,"token ASSIGN");
        RewriteRuleSubtreeStream stream_aexpr=new RewriteRuleSubtreeStream(adaptor,"rule aexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:138:12: ( IDENTIFIER ASSIGN aexpr SEMI -> ^( ASSIGNMENT_VARIABLE IDENTIFIER aexpr ) | IDENTIFIER LBRACKET aexpr RBRACKET ASSIGN aexpr SEMI -> ^( ASSIGNMENT_ARRAY IDENTIFIER aexpr aexpr ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==IDENTIFIER) ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1==ASSIGN) ) {
                    alt11=1;
                }
                else if ( (LA11_1==LBRACKET) ) {
                    alt11=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:138:14: IDENTIFIER ASSIGN aexpr SEMI
                    {
                    IDENTIFIER52=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStmt1073); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER52);


                    ASSIGN53=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignStmt1075); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN53);


                    pushFollow(FOLLOW_aexpr_in_assignStmt1077);
                    aexpr54=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr54.getTree());

                    SEMI55=(Token)match(input,SEMI,FOLLOW_SEMI_in_assignStmt1079); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI55);


                    // AST REWRITE
                    // elements: aexpr, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 138:43: -> ^( ASSIGNMENT_VARIABLE IDENTIFIER aexpr )
                    {
                        // .\\src\\thelang\\TheLang.g:138:46: ^( ASSIGNMENT_VARIABLE IDENTIFIER aexpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGNMENT_VARIABLE, "ASSIGNMENT_VARIABLE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, stream_aexpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:139:11: IDENTIFIER LBRACKET aexpr RBRACKET ASSIGN aexpr SEMI
                    {
                    IDENTIFIER56=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStmt1101); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER56);


                    LBRACKET57=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_assignStmt1103); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET57);


                    pushFollow(FOLLOW_aexpr_in_assignStmt1105);
                    aexpr58=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr58.getTree());

                    RBRACKET59=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_assignStmt1107); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET59);


                    ASSIGN60=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignStmt1109); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSIGN.add(ASSIGN60);


                    pushFollow(FOLLOW_aexpr_in_assignStmt1111);
                    aexpr61=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr61.getTree());

                    SEMI62=(Token)match(input,SEMI,FOLLOW_SEMI_in_assignStmt1113); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI62);


                    // AST REWRITE
                    // elements: IDENTIFIER, aexpr, aexpr
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 139:64: -> ^( ASSIGNMENT_ARRAY IDENTIFIER aexpr aexpr )
                    {
                        // .\\src\\thelang\\TheLang.g:139:67: ^( ASSIGNMENT_ARRAY IDENTIFIER aexpr aexpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ASSIGNMENT_ARRAY, "ASSIGNMENT_ARRAY")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, stream_aexpr.nextTree());

                        adaptor.addChild(root_1, stream_aexpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 12, assignStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "assignStmt"


    public static class skipStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "skipStmt"
    // .\\src\\thelang\\TheLang.g:141:1: skipStmt : SKIP SEMI -> SKIP_STATEMENT ;
    public final TheLangParser.skipStmt_return skipStmt() throws RecognitionException {
        TheLangParser.skipStmt_return retval = new TheLangParser.skipStmt_return();
        retval.start = input.LT(1);

        int skipStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token SKIP63=null;
        Token SEMI64=null;

        CommonTree SKIP63_tree=null;
        CommonTree SEMI64_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_SKIP=new RewriteRuleTokenStream(adaptor,"token SKIP");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:141:10: ( SKIP SEMI -> SKIP_STATEMENT )
            // .\\src\\thelang\\TheLang.g:141:12: SKIP SEMI
            {
            SKIP63=(Token)match(input,SKIP,FOLLOW_SKIP_in_skipStmt1133); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SKIP.add(SKIP63);


            SEMI64=(Token)match(input,SEMI,FOLLOW_SEMI_in_skipStmt1135); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMI.add(SEMI64);


            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 141:22: -> SKIP_STATEMENT
            {
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(SKIP_STATEMENT, "SKIP_STATEMENT")
                );

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 13, skipStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "skipStmt"


    public static class readStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "readStmt"
    // .\\src\\thelang\\TheLang.g:143:1: readStmt : ( READ IDENTIFIER SEMI -> ^( READ_VARIABLE ^( VARIABLE IDENTIFIER ) ) | READ IDENTIFIER LBRACKET aexpr RBRACKET SEMI -> ^( READ_ARRAY ^( VARIABLE IDENTIFIER ) aexpr ) );
    public final TheLangParser.readStmt_return readStmt() throws RecognitionException {
        TheLangParser.readStmt_return retval = new TheLangParser.readStmt_return();
        retval.start = input.LT(1);

        int readStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token READ65=null;
        Token IDENTIFIER66=null;
        Token SEMI67=null;
        Token READ68=null;
        Token IDENTIFIER69=null;
        Token LBRACKET70=null;
        Token RBRACKET72=null;
        Token SEMI73=null;
        TheLangParser.aexpr_return aexpr71 =null;


        CommonTree READ65_tree=null;
        CommonTree IDENTIFIER66_tree=null;
        CommonTree SEMI67_tree=null;
        CommonTree READ68_tree=null;
        CommonTree IDENTIFIER69_tree=null;
        CommonTree LBRACKET70_tree=null;
        CommonTree RBRACKET72_tree=null;
        CommonTree SEMI73_tree=null;
        RewriteRuleTokenStream stream_READ=new RewriteRuleTokenStream(adaptor,"token READ");
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_LBRACKET=new RewriteRuleTokenStream(adaptor,"token LBRACKET");
        RewriteRuleTokenStream stream_RBRACKET=new RewriteRuleTokenStream(adaptor,"token RBRACKET");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_aexpr=new RewriteRuleSubtreeStream(adaptor,"rule aexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:143:10: ( READ IDENTIFIER SEMI -> ^( READ_VARIABLE ^( VARIABLE IDENTIFIER ) ) | READ IDENTIFIER LBRACKET aexpr RBRACKET SEMI -> ^( READ_ARRAY ^( VARIABLE IDENTIFIER ) aexpr ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==READ) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==IDENTIFIER) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==SEMI) ) {
                        alt12=1;
                    }
                    else if ( (LA12_2==LBRACKET) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;

                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:143:12: READ IDENTIFIER SEMI
                    {
                    READ65=(Token)match(input,READ,FOLLOW_READ_in_readStmt1147); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_READ.add(READ65);


                    IDENTIFIER66=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_readStmt1149); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER66);


                    SEMI67=(Token)match(input,SEMI,FOLLOW_SEMI_in_readStmt1151); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI67);


                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 143:33: -> ^( READ_VARIABLE ^( VARIABLE IDENTIFIER ) )
                    {
                        // .\\src\\thelang\\TheLang.g:143:36: ^( READ_VARIABLE ^( VARIABLE IDENTIFIER ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(READ_VARIABLE, "READ_VARIABLE")
                        , root_1);

                        // .\\src\\thelang\\TheLang.g:143:52: ^( VARIABLE IDENTIFIER )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(VARIABLE, "VARIABLE")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:144:6: READ IDENTIFIER LBRACKET aexpr RBRACKET SEMI
                    {
                    READ68=(Token)match(input,READ,FOLLOW_READ_in_readStmt1170); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_READ.add(READ68);


                    IDENTIFIER69=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_readStmt1172); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER69);


                    LBRACKET70=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_readStmt1174); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LBRACKET.add(LBRACKET70);


                    pushFollow(FOLLOW_aexpr_in_readStmt1176);
                    aexpr71=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_aexpr.add(aexpr71.getTree());

                    RBRACKET72=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_readStmt1178); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_RBRACKET.add(RBRACKET72);


                    SEMI73=(Token)match(input,SEMI,FOLLOW_SEMI_in_readStmt1180); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMI.add(SEMI73);


                    // AST REWRITE
                    // elements: aexpr, IDENTIFIER
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {

                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 144:51: -> ^( READ_ARRAY ^( VARIABLE IDENTIFIER ) aexpr )
                    {
                        // .\\src\\thelang\\TheLang.g:144:54: ^( READ_ARRAY ^( VARIABLE IDENTIFIER ) aexpr )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(READ_ARRAY, "READ_ARRAY")
                        , root_1);

                        // .\\src\\thelang\\TheLang.g:144:67: ^( VARIABLE IDENTIFIER )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(VARIABLE, "VARIABLE")
                        , root_2);

                        adaptor.addChild(root_2, 
                        stream_IDENTIFIER.nextNode()
                        );

                        adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_1, stream_aexpr.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 14, readStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "readStmt"


    public static class writeStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "writeStmt"
    // .\\src\\thelang\\TheLang.g:146:1: writeStmt : WRITE aexpr SEMI -> ^( WRITE_EXPRESSION aexpr ) ;
    public final TheLangParser.writeStmt_return writeStmt() throws RecognitionException {
        TheLangParser.writeStmt_return retval = new TheLangParser.writeStmt_return();
        retval.start = input.LT(1);

        int writeStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WRITE74=null;
        Token SEMI76=null;
        TheLangParser.aexpr_return aexpr75 =null;


        CommonTree WRITE74_tree=null;
        CommonTree SEMI76_tree=null;
        RewriteRuleTokenStream stream_SEMI=new RewriteRuleTokenStream(adaptor,"token SEMI");
        RewriteRuleTokenStream stream_WRITE=new RewriteRuleTokenStream(adaptor,"token WRITE");
        RewriteRuleSubtreeStream stream_aexpr=new RewriteRuleSubtreeStream(adaptor,"rule aexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:146:11: ( WRITE aexpr SEMI -> ^( WRITE_EXPRESSION aexpr ) )
            // .\\src\\thelang\\TheLang.g:146:13: WRITE aexpr SEMI
            {
            WRITE74=(Token)match(input,WRITE,FOLLOW_WRITE_in_writeStmt1202); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WRITE.add(WRITE74);


            pushFollow(FOLLOW_aexpr_in_writeStmt1204);
            aexpr75=aexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_aexpr.add(aexpr75.getTree());

            SEMI76=(Token)match(input,SEMI,FOLLOW_SEMI_in_writeStmt1206); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SEMI.add(SEMI76);


            // AST REWRITE
            // elements: aexpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 146:30: -> ^( WRITE_EXPRESSION aexpr )
            {
                // .\\src\\thelang\\TheLang.g:146:33: ^( WRITE_EXPRESSION aexpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WRITE_EXPRESSION, "WRITE_EXPRESSION")
                , root_1);

                adaptor.addChild(root_1, stream_aexpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 15, writeStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "writeStmt"


    public static class ifStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "ifStmt"
    // .\\src\\thelang\\TheLang.g:148:1: ifStmt : IF bexpr THEN stmts ELSE stmts FI -> ^( IF_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ^( BLOCK_STATEMENT stmts ) ) ;
    public final TheLangParser.ifStmt_return ifStmt() throws RecognitionException {
        TheLangParser.ifStmt_return retval = new TheLangParser.ifStmt_return();
        retval.start = input.LT(1);

        int ifStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IF77=null;
        Token THEN79=null;
        Token ELSE81=null;
        Token FI83=null;
        TheLangParser.bexpr_return bexpr78 =null;

        TheLangParser.stmts_return stmts80 =null;

        TheLangParser.stmts_return stmts82 =null;


        CommonTree IF77_tree=null;
        CommonTree THEN79_tree=null;
        CommonTree ELSE81_tree=null;
        CommonTree FI83_tree=null;
        RewriteRuleTokenStream stream_FI=new RewriteRuleTokenStream(adaptor,"token FI");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleTokenStream stream_THEN=new RewriteRuleTokenStream(adaptor,"token THEN");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleSubtreeStream stream_stmts=new RewriteRuleSubtreeStream(adaptor,"rule stmts");
        RewriteRuleSubtreeStream stream_bexpr=new RewriteRuleSubtreeStream(adaptor,"rule bexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:148:8: ( IF bexpr THEN stmts ELSE stmts FI -> ^( IF_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ^( BLOCK_STATEMENT stmts ) ) )
            // .\\src\\thelang\\TheLang.g:148:10: IF bexpr THEN stmts ELSE stmts FI
            {
            IF77=(Token)match(input,IF,FOLLOW_IF_in_ifStmt1222); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IF.add(IF77);


            pushFollow(FOLLOW_bexpr_in_ifStmt1224);
            bexpr78=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bexpr.add(bexpr78.getTree());

            THEN79=(Token)match(input,THEN,FOLLOW_THEN_in_ifStmt1226); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_THEN.add(THEN79);


            pushFollow(FOLLOW_stmts_in_ifStmt1228);
            stmts80=stmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stmts.add(stmts80.getTree());

            ELSE81=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStmt1230); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ELSE.add(ELSE81);


            pushFollow(FOLLOW_stmts_in_ifStmt1232);
            stmts82=stmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stmts.add(stmts82.getTree());

            FI83=(Token)match(input,FI,FOLLOW_FI_in_ifStmt1234); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FI.add(FI83);


            // AST REWRITE
            // elements: stmts, stmts, bexpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:44: -> ^( IF_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ^( BLOCK_STATEMENT stmts ) )
            {
                // .\\src\\thelang\\TheLang.g:148:47: ^( IF_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ^( BLOCK_STATEMENT stmts ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IF_STATEMENT, "IF_STATEMENT")
                , root_1);

                adaptor.addChild(root_1, stream_bexpr.nextTree());

                // .\\src\\thelang\\TheLang.g:148:68: ^( BLOCK_STATEMENT stmts )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK_STATEMENT, "BLOCK_STATEMENT")
                , root_2);

                adaptor.addChild(root_2, stream_stmts.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // .\\src\\thelang\\TheLang.g:148:93: ^( BLOCK_STATEMENT stmts )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK_STATEMENT, "BLOCK_STATEMENT")
                , root_2);

                adaptor.addChild(root_2, stream_stmts.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 16, ifStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "ifStmt"


    public static class whileStmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "whileStmt"
    // .\\src\\thelang\\TheLang.g:150:1: whileStmt : WHILE bexpr DO stmts OD -> ^( WHILE_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ) ;
    public final TheLangParser.whileStmt_return whileStmt() throws RecognitionException {
        TheLangParser.whileStmt_return retval = new TheLangParser.whileStmt_return();
        retval.start = input.LT(1);

        int whileStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WHILE84=null;
        Token DO86=null;
        Token OD88=null;
        TheLangParser.bexpr_return bexpr85 =null;

        TheLangParser.stmts_return stmts87 =null;


        CommonTree WHILE84_tree=null;
        CommonTree DO86_tree=null;
        CommonTree OD88_tree=null;
        RewriteRuleTokenStream stream_OD=new RewriteRuleTokenStream(adaptor,"token OD");
        RewriteRuleTokenStream stream_WHILE=new RewriteRuleTokenStream(adaptor,"token WHILE");
        RewriteRuleTokenStream stream_DO=new RewriteRuleTokenStream(adaptor,"token DO");
        RewriteRuleSubtreeStream stream_stmts=new RewriteRuleSubtreeStream(adaptor,"rule stmts");
        RewriteRuleSubtreeStream stream_bexpr=new RewriteRuleSubtreeStream(adaptor,"rule bexpr");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:150:11: ( WHILE bexpr DO stmts OD -> ^( WHILE_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) ) )
            // .\\src\\thelang\\TheLang.g:150:13: WHILE bexpr DO stmts OD
            {
            WHILE84=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStmt1262); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_WHILE.add(WHILE84);


            pushFollow(FOLLOW_bexpr_in_whileStmt1264);
            bexpr85=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_bexpr.add(bexpr85.getTree());

            DO86=(Token)match(input,DO,FOLLOW_DO_in_whileStmt1266); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DO.add(DO86);


            pushFollow(FOLLOW_stmts_in_whileStmt1268);
            stmts87=stmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stmts.add(stmts87.getTree());

            OD88=(Token)match(input,OD,FOLLOW_OD_in_whileStmt1270); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_OD.add(OD88);


            // AST REWRITE
            // elements: bexpr, stmts
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 150:37: -> ^( WHILE_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) )
            {
                // .\\src\\thelang\\TheLang.g:150:40: ^( WHILE_STATEMENT bexpr ^( BLOCK_STATEMENT stmts ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(WHILE_STATEMENT, "WHILE_STATEMENT")
                , root_1);

                adaptor.addChild(root_1, stream_bexpr.nextTree());

                // .\\src\\thelang\\TheLang.g:150:64: ^( BLOCK_STATEMENT stmts )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK_STATEMENT, "BLOCK_STATEMENT")
                , root_2);

                adaptor.addChild(root_2, stream_stmts.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 17, whileStmt_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "whileStmt"


    public static class program_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "program"
    // .\\src\\thelang\\TheLang.g:152:1: program : PROGRAM ( decl )* stmts END -> ^( THEPROGRAM ^( BLOCK_DECLARATION ( decl )* ) ^( BLOCK_STATEMENT stmts ) ) ;
    public final TheLangParser.program_return program() throws RecognitionException {
        TheLangParser.program_return retval = new TheLangParser.program_return();
        retval.start = input.LT(1);

        int program_StartIndex = input.index();

        CommonTree root_0 = null;

        Token PROGRAM89=null;
        Token END92=null;
        TheLangParser.decl_return decl90 =null;

        TheLangParser.stmts_return stmts91 =null;


        CommonTree PROGRAM89_tree=null;
        CommonTree END92_tree=null;
        RewriteRuleTokenStream stream_END=new RewriteRuleTokenStream(adaptor,"token END");
        RewriteRuleTokenStream stream_PROGRAM=new RewriteRuleTokenStream(adaptor,"token PROGRAM");
        RewriteRuleSubtreeStream stream_stmts=new RewriteRuleSubtreeStream(adaptor,"rule stmts");
        RewriteRuleSubtreeStream stream_decl=new RewriteRuleSubtreeStream(adaptor,"rule decl");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:152:9: ( PROGRAM ( decl )* stmts END -> ^( THEPROGRAM ^( BLOCK_DECLARATION ( decl )* ) ^( BLOCK_STATEMENT stmts ) ) )
            // .\\src\\thelang\\TheLang.g:152:11: PROGRAM ( decl )* stmts END
            {
            PROGRAM89=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program1292); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PROGRAM.add(PROGRAM89);


            // .\\src\\thelang\\TheLang.g:152:19: ( decl )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==INT) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:152:19: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program1294);
            	    decl90=decl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_decl.add(decl90.getTree());

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            pushFollow(FOLLOW_stmts_in_program1297);
            stmts91=stmts();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_stmts.add(stmts91.getTree());

            END92=(Token)match(input,END,FOLLOW_END_in_program1299); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_END.add(END92);


            // AST REWRITE
            // elements: stmts, decl
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {

            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 152:35: -> ^( THEPROGRAM ^( BLOCK_DECLARATION ( decl )* ) ^( BLOCK_STATEMENT stmts ) )
            {
                // .\\src\\thelang\\TheLang.g:152:38: ^( THEPROGRAM ^( BLOCK_DECLARATION ( decl )* ) ^( BLOCK_STATEMENT stmts ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(THEPROGRAM, "THEPROGRAM")
                , root_1);

                // .\\src\\thelang\\TheLang.g:152:51: ^( BLOCK_DECLARATION ( decl )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK_DECLARATION, "BLOCK_DECLARATION")
                , root_2);

                // .\\src\\thelang\\TheLang.g:152:71: ( decl )*
                while ( stream_decl.hasNext() ) {
                    adaptor.addChild(root_2, stream_decl.nextTree());

                }
                stream_decl.reset();

                adaptor.addChild(root_1, root_2);
                }

                // .\\src\\thelang\\TheLang.g:152:78: ^( BLOCK_STATEMENT stmts )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK_STATEMENT, "BLOCK_STATEMENT")
                , root_2);

                adaptor.addChild(root_2, stream_stmts.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;
            }

            }

            retval.stop = input.LT(-1);


            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
            if ( state.backtracking>0 ) { memoize(input, 18, program_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "program"

    // $ANTLR start synpred9_TheLang
    public final void synpred9_TheLang_fragment() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:104:17: ( OR bexpr1 )
        // .\\src\\thelang\\TheLang.g:104:17: OR bexpr1
        {
        match(input,OR,FOLLOW_OR_in_synpred9_TheLang754); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr1_in_synpred9_TheLang757);
        bexpr1();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_TheLang

    // $ANTLR start synpred10_TheLang
    public final void synpred10_TheLang_fragment() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:107:18: ( AND bexpr2 )
        // .\\src\\thelang\\TheLang.g:107:18: AND bexpr2
        {
        match(input,AND,FOLLOW_AND_in_synpred10_TheLang777); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr2_in_synpred10_TheLang780);
        bexpr2();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_TheLang

    // $ANTLR start synpred11_TheLang
    public final void synpred11_TheLang_fragment() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:110:10: ( aexpr opr aexpr )
        // .\\src\\thelang\\TheLang.g:110:10: aexpr opr aexpr
        {
        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang798);
        aexpr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_opr_in_synpred11_TheLang800);
        opr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang803);
        aexpr();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred11_TheLang

    // Delegated rules

    public final boolean synpred9_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_TheLang() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_TheLang_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_aexpr1_in_aexpr516 = new BitSet(new long[]{0x0000102000000002L});
    public static final BitSet FOLLOW_set_in_aexpr519 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr1_in_aexpr528 = new BitSet(new long[]{0x0000102000000002L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1539 = new BitSet(new long[]{0x0000004000020002L});
    public static final BitSet FOLLOW_set_in_aexpr1542 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1551 = new BitSet(new long[]{0x0000004000020002L});
    public static final BitSet FOLLOW_MINUS_in_aexpr2562 = new BitSet(new long[]{0x0000000844000000L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aexpr3599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aexpr3639 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_LBRACKET_in_aexpr3641 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3643 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_aexpr3645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_aexpr3666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_aexpr3712 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3714 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_aexpr3716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr751 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_OR_in_bexpr754 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr757 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1774 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_bexpr1777 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1780 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2798 = new BitSet(new long[]{0x0000009203200000L});
    public static final BitSet FOLLOW_opr_in_bexpr2800 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_bexpr2814 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_bexpr2835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_bexpr2854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_bexpr2873 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2875 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_bexpr2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_decl950 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_decl952 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_decl954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_decl968 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_decl970 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_LBRACKET_in_decl972 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_INTEGER_in_decl974 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_decl976 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_decl978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stmt_in_stmts1004 = new BitSet(new long[]{0x502100000C000002L});
    public static final BitSet FOLLOW_assignStmt_in_stmt1014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt1023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStmt_in_stmt1032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_writeStmt_in_stmt1041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_stmt1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignStmt1073 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assignStmt1075 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt1077 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_assignStmt1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignStmt1101 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_LBRACKET_in_assignStmt1103 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt1105 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_assignStmt1107 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ASSIGN_in_assignStmt1109 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt1111 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_assignStmt1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_in_skipStmt1133 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_skipStmt1135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_readStmt1147 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_readStmt1149 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_readStmt1151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_readStmt1170 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_readStmt1172 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_LBRACKET_in_readStmt1174 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_readStmt1176 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_readStmt1178 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_readStmt1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_writeStmt1202 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_writeStmt1204 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_SEMI_in_writeStmt1206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStmt1222 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr_in_ifStmt1224 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_THEN_in_ifStmt1226 = new BitSet(new long[]{0x502100000C000000L});
    public static final BitSet FOLLOW_stmts_in_ifStmt1228 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ELSE_in_ifStmt1230 = new BitSet(new long[]{0x502100000C000000L});
    public static final BitSet FOLLOW_stmts_in_ifStmt1232 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_FI_in_ifStmt1234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStmt1262 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr_in_whileStmt1264 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DO_in_whileStmt1266 = new BitSet(new long[]{0x502100000C000000L});
    public static final BitSet FOLLOW_stmts_in_whileStmt1268 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_OD_in_whileStmt1270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program1292 = new BitSet(new long[]{0x502100002C000000L});
    public static final BitSet FOLLOW_decl_in_program1294 = new BitSet(new long[]{0x502100002C000000L});
    public static final BitSet FOLLOW_stmts_in_program1297 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_END_in_program1299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_synpred9_TheLang754 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr1_in_synpred9_TheLang757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_synpred10_TheLang777 = new BitSet(new long[]{0x0200012844400000L});
    public static final BitSet FOLLOW_bexpr2_in_synpred10_TheLang780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang798 = new BitSet(new long[]{0x0000009203200000L});
    public static final BitSet FOLLOW_opr_in_synpred11_TheLang800 = new BitSet(new long[]{0x0000002844000000L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang803 = new BitSet(new long[]{0x0000000000000002L});

}