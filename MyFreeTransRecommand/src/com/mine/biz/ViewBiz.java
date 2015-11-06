package com.mine.biz;

import java.util.List;

import com.mine.biz.impl.ViewBizImpl;
import com.mine.dao.ViewDao;
import com.mine.entity.View;

public class ViewBiz implements ViewBizImpl{
	private ViewDao viewDao = null;
	public ViewBiz() {
		viewDao = new ViewDao();
	}
	@Override
	public boolean saveView(View view) {
		// TODO Auto-generated method stub
		return viewDao.saveView(view);
	}

	@Override
	public boolean updateView(View view) {
		// TODO Auto-generated method stub
		return viewDao.updateView(view);
	}

	@Override
	public boolean delView(String pinYin) {
		// TODO Auto-generated method stub
		return viewDao.delView(pinYin);
	}

	@Override
	public View queryView(View view) {
		// TODO Auto-generated method stub
		return viewDao.queryView(view);
	}

	@Override
	public View queryView(String pinYin) {
		// TODO Auto-generated method stub
		return viewDao.queryView(pinYin);
	}
	@Override
	public List<View> queryViewByRegion(String region) {
		// TODO Auto-generated method stub
		return viewDao.queryViewByRegion("%___" + region + "%");
	}
	@Override
	public List<View> queryAllView() {
		// TODO Auto-generated method stub
		return viewDao.queryViewByRegion("%");
	}

}
