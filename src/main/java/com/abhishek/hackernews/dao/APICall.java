package com.abhishek.hackernews.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.abhishek.hackernews.entity.Comment;
import com.abhishek.hackernews.entity.Story;
import com.abhishek.hackernews.entity.User;

@Repository
public class APICall {
	@Autowired
	RestTemplate restTemplate;

	final String baseURL = "https://hacker-news.firebaseio.com/v0/";

	public List<String> getTopStoryId() {
		String result = restTemplate.getForObject(baseURL + "topstories.json", String.class);
		List<String> topStoriesId = Arrays.stream(result.substring(1, result.length() - 1).split(",")).limit(10)
				.collect(Collectors.toList());
		return topStoriesId;
	}

	public List<Story> getTopStories(List<String> storyIds) {
		List<Story> stories = new ArrayList<Story>();
		try {
			for (String storyId : storyIds) {
				Story story = restTemplate.getForObject(baseURL + "/item/" + storyId + ".json", Story.class);
				stories.add(story);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stories;
	}

	public List<Long> getCommentIds(long storyId) {
		List<Long> commentIds = null;
		try {
			Story story = restTemplate.getForObject(baseURL + "/item/" + storyId + ".json", Story.class);
			if (null != story.getKids() && story.getKids().length != 0) {
				commentIds = Arrays.stream(story.getKids()).boxed().limit(10).collect(Collectors.toList());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentIds;
	}

	public List<Comment> getComments(List<Long> commentIds) {
		List<Comment> comments = new ArrayList<Comment>();
		try {
			for (long commentId : commentIds) {
				Comment comment = restTemplate.getForObject(baseURL + "/item/" + commentId + ".json", Comment.class);
				System.out.println("CommentId: "+ comment.getId());
				System.out.println("User: "+ comment.getBy());
				if (null != comment.getBy() && !comment.getBy().isEmpty()) {
					comment.setUser(getUserDetail(comment.getBy()));
				}
				//System.out.println("Kids: "+ comment.getKids().toString());
				if (null != comment.getKids()) {
					List<Long> subCommentIds = Arrays.stream(comment.getKids()).boxed().collect(Collectors.toList());
					comment.setSubComments(getComments(subCommentIds));
				}

				comments.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return comments;
	}

	private User getUserDetail(String userId) {
		User user = null;
		try {
			user = restTemplate.getForObject(baseURL + "/user/" + userId + ".json", User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
