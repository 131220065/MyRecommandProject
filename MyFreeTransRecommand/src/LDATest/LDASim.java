package LDATest;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Vector;

public class LDASim {
	private static int topicNum = 5;
	private static int wordsNum = 100;
	public static double dJS(String filePath1, String filePath2) throws IOException{
		File file1 = new File(filePath1);
		File file2 = new File(filePath2);
		//System.out.println(file1.getName());
    	
    	Corpus corpus = Corpus.load(file1);

		
		LdaGibbsSampler ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(), corpus.getVocabularySize());

		
		ldaGibbsSampler.gibbs(topicNum);

		double [][] phi = ldaGibbsSampler.getPhi();

		Map<String, Double>[] topicMap1 = LdaUtil.translate(phi, corpus.getVocabulary(), wordsNum);

		//LdaUtil.explain(topicMap1);
		
		//System.out.println("****************************************************************");
    //}
		//System.out.println(file2.getName());
		corpus = Corpus.load(file2);

		
		ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(), corpus.getVocabularySize());

		
		ldaGibbsSampler.gibbs(topicNum);

		phi = ldaGibbsSampler.getPhi();

		Map<String, Double>[] topicMap2 = LdaUtil.translate(phi, corpus.getVocabulary(), wordsNum);

		//LdaUtil.explain(topicMap2);
		
		Vector<Double> dVec = new Vector<>();
		double sum = 0;
		for(int i = 0; i < topicMap1.length; i++) {
			dVec.add(LdaUtil.dJS(topicMap1[i], topicMap2[i]));
			double djs = LdaUtil.dJS(topicMap1[i], topicMap2[i]);
			sum += djs;
			//System.out.println("dJS距离为：" + djs);
		}
		//return sum / topicMap1.length;
		
		
		return Collections.min(dVec);
	}
	public static double dJS(String folderPath, String fileName1, String fileName2) throws IOException{
		if(!folderPath.endsWith("/")) {
			folderPath = folderPath + "/";
		}
		
		return dJS(folderPath + fileName1, folderPath + fileName2);
		
	}
	public static void load(String folderPath) throws IOException {
		File folder = new File(folderPath);
        //for (File file : folder.listFiles()) {
		File file1 = folder.listFiles().clone()[0];
		File file2 = folder.listFiles().clone()[1];
        	//System.out.println(file1.getName());
        	
        	Corpus corpus = Corpus.load(file1);

    		
    		LdaGibbsSampler ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(), corpus.getVocabularySize());

    		
    		ldaGibbsSampler.gibbs(10);

    		double [][] phi = ldaGibbsSampler.getPhi();

    		Map<String, Double>[] topicMap1 = LdaUtil.translate(phi, corpus.getVocabulary(), 10);

    		LdaUtil.explain(topicMap1);
    		
    		//System.out.println("****************************************************************");

    		//System.out.println(file2.getName());
    		corpus = Corpus.load(file2);

    		
    		ldaGibbsSampler = new LdaGibbsSampler(corpus.getDocument(), corpus.getVocabularySize());

    		
    		ldaGibbsSampler.gibbs(10);

    		phi = ldaGibbsSampler.getPhi();

    		Map<String, Double>[] topicMap2 = LdaUtil.translate(phi, corpus.getVocabulary(), 10);

    		LdaUtil.explain(topicMap2);
    		/*for(int i = 0; i < topicMap1.length; i++) {
    			System.out.println("dJS距离为：" + LdaUtil.dJS(topicMap1[i], topicMap2[i]));
    		}*/
    		
	}
}
