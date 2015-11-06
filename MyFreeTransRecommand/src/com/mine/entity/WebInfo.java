package com.mine.entity;

public class WebInfo {
	private int wid;
	private String author;
	private String toWho;
	private String content;
	private String publishTime;
	private int type;
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getToWho() {
		return toWho;
	}
	public void setToWho(String toWho) {
		this.toWho = toWho;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public WebInfo(int wid, String author, String toWho, String content,
			String publishTime, int type) {
		super();
		this.wid = wid;
		this.author = author;
		this.toWho = toWho;
		this.content = content;
		this.publishTime = publishTime;
		this.type = type;
	}
	public WebInfo() {
		super();
	}
	
}
