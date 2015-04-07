package cs160.team4;

import java.util.HashMap;
import java.util.Map;

public class ToSQL {
	HashMap<String,HashMap<String, String>> tools;
	
	public ToSQL (HashMap<String,HashMap<String,String>> tools)
	{
		this.tools = tools;
	}
	
	/**
	 * format: INSERT INTO table_name VALUES (value1,value2,value3,...);
	 * @param tools: hashmap of all tools
	 * 
	 * Will output to a text file containing the SQL import command
	 */
	public void hashtoSQL (HashMap<String,HashMap<String,String>> tools)
	{
		/*
		 *  INSERT INTO `education` VALUES
		 *  (ID, TITLE, DESCRIPTION, LESSON_LINK, LESSON_IMAGE, CATEGORY, STUDENT_GRADES, AUTHOR, CONTENT_TYPE, TIME_SCRAPED)
		 *  
		 *  
		*/
		
		// loop through the entire hashmap
		for (Map.Entry<String, HashMap<String, String>> entry : tools.entrySet())
		{
			String title = entry.getKey(); // get the title
			HashMap items = entry.getValue(); // get the title specifics
			
			// obtain specifics
			/*
			items.get("desc");
			items.get("link");
			items.get("image");
			items.get("category");
			items.get("grades");
			items.get("author");
			items.get("content_type");
			items.get("time_scraped");
			*/
		}
		
	}
}
