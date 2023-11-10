package task2_node;

import task1_qeen.Node;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		this.row = this.row + 1;
		if (this.row  == Node.N)
			this.row=0;
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// check colum
		if (q.getColumn() == this.column) {
			return false;
		}
		// check row
		if (this.getRow() == q.getRow())
			return false;
		// check duong cheo
		if (Math.abs((q.getColumn() - this.getColumn())) == Math.abs(q.getRow() - this.getRow()))
			return false;

		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "(" + row + ", " + column + ")";
	}
}
