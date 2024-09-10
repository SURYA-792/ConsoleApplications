package dungeon;

import java.util.ArrayList;
import java.util.List;

public class FindPath {

	ArrayList<Integer> adventurePath = new ArrayList<>();
	ArrayList<Integer> temp = new ArrayList<>();

	int getMinimumSteps(int row, int col, int[][] mat) {
		if (row < 0 || col < 0 || row >= mat.length || col >= mat[0].length || mat[row][col] == -1)
			return (int) 10e8;
		if (mat[row][col] == 1) {
			if (adventurePath.size() == 0 || adventurePath.size() > temp.size()) {
				adventurePath = new ArrayList<>(temp);
				adventurePath.add(row + 1);
				adventurePath.add(col + 1);
			}
			return 0;
		}
		mat[row][col] = -1;

		temp.add(row + 1);
		temp.add(col + 1);

		int up = getMinimumSteps(row - 1, col, mat) + 1;
		int right = getMinimumSteps(row, col + 1, mat) + 1;
		int down = getMinimumSteps(row + 1, col, mat) + 1;
		int left = getMinimumSteps(row, col - 1, mat) + 1;

		temp.remove(temp.size() - 1);
		temp.remove(temp.size() - 1);

		mat[row][col] = 0;

		return Math.min(left, Math.min(right, Math.min(up, down)));
	}

	List<Integer> getpath() {
		return adventurePath;
	}
}
