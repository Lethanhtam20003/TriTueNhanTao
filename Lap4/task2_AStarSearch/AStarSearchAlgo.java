package task2_AStarSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node curent = frontier.poll();
			if (curent.getLabel().equalsIgnoreCase(goal)) {
				return curent;
			} else {
				explored.add(curent);
				List<Edge> children = curent.getChildren();
				for (Edge child : children) {
					Node n = child.getEnd();
					if (!frontier.contains(n) && !explored.contains(n)) {
						n.setParent(curent);
						n.setG(curent.getG() + child.getWeight());
						frontier.add(n);
					} else if (frontier.contains(n) && n.getG() > curent.getH()) {
						// frontier.remove(n);
						n.setG(curent.getG() + child.getWeight());
						n.setParent(curent);
						// frontier.add(curent);
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
