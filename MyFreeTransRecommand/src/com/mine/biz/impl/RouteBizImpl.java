package com.mine.biz.impl;

import java.util.List;

import com.mine.entity.Route;

public interface RouteBizImpl {
	public boolean saveRoute(Route route);//添加路线
	public boolean updateRoute(Route route);//更新route
	public boolean delRoute(int rid);//删除指定的路线
	public List<Route> queryRoute(String startPlace);//从出发地查找
	public List<Route> queryRoute(String startPlace, String endPlace);//出发站和终点站
	public List<Route> queryRoute(String startPlace, int top);//人气最大的前top个路线
}
