import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;


public class start {
	public static void main(String ...x) throws FileNotFoundException, IOException, ParseException, Exception {
		
		fileParser obj = new fileParser();
		ArrayList<inventory> arr;
		
		arr = obj.invArr();
		
		Boolean name = arr.get(0).getBulk();
		
		obj.decAccBal("1111111111111111", 10.99);
				
		System.out.println(name);
			
			
	}
}
