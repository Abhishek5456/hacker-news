package com.abhishek.hackernews.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Story implements Comparable<Story> {
	private String by;
	private long descendants;
	private long id;
	private long[] kids;
	private long score;
	private long time;
	private String title;
	private String type;
	private String url;

	public String getBy() {
		return by;
	}

	public void setBy(String value) {
		this.by = value;
	}

	public long getDescendants() {
		return descendants;
	}

	public void setDescendants(long value) {
		this.descendants = value;
	}

	public long getID() {
		return id;
	}

	public void setID(long value) {
		this.id = value;
	}

	public long[] getKids() {
		return kids;
	}

	public void setKids(long[] value) {
		this.kids = value;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long value) {
		this.score = value;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long value) {
		this.time = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String value) {
		this.type = value;
	}


	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Story [by=" + by + ", descendants=" + descendants + ", id=" + id + ", kids=" + Arrays.toString(kids)
				+ ", score=" + score + ", time=" + time + ", title=" + title + ", type=" + type + ", url=" + url + "]";
	}

	@Override
	public int compareTo(Story story) {
		return Long.compare(score, story.score);
	}
}
