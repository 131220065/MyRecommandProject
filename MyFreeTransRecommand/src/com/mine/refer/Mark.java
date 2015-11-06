package com.mine.refer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import HanLpTest.DemoNotionalTokenizer;
import LDATest.LDASim;

import com.hankcs.hanlp.HanLP;
import com.mine.biz.ViewBiz;
import com.mine.entity.View;

public class Mark {
	private static String [] standardPath = {"data/standard/清净.txt", "data/standard/历史.txt", "data/standard/文化.txt", "data/standard/小吃.txt", "data/standard/古迹建筑.txt", "data/standard/沿河风光.txt", "data/standard/自然山水.txt", "data/standard/古镇古村.txt", "data/standard/主题公园.txt", "data/standard/海边风景.txt", "data/standard/购物中心.txt", "data/standard/户外运动.txt", "data/standard/休闲放松.txt", "data/standard/亲子.txt", "data/standard/朋友.txt", "data/standard/情侣.txt", "data/standard/长辈.txt"   };
	private static String hanLpMiddleStationPath = "Instr/hanLpMiddleStation.txt";
	
	public static void markAllPro() throws IOException {
		FileWriter fileWriter = new FileWriter("data/error.txt");
		String hanLpScore = "";
		ViewBiz viewBiz = new ViewBiz();
		List<View> views = viewBiz.queryAllView();
		for(View view : views) {
			if(view.getHanLpScore() != null) {
				continue;
			}
			if(view.getDescription() == null || view.getDescription().length() < 20) {
				fileWriter.write(view.toString() + "\n");
				fileWriter.flush();
				continue;
			}
			hanLpScore = "";
			System.out.println(view.getName());
			double [] djs = computedJS(standardPath, view);
			for(int i = 0; i < djs.length; i++) {
				System.out.println(standardPath[i] + " " + djs[i]);
				hanLpScore += djs[i] + "&&";
			}
			System.out.println("***********************************");
			view.setHanLpScore(hanLpScore);
			viewBiz.updateView(view);
		}
		fileWriter.close();
	}
	
	public static void markAllInFile() throws Exception {
		
		FileWriter fileWriter = new FileWriter("data/jingdian/距离3.txt");
		ViewBiz viewBiz = new ViewBiz();
		List<View> views = viewBiz.queryAllView();
		for(View view : views) {
			String hanLpScore = "";
			System.out.println(view.getName());
			
			double[] djs;
			try {
				djs = computedJSInFile(standardPath, view);
				for(int i = 0; i < djs.length; i++) {
					System.out.println(standardPath[i] + " " + djs[i]);
					hanLpScore += djs[i] + "&&";
				}
			} catch (Exception e) {
				fileWriter.write(view.getPinYin() + "%%" + hanLpScore + "\n");
				fileWriter.flush();
				continue;
			}
			//System.out.println("***********************************");
			fileWriter.write(view.getPinYin() + "%%" + hanLpScore + "\n");
			fileWriter.flush();
		}
		fileWriter.close();
	}
	
	public static double [] computedJS(String [] stanPath, View view) {
		double [] djs = new double[stanPath.length];
		try {
			DemoNotionalTokenizer.hanLp(view.getAbstr() + view.getDescription(), hanLpMiddleStationPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < stanPath.length; i++) {
			try {
				djs[i] = LDASim.dJS(hanLpMiddleStationPath, stanPath[i]);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return djs;
	}
	public static double [] computedJSInFile(String [] stanPath, View view) throws Exception {
		String fileFolder = "data/jingdian/";
		double [] djs = new double[stanPath.length];
		//DemoNotionalTokenizer.hanLp(fileFolder + view.getPinYin() + ".txt", fileFolder + view.getPinYin() + "N.txt", "utf-8");
		for(int i = 0; i < stanPath.length; i++) {
			djs[i] = LDASim.dJS(fileFolder + view.getPinYin() + "N.txt", stanPath[i]);
		}
		return djs;
	}
}
