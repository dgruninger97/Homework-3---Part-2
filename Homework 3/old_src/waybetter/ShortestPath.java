package waybetter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

// NOTE: DO NOT change this code.
// You will get NO CREDIT if you change this file in ANY way.
public class ShortestPath {
	private Map<String, Integer> nameToID;
	private Map<Integer, String> idToName;
	private Map<Integer, List<Integer[]>> edges;
	private int nextID = 0;

	public int nAlgorithmSteps;

	private String startNode;

	public ShortestPath(String[] ingraph, String startNode) {
		this.startNode = startNode;

		nameToID = new HashMap<>();
		idToName = new HashMap<>();

		edges = new HashMap<>();

		// parse graph
		for (String edge : ingraph) {
			String[] parts = edge.replaceAll("^(.) -> (.): (.*)$", "$1,$2,$3").split(",");
			String left = parts[0];
			String right = parts[1];
			int weight = Integer.valueOf(parts[2]);

			int leftId = getID(left);
			int rightId = getID(right);
			List<Integer[]> targets = edges.getOrDefault(leftId, new LinkedList<>());
			edges.put(leftId, targets);
			targets.add(new Integer[] { rightId, weight });
		}
	}

	public Map<String, String> getPredecessors() {
		nAlgorithmSteps = 0;

		int startID = nameToID.get(startNode);

		int[] distance = new int[nextID];
		Arrays.fill(distance, seed.Constants.INFINITY);
		distance[startID] = 0;

		int[] pred = new int[nextID];
		Arrays.fill(pred, -1);

		PriorityQueue<Integer> nextNearestNodes = new PriorityQueue<>(nextID, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(distance[o1], distance[o2]);
			}

		});

		nextNearestNodes.add(startID);

		Set<Integer> activelyQueued = new HashSet<>();
		Set<Integer> visited = new HashSet<>();

		while (!nextNearestNodes.isEmpty()) {
			nAlgorithmSteps++;
			Integer currentNode = nextNearestNodes.poll();
			if (visited.contains(currentNode)) {
				continue;
			}
			visited.add(currentNode);

			for (Integer[] e : edges.getOrDefault(currentNode, new LinkedList<Integer[]>())) {
				int destNode = e[0];
				int weight = e[1];
				nAlgorithmSteps++;
				int oldDistance = distance[destNode];
				int newDistance = distance[currentNode] + weight;
				if (newDistance < oldDistance) {
					if (activelyQueued.contains(destNode)) {
						nextNearestNodes.remove(destNode);
						nAlgorithmSteps += Math.log(nextID);
					}
					distance[destNode] = newDistance;
					pred[destNode] = currentNode;
					nextNearestNodes.add(destNode);
					nAlgorithmSteps += Math.log(nextID);
					activelyQueued.add(nextID);
				}
			}
		}

		Map<String, String> result = new HashMap<>();
		for (int i = 0; i < pred.length; i++) {
			if (pred[i] != -1) {
				result.put(idToName.get(i), idToName.get(pred[i]));
			}
		}
		return result;
	}

	private int getID(String nodeName) {
		if (!nameToID.containsKey(nodeName)) {
			int myID = nextID++;
			nameToID.put(nodeName, myID);
			idToName.put(myID, nodeName);
		}
		return nameToID.get(nodeName);
	}

}
