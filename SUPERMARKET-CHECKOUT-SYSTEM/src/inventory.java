
public class inventory {

	float price;
	String name;
	int available;
	int threshold;
	int points;
	boolean bulk;
	String id;
	
	inventory(float price, String name, int available, int threshold, int points, boolean bulk, String id) {
		
		this.price = price;
		this.name = name;
		this.available = available;
		this.threshold = threshold;
		this.points = points;
		this.bulk = bulk;
		this.id = id;
			
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
	
}
