package task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Depth_limited {

	public Node execute(Node root, String goal, int depthLimit) {
		Stack<Node> frontier = new Stack<>();
		List<Node> exploer = new ArrayList<>();
		frontier.add(root);
		while (frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getParent() == null) {
				current.setDepth(0);
			} else
				current.setDepth(current.getParent().getDepth() + 1);

			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				exploer.add(current);
				if(current.getDepth()< depthLimit) {
					List<Node> childrent = current.getChildrenNodes();
					for (Node child : childrent) {
						if (!frontier.contains(child) && !exploer.contains(child)) {
							frontier.add(child);
						}
						child.setParent(current);
						child.setDepth(current.getDepth());
					}
				}
			}
		}

		return null;

	}
}
