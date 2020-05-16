package seed.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import seed.Constants;

public class DFSArrayAlgorithm implements ArrayAlgorithm {
	int nAlgorithmSteps = 0;
	
	@Override
	public int getSteps() {
		return nAlgorithmSteps;
	}

	@Override
	public int[] run(int[][] edgeWeight) {
		nAlgorithmSteps = 0;
	
		Deque<Integer> sortedList = new ArrayDeque<>();
		topologicalSort_array(0, edgeWeight, sortedList, new HashSet<Integer>());
	
		int[] predecessorOf = new int[edgeWeight.length];
		Arrays.fill(predecessorOf, -1);
	
		int[] distanceTo = new int[edgeWeight.length];
		Arrays.fill(distanceTo, Constants.INFINITY);
		distanceTo[0] = 0;
	
		for (Integer u : sortedList) {
			for (int i = 0; i < edgeWeight.length; i++) {
				nAlgorithmSteps++;
				if (edgeWeight[u][i] != Constants.INFINITY) {
					if (distanceTo[i] > distanceTo[u] + edgeWeight[u][i]) {
						distanceTo[i] = distanceTo[u] + edgeWeight[u][i];
						predecessorOf[i] = u;
					}
				}
			}
		}
	
		return predecessorOf;
	}

	private void topologicalSort_array(int current, int[][] array, Deque<Integer> output, Set<Integer> visited) {
		if (visited.contains(current)) {
			return;
		}
	
		for (int i = 0; i < array.length; i++) {
			nAlgorithmSteps++;
			if (array[current][i] != Constants.INFINITY) {
				topologicalSort_array(i, array, output, visited);
			}
		}
	
		visited.add(current);
		output.push(current);
	}

	@Override
	public String getName() {
		return "DFS Array";
	}
}
