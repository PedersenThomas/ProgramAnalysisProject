package thelang;

import java.io.File;
import ast.*;
import frameworks.IWorklist;
import frameworks.MonotoneFramework;
import frameworks.detectionOfSigns.*;
import frameworks.reachingDefinitions.ReachingDefinitions;

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
}
