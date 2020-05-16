package seed;

import seed.algorithms.DFSArrayAlgorithm;
import seed.algorithms.MyEdge;
import seed.algorithms.MyNode;

// This demo in no way resembles the final desired output or design.
// It just shows how to use shortest path algorithms in general.
// Consult your peer's design to see what to do instead.
public class BasicDemo {
	public static void main(String[] args) {
		DFSArrayAlgorithm shortestPathAlgorithm = new DFSArrayAlgorithm();
		
		long startTime = System.nanoTime();
		// WARNING: ALGORITHMS MAY MODIFY THE GRAPH.
		// You MUST use a newly instantiated graph instance between executions,
		// or you will eventually be very, very sad and confused due to "obscure pointer issues."
		int[] predecessors = shortestPathAlgorithm.run(buildWikipediaArrayGraph());
		long endTime = System.nanoTime();
		
		System.out.println("DFS with 2D Array took "+(endTime-startTime) +"ns on Wikipedia graph");
		PrintingUtilities.printShortestPathTo(predecessors.length-1, predecessors);
	}
	
	static int[][] buildWikipediaArrayGraph(){
		return new int[][] {
			{ Constants.INFINITY, 4, 2, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, 5, 10, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 3, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 11 },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 4, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY } };
	}
	
	static MyNode[] buildWikipediaListGraph() {
		MyNode[] nodes;
		MyNode nA = new MyNode("A");
		MyNode nB = new MyNode("B");
		MyNode nC = new MyNode("C");
		MyNode nD = new MyNode("D");
		MyNode nE = new MyNode("E");
		MyNode nF = new MyNode("F");
		MyEdge ab = new MyEdge(nA, nB, 4);
		MyEdge ac = new MyEdge(nA, nC, 2);
		MyEdge bc = new MyEdge(nB, nC, 5);
		MyEdge bd = new MyEdge(nB, nD, 10);
		MyEdge ce = new MyEdge(nC, nE, 3);
		MyEdge ed = new MyEdge(nE, nD, 4);
		MyEdge df = new MyEdge(nD, nF, 11);
		nA.addEdges(ab, ac);
		nB.addEdges(bc);
		nB.addEdges(bd);
		nC.addEdges(ce);
		nD.addEdges(df);
		nE.addEdges(ed);
		nodes = new MyNode[] { nA, nB, nC, nD, nE, nF };
		for (MyNode node : nodes) {
			node.distanceTo = Constants.INFINITY;
		}
		nodes[0].distanceTo = 0;
		
		return nodes;
	}
}
