import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class paymentController implements ActionListener {
	
	ArrayList<inventory> cart;
	
	checkoutController obj = new checkoutController();
	
	
	public void printCart() {
		
		cart = obj.getOrder();
		
		for(inventory item:cart) {
			
			System.out.println(item.getName());
			
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	

}
