package thelang;

import java.util.ArrayList;

import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;

import ast.AstBuilder;
import ast.ILabelable;
import ast.Program;
import graph.FlowGraph;
import graph.FlowGraphNode;
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
				CommonTree tree = parserResult.tree;
				printTree(tree, 0);
				System.out.println("-----------------------------------------");

				Program theProgram = AstBuilder.build(tree);
				System.out.println(theProgram);

				FlowGraph graph = new FlowGraph(theProgram);
				
				printGraphInfo(graph);
			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
	}

	public static void printGraphInfo(FlowGraph graph) {
		System.out.println("////////////// Labels ////////////////////////////");
		for (ILabelable key : graph.getLabels().keySet()) {
			Integer value = graph.getLabels().get(key);
			System.out.println(value + " ---> " + key);
		}
		
		System.out.println("////////////// Flow ////////////////////////////");
		for (FlowGraphNode node : graph.getFlowNodes()) {
			System.out.println(node);
		}

		System.out.println("////////////// Free Variables ////////////////////////////");
		for (String variable : graph.getFreeVariables()) {
			System.out.println(variable);
		}
	}
	
	public static void printTree(CommonTree tree, int indentCount) {
		// TODO Remove this function!
		String indent = repeat(indentCount, " ");
		System.out.println(indent + tree + " #" + tree.getType());

		@SuppressWarnings("unchecked")
		ArrayList<CommonTree> children = (ArrayList<CommonTree>) tree.getChildren();
		if (children != null) {
			for (CommonTree node : children) {
				printTree(node, indentCount + 5);
			}
		}
	}

	public static String repeat(int count, String txt) {
		String result = "";
		for (int i = 0; i < count; i++) {
			result += txt;
		}
		return result;
	}
}
