package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Tictactoe {
	static char board[][] = new char[3][3];
	static Scanner sc = new Scanner(System.in);

	static {
		for (char[] row : board) {
			Arrays.fill(row, '-');
		}
	}

	public static void main(String[] args) {
		int currentPlayer = 1;
		while (true) {
			printBoard();
			// To check board is filled
			if (checkBoardFilled()) {
				System.err.println("The board is filled, and no player has won ( draw).");
				System.exit(0);
			}
			char symbol = currentPlayer == 1 ? 'X' : 'O';

			System.out.println("Player " + currentPlayer + " (" + symbol + "), enter your move(row and column): ");
			int row = sc.nextInt();
			int column = sc.nextInt();

			if (checkValidPosition(row, column)) {
				board[row][column] = symbol;

				if (checkWinner(row, column, symbol)) {
					printBoard();
					System.out.println("Congratulations, Player " + currentPlayer + "(" + symbol + ") wins!");
					System.exit(0);
				}

				if (currentPlayer == 1)
					currentPlayer = 2;
				else
					currentPlayer = 1;
			} else {
				System.err.println("Invalid Move!!!");
			}

		}

	}

	public static void printBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean checkValidPosition(int row, int col) {

		if (row < 0 || col < 0 || row >= 3 || col >= 3 || board[row][col] != '-')
			return false;
		return true;

	}

	static boolean checkWinner(int row, int col, char symbol) {

		if (board[row][0] == symbol && board[row][1] == symbol && board[row][2] == symbol)
			return true;
		if (board[0][col] == symbol && board[1][col] == symbol && board[2][col] == symbol)
			return true;

		if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol)
			return true;

		if (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol)
			return true;

		return false;
	}

	static boolean checkBoardFilled() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-')
					return false;
			}
		}
		return true;

	}
}
