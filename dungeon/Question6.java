package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Question6 {
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

		System.out.println("Enter the Number of pits: ");
		int numberOfPits = sc.nextInt();
		while (numberOfPits-- > 0) {
			System.out.println("Enter the pit(Row)");
			int pitRow = sc.nextInt() - 1;
			System.out.println("Enter the pit(Column)");
			int pitColumn = sc.nextInt() - 1;

			grid[pitRow][pitColumn] = -2;
		}
		int adventureMinimumSteps = findAdventureMinimumSteps(adventureRow, adventureCol, grid, false, goldRow,
				goldCol);
		int monsterMinimumSteps = findAdventureMinimumSteps(monsterRow, monsterColumn, grid, false, goldRow, goldCol);

		if (monsterMinimumSteps >= adventureMinimumSteps)
			System.out.println("Minumum number of steps: " + adventureMinimumSteps);
		else {

			System.out.println("No possible ways");
		}

	}

	static int findAdventureMinimumSteps(int row, int col, int[][] grid, boolean isMonster, int targetRow,
			int targetCol) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1
				|| (!isMonster && grid[row][col] == -2)) {
			return (int) 10e8;
		}
		if (row == targetRow && col == targetCol) {
			return 0;
		}
		grid[row][col] = -1;

		int down = findAdventureMinimumSteps(row + 1, col, grid, isMonster, targetRow, targetCol) + 1;
		int up = findAdventureMinimumSteps(row - 1, col, grid, isMonster, targetRow, targetCol) + 1;
		int left = findAdventureMinimumSteps(row, col - 1, grid, isMonster, targetRow, targetCol) + 1;
		int right = findAdventureMinimumSteps(row, col + 1, grid, isMonster, targetRow, targetCol) + 1;
		grid[row][col] = 0;

		return Math.min(left, Math.min(right, Math.min(up, down)));

	}
}
