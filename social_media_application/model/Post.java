package social_media_application.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Post {

	private String heading;
	private String content;

	private int likes;
	private int dislikes;

	private boolean isLikesAllowed;
	private boolean isCommentsAllowed;
	private boolean isOnlyOneUserComment;
	private boolean isPrivate;

	private ArrayList<String> comments = new ArrayList<>();
	private HashMap<String, LikeType> likedUsers = new HashMap<>();
	private HashSet<String> commentedUsers = new HashSet<>();
	private HashSet<String> allowedUsers = new HashSet<>();

	public Post(String heading, String content, boolean isLikesAllowed, boolean isCommentsAllowed,
			boolean isOnlyOneUserComment) {
		super();
		this.heading = heading;
		this.content = content;
		this.isLikesAllowed = isLikesAllowed;
		this.isCommentsAllowed = isCommentsAllowed;
		this.isOnlyOneUserComment = isOnlyOneUserComment;
	}

	public Post(String heading, String content, boolean isLikesAllowed, boolean isCommentsAllowed,
			boolean isOnlyOneUserComment, boolean isPrivate, HashSet<String> allowedUsers) {
		super();
		this.heading = heading;
		this.content = content;
		this.isLikesAllowed = isLikesAllowed;
		this.isCommentsAllowed = isCommentsAllowed;
		this.isOnlyOneUserComment = isOnlyOneUserComment;
		this.isPrivate = isPrivate;
		this.allowedUsers.addAll(allowedUsers);
	}

	public String getHeading() {
		return heading;
	}

	public String getContent() {
		return content;
	}

	public int getLikes() {
		return likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public boolean isLikesAllowed() {
		return isLikesAllowed;
	}

	public boolean isCommentsAllowed() {
		return isCommentsAllowed;
	}

	public boolean isOnlyOneUserComment() {
		return isOnlyOneUserComment;
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public HashSet<String> getAllowedUsers() {
		return allowedUsers;
	}

	public void addAllowedUsers(String allowedUser) {
		this.allowedUsers.add(allowedUser);
	}

	public ArrayList<String> getComments() {
		return comments;
	}

	public HashMap<String, LikeType> getLikedUsers() {
		return likedUsers;
	}

	public HashSet<String> getCommentedUsers() {
		return commentedUsers;
	}

	public void setLikes(int likes) {
		this.likes += likes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes += dislikes;
	}

	public void setLikesAllowed(boolean isLikesAllowed) {
		this.isLikesAllowed = isLikesAllowed;
	}

	public void setCommentsAllowed(boolean isCommentsAllowed) {
		this.isCommentsAllowed = isCommentsAllowed;
	}

	public void setOnlyOneUserComment(boolean isOnlyOneUserComment) {
		this.isOnlyOneUserComment = isOnlyOneUserComment;
	}

	public void addComments(String comment) {
		this.comments.add(comment);
	}

	public void setLikedUsers(String likedUser, LikeType type) {
		this.likedUsers.put(likedUser, type);
	}

	public void setCommentedUsers(String commentedUser) {
		this.commentedUsers.add(commentedUser);
	}

	@Override
	public String toString() {
		return "Post [heading=" + heading + ", content=" + content + ", likes=" + likes + ", dislikes=" + dislikes
				+ ", isLikesAllowed=" + isLikesAllowed + ", isCommentsAllowed=" + isCommentsAllowed
				+ ", isOnlyOneUserComment=" + isOnlyOneUserComment + ", isPrivate=" + isPrivate + ", comments="
				+ comments + ", likedUsers=" + likedUsers + ", commentedUsers=" + commentedUsers + ", allowedUsers="
				+ allowedUsers + "]";
	}
	
	
}
