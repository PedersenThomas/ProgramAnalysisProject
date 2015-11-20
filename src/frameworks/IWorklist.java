package frameworks;

public interface IWorklist {
	void insert(int index);
	int extract();
	boolean isEmpty();
	
	int getNumberOfInserts();
	int getNumberOfExtracts();
}
