package thelang;

import java.util.ArrayList;

import frameworks.reachingDefinitions.ReachingDefinitions;
import org.antlr.runtime.tree.*;

import ast.ILabelable;
import frameworks.ILatticeValue;
import frameworks.IWorklist;
import frameworks.worklists.SetWorklist;
import frameworks.WorklistAlgorithm;
import graph.FlowGraph;
import graph.FlowGraphEdge;

public class Main {

	public static void main(String args[]) throws Exception {

		ReachingDefinitions RD = new ReachingDefinitions(null);
		IWorklist worklist = new SetWorklist();
		WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm(worklist, RD);
		ArrayList<ILatticeValue> result = worklistAlgorithm.Run();
		System.out.println("Final values:");
		System.out.println(result);

		/*
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

				System.out.println("////////////// Detection of Signs ////////////////////////////");
				IMonotoneFramework dsFramework = new DSMonotoneFramework(graph);
				IWorklist worklist = new SetWorklist();
				WorklistAlgorithm algo = new WorklistAlgorithm(worklist, dsFramework);
				List<ILatticeValue> result = algo.Run();
				for (ILatticeValue value : result) {
					System.out.println(value);
				}

			}
		} catch (RecognitionException e) {
			e.printStackTrace();
		}
		*/
	}

	public static void printGraphInfo(FlowGraph graph) {
		System.out.println("////////////// Labels ////////////////////////////");
		for (Integer key : graph.getLabelMapping().keySet()) {
			ILabelable value = graph.getLabelMapping().get(key);
			System.out.println(key + " ---> " + value);
		}

		System.out.println("////////////// Flow ////////////////////////////");
		for (FlowGraphEdge node : graph.getFlowEdges()) {
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
