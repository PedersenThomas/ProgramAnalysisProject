// $ANTLR 3.5.2 .\\src\\thelang\\TheLang.g 2015-09-14 20:21:30

package thelang;

import ast.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TheLangParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASSIGN", "COLON", "COMMENT", 
		"DIV", "DO", "ELSE", "END", "EQ", "FALSE", "FI", "GE", "GT", "HIGH", "IDENTIFIER", 
		"IF", "INT", "INTEGER", "LBRACE", "LBRACKET", "LE", "LETTER", "LOW", "LPAREN", 
		"LT", "MINUS", "MUL", "NEQ", "NOT", "OD", "OR", "PLUS", "PROGRAM", "RBRACE", 
		"RBRACKET", "READ", "RPAREN", "SEMI", "SKIP", "THEN", "TRUE", "WHILE", 
		"WRITE", "WS"
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

	@Override public String[] getTokenNames() { return TheLangParser.tokenNames; }
	@Override public String getGrammarFileName() { return ".\\src\\thelang\\TheLang.g"; }



	// $ANTLR start "aexpr"
	// .\\src\\thelang\\TheLang.g:74:1: aexpr returns [ArithmeticExpression value] : l= aexpr1 ( PLUS r1= aexpr1 | MINUS r2= aexpr1 )* ;
	public final ArithmeticExpression aexpr() throws RecognitionException {
		ArithmeticExpression value = null;


		ArithmeticExpression l =null;
		ArithmeticExpression r1 =null;
		ArithmeticExpression r2 =null;

		try {
			// .\\src\\thelang\\TheLang.g:75:2: (l= aexpr1 ( PLUS r1= aexpr1 | MINUS r2= aexpr1 )* )
			// .\\src\\thelang\\TheLang.g:75:4: l= aexpr1 ( PLUS r1= aexpr1 | MINUS r2= aexpr1 )*
			{
			pushFollow(FOLLOW_aexpr1_in_aexpr411);
			l=aexpr1();
			state._fsp--;

			 value = l; 
			// .\\src\\thelang\\TheLang.g:76:3: ( PLUS r1= aexpr1 | MINUS r2= aexpr1 )*
			loop1:
			while (true) {
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
					// .\\src\\thelang\\TheLang.g:76:7: PLUS r1= aexpr1
					{
					match(input,PLUS,FOLLOW_PLUS_in_aexpr422); 
					pushFollow(FOLLOW_aexpr1_in_aexpr427);
					r1=aexpr1();
					state._fsp--;

					 value = new ArithmeticOperation(value, ArithmeticOperator.Plus, r1); 
					}
					break;
				case 2 :
					// .\\src\\thelang\\TheLang.g:77:7: MINUS r2= aexpr1
					{
					match(input,MINUS,FOLLOW_MINUS_in_aexpr438); 
					pushFollow(FOLLOW_aexpr1_in_aexpr442);
					r2=aexpr1();
					state._fsp--;

					 value = new ArithmeticOperation(value, ArithmeticOperator.Minus, r2); 
					}
					break;

				default :
					break loop1;
				}
			}

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
	// $ANTLR end "aexpr"



	// $ANTLR start "aexpr1"
	// .\\src\\thelang\\TheLang.g:81:1: aexpr1 returns [ArithmeticExpression value] : l= aexpr2 ( MUL r1= aexpr2 | DIV r2= aexpr2 )* ;
	public final ArithmeticExpression aexpr1() throws RecognitionException {
		ArithmeticExpression value = null;


		ArithmeticExpression l =null;
		ArithmeticExpression r1 =null;
		ArithmeticExpression r2 =null;

		try {
			// .\\src\\thelang\\TheLang.g:82:2: (l= aexpr2 ( MUL r1= aexpr2 | DIV r2= aexpr2 )* )
			// .\\src\\thelang\\TheLang.g:82:4: l= aexpr2 ( MUL r1= aexpr2 | DIV r2= aexpr2 )*
			{
			pushFollow(FOLLOW_aexpr2_in_aexpr1468);
			l=aexpr2();
			state._fsp--;

			 value = l; 
			// .\\src\\thelang\\TheLang.g:83:3: ( MUL r1= aexpr2 | DIV r2= aexpr2 )*
			loop2:
			while (true) {
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
					// .\\src\\thelang\\TheLang.g:83:7: MUL r1= aexpr2
					{
					match(input,MUL,FOLLOW_MUL_in_aexpr1478); 
					pushFollow(FOLLOW_aexpr2_in_aexpr1482);
					r1=aexpr2();
					state._fsp--;

					 value = new ArithmeticOperation(value, ArithmeticOperator.Multiply, r1); 
					}
					break;
				case 2 :
					// .\\src\\thelang\\TheLang.g:84:7: DIV r2= aexpr2
					{
					match(input,DIV,FOLLOW_DIV_in_aexpr1493); 
					pushFollow(FOLLOW_aexpr2_in_aexpr1497);
					r2=aexpr2();
					state._fsp--;

					 value = new ArithmeticOperation(value, ArithmeticOperator.Divide, r2); 
					}
					break;

				default :
					break loop2;
				}
			}

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
	// $ANTLR end "aexpr1"



	// $ANTLR start "aexpr2"
	// .\\src\\thelang\\TheLang.g:88:1: aexpr2 returns [ArithmeticExpression value] : ( MINUS a1= aexpr3 |a2= aexpr3 );
	public final ArithmeticExpression aexpr2() throws RecognitionException {
		ArithmeticExpression value = null;


		ArithmeticExpression a1 =null;
		ArithmeticExpression a2 =null;

		try {
			// .\\src\\thelang\\TheLang.g:89:2: ( MINUS a1= aexpr3 |a2= aexpr3 )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==MINUS) ) {
				alt3=1;
			}
			else if ( (LA3_0==IDENTIFIER||LA3_0==INTEGER||LA3_0==LPAREN) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// .\\src\\thelang\\TheLang.g:89:4: MINUS a1= aexpr3
					{
					match(input,MINUS,FOLLOW_MINUS_in_aexpr2521); 
					pushFollow(FOLLOW_aexpr3_in_aexpr2525);
					a1=aexpr3();
					state._fsp--;

					 value = new UnaryMinus(a1); 
					}
					break;
				case 2 :
					// .\\src\\thelang\\TheLang.g:90:13: a2= aexpr3
					{
					pushFollow(FOLLOW_aexpr3_in_aexpr2543);
					a2=aexpr3();
					state._fsp--;

					 value = a2; 
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
	// $ANTLR end "aexpr2"



	// $ANTLR start "aexpr3"
	// .\\src\\thelang\\TheLang.g:93:1: aexpr3 returns [ArithmeticExpression value] : ( IDENTIFIER ( LBRACKET a1= aexpr RBRACKET )? | INTEGER | LPAREN a2= aexpr RPAREN );
	public final ArithmeticExpression aexpr3() throws RecognitionException {
		ArithmeticExpression value = null;


		Token IDENTIFIER1=null;
		Token INTEGER2=null;
		ArithmeticExpression a1 =null;
		ArithmeticExpression a2 =null;

		try {
			// .\\src\\thelang\\TheLang.g:94:2: ( IDENTIFIER ( LBRACKET a1= aexpr RBRACKET )? | INTEGER | LPAREN a2= aexpr RPAREN )
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
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// .\\src\\thelang\\TheLang.g:94:4: IDENTIFIER ( LBRACKET a1= aexpr RBRACKET )?
					{
					IDENTIFIER1=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_aexpr3564); 
					 value = new Identifier(IDENTIFIER1.getText()); 
					// .\\src\\thelang\\TheLang.g:95:3: ( LBRACKET a1= aexpr RBRACKET )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==LBRACKET) ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// .\\src\\thelang\\TheLang.g:95:5: LBRACKET a1= aexpr RBRACKET
							{
							match(input,LBRACKET,FOLLOW_LBRACKET_in_aexpr3592); 
							pushFollow(FOLLOW_aexpr_in_aexpr3596);
							a1=aexpr();
							state._fsp--;

							match(input,RBRACKET,FOLLOW_RBRACKET_in_aexpr3598); 
							 value = new ArithmeticArray(value, a1); 
							}
							break;

					}

					}
					break;
				case 2 :
					// .\\src\\thelang\\TheLang.g:97:7: INTEGER
					{
					INTEGER2=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_aexpr3614); 
					 value = new Constant(Integer.parseInt( INTEGER2.getText() )); 
					}
					break;
				case 3 :
					// .\\src\\thelang\\TheLang.g:98:7: LPAREN a2= aexpr RPAREN
					{
					match(input,LPAREN,FOLLOW_LPAREN_in_aexpr3647); 
					pushFollow(FOLLOW_aexpr_in_aexpr3651);
					a2=aexpr();
					state._fsp--;

					match(input,RPAREN,FOLLOW_RPAREN_in_aexpr3653); 
					 value = a2; 
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
	// $ANTLR end "aexpr3"



	// $ANTLR start "program"
	// .\\src\\thelang\\TheLang.g:101:1: program returns [ArithmeticExpression value] : a= aexpr ;
	public final ArithmeticExpression program() throws RecognitionException {
		ArithmeticExpression value = null;


		ArithmeticExpression a =null;

		try {
			// .\\src\\thelang\\TheLang.g:102:2: (a= aexpr )
			// .\\src\\thelang\\TheLang.g:102:4: a= aexpr
			{
			pushFollow(FOLLOW_aexpr_in_program683);
			a=aexpr();
			state._fsp--;

			 value = a; 
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



	public static final BitSet FOLLOW_aexpr1_in_aexpr411 = new BitSet(new long[]{0x0000000820000002L});
	public static final BitSet FOLLOW_PLUS_in_aexpr422 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr1_in_aexpr427 = new BitSet(new long[]{0x0000000820000002L});
	public static final BitSet FOLLOW_MINUS_in_aexpr438 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr1_in_aexpr442 = new BitSet(new long[]{0x0000000820000002L});
	public static final BitSet FOLLOW_aexpr2_in_aexpr1468 = new BitSet(new long[]{0x0000000040000102L});
	public static final BitSet FOLLOW_MUL_in_aexpr1478 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr2_in_aexpr1482 = new BitSet(new long[]{0x0000000040000102L});
	public static final BitSet FOLLOW_DIV_in_aexpr1493 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr2_in_aexpr1497 = new BitSet(new long[]{0x0000000040000102L});
	public static final BitSet FOLLOW_MINUS_in_aexpr2521 = new BitSet(new long[]{0x0000000008240000L});
	public static final BitSet FOLLOW_aexpr3_in_aexpr2525 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aexpr3_in_aexpr2543 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENTIFIER_in_aexpr3564 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_LBRACKET_in_aexpr3592 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr_in_aexpr3596 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_RBRACKET_in_aexpr3598 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_aexpr3614 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_LPAREN_in_aexpr3647 = new BitSet(new long[]{0x0000000028240000L});
	public static final BitSet FOLLOW_aexpr_in_aexpr3651 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_RPAREN_in_aexpr3653 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_aexpr_in_program683 = new BitSet(new long[]{0x0000000000000002L});
}
