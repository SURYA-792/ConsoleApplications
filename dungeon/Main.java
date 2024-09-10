package dungeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row Size: ");
		int row = sc.nextInt();

		System.out.println("Enter the column Size: ");
		int col = sc.nextInt();

		int mat[][] = new int[row + 1][col + 1];
		mat = new int[row + 1][col + 1];

		FindPath adventure = new FindPath();
		FindPath monster = new FindPath();

		// Gold Position
		mat[4 - 1] [3 - 1] = 1;

		// Monster Position
		int monsterSteps = monster.getMinimumSteps(3 - 1, 1 - 1, mat);
		// Adventure Position
		int adventureSteps = adventure.getMinimumSteps(5 - 1, 1 - 1, mat);

		if (monsterSteps - 1 < adventureSteps) {
			
			System.out.println("Minimum number of steps: " + adventureSteps);
			List<Integer> path = adventure.getpath();

			for (int i = 0; i < path.size(); i++) {
				if (i != 0 && i % 2 == 0) {
					System.out.print("-> ");
				}
				System.out.print(path.get(i) + ",");
			}
		} else {
			System.out.println("No posible Solution");
		}

	}

}
