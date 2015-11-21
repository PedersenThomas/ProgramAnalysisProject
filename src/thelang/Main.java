package thelang;

import java.util.*;

import ast.*;
import frameworks.IWorklist;
import frameworks.detectionOfSigns.*;
import frameworks.reachingDefinitions.RDLatticeValue;
import frameworks.reachingDefinitions.ReachingDefinitions;

import graph.Variable;
import graph.VariableType;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.*;

import frameworks.ILatticeValue;
import frameworks.worklists.*;
import frameworks.WorklistAlgorithm;
import graph.FlowGraph;

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
            
            //RunReachingDefinitions(graph);
            runDetectionOfSigns(graph);

            //testArithmeticExpressions(theProgram);
            //testBooleanExpressions(theProgram);
            //testAtom();

            /*
            System.out.println("////////////// Detection of Signs ////////////////////////////");
            IMonotoneFramework dsFramework = new DetectionOfSigns(null);
            IWorklist workList = new SetWorklist();
            WorklistAlgorithm algorithm = new WorklistAlgorithm(workList, dsFramework);
            List<ILatticeValue> result = algorithm.run();
            for (ILatticeValue value : result) {
                System.out.println(value);
            }
            */
        }
	}

    private static void runDetectionOfSigns(FlowGraph flowGraph) {
        DetectionOfSigns DS = new DetectionOfSigns(flowGraph);
        IWorklist worklist = new SetWorklist();
        WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm(worklist, DS);
        List<ILatticeValue> result = worklistAlgorithm.run();
        System.out.println(worklistAlgorithm);
    }

    public static void testArithmeticExpressions(Program theProgram) {
        System.out.println("!#€%&/()=?` TEST OF ARITHMETIC EXPRESSIONS! !#€%&/()=?`");
        ArithmeticExpression expression = ((WriteStatement) theProgram.statements.get(0)).getExpression();
        System.out.println(expression);

        HashMap<Variable, PowerSetOfSigns> signState = new HashMap<>();
        signState.put(new Variable("A", VariableType.Array), new PowerSetOfSigns(Signs.zero));
        signState.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(Signs.negative));

        System.out.println(Util.evalDSArithmeticExpression(expression, signState));
    }

    public static void testBooleanExpressions(Program theProgram) {
        System.out.println("!#€%&/()=?` TEST OF BOOLEAN EXPRESSIONS! !#€%&/()=?`");
        BooleanExpression expression = ((IfStatement) theProgram.statements.get(0)).getCondition();
        System.out.println("The expression:");
        System.out.println(expression);

        HashMap<Variable, PowerSetOfSigns> signState = new HashMap<>();
        signState.put(new Variable("A", VariableType.Array), new PowerSetOfSigns(Signs.zero));
        signState.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(Signs.negative));
        signState.put(new Variable("b", VariableType.Variable), new PowerSetOfSigns(Signs.positive));

        System.out.println(Util.evalDSBooleanExpression(expression, signState));
    }

    /*
    public static void RunReachingDefinitions(FlowGraph flowgraph) {
    	ReachingDefinitions RD = new ReachingDefinitions(flowgraph);
		IWorklist workList = new RevPostOrderWorkList(flowgraph, RD);
		workList = new SetWorklist();
		WorklistAlgorithm workListAlgorithm = new WorklistAlgorithm(workList, RD);
		ArrayList<ILatticeValue> result = workListAlgorithm.run();
		
		System.out.println("Worklist Stats. Inserts: " + workList.getNumberOfInsertions() + " Extracts: " + workList.getNumberOfExtracts());
		System.out.println("Final values:");
	    for (int i = 0; i < result.size(); i++) {
	    	StringBuilder buffer = new StringBuilder();
	    	buffer.append("Variable " + i + ": {");
	    	BitSet value = ((RDLatticeValue) result.get(i)).getBitSet();
	    	for (int bitIndex = value.nextSetBit(0); bitIndex != -1; bitIndex = value.nextSetBit(bitIndex + 1)) {
	    	    buffer.append("(" + RD.getAssignmentTable().get(bitIndex).toString() + "), ");
	    	}
	    	buffer.append("}");
	    	//System.out.println(buffer);
	    	
	    }
	    
	    for (int label = -1; label <= flowgraph.getLabelMapping().size(); label++) {
			//List<Integer> constraints = RD.LabelMapToConstraints(label);
			String tokenText = "" + flowgraph.getLabelMapping().get(label);
			ILabelable astObj = flowgraph.getLabelMapping().get(label);
			if (astObj != null && astObj instanceof WhileStatement) {
				WhileStatement ast = (WhileStatement)astObj;
				tokenText = "While " + ast.getCondition() + " do";
			} else if (astObj != null && astObj instanceof IfStatement) {
				IfStatement ast = (IfStatement)astObj;
				tokenText = "If " + ast.getCondition() + " then";
			}
			//System.out.println("Label: " + label + " Constraints: " + constraints + " Token: " + tokenText);
		}
	}
	*/

    public static void testAtom() {
        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.negative);
        signs1.add(Signs.zero);

        Set<Signs> signs2 = new HashSet<>();
        signs2.add(Signs.positive);

        Set<Signs> signs3 = new HashSet<>();
        signs3.add(Signs.negative);
        signs3.add(Signs.zero);
        signs3.add(Signs.positive);

        HashMap<Variable, PowerSetOfSigns> signState = new HashMap<>();
        signState.put(new Variable("a", VariableType.Variable), new PowerSetOfSigns(signs1));
        signState.put(new Variable("b", VariableType.Array), new PowerSetOfSigns(signs3));
        signState.put(new Variable("c", VariableType.Variable), new PowerSetOfSigns(signs3));

        Set<Map<Variable, PowerSetOfSigns>> atoms = Util.atom(signState);

        System.out.println("TEST OF ATOM:");
        System.out.println(atoms);
        System.out.println(atoms.size());
    }

}
