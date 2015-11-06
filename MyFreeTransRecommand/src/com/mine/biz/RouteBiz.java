package com.mine.biz;

import java.util.List;

import com.mine.biz.impl.RouteBizImpl;
import com.mine.dao.RouteDao;
import com.mine.entity.Route;

public class RouteBiz implements RouteBizImpl{
	private RouteDao routeDao = null;
	public RouteBiz() {
		routeDao = new RouteDao();
	}
	@Override
	public boolean saveRoute(Route route) {
		return routeDao.saveRoute(route);
	}

	@Override
	public boolean updateRoute(Route route) {
		return routeDao.updateRoute(route);
	}

	@Override
	public boolean delRoute(int rid) {
		return routeDao.delRoute(rid);
	}

	@Override
	public List<Route> queryRoute(String startPlace) {
		return routeDao.queryRoute(startPlace);
	}

	@Override
	public List<Route> queryRoute(String startPlace, String endPlace) {
		return routeDao.queryRoute(startPlace, endPlace);
	}

	@Override
	public List<Route> queryRoute(String startPlace, int top) {
		return routeDao.queryRoute(startPlace, top);
	}

}
