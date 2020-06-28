package com.abhishek.hackernews.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.abhishek.hackernews.entity.Comment;
import com.abhishek.hackernews.entity.Story;
import com.abhishek.hackernews.model.ResponseComment;
import com.abhishek.hackernews.model.ResponseStory;

@Component
public class Transform {

	public List<ResponseStory> TransformtoResponseStory(List<Story> stories) {
		List<ResponseStory> responseStories = new ArrayList<>();

		for (Story story : stories) {
			responseStories.add(new ResponseStory(story.getID(), story.getTitle(), story.getUrl(), story.getScore(),
					story.getTime(), story.getBy()));
		}

		return responseStories;
	}

	public List<ResponseComment> TransformtoResponseComment(List<Comment> comments) {
		List<ResponseComment> responseComments = new ArrayList<>();

		for (Comment comment : comments) {
			ResponseComment responseComment = null;
			if(null != comment.getUser()) {
				responseComment = new ResponseComment(comment.getId(), comment.getText(),
						comment.getUser().getId(), comment.getUser().getCreated());	
			}
			else {
				responseComment = new ResponseComment(comment.getId(), comment.getText(),
						"", 0);
			}
			if (null != comment.getSubComments() && comment.getSubComments().size() != 0) {
				List<ResponseComment> subComments = TransformtoResponseComment(comment.getSubComments());
				responseComment.setSubcomments(subComments);
			}

			responseComments.add(responseComment);
		}
		return responseComments;
	}
}
