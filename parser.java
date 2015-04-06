import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parser {
	public static void main (String[] args)
	{	
		Document doc = null;
		String hostname = "http://sciencenetlinks.com";
		
		// begin testing code
		
		try {
			doc = Jsoup.connect("http://sciencenetlinks.com/search/?q=&content_types=Tool&s=1").get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Elements titles = doc.select(".detail h1 a");
		
		// get titles/links and print out
		for (Element e : titles)
		{
			String link = hostname + e.attr("href");
			System.out.println(e.text().substring(0 ,e.text().length()-2));
			System.out.println(link);
		}

		// end testing code
		
		return;
	}
	
	private void strip ()
	{
		return;
	}
}
