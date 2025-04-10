package social_media_application.model;

import java.util.HashMap;

public class User {
	private String userId;
	private String password;
	private String name;
	private HashMap<String, Post> posts;

	public User(String userId, String password, String name) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HashMap<String, Post> getPosts() {
		return posts;
	}

	public void setPosts(Post post) {
		this.posts.put(post.getHeading(), post);
	}

}
