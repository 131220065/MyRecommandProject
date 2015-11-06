package com.mine.entity;

public class NewInfoNum {
	private int uid;
	private int newRelaInfoNum;
	private int newWebInfoNum;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getNewRelaInfoNum() {
		return newRelaInfoNum;
	}
	public void setNewRelaInfoNum(int newRelaInfoNum) {
		this.newRelaInfoNum = newRelaInfoNum;
	}
	public int getNewWebInfoNum() {
		return newWebInfoNum;
	}
	public void setNewWebInfoNum(int newWebInfoNum) {
		this.newWebInfoNum = newWebInfoNum;
	}
	public NewInfoNum(int uid, int newRelaInfoNum, int newWebInfoNum) {
		super();
		this.uid = uid;
		this.newRelaInfoNum = newRelaInfoNum;
		this.newWebInfoNum = newWebInfoNum;
	}
	public NewInfoNum() {
		super();
	}
	
}
