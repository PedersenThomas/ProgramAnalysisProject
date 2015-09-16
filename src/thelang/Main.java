package thelang;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import ast.*;

public class Main {

  public static void main(String args[]) throws Exception {
    TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
    CommonTokenStream tokens = new CommonTokenStream(lex);
    TheLangParser parser = new TheLangParser(tokens);

    try {
      Program parserResult = parser.program();
      System.out.println(parserResult);
      if (parserResult != null) {
    	  
        //CommonTree tree = (CommonTree) parserResult.tree;
        //System.out.println(tree.toStringTree());
      }
    } catch (RecognitionException e) {
      e.printStackTrace();
    }
  }
}
