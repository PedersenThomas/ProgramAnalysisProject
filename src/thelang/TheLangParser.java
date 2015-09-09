// $ANTLR 3.4 .\\src\\thelang\\TheLang.g 2015-09-09 15:48:33

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
        this.state.ruleMemo = new HashMap[52+1];
         

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
    // .\\src\\thelang\\TheLang.g:72:1: aexpr : aexpr1 ( PLUS aexpr1 | MINUS aexpr1 )* ;
    public final TheLangParser.aexpr_return aexpr() throws RecognitionException {
        TheLangParser.aexpr_return retval = new TheLangParser.aexpr_return();
        retval.start = input.LT(1);

        int aexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token PLUS2=null;
        Token MINUS4=null;
        TheLangParser.aexpr1_return aexpr11 =null;

        TheLangParser.aexpr1_return aexpr13 =null;

        TheLangParser.aexpr1_return aexpr15 =null;


        CommonTree PLUS2_tree=null;
        CommonTree MINUS4_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:72:7: ( aexpr1 ( PLUS aexpr1 | MINUS aexpr1 )* )
            // .\\src\\thelang\\TheLang.g:72:9: aexpr1 ( PLUS aexpr1 | MINUS aexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr1_in_aexpr436);
            aexpr11=aexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr11.getTree());

            // .\\src\\thelang\\TheLang.g:72:16: ( PLUS aexpr1 | MINUS aexpr1 )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PLUS) ) {
                    alt1=1;
                }
                else if ( (LA1_0==MINUS) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:72:17: PLUS aexpr1
            	    {
            	    PLUS2=(Token)match(input,PLUS,FOLLOW_PLUS_in_aexpr439); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    PLUS2_tree = 
            	    (CommonTree)adaptor.create(PLUS2)
            	    ;
            	    adaptor.addChild(root_0, PLUS2_tree);
            	    }

            	    pushFollow(FOLLOW_aexpr1_in_aexpr441);
            	    aexpr13=aexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr13.getTree());

            	    }
            	    break;
            	case 2 :
            	    // .\\src\\thelang\\TheLang.g:72:31: MINUS aexpr1
            	    {
            	    MINUS4=(Token)match(input,MINUS,FOLLOW_MINUS_in_aexpr445); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MINUS4_tree = 
            	    (CommonTree)adaptor.create(MINUS4)
            	    ;
            	    adaptor.addChild(root_0, MINUS4_tree);
            	    }

            	    pushFollow(FOLLOW_aexpr1_in_aexpr447);
            	    aexpr15=aexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr15.getTree());

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
    // .\\src\\thelang\\TheLang.g:74:1: aexpr1 : aexpr2 ( MUL aexpr2 | DIV aexpr2 )* ;
    public final TheLangParser.aexpr1_return aexpr1() throws RecognitionException {
        TheLangParser.aexpr1_return retval = new TheLangParser.aexpr1_return();
        retval.start = input.LT(1);

        int aexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MUL7=null;
        Token DIV9=null;
        TheLangParser.aexpr2_return aexpr26 =null;

        TheLangParser.aexpr2_return aexpr28 =null;

        TheLangParser.aexpr2_return aexpr210 =null;


        CommonTree MUL7_tree=null;
        CommonTree DIV9_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:74:8: ( aexpr2 ( MUL aexpr2 | DIV aexpr2 )* )
            // .\\src\\thelang\\TheLang.g:74:10: aexpr2 ( MUL aexpr2 | DIV aexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_aexpr2_in_aexpr1458);
            aexpr26=aexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr26.getTree());

            // .\\src\\thelang\\TheLang.g:74:17: ( MUL aexpr2 | DIV aexpr2 )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==MUL) ) {
                    alt2=1;
                }
                else if ( (LA2_0==DIV) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:74:18: MUL aexpr2
            	    {
            	    MUL7=(Token)match(input,MUL,FOLLOW_MUL_in_aexpr1461); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    MUL7_tree = 
            	    (CommonTree)adaptor.create(MUL7)
            	    ;
            	    adaptor.addChild(root_0, MUL7_tree);
            	    }

            	    pushFollow(FOLLOW_aexpr2_in_aexpr1463);
            	    aexpr28=aexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr28.getTree());

            	    }
            	    break;
            	case 2 :
            	    // .\\src\\thelang\\TheLang.g:74:31: DIV aexpr2
            	    {
            	    DIV9=(Token)match(input,DIV,FOLLOW_DIV_in_aexpr1467); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DIV9_tree = 
            	    (CommonTree)adaptor.create(DIV9)
            	    ;
            	    adaptor.addChild(root_0, DIV9_tree);
            	    }

            	    pushFollow(FOLLOW_aexpr2_in_aexpr1469);
            	    aexpr210=aexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr210.getTree());

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
    // .\\src\\thelang\\TheLang.g:76:1: aexpr2 : ( MINUS aexpr3 | aexpr3 );
    public final TheLangParser.aexpr2_return aexpr2() throws RecognitionException {
        TheLangParser.aexpr2_return retval = new TheLangParser.aexpr2_return();
        retval.start = input.LT(1);

        int aexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token MINUS11=null;
        TheLangParser.aexpr3_return aexpr312 =null;

        TheLangParser.aexpr3_return aexpr313 =null;


        CommonTree MINUS11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:76:8: ( MINUS aexpr3 | aexpr3 )
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
                    // .\\src\\thelang\\TheLang.g:76:10: MINUS aexpr3
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    MINUS11=(Token)match(input,MINUS,FOLLOW_MINUS_in_aexpr2480); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    MINUS11_tree = 
                    (CommonTree)adaptor.create(MINUS11)
                    ;
                    adaptor.addChild(root_0, MINUS11_tree);
                    }

                    pushFollow(FOLLOW_aexpr3_in_aexpr2482);
                    aexpr312=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr312.getTree());

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:77:10: aexpr3
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr3_in_aexpr2493);
                    aexpr313=aexpr3();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr313.getTree());

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
    // .\\src\\thelang\\TheLang.g:80:1: aexpr3 : ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? | INTEGER | LPAREN aexpr RPAREN );
    public final TheLangParser.aexpr3_return aexpr3() throws RecognitionException {
        TheLangParser.aexpr3_return retval = new TheLangParser.aexpr3_return();
        retval.start = input.LT(1);

        int aexpr3_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER14=null;
        Token LBRACKET15=null;
        Token RBRACKET17=null;
        Token INTEGER18=null;
        Token LPAREN19=null;
        Token RPAREN21=null;
        TheLangParser.aexpr_return aexpr16 =null;

        TheLangParser.aexpr_return aexpr20 =null;


        CommonTree IDENTIFIER14_tree=null;
        CommonTree LBRACKET15_tree=null;
        CommonTree RBRACKET17_tree=null;
        CommonTree INTEGER18_tree=null;
        CommonTree LPAREN19_tree=null;
        CommonTree RPAREN21_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:80:8: ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? | INTEGER | LPAREN aexpr RPAREN )
            int alt5=3;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt5=1;
                }
                break;
            case INTEGER:
                {
                alt5=2;
                }
                break;
            case LPAREN:
                {
                alt5=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }

            switch (alt5) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:80:10: IDENTIFIER ( LBRACKET aexpr RBRACKET )?
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    IDENTIFIER14=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aexpr3509); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER14_tree = 
                    (CommonTree)adaptor.create(IDENTIFIER14)
                    ;
                    adaptor.addChild(root_0, IDENTIFIER14_tree);
                    }

                    // .\\src\\thelang\\TheLang.g:80:21: ( LBRACKET aexpr RBRACKET )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==LBRACKET) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // .\\src\\thelang\\TheLang.g:80:22: LBRACKET aexpr RBRACKET
                            {
                            LBRACKET15=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_aexpr3512); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            LBRACKET15_tree = 
                            (CommonTree)adaptor.create(LBRACKET15)
                            ;
                            adaptor.addChild(root_0, LBRACKET15_tree);
                            }

                            pushFollow(FOLLOW_aexpr_in_aexpr3514);
                            aexpr16=aexpr();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr16.getTree());

                            RBRACKET17=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_aexpr3516); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            RBRACKET17_tree = 
                            (CommonTree)adaptor.create(RBRACKET17)
                            ;
                            adaptor.addChild(root_0, RBRACKET17_tree);
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:81:10: INTEGER
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    INTEGER18=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_aexpr3529); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER18_tree = 
                    (CommonTree)adaptor.create(INTEGER18)
                    ;
                    adaptor.addChild(root_0, INTEGER18_tree);
                    }

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:82:10: LPAREN aexpr RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN19=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_aexpr3540); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN19_tree = 
                    (CommonTree)adaptor.create(LPAREN19)
                    ;
                    adaptor.addChild(root_0, LPAREN19_tree);
                    }

                    pushFollow(FOLLOW_aexpr_in_aexpr3542);
                    aexpr20=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr20.getTree());

                    RPAREN21=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_aexpr3544); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN21_tree = 
                    (CommonTree)adaptor.create(RPAREN21)
                    ;
                    adaptor.addChild(root_0, RPAREN21_tree);
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
    // .\\src\\thelang\\TheLang.g:85:1: bexpr : bexpr1 ( OR bexpr1 )* ;
    public final TheLangParser.bexpr_return bexpr() throws RecognitionException {
        TheLangParser.bexpr_return retval = new TheLangParser.bexpr_return();
        retval.start = input.LT(1);

        int bexpr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token OR23=null;
        TheLangParser.bexpr1_return bexpr122 =null;

        TheLangParser.bexpr1_return bexpr124 =null;


        CommonTree OR23_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:85:7: ( bexpr1 ( OR bexpr1 )* )
            // .\\src\\thelang\\TheLang.g:85:9: bexpr1 ( OR bexpr1 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr1_in_bexpr560);
            bexpr122=bexpr1();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr122.getTree());

            // .\\src\\thelang\\TheLang.g:85:16: ( OR bexpr1 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==OR) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred9_TheLang()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:85:17: OR bexpr1
            	    {
            	    OR23=(Token)match(input,OR,FOLLOW_OR_in_bexpr563); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR23_tree = 
            	    (CommonTree)adaptor.create(OR23)
            	    ;
            	    adaptor.addChild(root_0, OR23_tree);
            	    }

            	    pushFollow(FOLLOW_bexpr1_in_bexpr565);
            	    bexpr124=bexpr1();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr124.getTree());

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
    // .\\src\\thelang\\TheLang.g:88:1: bexpr1 : bexpr2 ( AND bexpr2 )* ;
    public final TheLangParser.bexpr1_return bexpr1() throws RecognitionException {
        TheLangParser.bexpr1_return retval = new TheLangParser.bexpr1_return();
        retval.start = input.LT(1);

        int bexpr1_StartIndex = input.index();

        CommonTree root_0 = null;

        Token AND26=null;
        TheLangParser.bexpr2_return bexpr225 =null;

        TheLangParser.bexpr2_return bexpr227 =null;


        CommonTree AND26_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:88:8: ( bexpr2 ( AND bexpr2 )* )
            // .\\src\\thelang\\TheLang.g:88:10: bexpr2 ( AND bexpr2 )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_bexpr2_in_bexpr1582);
            bexpr225=bexpr2();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr225.getTree());

            // .\\src\\thelang\\TheLang.g:88:17: ( AND bexpr2 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==AND) ) {
                    int LA7_2 = input.LA(2);

                    if ( (synpred10_TheLang()) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:88:18: AND bexpr2
            	    {
            	    AND26=(Token)match(input,AND,FOLLOW_AND_in_bexpr1585); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND26_tree = 
            	    (CommonTree)adaptor.create(AND26)
            	    ;
            	    adaptor.addChild(root_0, AND26_tree);
            	    }

            	    pushFollow(FOLLOW_bexpr2_in_bexpr1587);
            	    bexpr227=bexpr2();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr227.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
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
    // .\\src\\thelang\\TheLang.g:91:1: bexpr2 : ( aexpr opr aexpr | NOT bexpr | TRUE | FALSE | LPAREN bexpr RPAREN );
    public final TheLangParser.bexpr2_return bexpr2() throws RecognitionException {
        TheLangParser.bexpr2_return retval = new TheLangParser.bexpr2_return();
        retval.start = input.LT(1);

        int bexpr2_StartIndex = input.index();

        CommonTree root_0 = null;

        Token NOT31=null;
        Token TRUE33=null;
        Token FALSE34=null;
        Token LPAREN35=null;
        Token RPAREN37=null;
        TheLangParser.aexpr_return aexpr28 =null;

        TheLangParser.opr_return opr29 =null;

        TheLangParser.aexpr_return aexpr30 =null;

        TheLangParser.bexpr_return bexpr32 =null;

        TheLangParser.bexpr_return bexpr36 =null;


        CommonTree NOT31_tree=null;
        CommonTree TRUE33_tree=null;
        CommonTree FALSE34_tree=null;
        CommonTree LPAREN35_tree=null;
        CommonTree RPAREN37_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:91:8: ( aexpr opr aexpr | NOT bexpr | TRUE | FALSE | LPAREN bexpr RPAREN )
            int alt8=5;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
            case INTEGER:
            case MINUS:
                {
                alt8=1;
                }
                break;
            case LPAREN:
                {
                int LA8_4 = input.LA(2);

                if ( (synpred11_TheLang()) ) {
                    alt8=1;
                }
                else if ( (true) ) {
                    alt8=5;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 4, input);

                    throw nvae;

                }
                }
                break;
            case NOT:
                {
                alt8=2;
                }
                break;
            case TRUE:
                {
                alt8=3;
                }
                break;
            case FALSE:
                {
                alt8=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }

            switch (alt8) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:91:10: aexpr opr aexpr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_aexpr_in_bexpr2605);
                    aexpr28=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr28.getTree());

                    pushFollow(FOLLOW_opr_in_bexpr2607);
                    opr29=opr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, opr29.getTree());

                    pushFollow(FOLLOW_aexpr_in_bexpr2609);
                    aexpr30=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr30.getTree());

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:92:10: NOT bexpr
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    NOT31=(Token)match(input,NOT,FOLLOW_NOT_in_bexpr2620); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOT31_tree = 
                    (CommonTree)adaptor.create(NOT31)
                    ;
                    adaptor.addChild(root_0, NOT31_tree);
                    }

                    pushFollow(FOLLOW_bexpr_in_bexpr2622);
                    bexpr32=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr32.getTree());

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:93:10: TRUE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    TRUE33=(Token)match(input,TRUE,FOLLOW_TRUE_in_bexpr2633); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TRUE33_tree = 
                    (CommonTree)adaptor.create(TRUE33)
                    ;
                    adaptor.addChild(root_0, TRUE33_tree);
                    }

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:94:10: FALSE
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    FALSE34=(Token)match(input,FALSE,FOLLOW_FALSE_in_bexpr2644); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    FALSE34_tree = 
                    (CommonTree)adaptor.create(FALSE34)
                    ;
                    adaptor.addChild(root_0, FALSE34_tree);
                    }

                    }
                    break;
                case 5 :
                    // .\\src\\thelang\\TheLang.g:95:10: LPAREN bexpr RPAREN
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    LPAREN35=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_bexpr2655); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN35_tree = 
                    (CommonTree)adaptor.create(LPAREN35)
                    ;
                    adaptor.addChild(root_0, LPAREN35_tree);
                    }

                    pushFollow(FOLLOW_bexpr_in_bexpr2657);
                    bexpr36=bexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr36.getTree());

                    RPAREN37=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_bexpr2659); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN37_tree = 
                    (CommonTree)adaptor.create(RPAREN37)
                    ;
                    adaptor.addChild(root_0, RPAREN37_tree);
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
    // .\\src\\thelang\\TheLang.g:98:1: opr : ( GT | GE | LT | LE | EQ | NEQ );
    public final TheLangParser.opr_return opr() throws RecognitionException {
        TheLangParser.opr_return retval = new TheLangParser.opr_return();
        retval.start = input.LT(1);

        int opr_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set38=null;

        CommonTree set38_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:98:5: ( GT | GE | LT | LE | EQ | NEQ )
            // .\\src\\thelang\\TheLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(Token)input.LT(1);

            if ( input.LA(1)==EQ||(input.LA(1) >= GE && input.LA(1) <= GT)||input.LA(1)==LE||input.LA(1)==LT||input.LA(1)==NEQ ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set38)
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
    // .\\src\\thelang\\TheLang.g:106:1: decl : ( level )? INT IDENTIFIER ( LBRACKET INTEGER RBRACKET )? SEMI ;
    public final TheLangParser.decl_return decl() throws RecognitionException {
        TheLangParser.decl_return retval = new TheLangParser.decl_return();
        retval.start = input.LT(1);

        int decl_StartIndex = input.index();

        CommonTree root_0 = null;

        Token INT40=null;
        Token IDENTIFIER41=null;
        Token LBRACKET42=null;
        Token INTEGER43=null;
        Token RBRACKET44=null;
        Token SEMI45=null;
        TheLangParser.level_return level39 =null;


        CommonTree INT40_tree=null;
        CommonTree IDENTIFIER41_tree=null;
        CommonTree LBRACKET42_tree=null;
        CommonTree INTEGER43_tree=null;
        CommonTree RBRACKET44_tree=null;
        CommonTree SEMI45_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:106:6: ( ( level )? INT IDENTIFIER ( LBRACKET INTEGER RBRACKET )? SEMI )
            // .\\src\\thelang\\TheLang.g:106:8: ( level )? INT IDENTIFIER ( LBRACKET INTEGER RBRACKET )? SEMI
            {
            root_0 = (CommonTree)adaptor.nil();


            // .\\src\\thelang\\TheLang.g:106:8: ( level )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==HIGH||LA9_0==LOW) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:106:8: level
                    {
                    pushFollow(FOLLOW_level_in_decl728);
                    level39=level();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, level39.getTree());

                    }
                    break;

            }


            INT40=(Token)match(input,INT,FOLLOW_INT_in_decl731); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            INT40_tree = 
            (CommonTree)adaptor.create(INT40)
            ;
            adaptor.addChild(root_0, INT40_tree);
            }

            IDENTIFIER41=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_decl733); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER41_tree = 
            (CommonTree)adaptor.create(IDENTIFIER41)
            ;
            adaptor.addChild(root_0, IDENTIFIER41_tree);
            }

            // .\\src\\thelang\\TheLang.g:106:30: ( LBRACKET INTEGER RBRACKET )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LBRACKET) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:106:31: LBRACKET INTEGER RBRACKET
                    {
                    LBRACKET42=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_decl736); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACKET42_tree = 
                    (CommonTree)adaptor.create(LBRACKET42)
                    ;
                    adaptor.addChild(root_0, LBRACKET42_tree);
                    }

                    INTEGER43=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_decl738); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER43_tree = 
                    (CommonTree)adaptor.create(INTEGER43)
                    ;
                    adaptor.addChild(root_0, INTEGER43_tree);
                    }

                    RBRACKET44=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_decl740); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACKET44_tree = 
                    (CommonTree)adaptor.create(RBRACKET44)
                    ;
                    adaptor.addChild(root_0, RBRACKET44_tree);
                    }

                    }
                    break;

            }


            SEMI45=(Token)match(input,SEMI,FOLLOW_SEMI_in_decl744); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMI45_tree = 
            (CommonTree)adaptor.create(SEMI45)
            ;
            adaptor.addChild(root_0, SEMI45_tree);
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
            if ( state.backtracking>0 ) { memoize(input, 9, decl_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "decl"


    public static class level_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "level"
    // .\\src\\thelang\\TheLang.g:108:1: level : ( LOW | HIGH );
    public final TheLangParser.level_return level() throws RecognitionException {
        TheLangParser.level_return retval = new TheLangParser.level_return();
        retval.start = input.LT(1);

        int level_StartIndex = input.index();

        CommonTree root_0 = null;

        Token set46=null;

        CommonTree set46_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:108:7: ( LOW | HIGH )
            // .\\src\\thelang\\TheLang.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set46=(Token)input.LT(1);

            if ( input.LA(1)==HIGH||input.LA(1)==LOW ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set46)
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
            if ( state.backtracking>0 ) { memoize(input, 10, level_StartIndex); }

        }
        return retval;
    }
    // $ANTLR end "level"


    public static class stmt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "stmt"
    // .\\src\\thelang\\TheLang.g:110:1: stmt : ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt );
    public final TheLangParser.stmt_return stmt() throws RecognitionException {
        TheLangParser.stmt_return retval = new TheLangParser.stmt_return();
        retval.start = input.LT(1);

        int stmt_StartIndex = input.index();

        CommonTree root_0 = null;

        TheLangParser.assignStmt_return assignStmt47 =null;

        TheLangParser.skipStmt_return skipStmt48 =null;

        TheLangParser.readStmt_return readStmt49 =null;

        TheLangParser.writeStmt_return writeStmt50 =null;

        TheLangParser.ifStmt_return ifStmt51 =null;

        TheLangParser.whileStmt_return whileStmt52 =null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:110:6: ( assignStmt | skipStmt | readStmt | writeStmt | ifStmt | whileStmt )
            int alt11=6;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                alt11=1;
                }
                break;
            case SKIP:
                {
                alt11=2;
                }
                break;
            case READ:
                {
                alt11=3;
                }
                break;
            case WRITE:
                {
                alt11=4;
                }
                break;
            case IF:
                {
                alt11=5;
                }
                break;
            case WHILE:
                {
                alt11=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:110:8: assignStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_assignStmt_in_stmt766);
                    assignStmt47=assignStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignStmt47.getTree());

                    }
                    break;
                case 2 :
                    // .\\src\\thelang\\TheLang.g:111:8: skipStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_skipStmt_in_stmt775);
                    skipStmt48=skipStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, skipStmt48.getTree());

                    }
                    break;
                case 3 :
                    // .\\src\\thelang\\TheLang.g:112:8: readStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_readStmt_in_stmt784);
                    readStmt49=readStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, readStmt49.getTree());

                    }
                    break;
                case 4 :
                    // .\\src\\thelang\\TheLang.g:113:8: writeStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_writeStmt_in_stmt793);
                    writeStmt50=writeStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, writeStmt50.getTree());

                    }
                    break;
                case 5 :
                    // .\\src\\thelang\\TheLang.g:114:8: ifStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_ifStmt_in_stmt802);
                    ifStmt51=ifStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, ifStmt51.getTree());

                    }
                    break;
                case 6 :
                    // .\\src\\thelang\\TheLang.g:115:8: whileStmt
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_whileStmt_in_stmt811);
                    whileStmt52=whileStmt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, whileStmt52.getTree());

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
    // .\\src\\thelang\\TheLang.g:118:1: assignStmt : IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN aexpr SEMI ;
    public final TheLangParser.assignStmt_return assignStmt() throws RecognitionException {
        TheLangParser.assignStmt_return retval = new TheLangParser.assignStmt_return();
        retval.start = input.LT(1);

        int assignStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IDENTIFIER53=null;
        Token LBRACKET54=null;
        Token RBRACKET56=null;
        Token ASSIGN57=null;
        Token SEMI59=null;
        TheLangParser.aexpr_return aexpr55 =null;

        TheLangParser.aexpr_return aexpr58 =null;


        CommonTree IDENTIFIER53_tree=null;
        CommonTree LBRACKET54_tree=null;
        CommonTree RBRACKET56_tree=null;
        CommonTree ASSIGN57_tree=null;
        CommonTree SEMI59_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:118:12: ( IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN aexpr SEMI )
            // .\\src\\thelang\\TheLang.g:118:14: IDENTIFIER ( LBRACKET aexpr RBRACKET )? ASSIGN aexpr SEMI
            {
            root_0 = (CommonTree)adaptor.nil();


            IDENTIFIER53=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_assignStmt825); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER53_tree = 
            (CommonTree)adaptor.create(IDENTIFIER53)
            ;
            adaptor.addChild(root_0, IDENTIFIER53_tree);
            }

            // .\\src\\thelang\\TheLang.g:118:25: ( LBRACKET aexpr RBRACKET )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LBRACKET) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:118:26: LBRACKET aexpr RBRACKET
                    {
                    LBRACKET54=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_assignStmt828); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACKET54_tree = 
                    (CommonTree)adaptor.create(LBRACKET54)
                    ;
                    adaptor.addChild(root_0, LBRACKET54_tree);
                    }

                    pushFollow(FOLLOW_aexpr_in_assignStmt830);
                    aexpr55=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr55.getTree());

                    RBRACKET56=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_assignStmt832); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACKET56_tree = 
                    (CommonTree)adaptor.create(RBRACKET56)
                    ;
                    adaptor.addChild(root_0, RBRACKET56_tree);
                    }

                    }
                    break;

            }


            ASSIGN57=(Token)match(input,ASSIGN,FOLLOW_ASSIGN_in_assignStmt836); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ASSIGN57_tree = 
            (CommonTree)adaptor.create(ASSIGN57)
            ;
            adaptor.addChild(root_0, ASSIGN57_tree);
            }

            pushFollow(FOLLOW_aexpr_in_assignStmt838);
            aexpr58=aexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr58.getTree());

            SEMI59=(Token)match(input,SEMI,FOLLOW_SEMI_in_assignStmt840); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMI59_tree = 
            (CommonTree)adaptor.create(SEMI59)
            ;
            adaptor.addChild(root_0, SEMI59_tree);
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
    // .\\src\\thelang\\TheLang.g:120:1: skipStmt : SKIP SEMI ;
    public final TheLangParser.skipStmt_return skipStmt() throws RecognitionException {
        TheLangParser.skipStmt_return retval = new TheLangParser.skipStmt_return();
        retval.start = input.LT(1);

        int skipStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token SKIP60=null;
        Token SEMI61=null;

        CommonTree SKIP60_tree=null;
        CommonTree SEMI61_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:120:10: ( SKIP SEMI )
            // .\\src\\thelang\\TheLang.g:120:12: SKIP SEMI
            {
            root_0 = (CommonTree)adaptor.nil();


            SKIP60=(Token)match(input,SKIP,FOLLOW_SKIP_in_skipStmt849); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SKIP60_tree = 
            (CommonTree)adaptor.create(SKIP60)
            ;
            adaptor.addChild(root_0, SKIP60_tree);
            }

            SEMI61=(Token)match(input,SEMI,FOLLOW_SEMI_in_skipStmt851); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMI61_tree = 
            (CommonTree)adaptor.create(SEMI61)
            ;
            adaptor.addChild(root_0, SEMI61_tree);
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
    // .\\src\\thelang\\TheLang.g:122:1: readStmt : READ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI ;
    public final TheLangParser.readStmt_return readStmt() throws RecognitionException {
        TheLangParser.readStmt_return retval = new TheLangParser.readStmt_return();
        retval.start = input.LT(1);

        int readStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token READ62=null;
        Token IDENTIFIER63=null;
        Token LBRACKET64=null;
        Token RBRACKET66=null;
        Token SEMI67=null;
        TheLangParser.aexpr_return aexpr65 =null;


        CommonTree READ62_tree=null;
        CommonTree IDENTIFIER63_tree=null;
        CommonTree LBRACKET64_tree=null;
        CommonTree RBRACKET66_tree=null;
        CommonTree SEMI67_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:122:10: ( READ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI )
            // .\\src\\thelang\\TheLang.g:122:12: READ IDENTIFIER ( LBRACKET aexpr RBRACKET )? SEMI
            {
            root_0 = (CommonTree)adaptor.nil();


            READ62=(Token)match(input,READ,FOLLOW_READ_in_readStmt860); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            READ62_tree = 
            (CommonTree)adaptor.create(READ62)
            ;
            adaptor.addChild(root_0, READ62_tree);
            }

            IDENTIFIER63=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_readStmt862); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER63_tree = 
            (CommonTree)adaptor.create(IDENTIFIER63)
            ;
            adaptor.addChild(root_0, IDENTIFIER63_tree);
            }

            // .\\src\\thelang\\TheLang.g:122:28: ( LBRACKET aexpr RBRACKET )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LBRACKET) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // .\\src\\thelang\\TheLang.g:122:29: LBRACKET aexpr RBRACKET
                    {
                    LBRACKET64=(Token)match(input,LBRACKET,FOLLOW_LBRACKET_in_readStmt865); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LBRACKET64_tree = 
                    (CommonTree)adaptor.create(LBRACKET64)
                    ;
                    adaptor.addChild(root_0, LBRACKET64_tree);
                    }

                    pushFollow(FOLLOW_aexpr_in_readStmt867);
                    aexpr65=aexpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr65.getTree());

                    RBRACKET66=(Token)match(input,RBRACKET,FOLLOW_RBRACKET_in_readStmt869); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RBRACKET66_tree = 
                    (CommonTree)adaptor.create(RBRACKET66)
                    ;
                    adaptor.addChild(root_0, RBRACKET66_tree);
                    }

                    }
                    break;

            }


            SEMI67=(Token)match(input,SEMI,FOLLOW_SEMI_in_readStmt873); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMI67_tree = 
            (CommonTree)adaptor.create(SEMI67)
            ;
            adaptor.addChild(root_0, SEMI67_tree);
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
    // .\\src\\thelang\\TheLang.g:124:1: writeStmt : WRITE aexpr SEMI ;
    public final TheLangParser.writeStmt_return writeStmt() throws RecognitionException {
        TheLangParser.writeStmt_return retval = new TheLangParser.writeStmt_return();
        retval.start = input.LT(1);

        int writeStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WRITE68=null;
        Token SEMI70=null;
        TheLangParser.aexpr_return aexpr69 =null;


        CommonTree WRITE68_tree=null;
        CommonTree SEMI70_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:124:11: ( WRITE aexpr SEMI )
            // .\\src\\thelang\\TheLang.g:124:13: WRITE aexpr SEMI
            {
            root_0 = (CommonTree)adaptor.nil();


            WRITE68=(Token)match(input,WRITE,FOLLOW_WRITE_in_writeStmt882); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WRITE68_tree = 
            (CommonTree)adaptor.create(WRITE68)
            ;
            adaptor.addChild(root_0, WRITE68_tree);
            }

            pushFollow(FOLLOW_aexpr_in_writeStmt884);
            aexpr69=aexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, aexpr69.getTree());

            SEMI70=(Token)match(input,SEMI,FOLLOW_SEMI_in_writeStmt886); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            SEMI70_tree = 
            (CommonTree)adaptor.create(SEMI70)
            ;
            adaptor.addChild(root_0, SEMI70_tree);
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
    // .\\src\\thelang\\TheLang.g:126:1: ifStmt : IF bexpr THEN ( stmt )+ ELSE ( stmt )+ FI ;
    public final TheLangParser.ifStmt_return ifStmt() throws RecognitionException {
        TheLangParser.ifStmt_return retval = new TheLangParser.ifStmt_return();
        retval.start = input.LT(1);

        int ifStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token IF71=null;
        Token THEN73=null;
        Token ELSE75=null;
        Token FI77=null;
        TheLangParser.bexpr_return bexpr72 =null;

        TheLangParser.stmt_return stmt74 =null;

        TheLangParser.stmt_return stmt76 =null;


        CommonTree IF71_tree=null;
        CommonTree THEN73_tree=null;
        CommonTree ELSE75_tree=null;
        CommonTree FI77_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:126:8: ( IF bexpr THEN ( stmt )+ ELSE ( stmt )+ FI )
            // .\\src\\thelang\\TheLang.g:126:10: IF bexpr THEN ( stmt )+ ELSE ( stmt )+ FI
            {
            root_0 = (CommonTree)adaptor.nil();


            IF71=(Token)match(input,IF,FOLLOW_IF_in_ifStmt895); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IF71_tree = 
            (CommonTree)adaptor.create(IF71)
            ;
            adaptor.addChild(root_0, IF71_tree);
            }

            pushFollow(FOLLOW_bexpr_in_ifStmt897);
            bexpr72=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr72.getTree());

            THEN73=(Token)match(input,THEN,FOLLOW_THEN_in_ifStmt899); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            THEN73_tree = 
            (CommonTree)adaptor.create(THEN73)
            ;
            adaptor.addChild(root_0, THEN73_tree);
            }

            // .\\src\\thelang\\TheLang.g:126:24: ( stmt )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= IDENTIFIER && LA14_0 <= IF)||LA14_0==READ||LA14_0==SKIP||(LA14_0 >= WHILE && LA14_0 <= WRITE)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:126:24: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt901);
            	    stmt74=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt74.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            ELSE75=(Token)match(input,ELSE,FOLLOW_ELSE_in_ifStmt904); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ELSE75_tree = 
            (CommonTree)adaptor.create(ELSE75)
            ;
            adaptor.addChild(root_0, ELSE75_tree);
            }

            // .\\src\\thelang\\TheLang.g:126:35: ( stmt )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= IDENTIFIER && LA15_0 <= IF)||LA15_0==READ||LA15_0==SKIP||(LA15_0 >= WHILE && LA15_0 <= WRITE)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:126:35: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_ifStmt906);
            	    stmt76=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt76.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);


            FI77=(Token)match(input,FI,FOLLOW_FI_in_ifStmt909); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            FI77_tree = 
            (CommonTree)adaptor.create(FI77)
            ;
            adaptor.addChild(root_0, FI77_tree);
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
    // .\\src\\thelang\\TheLang.g:128:1: whileStmt : WHILE bexpr DO ( stmt )+ OD ;
    public final TheLangParser.whileStmt_return whileStmt() throws RecognitionException {
        TheLangParser.whileStmt_return retval = new TheLangParser.whileStmt_return();
        retval.start = input.LT(1);

        int whileStmt_StartIndex = input.index();

        CommonTree root_0 = null;

        Token WHILE78=null;
        Token DO80=null;
        Token OD82=null;
        TheLangParser.bexpr_return bexpr79 =null;

        TheLangParser.stmt_return stmt81 =null;


        CommonTree WHILE78_tree=null;
        CommonTree DO80_tree=null;
        CommonTree OD82_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:128:11: ( WHILE bexpr DO ( stmt )+ OD )
            // .\\src\\thelang\\TheLang.g:128:13: WHILE bexpr DO ( stmt )+ OD
            {
            root_0 = (CommonTree)adaptor.nil();


            WHILE78=(Token)match(input,WHILE,FOLLOW_WHILE_in_whileStmt918); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WHILE78_tree = 
            (CommonTree)adaptor.create(WHILE78)
            ;
            adaptor.addChild(root_0, WHILE78_tree);
            }

            pushFollow(FOLLOW_bexpr_in_whileStmt920);
            bexpr79=bexpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, bexpr79.getTree());

            DO80=(Token)match(input,DO,FOLLOW_DO_in_whileStmt922); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DO80_tree = 
            (CommonTree)adaptor.create(DO80)
            ;
            adaptor.addChild(root_0, DO80_tree);
            }

            // .\\src\\thelang\\TheLang.g:128:28: ( stmt )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= IDENTIFIER && LA16_0 <= IF)||LA16_0==READ||LA16_0==SKIP||(LA16_0 >= WHILE && LA16_0 <= WRITE)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:128:28: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_whileStmt924);
            	    stmt81=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt81.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            OD82=(Token)match(input,OD,FOLLOW_OD_in_whileStmt927); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            OD82_tree = 
            (CommonTree)adaptor.create(OD82)
            ;
            adaptor.addChild(root_0, OD82_tree);
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
    // .\\src\\thelang\\TheLang.g:130:1: program : PROGRAM ( decl )* ( stmt )+ END ;
    public final TheLangParser.program_return program() throws RecognitionException {
        TheLangParser.program_return retval = new TheLangParser.program_return();
        retval.start = input.LT(1);

        int program_StartIndex = input.index();

        CommonTree root_0 = null;

        Token PROGRAM83=null;
        Token END86=null;
        TheLangParser.decl_return decl84 =null;

        TheLangParser.stmt_return stmt85 =null;


        CommonTree PROGRAM83_tree=null;
        CommonTree END86_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }

            // .\\src\\thelang\\TheLang.g:130:9: ( PROGRAM ( decl )* ( stmt )+ END )
            // .\\src\\thelang\\TheLang.g:130:11: PROGRAM ( decl )* ( stmt )+ END
            {
            root_0 = (CommonTree)adaptor.nil();


            PROGRAM83=(Token)match(input,PROGRAM,FOLLOW_PROGRAM_in_program936); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            PROGRAM83_tree = 
            (CommonTree)adaptor.create(PROGRAM83)
            ;
            adaptor.addChild(root_0, PROGRAM83_tree);
            }

            // .\\src\\thelang\\TheLang.g:130:19: ( decl )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==HIGH||LA17_0==INT||LA17_0==LOW) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:130:19: decl
            	    {
            	    pushFollow(FOLLOW_decl_in_program938);
            	    decl84=decl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, decl84.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            // .\\src\\thelang\\TheLang.g:130:25: ( stmt )+
            int cnt18=0;
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= IDENTIFIER && LA18_0 <= IF)||LA18_0==READ||LA18_0==SKIP||(LA18_0 >= WHILE && LA18_0 <= WRITE)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // .\\src\\thelang\\TheLang.g:130:25: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_program941);
            	    stmt85=stmt();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stmt85.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt18 >= 1 ) break loop18;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(18, input);
                        throw eee;
                }
                cnt18++;
            } while (true);


            END86=(Token)match(input,END,FOLLOW_END_in_program944); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            END86_tree = 
            (CommonTree)adaptor.create(END86)
            ;
            adaptor.addChild(root_0, END86_tree);
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
        // .\\src\\thelang\\TheLang.g:85:17: ( OR bexpr1 )
        // .\\src\\thelang\\TheLang.g:85:17: OR bexpr1
        {
        match(input,OR,FOLLOW_OR_in_synpred9_TheLang563); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr1_in_synpred9_TheLang565);
        bexpr1();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred9_TheLang

    // $ANTLR start synpred10_TheLang
    public final void synpred10_TheLang_fragment() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:88:18: ( AND bexpr2 )
        // .\\src\\thelang\\TheLang.g:88:18: AND bexpr2
        {
        match(input,AND,FOLLOW_AND_in_synpred10_TheLang585); if (state.failed) return ;

        pushFollow(FOLLOW_bexpr2_in_synpred10_TheLang587);
        bexpr2();

        state._fsp--;
        if (state.failed) return ;

        }

    }
    // $ANTLR end synpred10_TheLang

    // $ANTLR start synpred11_TheLang
    public final void synpred11_TheLang_fragment() throws RecognitionException {
        // .\\src\\thelang\\TheLang.g:91:10: ( aexpr opr aexpr )
        // .\\src\\thelang\\TheLang.g:91:10: aexpr opr aexpr
        {
        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang605);
        aexpr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_opr_in_synpred11_TheLang607);
        opr();

        state._fsp--;
        if (state.failed) return ;

        pushFollow(FOLLOW_aexpr_in_synpred11_TheLang609);
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


 

    public static final BitSet FOLLOW_aexpr1_in_aexpr436 = new BitSet(new long[]{0x0000000820000002L});
    public static final BitSet FOLLOW_PLUS_in_aexpr439 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr1_in_aexpr441 = new BitSet(new long[]{0x0000000820000002L});
    public static final BitSet FOLLOW_MINUS_in_aexpr445 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr1_in_aexpr447 = new BitSet(new long[]{0x0000000820000002L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1458 = new BitSet(new long[]{0x0000000040000102L});
    public static final BitSet FOLLOW_MUL_in_aexpr1461 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1463 = new BitSet(new long[]{0x0000000040000102L});
    public static final BitSet FOLLOW_DIV_in_aexpr1467 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr2_in_aexpr1469 = new BitSet(new long[]{0x0000000040000102L});
    public static final BitSet FOLLOW_MINUS_in_aexpr2480 = new BitSet(new long[]{0x0000000008240000L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr3_in_aexpr2493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_aexpr3509 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_LBRACKET_in_aexpr3512 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3514 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_aexpr3516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_aexpr3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_aexpr3540 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_aexpr3542 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_aexpr3544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr560 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_OR_in_bexpr563 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr1_in_bexpr565 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1582 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_AND_in_bexpr1585 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr2_in_bexpr1587 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2605 = new BitSet(new long[]{0x0000000091019000L});
    public static final BitSet FOLLOW_opr_in_bexpr2607 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_bexpr2609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_bexpr2620 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_bexpr2633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_bexpr2644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_bexpr2655 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr_in_bexpr2657 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_RPAREN_in_bexpr2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_level_in_decl728 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_INT_in_decl731 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_decl733 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_LBRACKET_in_decl736 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_INTEGER_in_decl738 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_decl740 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_decl744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignStmt_in_stmt766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_skipStmt_in_stmt775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_readStmt_in_stmt784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_writeStmt_in_stmt793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ifStmt_in_stmt802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_whileStmt_in_stmt811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_assignStmt825 = new BitSet(new long[]{0x0000000000800020L});
    public static final BitSet FOLLOW_LBRACKET_in_assignStmt828 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt830 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_assignStmt832 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_ASSIGN_in_assignStmt836 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_assignStmt838 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_assignStmt840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SKIP_in_skipStmt849 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_skipStmt851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_READ_in_readStmt860 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_readStmt862 = new BitSet(new long[]{0x0000020000800000L});
    public static final BitSet FOLLOW_LBRACKET_in_readStmt865 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_readStmt867 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RBRACKET_in_readStmt869 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_readStmt873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WRITE_in_writeStmt882 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_writeStmt884 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_SEMI_in_writeStmt886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_ifStmt895 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr_in_ifStmt897 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_THEN_in_ifStmt899 = new BitSet(new long[]{0x00006480000C0000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt901 = new BitSet(new long[]{0x00006480000C0400L});
    public static final BitSet FOLLOW_ELSE_in_ifStmt904 = new BitSet(new long[]{0x00006480000C0000L});
    public static final BitSet FOLLOW_stmt_in_ifStmt906 = new BitSet(new long[]{0x00006480000C4000L});
    public static final BitSet FOLLOW_FI_in_ifStmt909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHILE_in_whileStmt918 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr_in_whileStmt920 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_DO_in_whileStmt922 = new BitSet(new long[]{0x00006480000C0000L});
    public static final BitSet FOLLOW_stmt_in_whileStmt924 = new BitSet(new long[]{0x00006482000C0000L});
    public static final BitSet FOLLOW_OD_in_whileStmt927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROGRAM_in_program936 = new BitSet(new long[]{0x00006480041E0000L});
    public static final BitSet FOLLOW_decl_in_program938 = new BitSet(new long[]{0x00006480041E0000L});
    public static final BitSet FOLLOW_stmt_in_program941 = new BitSet(new long[]{0x00006480000C0800L});
    public static final BitSet FOLLOW_END_in_program944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OR_in_synpred9_TheLang563 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr1_in_synpred9_TheLang565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AND_in_synpred10_TheLang585 = new BitSet(new long[]{0x0000100128242000L});
    public static final BitSet FOLLOW_bexpr2_in_synpred10_TheLang587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang605 = new BitSet(new long[]{0x0000000091019000L});
    public static final BitSet FOLLOW_opr_in_synpred11_TheLang607 = new BitSet(new long[]{0x0000000028240000L});
    public static final BitSet FOLLOW_aexpr_in_synpred11_TheLang609 = new BitSet(new long[]{0x0000000000000002L});

}