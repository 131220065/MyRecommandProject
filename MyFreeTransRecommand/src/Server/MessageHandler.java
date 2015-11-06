package Server;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import routeDeal.RouteDeal;


import com.mine.biz.LogBiz;
import com.mine.biz.ViewBiz;
import com.mine.entity.Log;
import com.mine.entity.User;
import com.mine.entity.View;
import com.mine.refer.Compute;
import com.mine.refer.Reference;

public class MessageHandler {
	private User userl;
	private List<View> vList;
	private PrintWriter pw;//用于发送
	private int routeViewNum;
	
	public MessageHandler(User userl) {
		this.userl = userl;
		vList = null;
		pw = null;
		routeViewNum = 0;
	}

	public User getUserl() {
		return userl;
	}

	public void setUserl(User userl) {
		this.userl = userl;
	}

	public List<View> getvList() {
		return vList;
	}

	public void setvList(List<View> vList) {
		this.vList = vList;
	}

	public PrintWriter getPw() {
		return pw;
	}

	public void setPw(PrintWriter pw) {
		this.pw = pw;
	}
	
	public void handleMessage(String [] params) {
		switch(params[1]) {
		case "login":
			if(params.length != 3) {
				pw.println("false");
				break;
			}
			if(params[2].equals(userl.getPsd())) {
				pw.println("true");
			} else {
				pw.println("false");
			}
			break;
		case "refference":
			if(params.length != 8 && params.length != 3) {
				pw.println("false");
				System.out.println("nothing");
				break;
			}
			if(params.length == 8) {
				userl.setAim(Compute.tStringToInt(params[4]));
				userl.setViewp(Integer.parseInt(params[5]));
				
				//List<Route> rlist = Reference.refer(userl, params[1]);
				vList = Reference.referView(userl, params[3]);
				if(vList == null) {
					pw.println("nothing");
				}
				String message2 = "";
				/*int number = 1;
				for(Route route: rlist) {
					
					message2 += ("路线" + number + "：" + route.getRoute() + "/r/n");
					number++;
				}*/
				//System.out.println(message2);
				//String [] viewN = rlist.get(0).getRoute().split("->");
				/*List<View> views = new ArrayList<View>();
				for(String vName : viewN) {
					if(vName != "") {
						views.add(new ViewBiz().queryView(vName));
					}
				}*/
				/*View[] views2 = new View[views.size()];
				views.toArray(views2);*/
				//View [] views2 = { viewBiz.queryView("fuzimiao"), viewBiz.queryView("nanjingdatushayunantongbaojinianguan"), viewBiz.queryView("xuanwuhu"), viewBiz.queryView("jimingsi") };
				View [] views2 = new View[new Random().nextInt(5) + 2];
				int k;
				for(k = 0; k < views2.length && k < vList.size(); k++) {
					views2[k] = vList.get(k);
					//System.out.println(views2[i].getPinYin() + "&&" + views2[i].getLat() + " ");
				}
				routeViewNum = k;
				RouteDeal routeDeal = new RouteDeal(views2);
				try {
					message2 = routeDeal.getSort();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(message2);
				}
				System.out.println(message2);
				pw.println(message2);
			} else if(params.length == 3) {
				if(vList == null) {
					System.out.println("vList error");
					break;
				}
				String message3 = "";
				int fIndex = Integer.parseInt(params[2]) * 10 + routeViewNum;
				for(int i = fIndex; i < fIndex + 10 && i < vList.size(); i++) {
					View view = vList.get(i);
					message3 += view.getName() + "%%"
							+ view.getLat() + "%%"
							+ view.getLng() + "%%"
							+ view.getPrice() + "%%"
							+ view.getOpenTime() + "%%"
							+ view.getPicUrl() + "%%"
							+ view.getUrl();
					message3 += "&&";
				}
				if(message3.equals("")) {
					message3 = "nothing";
				}
				System.out.println(message3);
				pw.println(message3);
			}
			break;
		case "querySort":
			if(vList == null) {
				System.out.println("querySort错误！！！！why");
				pw.println("false");
				return;
			}
			List<View> queryViewList = new ArrayList<View>();
			routeViewNum = params.length - 2;
			for(int i = 2; i < params.length; i++) {
				View view = vList.get(Integer.parseInt(params[i]));
				queryViewList.add(view);
			}
			String message2 = "";
			if(queryViewList.size() == 1) {
				View view = queryViewList.get(0);
				vList.remove(view);
				vList.add(0, view);
				message2 += view.getName() + "%%"
						+ view.getLat() + "%%"
						+ view.getLng() + "%%"
						+ view.getPrice() + "%%"
						+ view.getOpenTime() + "%%"
						+ view.getPicUrl() + "%%"
						+ view.getUrl();
				message2 += "&&";
				pw.println(message2);
			} else {
				View [] views3 = new View[queryViewList.size()];
				queryViewList.toArray(views3);
				RouteDeal routeDeal = new RouteDeal(views3);
				try {
					List<View> vTempList = routeDeal.getSort2();
					for(int i = 0; i < vTempList.size(); i++) {
						View view = vTempList.get(i);
						vList.remove(view);
						vList.add(i, view);
						message2 += view.getName() + "%%"
								+ view.getLat() + "%%"
								+ view.getLng() + "%%"
								+ view.getPrice() + "%%"
								+ view.getOpenTime() + "%%"
								+ view.getPicUrl() + "%%"
								+ view.getUrl();
						message2 += "&&";
					}
					System.out.println(message2);
					pw.println(message2);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			break;
		case "mark"://添加对景点评分记录
			if(params.length != 4) {
				System.out.println("mark错误");
				pw.println("false");
				return;
			}
			String viewPinyin = params[2];
			int mark = Integer.parseInt(params[3]);
			Log viewLog = new Log(0, userl.getUid(), 0, mark, viewPinyin);
			LogBiz logBiz = new LogBiz();
			if(!logBiz.saveLog(viewLog)) {
				logBiz.updateLog(viewLog);
			}
			break;
		default:
			break;
		
		}
	}
	
}
