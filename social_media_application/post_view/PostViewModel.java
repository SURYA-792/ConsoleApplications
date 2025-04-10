package social_media_application.post_view;

import java.util.HashMap;
import java.util.HashSet;

import social_media_application.model.LikeType;
import social_media_application.model.Post;
import social_media_application.model.User;
import social_media_application.repository.Repository;

public class PostViewModel {
	Repository repository = Repository.getInstance();

	public boolean checkHeadingAvailable(String heading) {
		return repository.checkHeadingAvailable(heading);
	}

	public void addPostWithoutGroup(String heading, String content, boolean allowLikes, boolean allowComments,
			boolean allowOnlyOneUserComment) {

		Post post = new Post(heading, content, allowLikes, allowComments, allowOnlyOneUserComment);
		repository.addNewPost(post);
	}

	public void addPostWithGroup(String heading, String content, boolean allowLikes, boolean allowComments,
			boolean allowOnlyOneUserComment, boolean isPrivate, HashSet<String> allowedUsers) {
		allowedUsers.add(repository.getCurrentUser().getUserId());
		Post post = new Post(heading, content, allowLikes, allowComments, allowOnlyOneUserComment, true, allowedUsers);
		repository.addNewPost(post);
	}

	public HashMap<String, Post> getAllPost() {
		return repository.getPosts();
	}

	public boolean checkValidUser(String allowedUser) {
		return repository.isValidUser(allowedUser);
	}

	public boolean checkPostIsAllowed(Post post) {
		return repository.checkPostIsAllowed(post);
	}

	public String likePost(Post post) {
		User user = repository.getCurrentUser();

		if (!post.isLikesAllowed())
			return "\nLikes Disabled";
		if (post.getLikedUsers().containsKey(user.getUserId())) {
			if (post.getLikedUsers().get(user.getUserId()).equals(LikeType.LIKE)) {
				return "Alredy Liked!";
			}
			if (post.getLikedUsers().get(user.getUserId()).equals(LikeType.DISLIKE)) {
				post.getLikedUsers().remove(user.getUserId());
				post.setDislikes(-1);
			}
		}

		post.setLikedUsers(user.getUserId(), LikeType.LIKE);
		post.setLikes(1);
		return "\nSuccessfully Liked!";
	}

	public String dislikePost(Post post) {
		User user = repository.getCurrentUser();

		if (!post.isLikesAllowed())
			return "\nLikes Disabled";
		if (post.getLikedUsers().containsKey(user.getUserId())) {
			if (post.getLikedUsers().get(user.getUserId()).equals(LikeType.DISLIKE)) {
				return "Alredy DisLiked!";
			}
			if (post.getLikedUsers().get(user.getUserId()).equals(LikeType.LIKE)) {
				post.getLikedUsers().remove(user.getUserId());
				post.setLikes(-1);
			}
		}

		post.setLikedUsers(user.getUserId(), LikeType.DISLIKE);
		post.setDislikes(1);
		return "\nSuccessfully DisLiked!";
	}

	public String commentPost(Post post, String comment) {
		User user = repository.getCurrentUser();
		if (!post.isCommentsAllowed())
			return "\nComment disabled!";
		else if (post.isOnlyOneUserComment() && post.getCommentedUsers().contains(user.getUserId())) {
			return "\nOnly one user comment enabled!";
		}
		post.addComments(comment);
		post.getCommentedUsers().add(user.getUserId());
		return "\nSuccessfully commented!";
	}

}
