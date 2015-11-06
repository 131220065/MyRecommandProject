package routeDeal;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import com.mine.entity.View;

public class RouteDeal {
	private ArrayList<View> cities;
	private ArrayList<View> sortCities;

	public RouteDeal(View[] cities) {
		this.cities = new ArrayList<>();
		this.sortCities = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			this.cities.add(cities[i]);
		}
	}

	public int getDis(View c1, View c2) throws Exception {
		String origin = c1.getLat() + "," + c1.getLng();
		String destination = c2.getLat() + "," + c2.getLng();
		String origin_region = c1.getRegion();
		String destination_region = c2.getRegion();
		String str = "http://api.map.baidu.com/direction/v1?mode=transit&origin=" + origin + "&destination="
				+ destination + "&origin_region=" + origin_region + "&destination_region=" + destination_region
				+ "&output=json&ak=729jxIacHPsZM0pQemj95CcC";
		URL u = new URL(str);
		InputStream in = u.openStream();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			byte buf[] = new byte[1024];
			int read = 0;
			while ((read = in.read(buf)) > 0) {
				out.write(buf, 0, read);
			}
		} finally {
			if (in != null) {
				in.close();
			}
		}
		byte b[] = out.toByteArray();
		JSONObject jsonObject = new JSONObject(new String(b));
		int dis = Integer.MAX_VALUE;
		try {
			dis = jsonObject.getJSONObject("result").getJSONArray("routes").getJSONObject(0).getJSONArray("scheme")
					.getJSONObject(0).getInt("distance");
		} catch (Exception e) {
			dis = jsonObject.getJSONObject("result").getJSONArray("routes").getJSONObject(0).getJSONArray("scheme")
					.getJSONObject(0).getInt("distance");
		}
//		System.out.print(c1.getName() + "->" + c2.getName() + " : ");
//		System.out.println(dis);
		return dis;
	}

	public View getStartC() {

		float MaxX = 0;
		float MinX = Float.POSITIVE_INFINITY;
		float MaxY = 0;
		float MinY = Float.POSITIVE_INFINITY;
		View MaxXC = null, MaxYC = null, MinXC = null, MinYC = null;
		View startC;
		for (int i = 0; i < cities.size(); i++) {
			if (cities.get(i).getLng() > MaxX) {
				MaxX = (float) cities.get(i).getLng();
				MaxXC = cities.get(i);
			}
			if (cities.get(i).getLng() < MinX) {
				MinX = (float) cities.get(i).getLng();
				MinXC = cities.get(i);
			}
			if (cities.get(i).getLat() > MaxY) {
				MaxY = (float) cities.get(i).getLat();
				MaxYC = cities.get(i);
			}
			if (cities.get(i).getLat() < MinY) {
				MinY = (float) cities.get(i).getLat();
				MinYC = cities.get(i);
			}
		}
		if (MaxX - MinX > MaxY - MinY) {
			startC = MinXC;
		} else {
			startC = MinYC;
		}
		return startC;
	}

	public String getSort() throws Exception {
		View startC = getStartC();
		Select(startC);
		View currC = startC;
		while (cities.size() > 1) {
			View c = getNearest(currC);
			if(c != null) {
				Select(c);
				currC = c;
			} else {
				System.out.println("cuowu?");
			}
		}
		Select(cities.get(0));
		String str = "";
		for (int i = 0; i < sortCities.size(); i++) {
			View view = sortCities.get(i);
			str += view.getName() + "%%"
					+ view.getLat() + "%%"
					+ view.getLng() + "%%"
					+ view.getPrice() + "%%"
					+ view.getOpenTime() + "%%"
					+ view.getPicUrl() + "%%"
					+ view.getUrl();
			str += "&&";
		}	
		return str;
	}

	public void Select(View c) {
		sortCities.add(c);
		cities.remove(c);
	}

	public View getNearest(View c) {
		if (cities.isEmpty()) {
			return null;
		}
		int Min = Integer.MAX_VALUE;
		int dis = Integer.MAX_VALUE;
		View cMin = null;
		for (int i = 0; i < cities.size(); i++) {
			try {
				//dis = getDis(c, cities.get(i));
				dis = (int) Distance.GetDistance(c.getLng(), c.getLat(), cities.get(i).getLng(), cities.get(i).getLat());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				dis = Integer.MAX_VALUE;
			}
			if(dis == Integer.MAX_VALUE) {
				dis = (int) Distance.GetDistance(c.getLng(), c.getLat(), cities.get(i).getLng(), cities.get(i).getLat());
			}
			if (dis < Min) {
				Min = dis;
				cMin = cities.get(i);
			}
			
		}
		return cMin;
	}
	
	public String getSort(View startC) throws Exception {
		Select(startC);
		View currC = startC;
		while (cities.size() > 1) {
			View c = getNearest(currC);
			Select(c);
			currC = c;
		}
		Select(cities.get(0));
		String str = "";
		for (int i = 0; i < sortCities.size(); i++) {
			View view = sortCities.get(i);
			str += view.getName() + "%%"
					+ view.getLat() + "%%"
					+ view.getLng() + "%%"
					+ view.getPrice() + "%%"
					+ view.getOpenTime() + "%%"
					+ view.getPicUrl() + "%%"
					+ view.getUrl();
			str += "&&";
		}
		return str;
	}
	public List<View> getSort2(View startC) throws Exception {
		Select(startC);
		View currC = startC;
		while (cities.size() > 1) {
			View c = getNearest(currC);
			Select(c);
			currC = c;
		}
		Select(cities.get(0));

		return sortCities;
	}
	public List<View> getSort2() throws Exception {
		View startC = getStartC();
		Select(startC);
		View currC = startC;
		while (cities.size() > 1) {
			View c = getNearest(currC);
			Select(c);
			currC = c;
		}
		Select(cities.get(0));

		return sortCities;
	}
}
