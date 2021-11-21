import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.SwingUtilities;

import org.json.simple.parser.ParseException;

public class start {
	public static void main(String ...x) throws FileNotFoundException, IOException, ParseException, Exception {
		
		// TO-DO: logic for Loyalty Account Controller 
		

		SwingUtilities.invokeLater(new Runnable() { 
			
			public void run() {
				
			checkoutController start = new checkoutController();
			start.mainMenuFrame();
			
		  }
			
		});

	}
}
