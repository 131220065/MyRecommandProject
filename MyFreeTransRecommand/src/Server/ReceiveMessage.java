package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import com.mine.biz.UserBiz;
import com.mine.entity.User;

public class ReceiveMessage implements Runnable{
	private Socket socket;
	private UserBiz userBiz = new UserBiz();
	private String [] params;
	
	private BufferedReader br;
	private PrintWriter pw;

	public ReceiveMessage(Socket socket) {
		super();
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void run() {
			
			while(true) {
				
				String message;
				try {
					message = br.readLine();
					System.out.println(message);
					if(message == null) {//链接已断开
						return;
					}
					params = message.split("&&");
				} catch (IOException e) {
					continue;
				}
				
				if(params[1].equals("register")) {
					User userR = new User();
					userR.setUname(params[0]);
					userR.setPsd(params[2]);
//					userR.setSex(params[3].toCharArray()[0] - '0');
//					userR.setAge(params[4].toCharArray()[0] - '0');
//					userR.setPlace(params[5]);
//					userR.setJob(params[6]);
//					userR.setHobby(params[7]);
					int re = new UserBiz().registerUser(userR);
					if(re == 1) {
						pw.println("failed");
					} else if(re == 2) {
						pw.println("success");
					} else {
						pw.println("failed");
					}
					return;
				}
				MessageHandler msgHandler;
				if(UserMap.isThere(params[0])) {
					msgHandler = UserMap.getMsgHandler(params[0]);
					msgHandler.setPw(pw);
					msgHandler.handleMessage(params);
				} else {
					if(UserMap.add(params[0])) {
						msgHandler = UserMap.getMsgHandler(params[0]);
						msgHandler.setPw(pw);
						msgHandler.handleMessage(params);
					} else {
						pw.println("false");
					}
				}
			}
		
	}
	
	
}
