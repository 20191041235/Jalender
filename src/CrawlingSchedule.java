
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingSchedule {
	int year;
	Document doc;
	DataControl dout = new DataControl();
	String URL = "http://www.jejunu.ac.kr/camp/sai/academyschedule";
	
	public CrawlingSchedule() {
		this.year = 2020;
	}
	
	public CrawlingSchedule(int year) {
		year = this.year;
	}
	
	public Iterator<Element> crawlingData()
	{
		try {
			doc = Jsoup.connect(URL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements infos = doc.select("dl.sub_content_list > dd dl > dd > table > tbody > tr");
		Iterator<Element> contents = infos.select("td").iterator();
		
		return contents;
	}
	
	public void exportDataToExcel() {
		Iterator<Element> contents = crawlingData();
		
		while(contents.hasNext()) {
			dout.writeData("학사일정", contents.next().text(), 0);
			dout.writeData("학사일정", contents.next().text(), 1);
		}
	}	
}
