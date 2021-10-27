import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.json.simple.parser.ParseException;

public class start {
	public static void main(String ...x) throws FileNotFoundException, IOException, ParseException, Exception {
		
		SwingUtilities.invokeLater(new Runnable() { 
			
			public void run() {
				
			checkoutController start = new checkoutController();
			start.mainMenuFrame();
			
		  }
			
		});
		

	}
}
