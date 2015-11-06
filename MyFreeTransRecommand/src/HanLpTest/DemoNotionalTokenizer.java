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
 * 演示自动去除停用词、自动断句的分词器
 * @author hankcs
 */
public class DemoNotionalTokenizer
{
    /*public static void main(String[] args) throws Exception
    {
    	String [] standardPath = {"data/standard/清净.txt", "data/standard/历史.txt", "data/standard/文化.txt", "data/standard/小吃.txt", "data/standard/古迹建筑.txt", "data/standard/沿河风光.txt", "data/standard/自然山水.txt", "data/standard/古镇古村.txt", "data/standard/主题公园.txt", "data/standard/海边风景.txt", "data/standard/购物中心.txt", "data/standard/户外运动.txt", "data/standard/休闲放松.txt", "data/standard/亲子.txt", "data/standard/朋友.txt", "data/standard/情侣.txt", "data/standard/长辈.txt"   };
    	for(String desPath : standardPath) {
    		hanLp(desPath.replace(".txt", "t.txt"), desPath, "utf-8");
    	}
        // 自动去除停用词
//        System.out.println(NotionalTokenizer.segment(text));    // 停用词典位于data/dictionary/stopwords.txt，可以自行修改
        // 自动断句+去除停用词
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