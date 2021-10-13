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
	
	/**
	 * 
	 * 
	 * @param name
	 * @param phoneNumber
	 * @param pin
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
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
				.replace("\"phoneNumber", "\n\t\"phoneNumber")
				.replace("\"Pin", "\n\t\"Pin")
				.replace("\"Points", "\n\t\"Points")
				.replace("},{", "},\n\n\t{")
				);
		
		pw.flush();
		pw.close();
	}
	
	/**
	 * 
	 * @param phoneNumber
	 * @param points
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
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
	 * 
	 * @param phoneNumber
	 * @param points
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
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
	 * 
	 * @param itemId
	 * @param quantity
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void decreaseInventoryQuantity(String itemId, int quantity) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator itterate = array.iterator();
		
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
					.replace("},{", "},\n\n\t{")
					);
			
			pw.close();
			pw.flush();
			
			
			
		}
		
		
	}
	
	/**
	 * 
	 * @param itemId
	 * @param quantity
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public void increaseInventoryQuantity(String itemId, int quantity) throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator itterate = array.iterator();
		
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
					.replace("},{", "},\n\n\t{")
					);
			
			pw.close();
			pw.flush();
			
			
			
		}
		
		
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 */
	public ArrayList<inventory> invArr() throws FileNotFoundException, IOException, ParseException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/inventory.json"));
		
		Iterator itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			float price = ((float) arrItem.get("price"));
			String name = (String) arrItem.get("name");
			int available = (int) arrItem.get("availble");
			int threshold = (int) arrItem.get("threshold");
			int points = (int) arrItem.get("points");
			Boolean bulk = (Boolean) arrItem.get("bulk");
			String id = (String) arrItem.get("id");
			
			invArr.add(new inventory(price, name, available, threshold, points, bulk, id));
			
		}
		
		return invArr;
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws IOException
	 */
	
	public ArrayList<loyaltyAccounts> loyaltyAccArr() throws FileNotFoundException, ParseException, IOException {
		
		JSONParser parser = new JSONParser();
		JSONArray array = (JSONArray) parser.parse(new FileReader("/Users/cantrellpicoujr/Documents/CS_3365-Software-Engineering/Supermarket-Checkout-System/loyalAccounts.json"));
		
		Iterator itterate = array.iterator();
		
		while(itterate.hasNext()) {
			
			JSONObject arrItem = (JSONObject) itterate.next();
			
			int points = (int) arrItem.get("points");
			String pin = (String) arrItem .get("pin");
			String phoneNumber = (String) arrItem.get("phonenumber");
			String name = (String) arrItem.get("name");
			
			loyaltyAccArr.add(new loyaltyAccounts(name, pin, phoneNumber, points));
			
		}
		
		
		return loyaltyAccArr;
	}
		
}