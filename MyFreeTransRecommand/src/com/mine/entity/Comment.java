package com.mine.entity;

public class Comment {
	private int cid;
	private String author;
	private int mid;
	private String content;
	private String publishTime;
	private int type;
	private int replyCid;
	private int pCid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
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
	public int getReplyCid() {
		return replyCid;
	}
	public void setReplyCid(int replyCid) {
		this.replyCid = replyCid;
	}
	public int getpCid() {
		return pCid;
	}
	public void setpCid(int pCid) {
		this.pCid = pCid;
	}
	public Comment(int cid, String author, int mid, String content,
			String publishTime, int type, int replyCid, int pCid) {
		super();
		this.cid = cid;
		this.author = author;
		this.mid = mid;
		this.content = content;
		this.publishTime = publishTime;
		this.type = type;
		this.replyCid = replyCid;
		this.pCid = pCid;
	}
	public Comment() {
		super();
	}
	
}
