package com.abhishek.hackernews.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.abhishek.hackernews.dao.APICall;
import com.abhishek.hackernews.entity.Comment;
import com.abhishek.hackernews.entity.Story;
import com.abhishek.hackernews.model.ResponseComment;
import com.abhishek.hackernews.model.ResponseStory;
import com.abhishek.hackernews.util.Transform;

@Service
public class APIService {

	@Autowired
	APICall apiCall;

	@Autowired
	Transform transform;

	@Cacheable(value = "stories-cache", key = "'stories'")
	public List<ResponseStory> getTopStories() {
		List<String> topTenStories = apiCall.getTopStoryId();
		List<Story> stories = apiCall.getTopStories(topTenStories);

		return transform.TransformtoResponseStory(stories);
	}

	@Cacheable(value = "Comment-cache", key = "'comment'.#storyId")
	public List<ResponseComment> getComments(long storyId) {
		List<Long> commentIds = apiCall.getCommentIds(storyId);
		List<Comment> comments = apiCall.getComments(commentIds);

		return transform.TransformtoResponseComment(comments);
	}

	@CacheEvict(value = { "stories-cache", "Comment-cache" }, allEntries = true)
	public void evictCache() {
		// TODO Auto-generated method stub

	}
}
