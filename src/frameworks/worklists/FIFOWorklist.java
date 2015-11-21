package frameworks.worklists;

import frameworks.IWorklist;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by PatrickKasting on 21/11/15.
 */
public class FIFOWorklist implements IWorklist {

    Queue<Integer> queue;

    int insertions = 0;
    int extractions = 0;

    public FIFOWorklist() {
        queue = new LinkedList<>();
    }

    @Override
    public void insert(int index) {
        insertions++;
        queue.add(index);
    }

    @Override
    public int extract() {
        extractions++;
        return queue.remove();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public String getName() {
        return "FIFO Worklist";
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
        return "queue=" + this.queue + ", size=" + queue.size();
    }
}
