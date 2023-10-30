package task1_GreedyBestFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

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
						frontier.add(n); 
					} else if (frontier.contains(n) && n.getH() > curent.getH()) {
						n.setParent(curent);
					}
				}
			}

		}
		return null;
	}

	public boolean isAdmissibleH(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		List<Node> explored = new ArrayList<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node curent = frontier.poll();
			if (curent.getLabel().equalsIgnoreCase(goal)) {
				return true;
			} else {
				explored.add(curent);
				List<Edge> children = curent.getChildren();
				for (Edge child : children) {
					Node n = child.getEnd();
					if (!frontier.contains(n) && !explored.contains(n)) {
						n.setParent(curent);
						frontier.add(n); 
					} else if (frontier.contains(n) && n.getH() > curent.getH()) {
						n.setParent(curent);
					}
				}
			}

		}
		return false;
	}
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
