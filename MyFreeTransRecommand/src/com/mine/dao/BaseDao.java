package com.mine.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ����ݿ⽨������
 * @author Hzq
 *������ݿ����Ӷ���
 */
public class BaseDao {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URL = "jdbc:sqlite:data\\FreeTransData";
	//private static final String URL = "jdbc:sqlite:d:\\JavaStudy\\SqliteData\\FreeTransData";
	public Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(URL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * �ͷ���Ӧ����Դ
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �˷��������ɾ�Ĳ���
	 * @param sql
	 * @param params
	 * @return true of false
	 * @throws SQLException 
	 */
	public boolean operUpDate(String sql, List<Object> params) throws SQLException {
		int res = 0;//Ӱ�������
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = getConn();//������ݿ�����
		try {
			pstmt = conn.prepareStatement(sql);//װ��sql���
			if(params != null) {
				//�����У�����ִ��֮ǰ�ѣ�ռλ���滻��
				for(int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new SQLException();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return res > 0 ? true : false;
	}
	
	/**
	 * ʹ�÷��ͷ����ͷ�����ƽ��з�װ
	 * @throws Exception
	 * @throws {@link InstantiationException}
	 */
	public <T> List<T> operQuery(String sql, List<Object> params, Class<T> cls) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<T> data = new ArrayList<T>();
		try {
			conn = getConn();//������ݿ�����
			pstmt = conn.prepareStatement(sql);//װ��sql���
			if(params != null) {
				//�����У�����ִ��֮ǰ�ѣ�ռλ���滻��
				for(int i = 0; i < params.size(); i++) {
					pstmt.setObject(i + 1, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			//�Ѳ�ѯ�����ļ�¼��װ�ɶ�Ӧ��ʵ�������
			ResultSetMetaData rsd = rs.getMetaData();//�õ���¼��Ԫ����ݶ���
			//ͨ��˶�����Եõ���Ľṹ,�����������еĸ����е��������
			while(rs.next()) {
				T m = cls.newInstance();
				for(int i = 0; i < rsd.getColumnCount(); i++) {
					String col_name = rsd.getColumnName(i + 1);//�������
					Object value = rs.getObject(col_name);//��������Ӧ��ֵ
					Field field = cls.getDeclaredField(col_name);
					field.setAccessible(true);//������˽���������ÿɷ���Ȩ
					field.set(m, value);//������˽�����Ը�ֵ
				}
				data.add(m);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return data;
	}
}
