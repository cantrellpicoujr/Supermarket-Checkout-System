
public class bankInfo {

	String name;
	String acctNum1;
	double acctBal1;
	String creditCardNum1;
	int pin1;
	String acctNum2;
	double acctBal2;
	String creditCardNum2;
	int pin2;
	
	bankInfo(String name, String acctNum1, double acctBal1, String creditCardNum1, int pin1, String acctNum2, double acctBal2, String creditCardNum2, int pin2) {
		
		this.name = name;
		this.acctNum1 = acctNum1;
		this.acctBal1 = acctBal1;
		this.creditCardNum1 = creditCardNum1;
		this.pin1 = pin1;
		
		this.acctNum2 = acctNum2;
		this.acctBal2 = acctBal2;
		this.creditCardNum2 = creditCardNum2;
		this.pin2 = pin2;
		
	}
	
	String getName() {
		
		return name;
		
	}
	
	String getAcctNum1() {
		
		return acctNum1;
		
	}
	
	double getacctBal1() {
		
		return acctBal1;
		
	}
	
	String getCreditCardNum1() {
		
		return creditCardNum1;
		
	}
	
	int getPin1() {
		
		return pin1;
	}
	
	String getAcctNum2() {
		
		return acctNum2;
		
	}
	
	double getAcctBal2() {
		
		return acctBal2;
		
	}
	
	String getCreditCardNum2() {
		
		return creditCardNum2;
		
	}
	
	int getPin2() {
		
		return pin2;
		
	}
	
}
