package com.mine.biz;

import java.util.List;

import com.mine.biz.impl.LogBizImpl;
import com.mine.dao.LogDao;
import com.mine.entity.Log;

public class LogBiz implements LogBizImpl{
	private LogDao logDao = null;
	
	public LogBiz() {
		logDao = new LogDao();
	}
	@Override
	public boolean saveLog(Log log) {
		return logDao.saveLog(log);
	}

	@Override
	public boolean updateLog(Log log) {
		return logDao.updateLog(log);
	}

	@Override
	public List<Log> queryLogByUid(int uid) {
		return logDao.queryLogByUid(uid);
	}

	@Override
	public List<Log> queryLog(String uname) {
		return logDao.queryLog(uname);
	}

	@Override
	public List<Log> queryLogByRid(int rid) {
		return logDao.queryLogByRid(rid);
	}

	@Override
	public List<Log> queryLog(String startPlace, String endPlace) {
		return logDao.queryLog(startPlace, endPlace);
	}

	@Override
	public Log queryLog(int uid, int rid) {
		return logDao.queryLog(uid, rid);
	}
	@Override
	public List<Log> queryLogByVPinYin(String vPinYin) {
		return logDao.queryLogByVPinYin(vPinYin);
	}
	
}
