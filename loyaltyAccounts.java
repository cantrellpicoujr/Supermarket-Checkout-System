
public class loyaltyAccounts {

	String name;
	String pin;
	String phoneNumber;
	int points;
	
	loyaltyAccounts(String name, String pin, String phoneNumber, int points) {
		
		this.name = name;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.points = points;
		
	}
	
	String getName() {
		
		return name;
		
	}
	
	String getPin() {
		
		return pin;
		
	}
	
	String getPhoneNumber() {
		
		return phoneNumber;
		
	}
	
	int getPoints() {
		
		return points;
		
	}
	
}
