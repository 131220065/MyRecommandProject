package com.mine.dao.impl;

import java.util.List;

import com.mine.entity.Route;

public interface RouteDaoImpl {
	public boolean saveRoute(Route route);//
	public boolean updateRoute(Route route);//
	public boolean delRoute(int rid);//
	public List<Route> queryRoute(String startPlace);//
	public List<Route> queryRoute(String startPlace, String endPlace);//
	public List<Route> queryRoute(String startPlace, int top);//
}
