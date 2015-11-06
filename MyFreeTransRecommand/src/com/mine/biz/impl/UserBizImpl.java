package com.mine.biz.impl;

import java.util.List;

import com.mine.entity.Comment;
import com.mine.entity.Mood;
import com.mine.entity.NewInfoNum;
import com.mine.entity.User;
import com.mine.entity.WebInfo;

public interface UserBizImpl {
	public User login(User user);//�û���¼
	public int registerUser(User user);//ע���û�
	public User queryUser(int uid);//����û����ѯ�û�
	public User queryUser(String uname);
	
	public boolean isExistUser(String uname);
	public NewInfoNum getNewInfoNum(int uid);//返回新消息的个数
	public void addNewWebInfo(int uid);//增加新站内信个数
	public void addNewRelaInfo(int uid);//增加新与我相关个数
	public void clearNewWebInfo(int uid);//清零新站内信个数
	public void clearNewRelaInfo(int uid);//清零新与我相关个数
	public boolean makeFriends(String user1, String user2, int type);//加为好友
	public void removeOneFriend(String user1, String user2);
	public boolean isFriend(String user1, String user2);
	public List<User> getMyFriends(String uname);//得到我的朋友列表
	public List<User> getMyNBFriends(String uname);//Ta在我的好友列表，我没在ta的好友列表
	public List<User> getMyNotFriends(String uname);//ta不在我的好友列表，但我在ta的好友列表
	public List<Mood> getMoodsOfFriends(String uname);//得到我朋友发的动态
	public List<Mood> getMoodsOfView(String vPinyin);//得到景点下的动态
	public boolean publishMood(String author, String content, String publishTime, String vPinyin, int type, String picUrls);//发表动态
	public Mood getOneMood(int mid);
	public List<Mood> getMoodsOfWho(String who);
	public List<Mood> getTopMoods();
	public boolean publishComment(String author, String content, int mid, String publishTime, int type, int replyCid, int pCid);//发表评论
	public Comment getOneComment(int cid);
	public List<Comment> getCommentOfMid(int mid);
	public List<Comment> getReplyCommentOfPC(int pCid);
	public List<Comment> getRelaComment(String uname);
	public boolean publishWebInfo(String author, String toWho, String content, String publishTime, int type);
	public List<WebInfo> getRelaWebInfo(String uname);
	public boolean dianZan(int uid, int mid, int type);
}
