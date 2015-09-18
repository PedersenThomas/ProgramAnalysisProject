tree grammar TheLangWalker;

options {
	tokenVocab=TheLang;
  	ASTLabelType = CommonTree;
}

@header {
package thelang;

import ast.*;
import java.util.*;
}


program returns [Program value]
	: ^(THEPROGRAM BLOCK_DECLARATION ^(BLOCK_STATEMENT s=stmts)) { $value = new Program(null, s); }
	;	

stmts returns [List<Statement> value]
	@init
    {
    	$value = new ArrayList<Statement>();
    }
	: (s=stmt { $value.add(s); } )+
	;

stmt returns [Statement value]
	: s=skipStmt { $value = s; }
    ;

skipStmt returns [SkipStatement value]
	: SKIP_STATEMENT { $value = new SkipStatement(); };
	