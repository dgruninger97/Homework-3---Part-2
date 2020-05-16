package seed;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import seed.algorithms.MyNode;

public class PrintingUtilities {

	public static void printShortestPathTo(int lastNode, int[] pred) {
		Deque<Integer> reverse = new ArrayDeque<>();
		while (lastNode != -1) {
			reverse.offerFirst(lastNode);
			lastNode = pred[lastNode];
		}
		System.out.println(Arrays.asList(
				reverse.stream().map((a) -> (Character) Character.valueOf((char) (a.intValue() + 'A'))).toArray()));
	}

	public static void printShortestPathTo(MyNode lastNode) {
		Deque<MyNode> reverse = new ArrayDeque<>();
		while (lastNode != null) {
			reverse.offerFirst(lastNode);
			lastNode = lastNode.predecessor;
		}
		System.out.println(reverse);
	}

}
