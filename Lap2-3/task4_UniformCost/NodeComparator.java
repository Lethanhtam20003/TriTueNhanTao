package task4_UniformCost;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		double result = o1.getPathCost() - o2.getPathCost();
		if (result > 0)
			return (int) result;

		return (int) (o1.getLabel().compareTo(o2.getLabel()));
	}
}
