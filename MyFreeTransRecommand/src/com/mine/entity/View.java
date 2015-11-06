package com.mine.entity;

public class View {
	@Override
	public String toString() {
		return "View [name=" + name + ", type=" + type + ", payl=" + payl
				+ ", payt=" + payt + ", timel=" + timel + ", timet=" + timet
				+ ", hobbyp=" + hobbyp + ", suitweathers=" + suitweathers
				+ ", suitseasons=" + suitseasons + ", suitp=" + suitp
				+ ", vid=" + vid + ", region=" + region + ", lat=" + lat
				+ ", lng=" + lng + ", abstr=" + abstr + ", description="
				+ description + ", star=" + star + ", telephone=" + telephone
				+ ", attentionName=" + attentionName + ", attentionDesc="
				+ attentionDesc + ", openTime=" + openTime + ", price=" + price
				+ ", url=" + url + ", picUrl=" + picUrl + ", pinYin=" + pinYin
				+ ", url2=" + url2 + "]";
	}
	private String name;
	private int type;
	private double payl;
	private double payt;
	private double timel;
	private double timet;
	private int hobbyp;
	private int suitweathers;
	private int suitseasons;
	private int suitp;
	
	private String vid;
	private String region;
	private double lat;//纬度
	private double lng;//经度
	
	private String abstr;
	private String description;
	private int star;
	private String telephone;
	private String attentionName;
	private String attentionDesc;
	private String openTime;
	private String price;
	private String url;
	private String picUrl;
	private String pinYin;
	
	private String url2;
	private String hanLpScore;
	
	private float referScore;
	private int mark;
	
	public float getReferScore() {
		return referScore;
	}
	public void setReferScore(float referScore) {
		this.referScore = referScore;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	
	public String getHanLpScore() {
		return hanLpScore;
	}
	public void setHanLpScore(String hanLpScore) {
		this.hanLpScore = hanLpScore;
	}
	public String getUrl2() {
		return url2;
	}
	public void setUrl2(String url2) {
		this.url2 = url2;
	}
	public String getAbstr() {
		return abstr;
	}
	public void setAbstr(String abstr) {
		this.abstr = abstr;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAttentionName() {
		return attentionName;
	}
	public void setAttentionName(String attentionName) {
		this.attentionName = attentionName;
	}
	public String getAttentionDesc() {
		return attentionDesc;
	}
	public void setAttentionDesc(String attentionDesc) {
		this.attentionDesc = attentionDesc;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getPinYin() {
		return pinYin;
	}
	public void setPinYin(String pinYin) {
		this.pinYin = pinYin;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getPayl() {
		return payl;
	}
	public void setPayl(double payl) {
		this.payl = payl;
	}
	public double getPayt() {
		return payt;
	}
	public void setPayt(double payt) {
		this.payt = payt;
	}
	public double getTimel() {
		return timel;
	}
	public void setTimel(double timel) {
		this.timel = timel;
	}
	public double getTimet() {
		return timet;
	}
	public void setTimet(double timet) {
		this.timet = timet;
	}
	public int getHobbyp() {
		return hobbyp;
	}
	public void setHobbyp(int hobbyp) {
		this.hobbyp = hobbyp;
	}
	public int getSuitweathers() {
		return suitweathers;
	}
	public void setSuitweathers(int suitweathers) {
		this.suitweathers = suitweathers;
	}
	public int getSuitseasons() {
		return suitseasons;
	}
	public void setSuitseasons(int suitseasons) {
		this.suitseasons = suitseasons;
	}
	public int getSuitp() {
		return suitp;
	}
	public void setSuitp(int suitp) {
		this.suitp = suitp;
	}
	public View() {
		super();
	}
	public View(String name, int type, double payl, double payt, double timel,
			double timet, int hobbyp, int suitweathers, int suitseasons,
			int suitp, String vid, String region, double lat, double lng) {
		super();
		this.name = name;
		this.type = type;
		this.payl = payl;
		this.payt = payt;
		this.timel = timel;
		this.timet = timet;
		this.hobbyp = hobbyp;
		this.suitweathers = suitweathers;
		this.suitseasons = suitseasons;
		this.suitp = suitp;
		this.vid = vid;
		this.region = region;
		this.lat = lat;
		this.lng = lng;
	}
	
	
}
