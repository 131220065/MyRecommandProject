package com.mine.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mine.dao.impl.ViewDaoImpl;
import com.mine.entity.View;

public class ViewDao extends BaseDao implements ViewDaoImpl{

	@Override
	public boolean saveView(View view) {
		// TODO Auto-generated method stub
		String sql = "insert into views(name, type, payl, payt, timel, timet, hobbyp, suitweathers, suitseasons, suitp, vid, region, lat, lng, abstr, description, star, telephone, attentionName, attentionDesc, openTime, price, url, picUrl, pinYin, url2) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(view.getName());
		params.add(view.getType());
		params.add(view.getPayl());
		params.add(view.getPayt());
		params.add(view.getTimel());
		params.add(view.getTimet());
		params.add(view.getHobbyp());
		params.add(view.getSuitweathers());
		params.add(view.getSuitseasons());
		params.add(view.getSuitp());
		params.add(view.getVid());
		params.add(view.getRegion());
		params.add(view.getLat());
		params.add(view.getLng());
		params.add(view.getAbstr());
		params.add(view.getDescription());
		params.add(view.getStar());
		params.add(view.getTelephone());
		params.add(view.getAttentionName());
		params.add(view.getAttentionDesc());
		params.add(view.getOpenTime());
		params.add(view.getPrice());
		params.add(view.getUrl());
		params.add(view.getPicUrl());
		params.add(view.getPinYin());
		params.add(view.getUrl2());
		boolean ret = false;
		try {
			ret = this.operUpDate(sql, params);
		} catch (SQLException e) {
			ErrorWrite.write(view.toString() + "\n");
		}
		return ret;
	}

	@Override
	public boolean updateView(View view) {
		// TODO Auto-generated method stub
		String sql = "update views set type = ?, payl = ?, payt = ?, timel = ?, timet = ?, hobbyp = ?, suitweathers = ?, suitseasons = ?, suitp = ?, vid = ?, region = ?, lat = ?, lng = ?, name = ?, hanLpScore = ? where pinYin = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(view.getType());
		params.add(view.getPayl());
		params.add(view.getPayt());
		params.add(view.getTimel());
		params.add(view.getTimet());
		params.add(view.getHobbyp());
		params.add(view.getSuitweathers());
		params.add(view.getSuitseasons());
		params.add(view.getSuitp());
		params.add(view.getVid());
		params.add(view.getRegion());
		params.add(view.getLat());
		params.add(view.getLng());
		params.add(view.getName());
		params.add(view.getHanLpScore());
		/*params.add(view.getAbstr());
		params.add(view.getDescription());
		params.add(view.getStar());
		params.add(view.getTelephone());
		params.add(view.getAttentionName());
		params.add(view.getAttentionDesc());
		params.add(view.getOpenTime());
		params.add(view.getPrice());
		params.add(view.getUrl());
		params.add(view.getPicUrl());
		params.add(view.getPinYin());
		params.add(view.getUrl2());*/
		params.add(view.getPinYin());
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
	public boolean delView(String vnamePinYin) {
		// TODO Auto-generated method stub
		String sql = "delete from views where pinYin =  ?";
		List<Object> params = new ArrayList<Object>();
		params.add(vnamePinYin);
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
	public View queryView(View view) {
		// TODO Auto-generated method stub
		List<View> vList = null;
		String sql = "select name, type, payl, payt, timel, timet, hobbyp, suitweathers, suitseasons, suitp, vid, region, lat, lng, abstr, description, star, telephone, attentionName, attentionDesc, openTime, price, url, picUrl, pinYin, url2, hanLpScore from views where name = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(view.getName());
		try {
			vList = this.operQuery(sql, params, View.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(vList.size() > 0) {
			return vList.get(0);
		}
		return null;
	}
	@Override
	public View queryView(String vnamePinYin) {
		List<View> vList = null;
		String sql = "select name, type, payl, payt, timel, timet, hobbyp, suitweathers, suitseasons, suitp, vid, region, lat, lng, hanLpScore from views where pinYin = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(vnamePinYin);
		try {
			vList = this.operQuery(sql, params, View.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(vList.size() > 0) {
			return vList.get(0);
		}
		return null;
	}

	@Override
	public List<View> queryViewByRegion(String region) {
		// TODO Auto-generated method stub
		List<View> vList = null;
		String sql = "select name, type, payl, payt, timel, timet, hobbyp, suitweathers, suitseasons, suitp, vid, region, lat, lng, abstr, description, star, telephone, attentionName, attentionDesc, openTime, price, url, picUrl, pinYin, url2, hanLpScore from views where region like ?";
		List<Object> params = new ArrayList<Object>();
		params.add(region);
		try {
			vList = this.operQuery(sql, params, View.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return vList;
	}

}
