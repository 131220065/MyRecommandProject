package com.mine.biz.impl;

import java.util.List;

import com.mine.entity.Log;

public interface LogBizImpl {
	public boolean saveLog(Log log);//�����¼
	public boolean updateLog(Log log);//���¼�¼
	public List<Log> queryLogByUid(int uid);//ͨ���û���Ų�ѯ
	public List<Log> queryLog(String uname);//ͨ���û����ѯ��¼
	public List<Log> queryLogByRid(int rid);//ͨ��·����Ų�ѯ
	public List<Log> queryLog(String startPlace, String endPlace);//ͨ��·�߾����ѯ
	public Log queryLog(int uid, int rid);//ͨ���û���ź�·����Ų�ѯ
	public List<Log> queryLogByVPinYin(String vPinYin);
}
