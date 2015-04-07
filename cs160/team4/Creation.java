package cs160.team4;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Creation {

	public static void main (String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		HashMap<String, HashMap<String, String>> tools = new HashMap<String, HashMap<String,String>>();
		Parser prsr = new Parser("http://sciencenetlinks.com", tools);
		ToSQL sql = new ToSQL(tools);
		try {
			prsr.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sql.hashtoSQL(tools);
	}
}
