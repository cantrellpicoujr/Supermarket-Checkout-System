import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;


public class start {
	public static void main(String ...x) {
		
		fileParser obj = new fileParser();
		
		try {
			obj.decreaseInventoryQuantity("1", 1);;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
