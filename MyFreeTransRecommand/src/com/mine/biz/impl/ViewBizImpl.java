package com.mine.biz.impl;

import java.util.List;

import com.mine.entity.View;

public interface ViewBizImpl {
	public boolean saveView(View view);//
	public boolean updateView(View view);//
	public boolean delView(String pinYin);//
	public View queryView(View view);//
	public View queryView(String pinYin);
	public List<View> queryViewByRegion(String region);
	public List<View> queryAllView();
}
