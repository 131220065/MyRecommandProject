package com.mine.entity;

public class Log {
	private int lid;
	private int uid;
	private int rid;
	private double score;
	private String vPinYin;
	
	public String getvPinYin() {
		return vPinYin;
	}
	public void setvPinYin(String vPinYin) {
		this.vPinYin = vPinYin;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public double getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public Log() {
		
	}
	public Log(int lid, int uid, int rid, double score, String vPinYin) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.rid = rid;
		this.score = score;
		this.vPinYin = vPinYin;
	}

	
}
