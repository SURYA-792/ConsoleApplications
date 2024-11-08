package dungeon;

import java.util.ArrayList;
import java.util.Scanner;

public class Question3 {

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

		ArrayList<Integer> adventurePath = new ArrayList<>();

		grid[goldRow][goldCol] = 1;

		int adventureMinimumSteps = findAdventureMinimumSteps(adventureRow, adventureCol, grid, new ArrayList<>(),
				adventurePath);
		int monsterMinimumSteps = monsterMinimumSteps(monsterRow, monsterColumn, grid);

		if (monsterMinimumSteps >= adventureMinimumSteps) {
			System.out.println("Minumum number of steps: " + adventureMinimumSteps);
			System.out.print("Path: ");
			for (int i = 0; i < adventurePath.size(); i += 2) {
				System.out.print("(" + adventurePath.get(i) + ", " + adventurePath.get(i + 1) + ")");
				if (i != adventurePath.size() - 2) {
					System.out.print(" -> ");
				}
			}
		} else
			System.out.println("No possible ways");

	}

	static int findAdventureMinimumSteps(int row, int col, int[][] grid, ArrayList<Integer> tempPath,
			ArrayList<Integer> adventurePath) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
			return (int) 10e8;
		}
		if (grid[row][col] == 1) {
			if ((adventurePath.size() == 0 || adventurePath.size() > tempPath.size())) {
				adventurePath.clear();
				adventurePath.addAll(tempPath);
				adventurePath.add(row + 1);
				adventurePath.add(col + 1);
			}
			return 0;
		}
		grid[row][col] = -1;

		tempPath.add(row + 1);
		tempPath.add(col + 1);

		int down = findAdventureMinimumSteps(row + 1, col, grid, tempPath, adventurePath) + 1;
		int up = findAdventureMinimumSteps(row - 1, col, grid, tempPath, adventurePath) + 1;
		int left = findAdventureMinimumSteps(row, col - 1, grid, tempPath, adventurePath) + 1;
		int right = findAdventureMinimumSteps(row, col + 1, grid, tempPath, adventurePath) + 1;
		grid[row][col] = 0;

		tempPath.remove(tempPath.size() - 1);
		tempPath.remove(tempPath.size() - 1);

		return Math.min(left, Math.min(right, Math.min(up, down)));

	}

	static int monsterMinimumSteps(int row, int col, int[][] grid) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1) {
			return (int) 10e8;
		}
		if (grid[row][col] == 1)
			return 0;
		grid[row][col] = -1;
		int up = monsterMinimumSteps(row - 1, col, grid) + 1;
		int down = monsterMinimumSteps(row + 1, col, grid) + 1;
		int left = monsterMinimumSteps(row, col - 1, grid) + 1;
		int right = monsterMinimumSteps(row, col + 1, grid) + 1;
		grid[row][col] = 0;

		return Math.min(left, Math.min(right, Math.min(up, down)));
	}
}
