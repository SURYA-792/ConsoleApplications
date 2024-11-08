package snake;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Snake {

	char board[][];
	Queue<Node> queue = new LinkedList<>();
	Random r = new Random();
	Scanner sc = new Scanner(System.in);

	Snake(int row, int col) {
		board = new char[row][col];
		queue.offer(new Node(0, 0));
		for (char i[] : board) {
			Arrays.fill(i, '.');
		}
		board[0][0] = 'X';
		generateFood();
	}

	void move(int row, int col) {
		if (row < 0 || col < 0 || row >= board.length || col >= board.length
				|| (row != 0 && col != 0 && board[row][col] == 'X')) {
			System.out.println("Game Over!!!");
			System.exit(0);
		}

		queue.offer(new Node(row, col));
		if (board[row][col] != '0') {
			Node node = queue.poll();
			board[node.getRow()][node.getCol()] = '.';

		}
		if(board[row][col]=='0') {
		generateFood();
		}
		board[row][col] = 'X';

		while (!queue.isEmpty()) {
			printBoard();
			System.out.println("Enter the Direction: ");
			char direction = sc.next().charAt(0);

			if (direction == 'R') {
				move(row, col + 1);
			}
			if (direction == 'L') {
				move(row, col - 1);
			}
			if (direction == 'U') {
				move(row - 1, col);
			}
			if (direction == 'D') {
				move(row + 1, col);
			}
		}

	}

	void generateFood() {
		int row = r.nextInt(board.length);
		int col = r.nextInt(board[0].length);
		while (board[row][col] == 'X') {
			row = r.nextInt(board.length);
			col = r.nextInt(board[0].length);
		}
		board[row][col] = '0';
	}

	void printBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
