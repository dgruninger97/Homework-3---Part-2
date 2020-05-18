package seed.algorithms;

import waybetter.ShortestPath;

public class ShortestPathAdapter extends ShortestPathAlgorithm{

	ShortestPath shortestPath;
	
	public void constructShortestPath(String[] inGraph, String startNode) {
		shortestPath = new ShortestPath(inGraph, startNode);
		this.name = "WayBetterShortestPath";
	}

	@Override
	long findShortestPath(Graph g) {
		long startTime = System.nanoTime();
		shortestPath.getPredecessors();
		long endTime = System.nanoTime();
		this.timeComplexity = endTime - startTime;
		return this.timeComplexity;
	}
}
