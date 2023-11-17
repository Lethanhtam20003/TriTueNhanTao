package task1_GA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			List<Node> newPopulation = new ArrayList<>();
			for (int i = 0; i < POP_SIZE; i++) {
				Node x = getParentByRandomSelection();
				Node y = getParentByRandomSelection();
				Node child = reproduce(x, y);
				if ((new Random()).nextDouble() > MUTATION_RATE) {
					mutate(child);
				}
				if (child.getH() == 0)
					return child;
				newPopulation.add(child);
			}
			population = newPopulation;

		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here
		Random rd = new Random();
		int indexQeen = rd.nextInt(Node.N);
		int indexRow = rd.nextInt(Node.N);
		if (indexRow == node.getState()[indexQeen].getRow()) {
			if (indexRow < Node.N)
				indexRow++;
			if (indexRow > 1)
				indexRow--;
		}
		node.getState()[indexQeen].setRow(indexRow);
	}

	// Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		// Enter your code here
		Node child = new Node();
		Random rd = new Random();
		child.generateBoard();
		int c = rd.nextInt(Node.N);
		for (int i = 0; i < c; i++) {
			child.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			child.setRow(i, x.getRow(i));
		}

		return child;
	}

	// Select K individuals from the population at random and
	// select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here5
		Node res = null;
		int indNum = 10;
		Random rd = new Random();
		for (int i = 0; i < indNum; i++) {
			int r = rd.nextInt(POP_SIZE);
			if (res == null) {
				res = population.get(rd.nextInt(POP_SIZE));
			}
			if (res.getH() > population.get(r).getH()) {
				res = population.get(r);
			}
		}
		return res;
	}

	// Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		return population.get((new Random()).nextInt(POP_SIZE));
	}
	public static void main(String[] args) {
		GA_NQueenAlgo t = new GA_NQueenAlgo();
		Node n = t.execute();
		n.displayBoard();
		
		System.out.println(n.getH());
	}
}
