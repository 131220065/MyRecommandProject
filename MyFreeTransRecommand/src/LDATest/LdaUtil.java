package LDATest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author hankcs
 */
public class LdaUtil
{
    /**
     * To translate a LDA matrix to readable result
     * @param phi the LDA model
     * @param vocabulary
     * @param limit limit of max words in a topic
     * @return a map array
     */
    public static Map<String, Double>[] translate(double[][] phi, Vocabulary vocabulary, int limit)
    {
        limit = Math.min(limit, phi[0].length);
        Map<String, Double>[] result = new Map[phi.length];
        for (int k = 0; k < phi.length; k++)
        {
            Map<Double, String> rankMap = new TreeMap<Double, String>(Collections.reverseOrder());
            for (int i = 0; i < phi[k].length; i++)
            {
                rankMap.put(phi[k][i], vocabulary.getWord(i));
            }
            Iterator<Map.Entry<Double, String>> iterator = rankMap.entrySet().iterator();
            result[k] = new LinkedHashMap<String, Double>();
            for (int i = 0; i < limit; ++i)
            {
                Map.Entry<Double, String> entry = iterator.next();
                result[k].put(entry.getValue(), entry.getKey());
            }
        }
        return result;
    }

    public static Map<String, Double> translate(double[] tp, double[][] phi, Vocabulary vocabulary, int limit)
    {
        Map<String, Double>[] topicMapArray = translate(phi, vocabulary, limit);
        double p = -1.0;
        int t = -1;
        for (int k = 0; k < tp.length; k++)
        {
            if (tp[k] > p)
            {
                p = tp[k];
                t = k;
            }
        }
        return topicMapArray[t];
    }

    /**
     * To print the result in a well formatted form
     * @param result
     */
    public static void explain(Map<String, Double>[] result)
    {
        int i = 0;
        for (Map<String, Double> topicMap : result)
        {
            System.out.printf("topic %d :\n", i++);
            explain(topicMap);
            System.out.println();
        }
    }

    public static void explain(Map<String, Double> topicMap)
    {
        for (Map.Entry<String, Double> entry : topicMap.entrySet())
        {
            System.out.println(entry);
        }
    }
    //����
    public static double dJS(Map<String, Double> topicMap1, Map<String, Double> topicMap2) {
    	List<Double> p = new ArrayList<Double>();
    	List<Double> q = new ArrayList<Double>();
    	for(Map.Entry<String, Double> entry : topicMap1.entrySet()) {
    		p.add(entry.getValue());
    		q.add(topicMap2.get(entry.getKey()) == null ? 1e-15 : topicMap2.get(entry.getKey()));
    	}
    	for(Map.Entry<String, Double> entry : topicMap2.entrySet()) {
    		p.add(entry.getValue());
    		q.add(topicMap1.get(entry.getKey()) == null ? 1e-15 : topicMap1.get(entry.getKey()));
    	}
    	return dJS(p,q);
    	
    }
    public static double dJS(List<Double> p, List<Double> q) {
    	List<Double> pq = new ArrayList<Double>();
    	for(int i = 0; i < p.size(); i++) {
    		pq.add((p.get(i) + q.get(i)) / 2);
    	}
    	return (dKL(p, pq) + dKL(q, pq) ) / 2;
    }
    public static double dKL(List<Double> px, List<Double> qx) {
    	double dKl = 0;
    	for(int i = 0; i < px.size(); i++) {
    		dKl += px.get(i) * Math.log(px.get(i) / qx.get(i));
    	}
    	return dKl;
    }
}