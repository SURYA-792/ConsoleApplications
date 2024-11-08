package dungeon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Question4 {
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

		System.out.println("Enter the Trigger Position(Row): ");
		int triggerRow = sc.nextInt() - 1;

		System.out.println("Enter the Trigger Position(Column): ");
		int triggerColumn = sc.nextInt() - 1;

		// To find miminum steps for adventure to get Gold
		int adventureMinimumSteps = findMinimumSteps(adventureRow, adventureCol, grid, goldRow, goldCol);

		// To find minimum steps for monster to get a Gold
		int monsterMinimumSteps = findMinimumSteps(monsterRow, monsterColumn, grid, goldRow, goldCol);

		// if adventure get gold before monster
		if (monsterMinimumSteps >= adventureMinimumSteps) {
			System.out.println("Minumum number of steps: " + adventureMinimumSteps);

		} else {
			int adventureMinimumStepsForTrigger = findMinimumSteps(adventureRow, adventureCol, grid, triggerRow,
					triggerColumn);
			
			if (monsterMinimumSteps >= adventureMinimumStepsForTrigger) {
				int triggerToGoldMinimumSteps = findMinimumSteps(triggerRow, triggerColumn, grid, goldRow, goldCol);
				System.out.println(
						"Minimum number of steps:" + (adventureMinimumStepsForTrigger + triggerToGoldMinimumSteps));
			}
		}

	}

	static int findMinimumSteps(int row, int col, int[][] grid, int targetRow, int targetCol) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
			return (int) 10e8;
		}
		if (row == targetRow && col == targetCol)
			return 0;

		grid[row][col] = -1;

		int down = findMinimumSteps(row + 1, col, grid, targetRow, targetCol) + 1;
		int up = findMinimumSteps(row - 1, col, grid, targetRow, targetCol) + 1;
		int left = findMinimumSteps(row, col - 1, grid, targetRow, targetCol) + 1;
		int right = findMinimumSteps(row, col + 1, grid, targetRow, targetCol) + 1;
		grid[row][col] = 0;

		return Math.min(left, Math.min(right, Math.min(up, down)));

	}
}
