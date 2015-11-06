package com.mine.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mine.dao.impl.RouteDaoImpl;
import com.mine.entity.Route;

public class RouteDao extends BaseDao implements RouteDaoImpl{

	@Override
	public boolean saveRoute(Route route) {
		String sql = "insert into routes(startPlace, endPlace, route, timel, timet, payl, payt, suitp, suitweathers, suitseasons, numv, nump, mark, property) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(route.getStartPlace());
		params.add(route.getEndPlace());
		params.add(route.getRoute());
		params.add(route.getTimel());
		params.add(route.getTimet());
		params.add(route.getPayl());
		params.add(route.getPayt());
		params.add(route.getSuitp());
		params.add(route.getSuitweathers());
		params.add(route.getSuitseasons());
		params.add(route.getNumv());
		params.add(route.getNump());
		params.add(route.getMark());
		params.add(route.getProperty());
		
		
		boolean ret = false;
		try {
			ret = this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean updateRoute(Route route) {
		String sql = "update routes set startPlace = ?, endPlace = ?, route = ?, timel = ?, timet = ?, payl = ?, payt = ?, suitp = ?, suitweathers = ?, suitseasons = ?, numv = ?, nump = ?, mark = ?, property = ? where rid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(route.getStartPlace());
		params.add(route.getEndPlace());
		params.add(route.getRoute());
		params.add(route.getTimel());
		params.add(route.getTimet());
		params.add(route.getPayl());
		params.add(route.getPayt());
		params.add(route.getSuitp());
		params.add(route.getSuitweathers());
		params.add(route.getSuitseasons());
		params.add(route.getNumv());
		params.add(route.getNump());
		params.add(route.getMark());
		params.add(route.getProperty());
		boolean ret = false;
		try {
			ret = this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public boolean delRoute(int rid) {
		String sql = "delete from routes where rid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(rid);
		boolean ret = false;
		try {
			ret = this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public List<Route> queryRoute(String startPlace) {
		String sql = "select rid, startPlace, endPlace, route, timel, timet, payl, payt, suitp, suitweathers, suitseasons, numv, nump, mark, property from routes where startPlace = ?";
		List<Route> rList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(startPlace);
		try {
			rList = this.operQuery(sql, params, Route.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public List<Route> queryRoute(String startPlace, String endPlace) {
		String sql = "select rid, startPlace, endPlace, route, timel, timet, payl, payt, suitp, suitweathers, suitseasons, numv, nump, mark, property from routes where startPlace = ? and endPlace = ?";
		List<Route> rList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(startPlace);
		params.add(endPlace);
		try {
			rList = this.operQuery(sql, params, Route.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}

	@Override
	public List<Route> queryRoute(String startPlace, int top) {
		String sql = "select rid, startPlace, endPlace, route, timel, timet, payl, payt, suitp, suitweathers, suitseasons, numv, nump, mark, property from routes order by nump desc limit " + top + " from where startPlace = ?";
		List<Route> rList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(startPlace);
		try {
			rList = this.operQuery(sql, params, Route.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rList;
	}

}
