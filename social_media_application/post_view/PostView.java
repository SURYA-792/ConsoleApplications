package social_media_application.post_view;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import social_media_application.model.Post;

public class PostView {
	private Scanner sc = new Scanner(System.in);
	private PostViewModel vm = new PostViewModel();

	public void createNewPost() {
		String heading;
		String content;
		boolean allowLikes;
		boolean allowComments;
		boolean allowOnlyOneUserComment;
		while (true) {
			try {
				System.out.println("\nEnter the Post Heading:");
				heading = sc.nextLine();
				if (vm.checkHeadingAvailable(heading)) {
					System.err.println("\nHeading is already exist!");
					continue;
				}
				System.out.println("\nEnter the content: ");
				content = sc.nextLine();

				System.out.println("\nAlow Likes 1(Yes) 2(No)");
				allowLikes = sc.nextInt() == 1 ? true : false;
				sc.nextLine();

				System.out.println("\nAlow comments 1(Yes) 2(No)");
				allowComments = sc.nextInt() == 1 ? true : false;
				sc.nextLine();

				allowOnlyOneUserComment = false;
				if (allowComments) {
					System.out.println("\nAlow only one user comment 1(Yes) 2(No)");
					allowOnlyOneUserComment = sc.nextInt() == 1 ? true : false;
					sc.nextLine();
				}

				System.out.println("\nMake this post private 1(Yes) 2(No): ");
				boolean isPrivate = sc.nextInt() == 1 ? true : false;
				sc.nextLine();

				// If post is private only allowed users can view the post
				if (isPrivate) {
					HashSet<String> allowedUsers = new HashSet<>();
					while (true) {
						System.out.println("\nEnter the User Id or Enter (-1) for exit");
						String allowedUser = sc.nextLine();
						if (allowedUser.equals("-1")) {
							break;
						}
						if (!vm.checkValidUser(allowedUser)) {
							System.err.println("\nUser is not found!");
						} else {
							allowedUsers.add(allowedUser);
						}
					}
					vm.addPostWithGroup(heading, content, allowLikes, allowComments, allowOnlyOneUserComment, true,
							allowedUsers);
				}
				// if the post is public anyone can view the post
				else {
					vm.addPostWithoutGroup(heading, content, allowLikes, allowComments, allowOnlyOneUserComment);
				}
				System.out.println("\nPost added successfully!");

				break;
			} catch (InputMismatchException e) {
				System.err.println("\nPleas enter valid input!");
				sc.nextLine();
				continue;
			}
		}
	}

	public void viewAllpost() {
		HashMap<String, Post> posts = vm.getAllPost();
		boolean isPostEmpty = true;
		System.out.println("----------------------------------------");
		for (Post post : posts.values()) {
			if (!post.isPrivate() || post.isPrivate() && vm.checkPostIsAllowed(post)) {
				System.out.println("\nHeading: " + post.getHeading());
				isPostEmpty = false;
			}
			System.out.println("----------------------------------------");

		}

		if (isPostEmpty) {
			System.err.println("\n No posts Available!");
			return;
		}

		System.out.println("\nEnter post heading to view post details: ");
		String heading = sc.nextLine();
		if (!posts.containsKey(heading) || !vm.checkPostIsAllowed(posts.get(heading)))
			System.err.println("\nInvalid post heading");
		else
			showPostDetails(posts.get(heading));
	}

	void showPostDetails(Post post) {
		System.out.println("----------------------------------------");
		System.out.println("\nPost heading: " + post.getHeading());
		System.out.println("\npost content: " + post.getContent());
		System.out.println("\nLikes: " + post.getLikes());
		System.out.println("\nDislikes: " + post.getDislikes());
		System.out.println("\nComments: ");
		List<String> comments = post.getComments();
		if (comments.size() == 0) {
			System.out.println("\nNo comments available!");
		} else {
			for (String comment : comments) {
				System.out.println(comment);
			}
		}
		System.out.println("----------------------------------------");
		postInteractions(post);
	}

	void postInteractions(Post post) {
		outer: while (true) {
			int option;
			inner: while (true) {
				System.out.println("\n1.Like\n2.Dislike\n3.Comment\n4.Exit");
				try {
					option = sc.nextInt();
					sc.nextLine();
					break inner;
				} catch (InputMismatchException e) {
					System.err.println("\nPlease give a valid input!");
					continue inner;
				}
			}
			switch (option) {
			case 1: {
				System.out.println(vm.likePost(post));
			}
				break;
			case 2: {
				System.out.println(vm.dislikePost(post));
			}
				break;
			case 3: {
				System.out.println("\nEnter the comment: ");
				String comment = sc.nextLine();
				System.out.println(vm.commentPost(post, comment));
			}
				break;
			case 4: {
				break outer;
			}
			default: {
				System.err.println("\nPlease enter the valid option!");
			}
			}
		}
	}
}
