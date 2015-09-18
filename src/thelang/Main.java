package thelang;

import java.util.ArrayList;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import ast.AstBuilder;
import ast.Program;
import thelang.TheLangParser.program_return;

public class Main {

  public static void main(String args[]) throws Exception {
    TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
    CommonTokenStream tokens = new CommonTokenStream(lex);
    TheLangParser parser = new TheLangParser(tokens);

    try {
      program_return parserResult = parser.program();
      System.out.println(parserResult);
      if (parserResult != null) {
    	  
        CommonTree tree = (CommonTree) parserResult.tree;
        System.out.println(tree.toStringTree());
        
        System.out.println("-----------------------------------------");
        
        printTree(tree, 0);
        
        Program theProgram = AstBuilder.build(tree);
        System.out.println(theProgram);
      }
    } catch (RecognitionException e) {
      e.printStackTrace();
    }
  }
  
  public static void printTree(CommonTree tree, int indentCount) {
	  String indent = repeat(indentCount, " ");
	  System.out.println(indent + tree + " #" + tree.getType());

      ArrayList<CommonTree> children = (ArrayList) tree.getChildren();
      if(children != null) {
    	  for(CommonTree node: children) {
    		  printTree(node, indentCount + 5);
  		}
      }
  }
  
  public static String repeat(int count, String txt) {
	  String result = "";
	  for(int i = 0; i < count; i++) {
		  result += txt;
	  }
	  return result;
	  
  }
}
