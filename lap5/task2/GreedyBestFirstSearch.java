package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;



public class GreedyBestFirstSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<>();

		frontier.add(model.getInitialState());
		while (!frontier.isEmpty()) {
			Node curent = frontier.poll();
			if (curent.getH() == 0) {
				return curent;
			} else {
				explored.add(curent);
				List<Node> children = model.getSuccessors(curent);
				for (Node child : children) {
					if (!frontier.contains(child) && !explored.contains(child)) {
						child.setG(child.getG() + 1);
						frontier.add(child);
					}
				}
			}

		}
		return null;
	}

}
