package task2_AStarSearch;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		double h1 = o1.getH();
		double h2 = o2.getH();
		double g1 = o1.getG(); 
		double g2 = o2.getG();

		int res = (int) (h1 + g1 - h2 - g2);
		if (res == 0) {
			return o1.getLabel().compareToIgnoreCase(o2.getLabel());
		}
		return res;
	}
 
}
