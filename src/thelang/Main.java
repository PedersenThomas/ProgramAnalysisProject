package thelang;

import java.util.*;

import ast.*;
import frameworks.IMonotoneFramework;
import frameworks.IWorklist;
import frameworks.detectionOfSigns.*;
import frameworks.reachingDefinitions.ReachingDefinitions;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.*;

import frameworks.ILatticeValue;
import frameworks.worklists.*;
import frameworks.WorklistAlgorithm;
import graph.FlowGraph;
import graph.FlowGraphEdge;

public class Main {

	public static void main(String args[]) throws Exception {
		
		TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(args[0]));
		CommonTokenStream tokens = new CommonTokenStream(lex);
		TheLangParser parser = new TheLangParser(tokens);

        TheLangParser.program_return parserResult = parser.program();
        if (parserResult != null) {
            CommonTree tree = parserResult.tree;
            Program theProgram = AstBuilder.build(tree);

            FlowGraph graph = new FlowGraph(theProgram);
            RunReachingDefinitions(graph);

            testAtom();

            /*
            System.out.println("////////////// Detection of Signs ////////////////////////////");
            IMonotoneFramework dsFramework = new DetectionOfSigns(null);
            IWorklist workList = new SetWorklist();
            WorklistAlgorithm algorithm = new WorklistAlgorithm(workList, dsFramework);
            List<ILatticeValue> result = algorithm.Run();
            for (ILatticeValue value : result) {
                System.out.println(value);
            }
            */

        }
	}

    public static void testArithmeticExpressions(Program theProgram) {
        System.out.println("!#€%&/()=?` TEST OF ARITHMETIC EXPRESSIONS! !#€%&/()=?`");
        ArithmeticExpression expression = ((WriteStatement) theProgram.statements.get(0)).getExpression();
        System.out.println(expression);
        HashMap<String, PowerSetOfSigns> signState = new HashMap<>();
        signState.put("A", new PowerSetOfSigns(Signs.zero));
        signState.put("a", new PowerSetOfSigns(Signs.negative));
        System.out.println(Util.evalDSArithmeticExpression(expression, signState));
    }

    public static void RunReachingDefinitions(FlowGraph flowgraph) {
		ReachingDefinitions RD = new ReachingDefinitions(flowgraph);
		IWorklist workList = new SetWorklist();
		WorklistAlgorithm workListAlgorithm = new WorklistAlgorithm(workList, RD);
		ArrayList<ILatticeValue> result = workListAlgorithm.Run();
		System.out.println("Final values:");
	    for (int i = 0; i < result.size(); i++) {
	    	System.out.println("Variable " + i + ": " + result.get(i));
	    }
	}

    public static void testAtom() {
        Set<Signs> signs1 = new HashSet<>();
        signs1.add(Signs.negative);
        signs1.add(Signs.zero);

        Set<Signs> signs2 = new HashSet<>();
        signs2.add(Signs.positive);

        Set<Signs> signs3 = new HashSet<>();
        signs3.add(Signs.negative);
        signs3.add(Signs.zero);
        signs3.add(Signs.positive);

        HashMap<String, PowerSetOfSigns> signState = new HashMap<>();
        signState.put("a", new PowerSetOfSigns(signs1));
        signState.put("b", new PowerSetOfSigns(signs2));
        signState.put("c", new PowerSetOfSigns(signs3));

        Set<Map<String, PowerSetOfSigns>> atoms = Util.atom(signState);

        System.out.println("TEST OF ATOM:");
        System.out.println(atoms);
        System.out.println(atoms.size());
    }

}
