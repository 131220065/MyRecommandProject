package routeDeal;


public class Distance {
	private static final double EARTH_RADIUS = 6378137;
	private static double rad(double d)
	{
	   return d * Math.PI / 180.0;
	}
	 /**
	* 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @param lng1
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @param lat1
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @param lng2
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @param lat2
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @return
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     */
	public static double GetDistance(double lng1, double lat1, double lng2, double lat2)
	{
	   double radLat1 = rad(lat1);
	   double radLat2 = rad(lat2);
	   double a = radLat1 - radLat2;
	   double b = rad(lng1) - rad(lng2);
	   double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) + 
	    Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
	   s = s * EARTH_RADIUS;
	   s = Math.round(s * 10000) / 10000;
	   return s;
	}
	/**
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     * @param args
	java通过经纬度计算两个点的之间的距离的算法 - dengyukun - dengyukun的博客     */
	public static void main(String[] args)
	{
	// TODO 自动生成方法存根
	    double distance = GetDistance(-180,0,-90,0);
	    System.out.println("Distance is:"+distance);
	}
}
