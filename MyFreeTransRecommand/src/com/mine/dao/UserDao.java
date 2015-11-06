package com.mine.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mine.dao.impl.UserDaoImpl;
import com.mine.entity.Comment;
import com.mine.entity.Mood;
import com.mine.entity.NewInfoNum;
import com.mine.entity.User;
import com.mine.entity.WebInfo;

public class UserDao extends BaseDao implements UserDaoImpl{

	@Override
	public boolean saveUser(User user) {
		String sql = "insert into users(uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getPsd());
		params.add(user.getAge());
		params.add(user.getSex());
		params.add(user.getHobby());
		params.add(user.getVtype());
		params.add(user.getPlace());
		params.add(user.getStudy());
		params.add(user.getJob());
		params.add(user.getIncome());
		params.add(user.getAim());
		params.add(user.getViewp());
		params.add(user.getWeather());
		params.add(user.getSeason());
		params.add(user.getProperty());
		params.add(user.getNickname());
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
	public boolean delUser(int id) {
		String sql = "delete from users where uid =  ?";
		List<Object> params = new ArrayList<Object>();
		params.add(id);
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
	public boolean delUser(String uname) {
		String sql = "delete from users where uname =  ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
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
	public boolean updateUser(User user) {
		String sql = "update users set uname = ?, psd = ?, age = ?, sex = ?, hobby = ?, vtype = ?, place = ?, study = ?, job = ?, income = ?, aim = ?, viewp = ?, weather = ?, season = ?, property = ?, nickname = ? where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getPsd());
		params.add(user.getAge());
		params.add(user.getSex());
		params.add(user.getHobby());
		params.add(user.getVtype());
		params.add(user.getPlace());
		params.add(user.getStudy());
		params.add(user.getJob());
		params.add(user.getIncome());
		params.add(user.getAim());
		params.add(user.getViewp());
		params.add(user.getWeather());
		params.add(user.getSeason());
		params.add(user.getProperty());
		params.add(user.getNickname());
		params.add(user.getUid());
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
	public User queryUser(User user) {
		List<User> uList = null;
		String sql = "select uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where uname = ? and psd = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user.getUname());
		params.add(user.getPsd());
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

	@Override
	public User queryUser(String uname) {
		List<User> uList = null;
		String sql = "select uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where uname = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

	@Override
	public User queryUser(int uid) {
		List<User> uList = null;
		String sql = "select uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0) {
			return uList.get(0);
		}
		return null;
	}

	@Override
	public List<User> queryUserByProperty(String property) {
		List<User> uList = null;
		String sql = "select uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where property = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(property);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0) {
			return uList;
		}
		return null;
	}

	@Override
	public boolean isExistUser(String uname) {
		List<User> uList = null;
		String sql = "select * from users where uname = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0){
			return true;
		}
		return false;
	}

	@Override
	public NewInfoNum getNewInfoNum(int uid) {
		List<NewInfoNum> nList = null;
		String sql = "select uid, newWebInfo, newRelaInfo from users where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		try {
			nList = this.operQuery(sql, params, NewInfoNum.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nList.size() > 0) {
			return nList.get(0);
		}
		return null;
	}

	@Override
	public void addNewWebInfo(int uid) {
		String sql = "update users set newWebInfo = newWebInfo + 1 where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addNewRelaInfo(int uid) {
		String sql = "update users set newRelaInfo = newRelaInfo + 1 where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void clearNewWebInfo(int uid) {
		String sql = "update users set newWebInfo = 0 where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void clearNewRelaInfo(int uid) {
		String sql = "update users set newRelaInfo = 0 where uid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean makeFriends(String user1, String user2, int type) {
		String sql = "insert into friends(user1, user2, type) values(?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(user1);
		params.add(user2);
		params.add(type);
		
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
	public void removeOneFriend(String user1, String user2) {
		String sql = "delete from friends where user1 = ? and user2 = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(user1);
		params.add(user2);
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean isFriend(String user1, String user2) {
		List<User> uList = null;
		String sql = "select users.uname from friends, users where user1 = ? and user2 = ? and users.uname = user2";
		List<Object> params = new ArrayList<Object>();
		params.add(user1);
		params.add(user2);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(uList.size() > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getMyFriends(String uname) {
		List<User> uList = null;
		String sql = "select users.uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from friends, users where user1 = ? and users.uname = user2";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uList;
	}

	@Override
	public List<User> getMyNBFriends(String uname) {
		List<User> uList = null;
		String sql = "select users.uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where exists(select * from friends where user1 = ? and user2 = users.uname) and not exists(select * from friends where user1 = users.uname and user2 = ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(uname);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uList;
	}

	@Override
	public List<User> getMyNotFriends(String uname) {
		List<User> uList = null;
		String sql = "select users.uid, uname, psd, age, sex, hobby, vtype, place, study, job, income, aim, viewp, weather, season, property, nickname from users where exists(select * from friends where user1 = users.uname and user2 = ?) and not exists(select * from friends where user1 = ? and user2 = users.uname)";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(uname);
		try {
			uList = this.operQuery(sql, params, User.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uList;
	}

	@Override
	public List<Mood> getMoodsOfFriends(String uname) {
		List<Mood> mList = null;
		String sql = "select * from travelMood where author in(select user2 from friends where user1 = ? order by publishTime desc)";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		try {
			mList = this.operQuery(sql, params, Mood.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
		
	}

	@Override
	public List<Mood> getMoodsOfView(String vPinyin) {
		List<Mood> mList = null;
		String sql = "select * from travelMood where vPinyin = ? order by publishTime desc";
		List<Object> params = new ArrayList<Object>();
		params.add(vPinyin);
		try {
			mList = this.operQuery(sql, params, Mood.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public boolean publishMood(String author, String content,
			String publishTime, String vPinyin, int type, String picUrls) {
		String sql = "insert into travelMood(author, content, publishTime, type, vPinyin, zNum, picUrls) values(?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(author);
		params.add(content);
		params.add(publishTime);
		params.add(type);
		params.add(vPinyin);
		params.add(0);
		params.add(picUrls);
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
	public Mood getOneMood(int mid) {
		List<Mood> mList = null;
		String sql = "select * from travelMood where mid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(mid);
		try {
			mList = this.operQuery(sql, params, Mood.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(mList.size() > 0){
			return mList.get(0);
		}
		return null;
	}

	@Override
	public List<Mood> getMoodsOfWho(String who) {
		List<Mood> mList = null;
		String sql = "select * from travelMood where author = ? order by publishTime desc";
		List<Object> params = new ArrayList<Object>();
		params.add(who);
		try {
			mList = this.operQuery(sql, params, Mood.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public List<Mood> getTopMoods() {
		List<Mood> mList = null;
		String sql = "select * from travelMood where zNum > 10 order by zNum desc";
		List<Object> params = new ArrayList<Object>();
		try {
			mList = this.operQuery(sql, params, Mood.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mList;
	}

	@Override
	public boolean publishComment(String author, String content, int mid,
			String publishTime, int type, int replyCid, int pCid) {
		String sql = "insert into comment(author, content, mid, publishTime, type, replyCid, pCid) values(?, ?, ?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(author);
		params.add(content);
		params.add(mid);
		params.add(publishTime);
		params.add(type);
		params.add(replyCid);
		params.add(pCid);
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
	public Comment getOneComment(int cid) {
		List<Comment> cList = null;
		String sql = "select * from comment where cid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(cid);
		try {
			cList = this.operQuery(sql, params, Comment.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cList.size() > 0){
			return cList.get(0);
		}
		return null;
	}

	@Override
	public List<Comment> getCommentOfMid(int mid) {
		List<Comment> cList = null;
		String sql = "select * from comment where mid = ? and type = 0";
		List<Object> params = new ArrayList<Object>();
		params.add(mid);
		try {
			cList = this.operQuery(sql, params, Comment.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Comment> getReplyCommentOfPC(int pCid) {
		List<Comment> cList = null;
		String sql = "select * from comment where pCid = ? and type = 1";
		List<Object> params = new ArrayList<Object>();
		params.add(pCid);
		try {
			cList = this.operQuery(sql, params, Comment.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public List<Comment> getRelaComment(String uname) {
		List<Comment> cList = null;
		String sql = "select * from comment where comment.mid in(select mid from travelMood where author = ?) or comment.mid in(select mid from comment where author = ?) order by publishTime desc";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(uname);
		try {
			cList = this.operQuery(sql, params, Comment.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cList;
	}

	@Override
	public boolean publishWebInfo(String author, String toWho, String content,
			String publishTime, int type) {
		String sql = "insert into webInfo(author, toWho, content, publishTime, type) values(?, ?, ?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(author);
		params.add(toWho);
		params.add(content);
		params.add(publishTime);
		params.add(type);
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
	public List<WebInfo> getRelaWebInfo(String uname) {
		List<WebInfo> wList = null;
		String sql = "select * from webInfo where author = ? or toWho = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(uname);
		params.add(uname);
		try {
			wList = this.operQuery(sql, params, WebInfo.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wList;
	}

	@Override
	public boolean addDianZanLog(int uid, int mid, int type) {
		String sql = "insert into zan(uid, mid, type) values(?, ?, ?)";
		List<Object> params = new ArrayList<Object>();
		params.add(uid);
		params.add(mid);
		params.add(type);
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
	public void addZNumOfMid(int mid) {
		String sql = "update travelMood set zNum = zNum + 1 where mid = ?";
		List<Object> params = new ArrayList<Object>();
		params.add(mid);
		try {
			this.operUpDate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
