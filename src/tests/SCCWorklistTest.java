package tests;

import ast.AstBuilder;
import ast.Program;
import frameworks.ILatticeValue;
import frameworks.MonotoneFramework;
import frameworks.WorklistAlgorithm;
import frameworks.detectionOfSigns.DetectionOfSigns;
import frameworks.reachingDefinitions.ReachingDefinitions;
import frameworks.worklists.FIFOWorklist;
import frameworks.worklists.LIFOWorklist;
import frameworks.worklists.SCCWorklist;
import frameworks.worklists.SetWorklist;
import graph.FlowGraph;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import thelang.TheLangLexer;
import thelang.TheLangParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.ListIterator;

import static org.junit.Assert.*;

/**
 * Created by PatrickKasting on 27/11/15.
 */
public class SCCWorklistTest {

    @Test
    public void testSCCWorklist() throws IOException, RecognitionException {

        List<File> allPrograms = new ArrayList<File>();
        File programsDirectory = new File("examples");

        assertTrue(programsDirectory.isDirectory());

        getAllPrograms(programsDirectory, allPrograms);

        for (File program : allPrograms) {
            System.out.println(program);

            TheLangLexer lex = new TheLangLexer(new ANTLRFileStream(program.getAbsolutePath()));
            CommonTokenStream tokens = new CommonTokenStream(lex);
            TheLangParser parser = new TheLangParser(tokens);

            TheLangParser.program_return parserResult = parser.program();
            CommonTree tree = parserResult.tree;
            Program theProgram = AstBuilder.build(tree);
            FlowGraph flowGraph = new FlowGraph(theProgram);

            MonotoneFramework reachingDefinitions = new ReachingDefinitions(flowGraph);
            reachingDefinitions.initialize();
            MonotoneFramework detectionOfSigns = new DetectionOfSigns(flowGraph);
            detectionOfSigns.initialize();

            SetWorklist RDSetWorklist = new SetWorklist();
            SetWorklist DSSetWorklist = new SetWorklist();
            FIFOWorklist RDFIFOWorklist = new FIFOWorklist();
            FIFOWorklist DSFIFOWorklist = new FIFOWorklist();
            LIFOWorklist RDLIFOWorklist = new LIFOWorklist();
            LIFOWorklist DSLIFOWorkList = new LIFOWorklist();
            SCCWorklist RDSCCWorklist =
                    new SCCWorklist(reachingDefinitions.getConstraints(),
                            reachingDefinitions.getInfluenceList());
            SCCWorklist DSSCCWorklist =
                    new SCCWorklist(detectionOfSigns.getConstraints(),
                            detectionOfSigns.getInfluenceList());

            WorklistAlgorithm RDSetAlgorithm = new WorklistAlgorithm(RDSetWorklist, reachingDefinitions);
            WorklistAlgorithm DSSetAlgorithm = new WorklistAlgorithm(DSSetWorklist, detectionOfSigns);
            WorklistAlgorithm RDFIFOAlgorithm = new WorklistAlgorithm(RDFIFOWorklist, reachingDefinitions);
            WorklistAlgorithm DSFIFOAlgorithm = new WorklistAlgorithm(DSFIFOWorklist, detectionOfSigns);
            WorklistAlgorithm RDLIFOAlgorithm = new WorklistAlgorithm(RDLIFOWorklist, reachingDefinitions);
            WorklistAlgorithm DSLIFOAlgorithm = new WorklistAlgorithm(DSLIFOWorkList, detectionOfSigns);
            WorklistAlgorithm RDSCCAlgorithm = new WorklistAlgorithm(RDSCCWorklist, reachingDefinitions);
            WorklistAlgorithm DSSCCAlgorithm = new WorklistAlgorithm(DSSCCWorklist, detectionOfSigns);

            List<ILatticeValue> RDSetResult = RDSetAlgorithm.run();
            List<ILatticeValue> DSSetResult = DSSetAlgorithm.run();
            List<ILatticeValue> RDFIFOResult = RDFIFOAlgorithm.run();
            List<ILatticeValue> DSFIFOResult = DSFIFOAlgorithm.run();
            List<ILatticeValue> RDLIFOResult = RDLIFOAlgorithm.run();
            List<ILatticeValue> DSLIFOResult = DSLIFOAlgorithm.run();
            List<ILatticeValue> RDSCCResult = RDSCCAlgorithm.run();
            List<ILatticeValue> DSSCCResult = DSSCCAlgorithm.run();

            assertEquals(RDSetResult, RDFIFOResult);
            assertEquals(DSSetResult, DSFIFOResult);
            assertEquals(RDSetResult, RDLIFOResult);
            assertEquals(DSSetResult, DSLIFOResult);
            assertEquals(RDSetResult, RDSCCResult);
            assertEquals(DSSetResult, DSSCCResult);

        }

    }

    private void getAllPrograms(File file, List<File> programs) {
        if (file.isFile() && !file.isHidden()) {
            programs.add(file);
        } else if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                getAllPrograms(subFile, programs);
            }
        }
    }

}
