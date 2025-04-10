package social_media_application.user_view;

import java.util.InputMismatchException;
import java.util.Scanner;

import social_media_application.post_view.PostView;

public class UserView {
	Scanner sc = new Scanner(System.in);

	public void init() {
		boolean flag = true;
		while (flag) {
			System.out.println("\nEnter the option: \n1.Add New Post\n2.View All Posts\n3.Logout");
			int option;
			try {
				option = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.err.println("\nPlease enter the valid input!");
				sc.nextLine();
				continue;
			}

			switch (option) {
			case 1: {
				PostView view = new PostView();
				view.createNewPost();
			}
				break;
			case 2: {
				PostView view = new PostView();
				view.viewAllpost();
			}
				break;
			case 3: {
				flag = false;
			}
				break;
			default: {
				System.err.println("\nPlease select valid option!");
			}
			}
		}
	}
}
