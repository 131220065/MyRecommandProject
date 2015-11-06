package com.mine.entity;


public class User {
	private int uid = 0;
	private String uname = null;
	private String psd = null;
	private int age;
	private int sex;
	private int hobby;
	private int vtype;
	private int place;
	private int study;
	private int job;
	private int income;
	private int aim;
	private int viewp;
	private int weather;
	private int season;
	private int property;
	private String nickname;
	
	

	
	public User(int uid, String uname, String psd, int age, int sex, int hobby,
			int vtype, int place, int study, int job, int income, int aim,
			int viewp, int weather, int season, int property, String nickname) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.psd = psd;
		this.age = age;
		this.sex = sex;
		this.hobby = hobby;
		this.vtype = vtype;
		this.place = place;
		this.study = study;
		this.job = job;
		this.income = income;
		this.aim = aim;
		this.viewp = viewp;
		this.weather = weather;
		this.season = season;
		this.property = property;
		this.nickname = nickname;
	}




	public String getNickname() {
		return nickname;
	}




	public void setNickname(String nickname) {
		this.nickname = nickname;
	}




	public int getUid() {
		return uid;
	}




	public void setUid(int uid) {
		this.uid = uid;
	}




	public String getUname() {
		return uname;
	}




	public void setUname(String uname) {
		this.uname = uname;
	}




	public String getPsd() {
		return psd;
	}




	public void setPsd(String psd) {
		this.psd = psd;
	}




	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
	}




	public int getSex() {
		return sex;
	}




	public void setSex(int sex) {
		this.sex = sex;
	}




	public int getHobby() {
		return hobby;
	}




	public void setHobby(int hobby) {
		this.hobby = hobby;
	}




	public int getVtype() {
		return vtype;
	}




	public void setVtype(int vtype) {
		this.vtype = vtype;
	}




	public int getPlace() {
		return place;
	}




	public void setPlace(int place) {
		this.place = place;
	}




	public int getStudy() {
		return study;
	}




	public void setStudy(int study) {
		this.study = study;
	}




	public int getJob() {
		return job;
	}




	public void setJob(int job) {
		this.job = job;
	}




	public int getIncome() {
		return income;
	}




	public void setIncome(int income) {
		this.income = income;
	}




	public int getAim() {
		return aim;
	}




	public void setAim(int aim) {
		this.aim = aim;
	}




	public int getViewp() {
		return viewp;
	}




	public void setViewp(int viewp) {
		this.viewp = viewp;
	}




	public int getWeather() {
		return weather;
	}




	public void setWeather(int weather) {
		this.weather = weather;
	}




	public int getSeason() {
		return season;
	}




	public void setSeason(int season) {
		this.season = season;
	}




	public int getProperty() {
		return property;
	}




	public void setProperty(int property) {
		this.property = property;
	}




	public User(int uid, String uname, String psd, int age, int sex, int hobby,
			int vtype, int place, int study, int job, int income, int aim,
			int viewp, int weather, int season, int property) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.psd = psd;
		this.age = age;
		this.sex = sex;
		this.hobby = hobby;
		this.vtype = vtype;
		this.place = place;
		this.study = study;
		this.job = job;
		this.income = income;
		this.aim = aim;
		this.viewp = viewp;
		this.weather = weather;
		this.season = season;
		this.property = property;
	}




	public User() {
		super();
	}
	
}
