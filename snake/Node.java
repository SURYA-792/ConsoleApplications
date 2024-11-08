package snake;

public class Node {
	int row;
	int col;

	Node(int row, int col) {
		this.row = row;
		this.col = col;
	}

	int getRow() {
		return row;
	}

	int getCol() {
		return col;
	}
}
