package frameworks;

public interface IWorklist {
	void insert(int index);
	int extract();
	boolean isEmpty();
	String getName();
	
	int getNumberOfInsertions();
	int getNumberOfExtractions();
}
