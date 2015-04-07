package cs160.team4;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Parser {
	
	String hostname;
	HashMap<String, HashMap<String, String>> tools;
	
	/**
	 * 
	 * @param hostname: top level hostname
	 */
	public Parser (String hostname, HashMap<String, HashMap<String,String>> tools)
	{
		this.hostname = hostname;
		this.tools = tools;
	}
	
	/**
	 * Inital parser. Will loop through search results grabbing title, description and grade level
	 * @author Allen Enrile
	 * @param args
	 * @throws IOException
	 * @return HashMap of tools found and their specific data
	 */
	public HashMap parse () throws IOException
	{	
		Document doc = null;

		
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
				tools.get(title).put("time_scraped", String.valueOf(System.currentTimeMillis())); // insert timestamp in ms
				
				// load the tools page
				Document specific_Tool = Jsoup.connect(link).get();
				
				// begin page specific parsing
				pageSpecificParser(specific_Tool, tools.get(title));
				j++; // go to next tool
			}
			System.out.println("Processing page " + String.valueOf(i));
		}
		return tools;
	}
	
	/**
	 * 
	 * @Author Team 4
	 * @param doc: the specific tool webpage to be parsed
	 * @param title: hashmap for the specific tool
	 */
	private void pageSpecificParser (Document doc, HashMap<String, String> title)
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
