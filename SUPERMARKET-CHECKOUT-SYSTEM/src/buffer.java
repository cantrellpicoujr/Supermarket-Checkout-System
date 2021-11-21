
public class buffer {
	
	String ccNum;
	String reply;
	
	String ccPin;
	Integer num;
	double total;
	
	Boolean valueSet = false;
	
	synchronized String recieveCcNum() {
		
		while(!valueSet) {
			
			try {
				
				wait();
				Thread.sleep(500);

				
			} catch(InterruptedException e) {
				
				
				
			}
			
		}
		
		System.out.println("ccNum: " + ccNum);
		valueSet = false;
		notify();
		
		return ccNum;
		
		
	}
	
	synchronized String recieveCcPin() {
		
		while(valueSet) {
			
			try {
				
				wait();
				Thread.sleep(500);

			} catch(InterruptedException e) {
				
			}
			
		}
		
		System.out.println("ccPin: " + ccPin);
		valueSet = true;
		notify();
		
		return ccPin;
		
		
	}
	
	synchronized double recieveTotal() {
		
		while(!valueSet) {
			
			try {
				
				wait();
				Thread.sleep(500);
				
			} catch(InterruptedException e) {
				
				
			}
			
		}
		
		System.out.println("Total: " + total);
		valueSet = false;
		notify();
		
		return total;
		
	}
	
	synchronized String recieveReply() {
		
		while(!valueSet) {
			
			try {
				
				
				wait();
				Thread.sleep(500);

				
			} catch(InterruptedException e) {
				
				
			}
			
		}
		
		valueSet = false;
		System.out.println("Recieved reply: " + this.reply);
		notify();
		
		return reply;
		
	}
	
	synchronized void getReply(String reply) {
		
		while(valueSet) {
			
			try {
				
				wait();
				Thread.sleep(500);
		
				
			} catch(InterruptedException e) {
				
			}
			
		}
		
		this.reply = reply;
		System.out.println("Reply: " + this.reply);
		valueSet = true;
		notify();
		
		
	}
	
	synchronized void get(String ccNum, String ccPin, double total) {
		
		while(valueSet) {
			
			try {
				
				wait();
				Thread.sleep(500);

				
			} catch(InterruptedException e) {
				
				
			}	
			
		}
		
		this.ccNum = ccNum;
		this.ccPin = ccPin;
		this.total = total;
		valueSet = true;
		notify();
		
	}
	
}
