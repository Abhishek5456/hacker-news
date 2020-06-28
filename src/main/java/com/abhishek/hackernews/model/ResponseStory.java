package com.abhishek.hackernews.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

public class ResponseStory {

	private long id;
	private String title;
	private String url;
	private long score;
	private LocalDateTime timeOfSubmission;
	private String user;

	public ResponseStory() {

	}

	public ResponseStory(long id, String title, String url, long score, long timeOfSubmission, String user) {
		this.id = id;
		this.title = title;
		this.url = url;
		this.score = score;
		this.timeOfSubmission = LocalDateTime.ofInstant(Instant.ofEpochSecond(timeOfSubmission),
				TimeZone.getDefault().toZoneId());
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public LocalDateTime getTimeOfSubmission() {
		return timeOfSubmission;
	}

	public void setTimeOfSubmission(LocalDateTime timeOfSubmission) {
		this.timeOfSubmission = timeOfSubmission;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
