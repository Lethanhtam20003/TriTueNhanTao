package task4_UniformCost;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub'
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			}
			else {
				explored.add(current);
				List<Edge> children = current.getChildren();
				for(Edge chil : children) {
					Node n = chil.getEnd();
					if (!frontier.contains(n) && !explored.contains(n)) {
						n.setParent(current);
						n.setPathCost(current.getPathCost()+chil.getWeight());
						frontier.add(n);
					}else if(frontier.contains(n) && n.getPathCost()>current.getPathCost()+chil.getWeight()) {
						n.setPathCost(current.getPathCost()+chil.getWeight());
						n.setParent(current);
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
