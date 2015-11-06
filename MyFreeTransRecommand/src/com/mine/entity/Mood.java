package com.mine.entity;

public class Mood {
	private int mid;
	private String author;
	private String content;
	private String publishTime;
	private int type;
	private String vPinyin;
	private int zNum;
	private String picUrls;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public String getvPinyin() {
		return vPinyin;
	}
	public void setvPinyin(String vPinyin) {
		this.vPinyin = vPinyin;
	}
	public int getzNum() {
		return zNum;
	}
	public void setzNum(int zNum) {
		this.zNum = zNum;
	}
	public String getPicUrls() {
		return picUrls;
	}
	public void setPicUrls(String picUrls) {
		this.picUrls = picUrls;
	}
	public Mood(int mid, String author, String content, String publishTime,
			int type, String vPinyin, int zNum, String picUrls) {
		super();
		this.mid = mid;
		this.author = author;
		this.content = content;
		this.publishTime = publishTime;
		this.type = type;
		this.vPinyin = vPinyin;
		this.zNum = zNum;
		this.picUrls = picUrls;
	}
	public Mood() {
		super();
	}
	
}
