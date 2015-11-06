package com.mine.entity;

public class Route {
	private int rid;
	private String startPlace;
	private String endPlace;
	private String route;
	private double timel;
	private double timet;
	private double payl;
	private double payt;
	private int suitp;
	private int suitweathers;
	private int suitseasons;
	private int numv;
	private int nump;
	private double mark;
	private int property;
	
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
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
	public int getSuitp() {
		return suitp;
	}
	public void setSuitp(int suitp) {
		this.suitp = suitp;
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
	public int getNumv() {
		return numv;
	}
	public void setNumv(int numv) {
		this.numv = numv;
	}
	public int getNump() {
		return nump;
	}
	public void setNump(int nump) {
		this.nump = nump;
	}
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}
	public int getProperty() {
		return property;
	}
	public void setProperty(int property) {
		this.property = property;
	}
	
	
	
	
	public Route() {
		
	}
	public Route(int rid, String startPlace, String endPlace, String route,
			double timel, double timet, double payl, double payt, int suitp,
			int suitweathers, int suitseasons, int numv, int nump, double mark,
			int property) {
		super();
		this.rid = rid;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.route = route;
		this.timel = timel;
		this.timet = timet;
		this.payl = payl;
		this.payt = payt;
		this.suitp = suitp;
		this.suitweathers = suitweathers;
		this.suitseasons = suitseasons;
		this.numv = numv;
		this.nump = nump;
		this.mark = mark;
		this.property = property;
	}
	
}
