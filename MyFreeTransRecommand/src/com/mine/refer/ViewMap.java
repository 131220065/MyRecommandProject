package com.mine.refer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mine.biz.ViewBiz;
import com.mine.entity.View;

public class ViewMap {
	private static Map<String, List<View>> viewMap = new HashMap<String, List<View>>();
	private static ViewBiz viewBiz = new ViewBiz();
	public static List<View> get(String region) {
		List<View> vList;
		if(!viewMap.containsKey(region)) {
			vList = viewBiz.queryViewByRegion(region);
			if(vList == null)
				return null;
			viewMap.put(region, vList);
		} else {
			vList = viewMap.get(region);
		}
		List<View> vTempList = new ArrayList<View>();
		for(View view : vList) {
			vTempList.add(view);
		}
		return vTempList;
	}
}
