package task1_graphSearch;

public interface ISearchAlgo {
	public Node execute(Node root, String goal);// find the path from root node to the goal node

	public Node execute(Node root, String start, String goal); // find the path from start node to the goal node
}
