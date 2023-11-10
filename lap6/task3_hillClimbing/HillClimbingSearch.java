package task3_hillClimbing;

import java.util.List;

public class HillClimbingSearch {
	int stepClimbed = 0;
	int stepClimbedAfterRandomRestart = 0;
	int randomRestarts = 0;

	public Node excute(Node initialState) {
		Node curent = initialState;
		Node neighbor = null;
		List<Node> list = curent.generateAllCandidates();
		for (int i = 0; i < Node.N; i++) {
			for (Node n : list) {
				neighbor = new Node(n);
				if (curent.getH() > neighbor.getH())
					curent = neighbor;
			}
		}
		return curent;
	}

	public Node excute2(Node initialState) {
		Node curent = excute2(initialState);
		Node neighbor = null;
		while (true) {
			neighbor = curent.getBestCandidates(curent.generateAllCandidates());
			if (curent.getH() > neighbor.getH()) {
				curent = neighbor;

			}
			return curent;
		}
	}

	public Node executeHillClimbingWithRandomRestart(Node initialState) {
		Node curent = new Node(initialState);
		while (curent.getH() != 0) {
			
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
