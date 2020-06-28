package com.abhishek.hackernews.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class ResponseComment {

	private long id;
	private String text;
	private String handle;
	private long years;
	List<ResponseComment> subComments;

	public ResponseComment() {
	}

	public ResponseComment(long id, String text, String handle, long years) {
		this.id = id;
		this.text = text;
		this.handle = handle;
		this.years = LocalDateTime.now().getYear()
				- LocalDateTime.ofInstant(Instant.ofEpochSecond(years), TimeZone.getDefault().toZoneId()).getYear();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public long getYears() {
		return years;
	}

	public void setYears(long years) {
		this.years = years;
	}

	public List<ResponseComment> getSubcomments() {
		return subComments;
	}

	public void setSubcomments(List<ResponseComment> subComments) {
		this.subComments = subComments;
	}

	public void addSubComment(ResponseComment responseComment) {
		if (null == this.subComments) {
			this.subComments = new ArrayList<>();
			this.subComments.add(responseComment);
		} else {
			this.subComments.add(responseComment);
		}
	}
}
