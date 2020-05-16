package seed.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyNode {
	public int distanceTo;
	public List<MyEdge> edges = new LinkedList<>();
	public String name;
	public MyNode predecessor;
	public boolean visited = false;

	public MyNode(String name) {
		this.name = name;
	}

	public void addEdges(MyEdge... edges) {
		this.edges.addAll(Arrays.asList(edges));
	}

	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyNode other = (MyNode) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}