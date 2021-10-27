
public class inventory {

	float price;
	String name;
	int available;
	int threshold;
	int points;
	boolean bulk;
	String id;
	int quantityPurchased;
	
	inventory(float price, String name, int available, int threshold, int points, boolean bulk, String id) {
		
		this.price = price;
		this.name = name;
		this.available = available;
		this.threshold = threshold;
		this.points = points;
		this.bulk = bulk;
		this.id = id;
			
	}
	
	inventory(float price, String name, int points, String id, int quantityPurchased) {
		
		this.price = price;
		this.name = name;
		this.points = points;
		this.id = id;
		this.quantityPurchased = quantityPurchased;
		
	}
	
	
	
	float getPrice() {
		
		return price;
		
	}
	
	String getName() {
		
		return name;
		
	}
	
	int getAvailable( ) {
		
		return available;
		
	}
	
	int getThreshold() {
		
		return threshold;
		
	}
	
	int getPoints() {
	
		return points;
	
	}
	
	boolean getBulk() {
		
		return bulk;
		
	}
	
	String getId() {
		
		return id;
		
	}
	
	int getQuantityPurchased() {
		
		return quantityPurchased;
		
	}
	
	
	
}
