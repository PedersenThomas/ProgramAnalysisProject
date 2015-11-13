package thelang;

import java.util.*;

import ast.AstBuilder;
import ast.Program;
import frameworks.IMonotoneFramework;
import frameworks.IWorklist;
import frameworks.detectionOfSigns.DetectionOfSigns;
import frameworks.reachingDefinitions.ReachingDefinitions;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.*;

import ast.ILabelable;
import frameworks.ILatticeValue;
import frameworks.worklists.SetWorklist;
import frameworks.WorklistAlgorithm;
import graph.FlowGraph;
import graph.FlowGraphEdge;

public class Main {

	public static void main(String args[]) throws Exception {

		ReachingDefinitions RD = new ReachingDefinitions(null);
		IWorklist workList = new SetWorklist();
		WorklistAlgorithm workListAlgorithm = new WorklistAlgorithm(workList, RD);
		ArrayList<ILatticeValue> result = workListAlgorithm.Run();
		System.out.println("Final values:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Variable " + i + ": " + result.get(i));
        }

        /*
		TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		TheLangParser parser = new TheLangParser(tokens);

        TheLangParser.program_return parserResult = parser.program();
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
            IMonotoneFramework dsFramework = new DetectionOfSigns(null);
            IWorkList workList = new SetWorkList();
            WorkListAlgorithm algorithm = new WorkListAlgorithm(workList, dsFramework);
            List<ILatticeValue> result = algorithm.Run();
            for (ILatticeValue value : result) {
                System.out.println(value);
            }

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
