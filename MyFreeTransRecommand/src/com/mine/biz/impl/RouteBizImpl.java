package com.mine.biz.impl;

import java.util.List;

import com.mine.entity.Route;

public interface RouteBizImpl {
	public boolean saveRoute(Route route);//���·��
	public boolean updateRoute(Route route);//����route
	public boolean delRoute(int rid);//ɾ��ָ����·��
	public List<Route> queryRoute(String startPlace);//�ӳ����ز���
	public List<Route> queryRoute(String startPlace, String endPlace);//����վ���յ�վ
	public List<Route> queryRoute(String startPlace, int top);//��������ǰtop��·��
}
