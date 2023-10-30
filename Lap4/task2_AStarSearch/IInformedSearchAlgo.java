package task2_AStarSearch;

public interface IInformedSearchAlgo {
	public Node execute(Node root, String goal);

	public Node execute(Node root, String start, String goal);

}
