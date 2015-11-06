package com.mine.refer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.mine.biz.LogBiz;
import com.mine.biz.UserBiz;
import com.mine.biz.ViewBiz;
import com.mine.dao.LogDao;
import com.mine.entity.Log;
import com.mine.entity.Route;
import com.mine.entity.User;
import com.mine.entity.View;

public class Compute {
	private static int vectorN = 24;
	private static int hobbyN = 5;
	private static int vtypeN = 9;
	private static int placeN = 6;
	private static int studyN = 6;
	private static int incomeN = 8;
	private static int aimN = 5;
	public static int tStringToInt(String cho) {//将01字符串转换为int
		char [] a = cho.toCharArray();
		int ret = 0;
		for(int i = 0; i < a.length; i++) {
			ret = ret << 1;
			if(a[i] == '1') {
				ret = ret + 1;
			} else if(a[i] != '0') {
				return -1;
			}
		}
		return ret;
	}
	public static int [] tIntToArr(int cho, int num) {
		if(cho < 0 || num < 0) {
			return null;
		}
		int [] arr = new int[num];
		for(int i = num - 1; i >= 0; i --) {
			arr[i] = cho & 1;
			cho = cho >> 1;
		}
		return arr;
	}
	public static int numOfC2(int cho) {//求二进制整数中1的个数
		if(cho < 0)
			return -1;
		int n = 0;
		while(cho != 0) {
			n += cho & 1;
			cho = cho >> 1;
		}
		return n;
	}

	public static int notSameNum(int cho1, int cho2) {
		return numOfC2(cho1 ^ cho2);
	}
	public static float sim(User user1, User user2) {
		float [] a1 = new float[vectorN];
		float [] a2 = new float[vectorN];
//		
		a1[0] = (float) (((user1.getAge() > user2.getAge() ?  (float)user2.getAge() / user1.getAge() : (float)user1.getAge() / user2.getAge())) * 1.0);
		a1[1] = (float) ((user1.getSex() == user2.getSex()) ? 1 : 0.8);
		a1[2] = (float) (( 1 - (float)notSameNum(user1.getHobby(), user2.getHobby()) / hobbyN ) * 1.0);
		a1[3] = (float) (( (float)numOfC2(user1.getVtype() & user2.getVtype()) / numOfC2(user1.getVtype() | user2.getVtype()) ) * 1.0);
		a1[4] = (float) (( 1 - (float)Math.abs(user1.getPlace() - user2.getPlace()) / placeN ) * 1.0);
		a1[5] = (float) (( 1 - (float)Math.abs(user1.getStudy() - user2.getStudy()) / studyN ) * 1.0);
		a1[6] = (float) (user1.getJob() == user2.getJob() ? 1 : 0.5);
		a1[7] = (float) (( 1 - (float)Math.abs(user1.getIncome() - user2.getIncome()) / incomeN) * 1.0);
		a1[8] = (float) (( (float)numOfC2(user1.getAim() & user2.getAim()) / numOfC2(user1.getAim() | user2.getAim())) * 1.0);
		a1[9] = (float) (user1.getViewp() == user2.getViewp() ? 1 : 0.5);
		a1[10] = (float) (user1.getWeather() == user2.getWeather() ? 1 : 0.5);
		a1[11] = (float) (user1.getSeason() == user2.getSeason() ? 1 : 0.5);
		a1[12] = a1[2];
		a1[13] = a1[2];
		a1[14] = a1[2];
		a1[15] = a1[3];
		a1[16] = a1[3];
		a1[17] = a1[3];
		a1[18] = a1[3];
		a1[19] = a1[3];
		a1[20] = a1[9];
		a1[21] = a1[5];
		a1[22] = a1[7];
		a1[23] = a1[8];
		
		for(int i = 0; i < vectorN; i++)
			a2[i] = (float) 1.0;
		return (float) (mul(a1,a2) / Math.sqrt(mod2(a1) * mod2(a2)));
	}
	public static float inferScore(User user, Route route) {
		LogBiz logBiz = new LogBiz();
		UserBiz userBiz = new UserBiz();
		List<Log> logList = logBiz.queryLogByRid(route.getRid());
		if(logList.size() <= 0) {
			return 0;
		}
		float scoreSum = 0;
		float simSum = 0;
		float aver = average(logList);
		for(int i = 0; i < logList.size(); i++) {
			float simi = sim(user, userBiz.queryUser(logList.get(i).getUid()));
			scoreSum += simi * (logList.get(i).getScore() - aver);
			simSum += simi;
		}
		float iScore = aver + scoreSum / simSum;
		return iScore;
	}
	public static float inferScoreNew(User user, Route route) {
		float scoreSum = 0;
		float score;
		float bwSum = 0;
		int n = 6;
		int noInside = 0;//没有在数据库中的景点个数
		ViewBiz viewBiz = new ViewBiz();
		String [] vArr = route.getRoute().split("->");
		float [] b = new float[n];
		float [] c = new float [n];
		for(int i = 0; i < vArr.length; i++) {
			b[0] = (float) 0.11; b[1] = (float) 0.09; b[2] = (float) 0.08; b[3] = (float) 0.12;
			b[4] = (float) 0.4; b[5] = (float) 0.3;
			c[0] = 5; c[1] = 5; c[2] = 5; c[3] = 5; c[4] = 5; c[5] = 5;
			score = 0;
			View view = viewBiz.queryView(vArr[i]);
			if(view == null) {
				noInside++;
				continue;
			}
			int [] arrV = tIntToArr(view.getHobbyp(), hobbyN);
			int [] arrU = tIntToArr(user.getHobby(), hobbyN);
			for(int j = 1; j < hobbyN; j++) {
				if(arrV[j] == arrU[j]) {
					c[j - 1] = 10;
				}
			}
			if(vtypeN - notSameNum(view.getType(), user.getVtype()) > 0) {
				c[hobbyN - 1] = (float) (7.5 + 2.5 / numOfC2(view.getType() | user.getVtype()) * ( numOfC2(view.getType() & user.getVtype())));
			}
			if(view.getSuitp() == Math.pow(2, 4) - 1 || user.getViewp() == 0) {
				b[5] = 0;
			} else if(tIntToArr(view.getSuitp(), 4)[user.getViewp() - 1] == 1) {
				c[5] = 10;
			}
			for(int k = 0; k < n; k++) {
				score += b[k] * c[k];
			}
			bwSum = 0;
			for(int k = 0; k < n; k++) {
				bwSum += b[k];
			}
			scoreSum += score / bwSum;
		}
		return scoreSum / (vArr.length - noInside);
	}
	private static float average(List<Log> logList) {
		float aver = 0;
		for(int i = 0; i < logList.size(); i++) {
			aver += logList.get(i).getScore();
		}
		aver = aver / logList.size();
		return aver;
	}
	private static float mod2(float [] a) {
		float sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum += a[i] * a[i];
		}
		return (float) sum;
	}
	private static float mul(float [] a1, float [] a2) {
		float c = 0;
		for(int i = 0; i < a1.length; i++) {
			c += a1[i] * a2[i];
		}
		return c;
	}
	
	private static class MyComparatorHanLp implements Comparator<View> {
		private int i;
		
		public MyComparatorHanLp(int i) {
			this.i = i;
		}

		@Override
		public int compare(View o1, View o2) {
			// TODO Auto-generated method stub
			String [] aHanLpScore1 = o1.getHanLpScore().split("&&");
			String [] aHanLpScore2 = o2.getHanLpScore().split("&&");
			if(Double.parseDouble(aHanLpScore1[i]) > Double.parseDouble(aHanLpScore2[i])) {
				return 1;
			} else if(Double.parseDouble(aHanLpScore1[i]) == Double.parseDouble(aHanLpScore2[i])) {
				return 0;
			} else {
				return -1;
			}
		}
		
	}
	private static class MyComparatorReferScore implements Comparator<View> {

		@Override
		public int compare(View arg0, View arg1) {
			if(arg0.getReferScore() > arg1.getReferScore()) {
				return -1;
			} else if(arg0.getReferScore() == arg1.getReferScore()) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}
	private static class MyComparatorMark implements Comparator<View> {

		@Override
		public int compare(View arg0, View arg1) {
			if(arg0.getMark() > arg1.getMark()) {
				return 1;
			} else if(arg0.getMark() == arg1.getMark()) {
				return 0;
			} else {
				return -1;
			}
		}
		
	}
	public static float [] inferViewScore(User user, View view) {
		LogBiz logBiz = new LogBiz();
		UserBiz userBiz = new UserBiz();
		float [] aScore = new float[2];
		List<Log> logList = logBiz.queryLogByVPinYin(view.getPinYin());
		if(logList.size() <= 0) {
			aScore[0] = 0;
			aScore[1] = 0;
			return aScore;
		}
		float scoreSum = 0;
		float simSum = 0;
		float aver = average(logList);
		for(int i = 0; i < logList.size(); i++) {
			float simi = sim(user, userBiz.queryUser(logList.get(i).getUid()));
			scoreSum += simi * (logList.get(i).getScore() - aver);
			simSum += simi;
		}
		float iScore = aver + scoreSum / simSum;
		aScore[0] = iScore;
		aScore[1] = aver;
		return aScore;
	}
	public static void inferViewScore(User user, List<View> viewList) {
		float [] aScore;
		int k = 0;
		float sum = 0;
		for(View view : viewList) {
			aScore = inferViewScore(user, view);
			if(aScore[0] != 0) {
				view.setReferScore(aScore[0]);
				k++;
				sum += aScore[1];
			} else {
				view.setReferScore(0);
			}
		}
		if(k == 0) {
			return;
		}
		float aver = sum / k;
		for(View view: viewList) {
			if(view.getReferScore() == 0) {
				view.setReferScore(aver);
			}
		}
	}
	
	public static void sortAndSetMark(List<View> viewList) {
		Collections.sort(viewList, new MyComparatorReferScore());
		View view = viewList.get(0);
		View view2;
		view.setMark(view.getMark());
		for(int i = 1, j = 0; i < viewList.size(); i++) {
			view2 = viewList.get(i);
			if(view2.getReferScore() < view.getReferScore()) {
				j++;
			}
			view2.setMark(view2.getMark() + j);
			view = view2;
		}
	}
	
	public static void setSort(User user, List<View> viewList) {
		int [] arrHobby = tIntToArr(user.getHobby(), hobbyN);
		List<View> viewWait = new ArrayList<View>();
		for(View view : viewList) {
			view.setMark(0);
		}
		for(int i = 1; i < hobbyN; i++) {
			if(arrHobby[i] == 1) {
				Collections.sort(viewList, new MyComparatorHanLp(i - 1));
				for(int j = 0; j < viewList.size(); j++) {
					View view = viewList.get(j);
					view.setMark(view.getMark() + j);
				}
				viewWait.add(viewList.get(0));
				viewWait.add(viewList.get(1));
			}
		}
		int [] arrType = tIntToArr(user.getVtype(), vtypeN);
		for(int i = 0; i < vtypeN; i++) {
			if(arrType[i] == 1) {
				Collections.sort(viewList, new MyComparatorHanLp(i + hobbyN - 1));
				for(int j = 0; j < viewList.size(); j++) {
					View view = viewList.get(j);
					view.setMark(view.getMark() + j);
				}
				viewWait.add(viewList.get(0));
				viewWait.add(viewList.get(1));
			}
		}
		if(user.getViewp() > 0) {
			Collections.sort(viewList, new MyComparatorHanLp(hobbyN - 1 + vtypeN));
			for(int j = 0; j < viewList.size(); j++) {
				View view = viewList.get(j);
				view.setMark(view.getMark() + j);
			}
			viewWait.add(viewList.get(0));
			viewWait.add(viewList.get(1));
		}
		Collections.sort(viewList, new MyComparatorMark());
		for(int i = 0; i < viewList.size(); i++) {
			viewList.get(i).setMark(i);
		}
		for(View view : viewWait) {
			//System.out.print(view.getName() + " ");
			view.setMark(0);
		}
		//System.out.println();
		inferViewScore(user, viewList);
		sortAndSetMark(viewList);
		Collections.sort(viewList, new MyComparatorMark());
	}
}
