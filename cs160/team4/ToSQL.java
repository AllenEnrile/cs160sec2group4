package cs160.team4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
	 * @throws UnsupportedEncodingException 
	 * @throws FileNotFoundException 
	 */
	public void hashtoSQL (HashMap<String,HashMap<String,String>> tools) throws FileNotFoundException, UnsupportedEncodingException
	{
		/*
		 *  INSERT INTO `education` VALUES
		 *  (ID, TITLE, DESCRIPTION, LESSON_LINK, LESSON_IMAGE, CATEGORY, STUDENT_GRADES, AUTHOR, CONTENT_TYPE, TIME_SCRAPED)
		 *  
		 *  
		*/
		PrintWriter file = new PrintWriter("education_import.sql", "UTF-8");
		// loop through the entire hashmap
		file.println("INSERT INTO `education` VALUES");
		for (Map.Entry<String, HashMap<String, String>> entry : tools.entrySet())
		{
			String title = entry.getKey(); // get the title
			HashMap<String,String> items = entry.getValue(); // get the title specifics
			StringBuilder statement = new StringBuilder(); // create insert statement
			int index = 1;
			
			// obtain specifics		
			statement.append("('" + String.valueOf(index) + "',"); // ID
			statement.append("'" + title + "',"); // TITLE
			statement.append("'" + items.get("desc") + "',"); // DESCRIPTION
			statement.append("'" + items.get("link") + "',"); // LINK
			statement.append("'" + items.get("image") + "',"); // IMAGE
			statement.append("'" + items.get("category") + "',"); // CAT
			statement.append("'" + items.get("grades") + "',"); // GRADE LEVEL
			statement.append("'',"); // AUTHOR
			statement.append("'" + items.get("content_type") +"',"); // TYPE
			statement.append("'" + items.get("timestamp") + "'),"); // TIME_SCRAPED			
			index++;
			file.println(statement); // write to file last comma needs to be semicolon
		}
		file.close();
	}
}
