package snake;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int dividend=-1, divisor = -1;
		System.out.println(!(dividend<0 && divisor<0));
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Row size: ");
		int row = sc.nextInt();
		System.out.println("Enter the Column size: ");
		int col = sc.nextInt();

		Snake snake = new Snake(row, col);
		snake.move(0, 0);
	}
}
