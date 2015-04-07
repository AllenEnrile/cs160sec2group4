package cs160.team4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Creation {

	public static void main (String[] args)
	{
		HashMap<String, HashMap<String, String>> tools = new HashMap<String, HashMap<String,String>>();
		Parser prsr = new Parser("http://sciencenetlinks.com", tools);
		ToSQL sql = new ToSQL(tools);
		sql.hashtoSQL(tools);
		try {
			prsr.parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
