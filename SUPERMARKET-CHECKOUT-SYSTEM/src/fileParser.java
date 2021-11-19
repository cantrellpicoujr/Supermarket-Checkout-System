import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

 class fileParser {
	
	 
	 ArrayList<inventory> invArr  = new ArrayList<inventory>();
	 ArrayList<loyaltyAccounts> loyaltyAccArr = new ArrayList<loyaltyAccounts>();
	 ArrayList<bankInfo> bankInfoArr = new ArrayList<bankInfo>();
	
	/**
	 * This function creates an account and stores it in the loyalAccounts.json
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param pin
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 * Author: Cantrell Picou Jr.
	 */
	public void createLoyaltyAcc(String name, String phoneNumber, String pin) throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json"));
		Map<String, Serializable> newMap = new LinkedHashMap<String, Serializable>(4);
		
		newMap.put("Name", name);
		newMap.put("PhoneNumber", phoneNumber);
		newMap.put("Pin", pin);
		newMap.put("Points", 0);
		
		array.add(newMap);
		
		PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json");
		pw.write(array.toJSONString()
				.replace("\"Name", "\n\t\"Name")
				.replace("\"PhoneNumber", "\n\t\"PhoneNumber")
				.replace("\"Pin", "\n\t\"Pin")
				.replace("\"Points", "\n\t\"Points")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.flush();
		pw.close();
	}
	
	/**
	 * This function adds points to the correct customers accounts.
	 * 
	 * @param phoneNumber
	 * @param points
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 * Author: Cantrell Picou Jr.
	 */
	public void addPoints(String phoneNumber, int points) throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			int addPoints = ((Long)arrItem.get("Points")).intValue();
			String phoneNum = (String) arrItem.get("PhoneNumber");
			
			if(phoneNumber.equals(phoneNum)) {
				
				arrItem.put("Points", addPoints + points);
				
			}

			
		}
		
		PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json");
		pw.write(array.toJSONString()
				.replace("\"Name", "\n\t\"Name")
				.replace("\"phoneNumber", "\n\t\"phoneNumber")
				.replace("\"Pin", "\n\t\"Pin")
				.replace("\"Points", "\n\t\"Points")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.close();
		pw.flush();
		
	}
	
	/**
	 * This function subtracts points from the correct customers account.
	 * 
	 * @param phoneNumber
	 * @param points
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 * Author: Cantrell Picou Jr.
	 */
	public void subtractPoints(String phoneNumber, int points) throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			int addPoints = ((Long)arrItem.get("Points")).intValue();
			String phoneNum = (String) arrItem.get("phonenumber");
			
			if(phoneNumber.equals(phoneNum)) {
				
				arrItem.put("Points", addPoints - points);
				
			}

			
		}
		
		PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json");
		pw.write(array.toJSONString()
				.replace("\"Name", "\n\t\"Name")
				.replace("\"phonenumber", "\n\t\"phonenumber")
				.replace("\"Pin", "\n\t\"Pin")
				.replace("\"Points", "\n\t\"Points")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.close();
		pw.flush();
		
	}
	
	/**
	 * This function decreases the inventory quantity.
	 * 
	 * @param itemId
	 * @param quantity
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * Author: Cantrell Picou Jr.
	 */
	public void decreaseInventoryQuantity(String itemId, int quantity) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			String id = (String) arrItem.get("id");
			int available =((int) arrItem.get("available"));
			
			
			if(itemId.equals(id)) {
				
				arrItem.put("available", available - quantity);
				
			}
			
			PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json");
			
			pw.write(array.toJSONString()
					.replace("\"price", "\n\t\"price")
					.replace("\"name", "\n\t\"name")
					.replace("\"available", "\n\t\"available")
					.replace("\"id", "\n\t\"id")
					.replace("\"threshold", "\n\t\"threshold")
					.replace("\"points", "\n\t\"points")
					.replace("\"bulk", "\n\t\"bulk")
					.replace("\"weight", "\n\t\"weight")
					.replace("},{", "},\n\n\t{")
					);
			
			pw.close();
			pw.flush();
			
			
		}
		
		
	}
	
	/**
	 * This function increases the inventory quantity.
	 * 
	 * @param itemId
	 * @param quantity
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * Author: Cantrell Picou Jr.
	 */
	public void increaseInventoryQuantity(String itemId, int quantity) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			String id = (String) arrItem.get("id");
			int available =((Long) arrItem.get("available")).intValue();
			
			
			if(itemId.equals(id)) {
				
				arrItem.put("available", available + quantity);
				
			}
			
			PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json");
			
			pw.write(array.toJSONString()
					.replace("\"price", "\n\t\"price")
					.replace("\"name", "\n\t\"name")
					.replace("\"available", "\n\t\"available")
					.replace("\"id", "\n\t\"id")
					.replace("\"threshold", "\n\t\"threshold")
					.replace("\"points", "\n\t\"points")
					.replace("\"bulk", "\n\t\"bulk")
					.replace("\"weight", "\n\t\"weight")
					.replace("},{", "},\n\n\t{")
					);
			
			pw.close();
			pw.flush();
			
			
		}
		
	}
	

	/**
	 * This function increases the account balance.
	 * 
	 * @param cc1
	 * @param cc2
	 * @param amnt
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	void incAccBal(String cc, double amnt) throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/bankInfo.json"));
		
		Iterator<?> itterate = arr.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			String ccNum1 = (String) arrItem.get("creditCard-1");
			Double acctBal1 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-1")));
			String ccNum2 = (String) arrItem.get("creditCard-2");
			Double acctBal2 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-2")));
			
			if(cc.equals(ccNum1)) {
				
				arrItem.put("accountBalance-1", acctBal1 + amnt);
				
			} else if (cc.equals(ccNum2)) {
				
				arrItem.put("accountBalance-2", acctBal2 + amnt);
			}
			
		}
		
		PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/bankInfo.json");
		
		pw.write(arr.toJSONString()
				.replace("\"name", "\n\t\"name")
				.replace("\"accountnumber-1", "\n\t\"accountnumber-1")
				.replace("\"accountBalance-1", "\n\t\"accountBalance-1")
				.replace("\"creditCard-1", "\n\t\"creditCard-1")
				.replace("\"pin-1", "\n\t\"pin-1")
				.replace("\"accountnumber-2", "\n\t\"accountnumber-2")
				.replace("\"accountBalance-2", "\n\t\"accountBalance-2")
				.replace("\"creditcard-2", "\n\t\"creditcard-2")
				.replace("\"pin-2", "\n\t\"pin-2")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.flush();
		pw.close();
		
	}
	
	/**
	 * This function decreases the account balance.
	 * 
	 * @param cc1
	 * @param cc2
	 * @param amnt
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	void decAccBal(String cc, double amnt) throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/bankInfo.json"));
		
		Iterator<?> itterate = arr.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			String ccNum1 = (String) arrItem.get("creditCard-1");
			Double acctBal1 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-1")));
			String ccNum2 = (String) arrItem.get("creditCard-2");
			Double acctBal2 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-2")));
			
			if(cc.equals(ccNum1)) {
				
				arrItem.put("accountBalance-1", acctBal1 - amnt);
				
			} else if(cc.equals(ccNum2)) {
				
				arrItem.put("accountBalance-2", acctBal2 - amnt);
				
			}
			
		}
		
		PrintWriter pw = new PrintWriter("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/bankInfo.json");
		
		pw.write(arr.toJSONString()
				.replace("\"name", "\n\t\"name")
				.replace("\"accountnumber-1", "\n\t\"accountnumber-1")
				.replace("\"accountBalance-1", "\n\t\"accountBalance-1")
				.replace("\"creditCard-1", "\n\t\"creditCard-1")
				.replace("\"pin-1", "\n\t\"pin-1")
				.replace("\"accountnumber-2", "\n\t\"accountnumber-2")
				.replace("\"accountBalance-2", "\n\t\"accountBalance-2")
				.replace("\"creditcard-2", "\n\t\"creditcard-2")
				.replace("\"pin-2", "\n\t\"pin-2")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.flush();
		pw.close();
		
	}
	
	/**
	 * This function creates an array list for the inventory.
	 * 
	 * @return invArr
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * Author: Cantrell Picou Jr.
	 */
	public ArrayList<inventory> invArr() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			float price = Float.parseFloat(String.valueOf(arrItem.get("price")));
			String name = (String) arrItem.get("name");
			int available = Integer.parseInt(String.valueOf(arrItem.get("available")));
			int threshold = Integer.parseInt(String.valueOf(arrItem.get("threshold")));
			int points = Integer.parseInt(String.valueOf(arrItem.get("points")));
			Boolean bulk = (Boolean) arrItem.get("bulk");
			String id = (String) arrItem.get("id");
			
			invArr.add(new inventory(price, name, available, threshold, points, bulk, id));
			
		}
		
		return invArr;
	}
	
	
	/**
	 * This function creates an array list for the loyalty accounts.
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 * Author: Cantrell Picou Jr.
	 */
	public ArrayList<loyaltyAccounts> loyaltyAccArr() throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json"));
		
		Iterator<?> itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			int points = Integer.parseInt(String.valueOf(arrItem.get("Points")));
			String pin = (String) arrItem .get("Pin");
			String phoneNumber = (String) arrItem.get("PhoneNumber");
			String name = (String) arrItem.get("Name");
			
			loyaltyAccArr.add(new loyaltyAccounts(name, pin, phoneNumber, points));
			
		}
		
		return loyaltyAccArr;
	}
	
	/**
	 * This function creates an array list for the bank accounts. 
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 * Author: Cantrell Picou Jr.
	 */
	public ArrayList<bankInfo> bankInfoArr() throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parse = new JSONParser();
		JSONArray arr = (JSONArray) parse.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/bankInfo.json"));
		
		Iterator<?> itterate = arr.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			String name = (String) arrItem.get("name");
			String accNum1 = (String) arrItem.get("accountnumber-1");
			double acctBal1 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-1")));
			String cc1 = (String) arrItem.get("creditCard-1");
			int pin1 = Integer.parseInt(String.valueOf(arrItem.get("pin-1")));
			String accNum2 = (String) arrItem.get("accountnumber-2");
			double acctBal2 = Double.parseDouble(String.valueOf(arrItem.get("accountBalance-2")));
			String cc2 = (String) arrItem.get("creditCard-2");
			int pin2 = Integer.parseInt(String.valueOf(arrItem.get("pin-2")));
					
			bankInfoArr.add(new bankInfo(name, accNum1, acctBal1, cc1, pin1, accNum2, acctBal2, cc2, pin2));
	
		}
		
		return bankInfoArr;
		
	}
		
}