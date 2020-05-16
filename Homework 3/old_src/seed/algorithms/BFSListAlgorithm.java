package seed.algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class BFSListAlgorithm implements ListAlgorithm {

	int nAlgorithmSteps = 0;

	@Override
	public int getSteps() {
		return nAlgorithmSteps;
	}

	@Override
	public void run(MyNode startNode) {
		nAlgorithmSteps = 0;

		Queue<MyNode> nextNearestNodes = new LinkedList<>();
		nextNearestNodes.add(startNode);

		while (!nextNearestNodes.isEmpty()) {
			nAlgorithmSteps++;
			MyNode current = nextNearestNodes.poll();
			if (current.visited) {
				continue;
			}
			current.visited = true;

			for (MyEdge e : current.edges) {
				nAlgorithmSteps++;
				if (!e.dest.visited && e.dest.predecessor == null) {
					nextNearestNodes.add(e.dest);
					e.dest.predecessor = current;
					int newDistance = current.distanceTo + 1;
					e.dest.distanceTo = newDistance;
				}
			}
		}
	}

	@Override
	public String getName() {
		return "BFS List";
	}

}
