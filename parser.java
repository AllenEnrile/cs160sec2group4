import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class parser {
	public static void main (String[] args)
	{
		
		String html = "<html><head><title>First parse</title></head>";
		
		Document doc = null;
		try {
			doc = Jsoup.connect("http://sciencenetlinks.com/search/?q=&content_types=Tool&s=1").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements newsHeadlines = doc.select(".detail");
		System.out.println(newsHeadlines);
		return;
	}
}
