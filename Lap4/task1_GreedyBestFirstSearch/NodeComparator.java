package task1_GreedyBestFirstSearch;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		double h1 = o1.getH();
		double h2 = o2.getH();
		int res = (int) (h1 - h2);
		if (res == 0) {
			return o2.getLabel().compareToIgnoreCase(o1.getLabel());
		}
		return res;
	}
  
}
