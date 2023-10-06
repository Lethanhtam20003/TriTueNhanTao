package task1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node d : children) {
				if (!frontier.contains(d) && !explored.contains(d)) {
					frontier.add(d);
				}
				d.setParent(current);
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		Queue<Node> frontier = new LinkedList<>();
		boolean started = false;
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(start)) {
				started = true;
				frontier.clear();
				explored.clear();
				current.setParent(null);
			}
			if (current.getLabel().equals(goal)) {
				if (started)
					return current;
			}
			explored.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node d : children) {
				if (!frontier.contains(d) && !explored.contains(d)) {
					frontier.add(d);
				}
				d.setParent(current);
			}
		}
		return null;
	}
}
