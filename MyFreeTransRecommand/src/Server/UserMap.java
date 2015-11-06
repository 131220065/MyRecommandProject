package Server;

import java.util.HashMap;
import java.util.Map;

import com.mine.biz.UserBiz;
import com.mine.entity.User;

public class UserMap {
	private static Map<String, MessageHandler> userMap = new HashMap<String, MessageHandler>();
	private static UserBiz userBiz = new UserBiz();
	public static boolean add(String userName) {
		User userl = userBiz.queryUser(userName);
		if(userl == null) {
			return false;
		}
		userMap.put(userName, new MessageHandler(userl));
		return true;
	}
	public static void remove(String uname) {
		userMap.remove(uname);
	}
	public static boolean isThere(String uname) {
		return userMap.containsKey(uname);
	}
	public static MessageHandler getMsgHandler(String uname) {
		return userMap.get(uname);
	}
}
