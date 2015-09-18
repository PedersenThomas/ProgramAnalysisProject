/*
 * ANTRL (http://www.antlr.org/) grammar for the project language. You will
 * probably want to adapt the file to generate parser for your language of
 * choice and use your own data structures (or define tree parser to traverse
 * the tree generated by ANTLR).
 *
 * Note that this has not been throughly tested, so let us know if there are
 * any problems.
 */

grammar TheLang;

options {
  language= Java;  /* Change this to generate parser for some other language. */
  backtrack = true;
  memoize = true;
  output = AST;
  ASTLabelType = CommonTree;
}

tokens {
  AND = '&';
  OR = '|';
  ASSIGN = ':=';
  SEMI = ';';
  GT = '>';
  GE = '>=';
  LT = '<';
  LE = '<=';
  EQ = '=';
  NEQ = '!=';
  PLUS = '+';
  MINUS = '-';
  MUL = '*';
  DIV = '/';
  NOT = '!';
  LPAREN = '(';
  RPAREN = ')';
  LBRACE = '{';
  RBRACE = '}';
  LBRACKET = '[';
  RBRACKET = ']';
  COLON = ':';
  IF = 'if';
  THEN = 'then';
  ELSE = 'else';
  FI = 'fi';
  WHILE = 'while';
  DO = 'do';
  OD = 'od';
  SKIP = 'skip';
  WRITE = 'write';
  READ = 'read';
  PROGRAM = 'program';
  END = 'end';
  TRUE = 'true';
  FALSE = 'false';
  INT = 'int';
  
  UNARY_MINUS;
  ARRAY_ACCESS;
  VARIABLE;
  CONSTANT;
  BOOL_CONSTANT;
  NOT_EXPRESSION;
  DECLARE_VARIABLE;
  DECLARE_ARRAY;
  ASSIGNMENT_VARIABLE;
  ASSIGNMENT_ARRAY;
  READ_VARIABLE;
  READ_ARRAY;
  WRITE_EXPRESSION;
  IF_STATEMENT;
  BLOCK_STATEMENT;
  BLOCK_DECLARATION;
  WHILE_STATEMENT;
  SKIP_STATEMENT;
  THEPROGRAM;
}

@header {
package thelang;
}

@lexer::header {
package thelang;

}

aexpr : aexpr1 ((PLUS | MINUS)^ aexpr1)* ;

aexpr1 : aexpr2 ((MUL | DIV)^ aexpr2)* ;

aexpr2 : MINUS aexpr3 -> ^(UNARY_MINUS aexpr3)
       | aexpr3
       ;

aexpr3 : IDENTIFIER                         -> ^(VARIABLE IDENTIFIER)
	   | IDENTIFIER LBRACKET aexpr RBRACKET -> ^(ARRAY_ACCESS ^(VARIABLE IDENTIFIER) aexpr)
       | INTEGER                            -> ^(CONSTANT INTEGER)
       | LPAREN aexpr RPAREN                -> aexpr
       ;

bexpr : bexpr1 (OR^ bexpr1)*
      ;

bexpr1 : bexpr2 (AND^ bexpr2)*
       ;

bexpr2 : aexpr opr^ aexpr
       | NOT bexpr -> ^(NOT_EXPRESSION bexpr)
       | TRUE -> ^(BOOL_CONSTANT TRUE)
       | FALSE -> ^(BOOL_CONSTANT FALSE)
       | LPAREN bexpr RPAREN -> bexpr
       ;

opr : GT
    | GE
    | LT
    | LE
    | EQ
    | NEQ
    ;

decl : INT IDENTIFIER SEMI -> ^(DECLARE_VARIABLE ^(VARIABLE IDENTIFIER))
	 | INT IDENTIFIER LBRACKET INTEGER RBRACKET SEMI -> ^(DECLARE_ARRAY ^(VARIABLE IDENTIFIER) ^(CONSTANT INTEGER));

stmts : stmt+ ;

stmt : assignStmt
     | skipStmt
     | readStmt
     | writeStmt
     | ifStmt
     | whileStmt
     ;

assignStmt : IDENTIFIER ASSIGN aexpr SEMI -> ^(ASSIGNMENT_VARIABLE ^(VARIABLE IDENTIFIER) aexpr)
	       | IDENTIFIER LBRACKET aexpr RBRACKET ASSIGN aexpr SEMI -> ^(ASSIGNMENT_ARRAY ^(VARIABLE IDENTIFIER) aexpr aexpr);

skipStmt : SKIP SEMI -> SKIP_STATEMENT;

readStmt : READ IDENTIFIER SEMI -> ^(READ_VARIABLE ^(VARIABLE IDENTIFIER))
		 | READ IDENTIFIER LBRACKET aexpr RBRACKET SEMI -> ^(READ_ARRAY ^(VARIABLE IDENTIFIER) aexpr);

writeStmt : WRITE aexpr SEMI -> ^(WRITE_EXPRESSION aexpr);

ifStmt : IF bexpr THEN stmts ELSE stmts FI -> ^(IF_STATEMENT bexpr ^(BLOCK_STATEMENT stmts) ^(BLOCK_STATEMENT stmts));

whileStmt : WHILE bexpr DO stmts OD -> ^(WHILE_STATEMENT bexpr ^(BLOCK_STATEMENT stmts));

program : PROGRAM decl* stmts END -> ^(THEPROGRAM ^(BLOCK_DECLARATION decl*) ^(BLOCK_STATEMENT stmts));


COMMENT : '(*' (options {greedy=false;} : .)* '*)' {$channel=HIDDEN;}
     ;

INTEGER : ('0' | '1'..'9' '0'..'9'*);

IDENTIFIER : LETTER (LETTER|'0'..'9')* ;

fragment
LETTER : 'A'..'Z'
       | 'a'..'z'
       | '_'
       ;

WS : (' '|'\r'|'\t'|'\u000C'|'\n') { skip(); } ;
