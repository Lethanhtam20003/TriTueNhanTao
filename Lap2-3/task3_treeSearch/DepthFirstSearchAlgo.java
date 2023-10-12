package task3_treeSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
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
		Stack<Node> frontier = new Stack<>();
		boolean started = false;
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
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
