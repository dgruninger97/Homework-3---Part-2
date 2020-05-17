package seed.algorithms;

import seed.Constants;

public class Graph {
	int[][] buildWikipediaArrayGraph(){
		return new int[][] {
			{ Constants.INFINITY, 4, 2, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, 5, 10, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 3, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 11 },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, 4, Constants.INFINITY, Constants.INFINITY },
			{ Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY, Constants.INFINITY } };
	}
	
	MyNode[] buildWikipediaListGraph() {
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
