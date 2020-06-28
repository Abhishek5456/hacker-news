package com.abhishek.hackernews.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
	private String by;
	private long id;
	private long[] kids;
	private long time;
	private String text;
	private User user;
	private List<Comment> subComments;

	public String getBy() {
		return by;
	}

	public void setBy(String by) {
		this.by = by;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long[] getKids() {
		return kids;
	}

	public void setKids(long[] kids) {
		this.kids = kids;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getSubComments() {
		return subComments;
	}

	public void setSubComments(List<Comment> subComments) {
		this.subComments = subComments;
	}
	
	

}
