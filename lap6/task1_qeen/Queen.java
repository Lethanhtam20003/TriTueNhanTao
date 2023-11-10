package task1_qeen;

public class Queen {
	private int row;
	private int column;

	public Queen(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

	public void move() {
		// Enter your code here
		this.row = this.row + 1;
		if (this.row  == Node.N)
			this.row=0;
	}

	// check whether this Queen can attack the given Queen (q)
	public boolean isConflict(Queen q) {
		// Enter your code here
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
