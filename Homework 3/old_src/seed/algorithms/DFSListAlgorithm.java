package seed.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSListAlgorithm extends ShortestPathAlgorithm implements ListAlgorithm {

	int nAlgorithmSteps = 0;
	
	@Override
	public int getSteps() {
		return nAlgorithmSteps;
	}

	@Override
	public void run(MyNode startNode) {
		nAlgorithmSteps = 0;

		Deque<MyNode> nodesByDistance = new ArrayDeque<>();
		topologicalSort_list(startNode, nodesByDistance);

		for (MyNode nextClosestNode : nodesByDistance) {
			for (MyEdge e : nextClosestNode.edges) {
				MyNode edgeDestination = e.dest;
				nAlgorithmSteps++;
				if (edgeDestination.distanceTo > nextClosestNode.distanceTo + e.weight) {
					edgeDestination.distanceTo = nextClosestNode.distanceTo + e.weight;
					edgeDestination.predecessor = nextClosestNode;
				}
			}
		}
	}

	private void topologicalSort_list(MyNode current, Deque<MyNode> output) {
		if (current.visited) {
			return;
		}
	
		for (MyEdge e : current.edges) {
			nAlgorithmSteps++;
			topologicalSort_list(e.dest, output);
		}
	
		current.visited = true;
		output.push(current);
	}

	@Override
	public String getName() {
		this.name = "DFS List";
		return this.name;
	}

	@Override
	long findShortestPath(Graph g) {
		long startTime = System.nanoTime();
		run(g.buildWikipediaListGraph()); //wont function here
		long endTime = System.nanoTime();
		timeComplexity = endTime - startTime;
		return timeComplexity;
	}

}
