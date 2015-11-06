package com.mine.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mine.dao.impl.LogDaoImpl;
import com.mine.entity.Log;

public class LogDao extends BaseDao implements LogDaoImpl{

	@Override
	public boolean saveLog(Log log) {
		String sql = "insert into logSheet(uid, rid, score, vPinYin) values(?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(log.getUid());
		params.add(log.getRid());
		params.add(log.getScore());
		params.add(log.getvPinYin());
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
	public boolean updateLog(Log log) {
		String sql = "update logSheet set score = ? where uid = ? and vPinYin = ? and rid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(log.getScore());
		params.add(log.getUid());
		params.add(log.getvPinYin());
		params.add(log.getRid());

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
	public List<Log> queryLogByUid(int uid) {
		String sql = "select lid, uid, rid, score, vPinYin from logSheet where uid = ?";
		List<Log> lList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		try {
			lList = this.operQuery(sql, params, Log.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lList;
	}

	@Override
	public List<Log> queryLog(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Log> queryLogByRid(int rid) {
		String sql = "select lid, uid, rid, score from logSheet where rid = ?";
		List<Log> lList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(rid);
		try {
			lList = this.operQuery(sql, params, Log.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lList;
	}

	@Override
	public List<Log> queryLog(String startPlace, String endPlace) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Log queryLog(int uid, int rid) {
		List<Log> lList = null;
		String sql = "select lid, uid, rid, score, vPinYin from logSheet where uid = ? and rid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		params.add(rid);
		try {
			lList = this.operQuery(sql, params, Log.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(lList.size() > 0) {
			return lList.get(0);
		}
		return null;
	}

	@Override
	public List<Log> queryLogByVPinYin(String vPinYin) {
		String sql = "select lid, uid, rid, score, vPinYin from logSheet where vPinYin = ?";
		List<Log> lList = null;
		List<Object> params = new ArrayList<Object>();
		params.add(vPinYin);
		try {
			lList = this.operQuery(sql, params, Log.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lList;
	}

}
