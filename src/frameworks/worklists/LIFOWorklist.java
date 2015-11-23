package frameworks.worklists;

import frameworks.IWorklist;

import java.util.Stack;

/**
 * Created by PatrickKasting on 21/11/15.
 */
public class LIFOWorklist implements IWorklist {

    Stack<Integer> stack;

    int insertions = 0;
    int extractions = 0;

    public LIFOWorklist() {
        this.stack = new Stack<Integer>();
    }

    @Override
    public void insert(int index) {
        insertions++;
        stack.push(index);
    }

    @Override
    public int extract() {
        extractions++;
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String getName() {
        return "LIFO Worklist";
    }

    @Override
    public int getNumberOfInsertions() {
        return this.insertions;
    }

    @Override
    public int getNumberOfExtractions() {
        return this.extractions;
    }

    @Override
    public String toString() {
        return "stack=" + this.stack + ", size=" + stack.size();
    }
}
