package com.mine.refer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mine.biz.RouteBiz;
import com.mine.biz.ViewBiz;
import com.mine.entity.Route;
import com.mine.entity.User;
import com.mine.entity.View;

public class Reference {
	public static void sortByReferScore(User user, List<Route> routeList) {
		for(int i = 0; i < routeList.size(); i++) {
			float temp = Compute.inferScore(user, routeList.get(i));
			float temp2 = Compute.inferScoreNew(user, routeList.get(i));
			routeList.get(i).setMark( ( (temp > 5 ? temp : temp2) + temp2)  / 2);
			//routeList.get(i).setMark( temp);
		}
		Collections.sort(routeList, new MyComparator());
	}
	public static List<Route> refer(User user, String startPlace) {
		RouteBiz routeBiz = new RouteBiz();
		List<Route> routeList = routeBiz.queryRoute(startPlace);
		sortByReferScore(user, routeList);
		return routeList;
	}
	public static List<Route> refer(User user, String startPlace, String endPlace) {
		RouteBiz routeBiz = new RouteBiz();
		List<Route> routeList = routeBiz.queryRoute(startPlace, endPlace);
		sortByReferScore(user, routeList);
		return routeList;
	}
	private static class MyComparator implements Comparator<Route> {

		@Override
		public int compare(Route o1, Route o2) {
			if(o1.getMark() < o2.getMark())
				return 1;
			else if(o1.getMark() > o2.getMark())
				return -1;
			else
				return 0;
		}
	}
	
	public static List<View> referView(User user, String region) {
		System.out.println(region);
		List<View> viewList = ViewMap.get(region);
		Compute.setSort(user, viewList);
		return viewList;
	}
}
