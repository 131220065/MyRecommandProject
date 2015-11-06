package com.mine.dao.impl;

import java.util.List;

import com.mine.entity.View;

public interface ViewDaoImpl {
	public boolean saveView(View view);//
	public boolean updateView(View view);//
	public boolean delView(String vnamePinYin);//
	public View queryView(View view);//
	public View queryView(String vnamePinYin);
	public List<View> queryViewByRegion(String region);
}
