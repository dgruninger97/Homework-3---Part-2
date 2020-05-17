package seed.algorithms;

public abstract class ShortestPathAlgorithm {

	String name;
	int timeComplexity;
	
	abstract long findShortestPath(Graph g);
	
}
