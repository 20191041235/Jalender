import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingSchedule {
	public int year;
	private int lastDate = 0;
	private Document doc;
	private HashMap<Integer, Vector<String>> academySchedule = new HashMap<Integer, Vector<String>>();
	
	private final static String URL = "http://www.jejunu.ac.kr/camp/sai/academyschedule/";
	private final static int lastDateOfMonth[]={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public CrawlingSchedule() {
		this.year = 20200000;
		crawlingData();
	}
	
	public CrawlingSchedule(int year) {
		this.year = year * 10000;
		crawlingData();
	}
	
	private void pushData(int date, String event) {
		if(!academySchedule.containsKey(date))
			academySchedule.put(date, new Vector<String>());
		academySchedule.get(date).add(event);
	}
	
	private void crawlingData()
	{
		try {
			doc = Jsoup.connect(URL + Integer.toString(year / 10000)).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements infos = doc.select("dl.sub_content_list > dd dl > dd > table > tbody > tr");
		Iterator<Element> contents = infos.select("td").iterator();
		
		while(contents.hasNext()) {
			String date = contents.next().toString().split(">")[1].replaceAll("[^0-9]","");	//날짜
			String event = contents.next().toString().split(">")[1].split("<")[0];	//이벤트
			int startDate = Integer.parseInt(date) / 10000;
			int endDate = Integer.parseInt(date) % 10000;

			if (startDate > 0) {
				if (startDate > endDate) {
					startDate += year;
					year += 10000;
					endDate += year;
				} else {
					startDate += year;
					endDate += year;
				}
			} else 
				startDate += (year + endDate);
			
			int month = startDate / 100 % 100;
			if(lastDate / 100 % 100 == 12 && month == 1) {
				year += 10000;
				startDate += 10000;
			}
				
			lastDate = startDate;
			
			for(; startDate < endDate; startDate++) {
				pushData(startDate, event);
				
				if (startDate % 100 == lastDateOfMonth[month - 1]) {
					if (month == 12) 
						startDate = 10000 + (startDate - 1130);
					else
						startDate = startDate + 100 - lastDateOfMonth[month] + 1;
				}
			}
			pushData(startDate, event);
		}
	}
	
	public HashMap<Integer, Vector<String>> getAcademySchedule() {
		return academySchedule;
	}
	
	public void showAcademySchedule() {
		Iterator<Integer> mapIter = academySchedule.keySet().iterator();
		
		while(mapIter.hasNext()) {
			int key = mapIter.next();
			Iterator<String> dateIter = academySchedule.get(key).iterator();
			while(dateIter.hasNext()) {
				System.out.println(key + " : " + dateIter.next());
			}

		}
	}	
}