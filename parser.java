import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class parser {
	
	/**
	 * Inital parser. Will loop through search results grabbing title, description and grade level
	 * @author Allen Enrile
	 * @param args
	 * @throws IOException
	 */
	public static void main (String[] args) throws IOException
	{	
		Document doc = null;
		String hostname = "http://sciencenetlinks.com";
		HashMap<String, HashMap<String, String>> tools = new HashMap<String,HashMap<String, String>>();
		
		for (int i = 1; i < 27; i++)
		{
			doc = Jsoup.connect("http://sciencenetlinks.com/search/?q=&content_types=Tool&s=" + String.valueOf(i)).get();
			Elements results = doc.select(".detail");
			Elements grades = doc.select(".grades");
			int j = 1;
			for (Element e : results)
			{	
				String gradeLevel = grades.get(j).text(); // get the grade levels
				String link = hostname + e.child(0).child(0).attr("href"); // obtain link to tool page
				String text = e.child(0).child(0).text(); // get the raw title
				String desc = e.child(e.childNodeSize()-1).text(); // get description
				String title = text.substring(0, text.length()-2); // truncate arrow from the title
				tools.put(title, new HashMap<String, String>()); // add new title to library hashmap
				tools.get(title).put("desc", desc); // insert description to title hashmap
				tools.get(title).put("grades", gradeLevel); // insert grade level to title hashmap
				
				// load the tools page
				Document specific_Tool = Jsoup.connect(link).get();
				
				// begin page specific parsing
				//pageSpecificParser(specific_Tool, tools.get(title));
				j++; // go to next tool
			}
			System.out.println("Processing page " + String.valueOf(i));
		}
		
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
	
	/**
	 * 
	 * @Author Team 4
	 * @param doc: the specific tool webpage to be parsed
	 * @param title: hashmap for the specific tool
	 */
	private static void pageSpecificParser (Document doc, HashMap title)
	{
		/* TO-DO:
		 * 	lesson link
		 * 	lesson image
		 * 	category
		 * 	author
		 * 	content type
		 * 	time stamp
		 */
		return;
	}
}
