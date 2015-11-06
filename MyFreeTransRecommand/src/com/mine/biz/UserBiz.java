package com.mine.biz;

import java.util.List;

import com.mine.biz.impl.UserBizImpl;
import com.mine.dao.UserDao;
import com.mine.dao.ViewDao;
import com.mine.entity.Comment;
import com.mine.entity.Mood;
import com.mine.entity.NewInfoNum;
import com.mine.entity.User;
import com.mine.entity.WebInfo;

public class UserBiz implements UserBizImpl{
	private UserDao userDao = null;
	
	public UserBiz() {
		userDao = new UserDao();
	}
	@Override
	public User login(User user) {
		return userDao.queryUser(user);
	}

	@Override
	public int registerUser(User user) {
		if(userDao.queryUser(user.getUname()) != null) {
			return 1;//���û����Ѿ�����
		} else {
			boolean res = userDao.saveUser(user);
			if(res) {
				return 2;//ע��ɹ�
			} else {
				return 3;//ע��ʧ��
			}
		}
	}
	@Override
	public User queryUser(int uid) {
		return userDao.queryUser(uid);
	}
	@Override
	public User queryUser(String uname) {
		return userDao.queryUser(uname);
	}
	@Override
	public boolean isExistUser(String uname) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public NewInfoNum getNewInfoNum(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public void addNewWebInfo(int uid) {
		// TODO Auto-generated method stub
		userDao.addNewWebInfo(uid);
	}
	@Override
	public void addNewRelaInfo(int uid) {
		userDao.addNewRelaInfo(uid);
		
	}
	@Override
	public void clearNewWebInfo(int uid) {
		userDao.clearNewWebInfo(uid);
		
	}
	@Override
	public void clearNewRelaInfo(int uid) {
		userDao.clearNewRelaInfo(uid);
		
	}
	@Override
	public boolean makeFriends(String user1, String user2, int type) {
		return userDao.makeFriends(user1, user2, type);
	}
	@Override
	public void removeOneFriend(String user1, String user2) {
		userDao.removeOneFriend(user1, user2);
		
	}
	@Override
	public boolean isFriend(String user1, String user2) {
		return userDao.isFriend(user1, user2);
	}
	@Override
	public List<User> getMyFriends(String uname) {
		return userDao.getMyFriends(uname);
	}
	@Override
	public List<User> getMyNBFriends(String uname) {
		return userDao.getMyNBFriends(uname);
	}
	@Override
	public List<User> getMyNotFriends(String uname) {
		return userDao.getMyNotFriends(uname);
	}
	@Override
	public List<Mood> getMoodsOfFriends(String uname) {
		return userDao.getMoodsOfFriends(uname);
	}
	@Override
	public List<Mood> getMoodsOfView(String vPinyin) {
		return userDao.getMoodsOfView(vPinyin);
	}
	@Override
	public boolean publishMood(String author, String content,
			String publishTime, String vPinyin, int type, String picUrls) {
		return userDao.publishMood(author, content, publishTime, vPinyin, type, picUrls);
	}
	@Override
	public Mood getOneMood(int mid) {
		return userDao.getOneMood(mid);
	}
	@Override
	public List<Mood> getMoodsOfWho(String who) {
		return userDao.getMoodsOfWho(who);
	}
	@Override
	public List<Mood> getTopMoods() {
		return userDao.getTopMoods();
	}
	@Override
	public boolean publishComment(String author, String content, int mid,
			String publishTime, int type, int replyCid, int pCid) {
		return userDao.publishComment(author, content, mid, publishTime, type, replyCid, pCid);
	}
	@Override
	public Comment getOneComment(int cid) {
		return userDao.getOneComment(cid);
	}
	@Override
	public List<Comment> getCommentOfMid(int mid) {
		return userDao.getCommentOfMid(mid);
	}
	@Override
	public List<Comment> getReplyCommentOfPC(int pCid) {
		return userDao.getReplyCommentOfPC(pCid);
	}
	@Override
	public List<Comment> getRelaComment(String uname) {
		return userDao.getRelaComment(uname);
	}
	@Override
	public boolean publishWebInfo(String author, String toWho, String content,
			String publishTime, int type) {
		return userDao.publishWebInfo(author, toWho, content, publishTime, type);
	}
	@Override
	public List<WebInfo> getRelaWebInfo(String uname) {
		return userDao.getRelaWebInfo(uname);
	}
	@Override
	public boolean dianZan(int uid, int mid, int type) {
		userDao.addZNumOfMid(mid);
		return userDao.addDianZanLog(uid, mid, type);
		
	}

}
