package task3_AStart;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class AstarSearch implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByF);
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
						child.setG(child.getF());
						frontier.add(child);
					}
				}
			}
		}

		return null;
	}

}
