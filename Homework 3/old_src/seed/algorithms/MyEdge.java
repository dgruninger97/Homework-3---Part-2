package seed.algorithms;

public class MyEdge {
	public MyNode source;
	public MyNode dest;
	public int weight;

	public MyEdge(MyNode source, MyNode dest, int weight) {
		this.source = source;
		this.dest = dest;
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		result = prime * result + weight;
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
		MyEdge other = (MyEdge) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}

}