package seed.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import seed.Constants;

public class BFSArrayAlgorithm extends ShortestPathAlgorithm implements ArrayAlgorithm {

	int nAlgorithmSteps = 0;
	
	@Override
	public int getSteps() {
		return nAlgorithmSteps;
	}

	@Override
	public int[] run(int[][] edgeWeight) {
		nAlgorithmSteps = 0;

		boolean[] visited = new boolean[edgeWeight.length];
		Queue<Integer> nextNearestNodes = new LinkedList<>();

		int[] predecessorOf = new int[edgeWeight.length];
		Arrays.fill(predecessorOf, -1);
		nextNearestNodes.add(0);

		int[] distanceTo = new int[edgeWeight.length];
		Arrays.fill(distanceTo, Constants.INFINITY);
		distanceTo[0] = 0;

		while (!nextNearestNodes.isEmpty()) {
			nAlgorithmSteps++;
			Integer current = nextNearestNodes.poll();
			if (visited[current]) {
				continue;
			}
			visited[current] = true;
			for (int i = 0; i < edgeWeight.length; i++) {
				nAlgorithmSteps++;
				if (edgeWeight[current][i] != Constants.INFINITY && !visited[i] && predecessorOf[i] == -1) {
					nextNearestNodes.add(i);
					predecessorOf[i] = current;
					int newDistance = distanceTo[current] + 1;
					distanceTo[i] = newDistance;
				}
			}
		}

		return predecessorOf;

	}
	
	public String getName() {
		this.name = "BFS Array";
		return name;
	}

	@Override
	long findShortestPath(Graph g) {
		long startTime = System.nanoTime();
		run(g.buildWikipediaArrayGraph());
		long endTime = System.nanoTime();
		timeComplexity = endTime - startTime;
		return timeComplexity;
	}

}
