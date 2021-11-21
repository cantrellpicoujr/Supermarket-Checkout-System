
public class authorizationNumber implements Runnable {
	
	buffer buff;
	Thread t;
	String reply;
	
	authorizationNumber(buffer buff) {
		
		this.buff = buff;
		
		t = new Thread(this, "Authorization Thread");

		t.start();
		
	}
	authorizationNumber() {

		
	}
	
	public void run() {
		
		reply = buff.recieveReply();
		
	}
	

}
