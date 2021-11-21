import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;

public class bank implements Runnable {
	
	buffer buff;
	Thread t;
	
	fileParser fileObj = new fileParser();
	ArrayList<bankInfo> arr = new  ArrayList<bankInfo>();
	
	String ccNum;
	String ccPin;
	static String authNum;
	Double total;
	
	Boolean verifySet = false;

	
	bank(buffer buff) {
		
		this.buff = buff;
		
		t = new Thread(this, "Bank Thread");
		
		t.start();
		
	}
	
	
	Boolean verifyCard() throws ParseException {
		
		try {
			
			arr = fileObj.bankInfoArr();
			
		} catch(IOException e) {
			
			
			
		}

		for(bankInfo acc:arr) {
			
			if(acc.getCreditCardNum1().equals(ccNum) || acc.getCreditCardNum2().equals(ccNum)) {

				if(acc.getPin1().equals(ccPin) || acc.getPin2().equals(ccPin)) {
					
					verifySet = true;
					
				}
				
			}
			
		}
		
		return verifySet;
			
	}
	
	static String generateAuthNum() {
		
		SecureRandom random = new SecureRandom();
		Integer num = random.nextInt(1000000000);
		String formatted = String.format("09%d", num);
		
		return formatted;
		
	}
	
	public void run() {
		
		this.ccNum = buff.recieveCcNum();
		this.ccPin = buff.recieveCcPin();
		this.total = buff.recieveTotal();
		
		 try {
			if(verifyCard()) {
				
				authNum = generateAuthNum();
				buff.getReply(authNum);
				
			}
		} catch (ParseException e) {
			
		}
		
	}

}
