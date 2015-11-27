package thelang;

import java.io.File;
import java.util.*;
import ast.*;
import frameworks.IWorklist;
import frameworks.MonotoneFramework;
import frameworks.detectionOfSigns.*;
import frameworks.reachingDefinitions.ReachingDefinitions;

import graph.Variable;
import graph.VariableType;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.*;

import frameworks.worklists.*;
import frameworks.WorklistAlgorithm;
import graph.FlowGraph;

public class Main {

	public static void main(String args[]) throws Exception {

        if (args.length < 2 || 3 < args.length) {
            System.out.println("Wrong number of arguments.");
            System.out.println("Usage: java -jar analysis.jar <file> RD/DS [set/FIFO/LIFO/SCC]");
            return;
        }

        String path = args[0];
        File file = new File(path);
        if(!file.exists() || file.isDirectory()) {
            System.out.println("The file does not exist.");
            return;
        }

        String MF = args[1];
        if (!(MF.equals("RD") || MF.equals("DS"))) {
            System.out.println("Unknown type of Monotone Framework.");
            System.out.println("The possible frameworks are:");
            System.out.println("* RD: Reaching Definitions");
            System.out.println("* DS: Detection of Signs");
            return;
        }

        String W = "SCC";
        if (args.length == 3) {
            W = args[2];
            if (!(W.equals("set") || W.equals("FIFO")
                    || W.equals("LIFO") || W.equals("SCC"))) {
                System.out.println("Unknown type of worklist.");
                System.out.println("The possible worklists are:");
                System.out.println("* set: Mathematical set");
                System.out.println("* FIFO: Queue");
                System.out.println("* LIFO: Stack");
                System.out.println("* SCC: Strongly Connected Components worklist (default)");
                return;
            }
        }

        try {

            TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(path));
            CommonTokenStream tokens = new CommonTokenStream(lex);
            TheLangParser parser = new TheLangParser(tokens);

            TheLangParser.program_return parserResult = parser.program();
            if (parserResult != null) {
                CommonTree tree = parserResult.tree;
                Program theProgram = AstBuilder.build(tree);
                FlowGraph flowGraph = new FlowGraph(theProgram);

                MonotoneFramework framework;
                switch (MF) {
                    case "RD":
                        framework = new ReachingDefinitions(flowGraph);
                        break;
                    case "DS":
                        framework = new DetectionOfSigns(flowGraph);
                        break;
                    default:
                        throw new Exception("Unknown framework.");
                }
                framework.initialize();

                IWorklist worklist;
                switch (W) {
                    case "set":
                        worklist = new SetWorklist();
                        break;
                    case "FIFO":
                        worklist = new FIFOWorklist();
                        break;
                    case "LIFO":
                        worklist = new LIFOWorklist();
                        break;
                    case "SCC":
                        worklist = new SCCWorklist(
                                framework.getConstraints(),
                                framework.getInfluenceList());
                        break;
                    default:
                        throw new Exception("Unknown worklist.");
                }

                WorklistAlgorithm worklistAlgorithm =
                        new WorklistAlgorithm(worklist, framework);
                worklistAlgorithm.run();
                System.out.println(worklistAlgorithm);

            } else {
                throw new Exception("Something went wrong with the parsing.");
            }

        } catch (Throwable e) {
            System.out.println("The following error occurred:");
            System.out.println(e.getMessage());;
        }

	}

    private static void runDetectionOfSigns(FlowGraph flowGraph) {
        DetectionOfSigns DS = new DetectionOfSigns(flowGraph);
        DS.initialize();
        IWorklist worklist = new SCCWorklist(DS.getConstraints(), DS.getInfluenceList());
        WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm(worklist, DS);
        worklistAlgorithm.run();
        System.out.println(worklistAlgorithm);
        /*
        int[] order = worklist.getOrder();
        System.out.println(ArrayUtils.toString(order));
        List<IConstraint> constraints = DS.getConstraints();
        for (int i = 0; i < order.length; i++) {
            int j;
            for (j = 0; j < order.length; j++) {
                if (i == order[j]) {
                    break;
                }
            }
            System.out.println("" + j + " " + constraints.get(j));
        }
        */
    }

    public static void testArithmeticExpressions(Program theProgram) {
        System.out.println("!#€%&/()=?` TEST OF ARITHMETIC EXPRESSIONS! !#€%&/()=?`");
        ArithmeticExpression expression = ((WriteStatement) theProgram.statements.get(0)).getExpression();
        System.out.println(expression);

        HashMap<Variable, SetOfSigns> signState = new HashMap<Variable, SetOfSigns>();
        signState.put(new Variable("A", VariableType.Array), new SetOfSigns(Signs.zero));
        signState.put(new Variable("a", VariableType.Variable), new SetOfSigns(Signs.negative));

        System.out.println(Util.evalDSArithmeticExpression(expression, signState));
    }

    public static void testBooleanExpressions(Program theProgram) {
        System.out.println("!#€%&/()=?` TEST OF BOOLEAN EXPRESSIONS! !#€%&/()=?`");
        BooleanExpression expression = ((IfStatement) theProgram.statements.get(0)).getCondition();
        System.out.println("The expression:");
        System.out.println(expression);

        HashMap<Variable, SetOfSigns> signState = new HashMap<Variable, SetOfSigns>();
        signState.put(new Variable("A", VariableType.Array), new SetOfSigns(Signs.zero));
        signState.put(new Variable("a", VariableType.Variable), new SetOfSigns(Signs.negative));
        signState.put(new Variable("b", VariableType.Variable), new SetOfSigns(Signs.positive));

        System.out.println(Util.evalDSBooleanExpression(expression, signState));
    }

    public static void RunReachingDefinitions(FlowGraph flowGraph) {
        ReachingDefinitions RD = new ReachingDefinitions(flowGraph);
        RD.initialize();
        IWorklist worklist = new LIFOWorklist();
        WorklistAlgorithm worklistAlgorithm = new WorklistAlgorithm(worklist, RD);
        worklistAlgorithm.run();
        System.out.println(worklistAlgorithm);

        /*
        System.out.println("Worklist Stats. Inserts: " + workList.getNumberOfInsertions() + " Extracts: " + workList.getNumberOfExtractions());
		System.out.println("Final values:");
	    for (int i = 0; i < result.size(); i++) {
	    	StringBuilder buffer = new StringBuilder();
	    	buffer.append("Variable " + i + ": {");
	    	BitSet value = ((RDLatticeValue) result.get(i)).getBitSet();
	    	for (int bitIndex = value.nextSetBit(0); bitIndex != -1; bitIndex = value.nextSetBit(bitIndex + 1)) {
	    	    buffer.append("(" + RD.constructAssignmentTable().get(bitIndex).toString() + "), ");
	    	}
	    	buffer.append("}");
	    	//System.out.println(buffer);
	    	
	    }
	    
	    for (int label = -1; label <= flowgraph.getLabelMap().size(); label++) {
			//List<Integer> constraints = RD.LabelMapToConstraints(label);
			String tokenText = "" + flowgraph.getLabelMap().get(label);
			ILabelable astObj = flowgraph.getLabelMap().get(label);
			if (astObj != null && astObj instanceof WhileStatement) {
				WhileStatement ast = (WhileStatement)astObj;
				tokenText = "While " + ast.getCondition() + " do";
			} else if (astObj != null && astObj instanceof IfStatement) {
				IfStatement ast = (IfStatement)astObj;
				tokenText = "If " + ast.getCondition() + " then";
			}
			//System.out.println("Label: " + label + " Constraints: " + constraints + " Token: " + tokenText);
		}
		*/
	}

    public static void testAtom() {
        Set<Signs> signs1 = new HashSet<Signs>();
        signs1.add(Signs.negative);
        signs1.add(Signs.zero);

        Set<Signs> signs2 = new HashSet<Signs>();
        signs2.add(Signs.positive);

        Set<Signs> signs3 = new HashSet<Signs>();
        signs3.add(Signs.negative);
        signs3.add(Signs.zero);
        signs3.add(Signs.positive);

        HashMap<Variable, SetOfSigns> signState = new HashMap<Variable, SetOfSigns>();
        signState.put(new Variable("a", VariableType.Variable), new SetOfSigns(signs1));
        signState.put(new Variable("b", VariableType.Array), new SetOfSigns(signs3));
        signState.put(new Variable("c", VariableType.Variable), new SetOfSigns(signs3));

        Set<Map<Variable, SetOfSigns>> atoms = Util.atom(signState);

        System.out.println("TEST OF ATOM:");
        System.out.println(atoms);
        System.out.println(atoms.size());
    }

}
