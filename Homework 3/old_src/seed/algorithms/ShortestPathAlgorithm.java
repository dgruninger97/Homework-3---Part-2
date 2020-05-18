package seed.algorithms;

public abstract class ShortestPathAlgorithm {

	String name;
	long timeComplexity;
	
	abstract long findShortestPath(Graph g);
	
}
