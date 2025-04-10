package social_media_application.repository;

import java.util.HashMap;
import social_media_application.model.Post;
import social_media_application.model.User;

public class Repository {
	private static Repository repository;
	private HashMap<String, User> users = new HashMap<>();
	private HashMap<String, Post> posts = new HashMap<>();
	private User currentUser;

	private Repository() {
	}

	public static Repository getInstance() {
		if (repository == null) {
			repository = new Repository();
		}
		return repository;
	}

	public boolean validateUser(String userId, String password) {
		if (users.containsKey(userId) && users.get(userId).getPassword().equals(password)) {
			currentUser = users.get(userId);
			return true;
		}
		return false;
	}

	public boolean addNewUser(String userId, String password, String name) {
		if (users.containsKey(userId))
			return false;
		users.put(userId, new User(userId, password, name));
		return true;
	}

	public boolean checkHeadingAvailable(String heading) {
		return posts.containsKey(heading);
	}

	public void addNewPost(Post post) {
		posts.put(post.getHeading(), post);

	}

	public HashMap<String, Post> getPosts() {
		return posts;
	}

	public boolean isValidUser(String allowedUser) {
		return users.containsKey(allowedUser);
	}

	public boolean checkPostIsAllowed(Post post) {
		return !post.isPrivate() || post.getAllowedUsers().contains(currentUser.getUserId());
	}

	public User getCurrentUser() {
		return currentUser;
	}
}
