package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row: ");
		int row = sc.nextInt();
		System.out.println("Enter the col: ");
		int col = sc.nextInt();
		int grid[][] = new int[row][col];

		System.out.println("Enter the Adventure position(Row): ");
		int adventureRow = sc.nextInt() - 1;
		System.out.println("Enter the Adventure position(Column): ");
		int adventureCol = sc.nextInt() - 1;

		System.out.println("Enter the Monster position(Row): ");
		int monsterRow = sc.nextInt() - 1;
		System.out.println("Enter the Monster position(Column): ");
		int monsterColumn = sc.nextInt() - 1;

		System.out.println("Enter the Gold position(Row): ");
		int goldRow = sc.nextInt() - 1;
		System.out.println("Enter the Gold position(Column): ");
		int goldCol = sc.nextInt() - 1;

		grid[goldRow][goldCol] = 1;

		int adventureMinimumSteps = rec(adventureRow, adventureCol, grid);
		int monsterMinimumSteps = rec(monsterRow, monsterColumn, grid);

		if (monsterMinimumSteps >= adventureMinimumSteps)
			System.out.println("Minumum number of steps: " + adventureMinimumSteps);
		else
			System.out.println("No possible ways");

	}

	static int rec(int row, int col, int[][] grid) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
			return (int) 10e8;
		}
		if (grid[row][col] == 1)
			return 0;
		grid[row][col] = -1;
		int down = rec(row + 1, col, grid) + 1;
		int up = rec(row - 1, col, grid) + 1;
		int left = rec(row, col - 1, grid) + 1;
		int right = rec(row, col + 1, grid) + 1;
		grid[row][col] = 0;

		return Math.min(left, Math.min(right, Math.min(up, down)));
	}
}
