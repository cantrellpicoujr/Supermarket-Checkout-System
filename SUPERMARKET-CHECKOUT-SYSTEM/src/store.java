
public class store implements Runnable {
	
	Thread t;	
	buffer buff;
	
	String ccNum;
	Double total;
	String ccPin;
	String reply;	
		
	store(buffer buff, String ccNum, String ccPin, Double total) {
		
		this.ccNum = ccNum;
		this.ccPin = ccPin;
		this.total = total;
		this.buff = buff;
		
		t = new Thread(this, "Store Thread");
		
		t.start();
		
	}
	
	public void run() {
			
			buff.get(ccNum, ccPin, total);
			
	}

}
