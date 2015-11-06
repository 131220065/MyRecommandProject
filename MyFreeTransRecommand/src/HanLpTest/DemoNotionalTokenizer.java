package HanLpTest;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import Code.CodeString;

import com.hankcs.hanlp.tokenizer.NotionalTokenizer;

/**
 * ��ʾ�Զ�ȥ��ͣ�ôʡ��Զ��Ͼ�ķִ���
 * @author hankcs
 */
public class DemoNotionalTokenizer
{
    /*public static void main(String[] args) throws Exception
    {
    	String [] standardPath = {"data/standard/�徻.txt", "data/standard/��ʷ.txt", "data/standard/�Ļ�.txt", "data/standard/С��.txt", "data/standard/�ż�����.txt", "data/standard/�غӷ��.txt", "data/standard/��Ȼɽˮ.txt", "data/standard/����Ŵ�.txt", "data/standard/���⹫԰.txt", "data/standard/���߷羰.txt", "data/standard/��������.txt", "data/standard/�����˶�.txt", "data/standard/���з���.txt", "data/standard/����.txt", "data/standard/����.txt", "data/standard/����.txt", "data/standard/����.txt"   };
    	for(String desPath : standardPath) {
    		hanLp(desPath.replace(".txt", "t.txt"), desPath, "utf-8");
    	}
        // �Զ�ȥ��ͣ�ô�
//        System.out.println(NotionalTokenizer.segment(text));    // ͣ�ôʵ�λ��data/dictionary/stopwords.txt�����������޸�
        // �Զ��Ͼ�+ȥ��ͣ�ô�
//        for (List<Term> sentence : NotionalTokenizer.seg2sentence(text))
//        {
//            System.out.println(sentence);
//        }
    }*/
    public static void hanLp(String filePathSrc, String filePathDes, String code) throws Exception{
    	FileInputStream fInputStream = new FileInputStream(filePathSrc);
    	InputStreamReader inputStreamReader = new InputStreamReader(fInputStream, code);
    	BufferedReader br = new BufferedReader(inputStreamReader);
    	FileWriter fw = new FileWriter(filePathDes);
    	String text = br.readLine();
    	while(text !=null){
    		//System.out.println(NotionalTokenizer.segment(text));
    		String s = NotionalTokenizer.segment(text).toString() + "\n";
    		s = s.replaceAll("\\[|\\]|,", "");
    		fw.write(s,0,s.length());    
            fw.flush();
    		text = br.readLine();
    	}
    	fw.close();
    }
    public static void hanLp(String fileContent, String filePathDes) throws Exception{
    	FileWriter fw = new FileWriter(filePathDes);
    	String s = NotionalTokenizer.segment(fileContent).toString() + "\n";
		s = s.replaceAll("\\[|\\]|,", "");
		fw.write(s,0,s.length());    
        fw.flush();
        fw.close();
    }
}