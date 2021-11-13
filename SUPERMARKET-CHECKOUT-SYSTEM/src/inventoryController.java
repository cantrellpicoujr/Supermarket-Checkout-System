import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class inventoryController implements ActionListener {
	
	private JFrame inventoryFrame = new JFrame();
	private JPanel inventoryPanel = new JPanel();
	private JLabel searchItemNameLabel;
	private JLabel searchItemIDLabel;
	private JTextField searchItemNameTextField;
	private JTextField searchItemIDTextField;
	private JLabel searchErrorMessage;
	private JButton searchItemNameButton;
	private JButton searchItemIDButton;
	private JButton mainCancelButton;
	
	//
	
	private JFrame inventoryItemFrame = new JFrame();
	private JPanel inventoryItemPanel = new JPanel();
	private JTextArea itemName;
	private JTextArea itemID;
	private JTextArea itemPrice;
	private JTextArea itemQuantity;
	private JTextArea itemWeight;
	private JLabel orderErrorMessage;
	private JLabel orderSuccessMessage;
	private JTextField orderQuantity;
	private JButton placeOrderButton;
	private JButton itemCancelButton;
	
	private fileParser obj = new fileParser();
	
	private ArrayList<inventory> inv;
	private int width = 400;
	private int height = 400;
	
	public void createMainInventoryFrame() {
		
		inventoryFrame.setSize(width, height);
		inventoryFrame.setTitle("INVENTORY");
		inventoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryFrame.setVisible(true);
		
		createMainInventoryPanel();
		
		inventoryFrame.setContentPane(inventoryPanel);
	}
	
	JPanel createMainInventoryPanel() {
		
		inventoryPanel.setLayout(null);
		
		inventoryPanel.add(createSearchItemNameLabel());
		inventoryPanel.add(createSearchItemIDLabel());
		inventoryPanel.add(createSearchItemNameTextField());
		inventoryPanel.add(createSearchItemIDTextField());
		inventoryPanel.add(createSearchItemNameButton());
		inventoryPanel.add(createSearchItemIDButton());
		inventoryPanel.add(createMainCancelButton());
		inventoryPanel.add(createSearchErrorMessage());
		
		return inventoryPanel;
	}
	
	JLabel createSearchItemNameLabel() {
		
		searchItemNameLabel = new JLabel("ENTER ITEM NAME");
		searchItemNameLabel.setBounds(85, 115, 150, 50);
		
		return searchItemNameLabel;
	}
	
	JLabel createSearchItemIDLabel() {
		
		searchItemIDLabel = new JLabel("OR            ENTER ITEM ID");
		searchItemIDLabel.setBounds(19, 177, 170, 50);
		
		return searchItemIDLabel;
	}
	
	JTextField createSearchItemNameTextField() {
		
		searchItemNameTextField = new JTextField();
		searchItemNameTextField.setBounds(90, 150, 190, 30);
		
		return searchItemNameTextField;
	}
	
	JTextField createSearchItemIDTextField() {
		
		searchItemIDTextField = new JTextField();
		searchItemIDTextField.setBounds(90, 210, 190, 30);
		
		return searchItemIDTextField;
	}
	
	JButton createSearchItemNameButton(){
		   
		searchItemNameButton = new JButton("SEARCH");
		searchItemNameButton.setBounds(280,148,80,35);
   
		searchItemNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					searchItemName(searchItemNameTextField.getText().toLowerCase());
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		return searchItemNameButton;
	}
	
	JButton createSearchItemIDButton() {
		
		searchItemIDButton = new JButton("SEARCH");
		searchItemIDButton.setBounds(280,208,80,35);
   
		searchItemIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					searchItemID(searchItemIDTextField.getText());
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		return searchItemIDButton;
	}
	
	JButton createMainCancelButton() {
		
		mainCancelButton = new JButton("CANCEL");
		mainCancelButton.setBounds(315, 340, 80, 35);
		
		mainCancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				searchItemNameTextField.setText(null);
				searchItemIDTextField.setText(null);
				
				inventoryFrame.setVisible(false);
				
				inventoryPanel.remove(searchItemNameLabel);
				searchItemNameLabel = null;
				inventoryPanel.remove(searchItemIDLabel);
				searchItemIDLabel = null;
				inventoryPanel.remove(searchItemNameTextField);
				searchItemNameTextField = null;
				inventoryPanel.remove(searchItemIDTextField);
				searchItemIDTextField = null;
				inventoryPanel.remove(searchItemNameButton);
				searchItemNameButton = null;
				inventoryPanel.remove(searchItemIDButton);
				searchItemIDButton = null;
				inventoryPanel.remove(searchErrorMessage);
				searchErrorMessage = null;
				
				inventoryPanel = new JPanel();
				inventoryFrame = new JFrame();

				inventoryPanel.remove(mainCancelButton);
				mainCancelButton = null;
			}
		});
		return mainCancelButton;
	}
	
	void searchItemName(String name) throws Exception{
		
		inv = obj.invArr();
		
		for(inventory item : inv) {
			if(item.getName().equals(name)) {
				searchItem(item);
				break;
			}
			if(searchErrorMessage != null) searchErrorMessage.setVisible(true);
		}
	}
	
	void searchItemID(String name) throws Exception{
		
		inv = obj.invArr();
   
		for(inventory item : inv) {
			if(item.getId().equals(name)) {
				searchItem(item);
				break;
			}
			if(searchErrorMessage != null) searchErrorMessage.setVisible(true);
		}
	}
	
	void searchItem(inventory item) {
		
		searchItemNameTextField.setText(null);
		searchItemIDTextField.setText(null);
		
		inventoryFrame.setVisible(false);
		
		inventoryPanel.remove(searchItemNameLabel);
		searchItemNameLabel = null;
		inventoryPanel.remove(searchItemIDLabel);
		searchItemIDLabel = null;
		inventoryPanel.remove(searchItemNameTextField);
		searchItemNameTextField = null;
		inventoryPanel.remove(searchItemIDTextField);
		searchItemIDTextField = null;
		inventoryPanel.remove(searchItemNameButton);
		searchItemNameButton = null;
		inventoryPanel.remove(searchItemIDButton);
		searchItemIDButton = null;
		inventoryPanel.remove(mainCancelButton);
		mainCancelButton = null;
		inventoryPanel.remove(searchErrorMessage);
		searchErrorMessage = null;
		
		inventoryPanel = new JPanel();
		inventoryFrame = new JFrame();
		
		createInventoryItemFrame(item);
	}
	
	JLabel createSearchErrorMessage() {
		
		searchErrorMessage = new JLabel("~~Invalid name or ID~~");
		searchErrorMessage.setBounds(90, 250, 190, 30);
		searchErrorMessage.setVisible(false);
		
		return searchErrorMessage;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	void createInventoryItemFrame(inventory item) {
		
		inventoryItemFrame.setSize(width, height);
		inventoryItemFrame.setTitle(item.getName());
		inventoryItemFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inventoryItemFrame.setVisible(true);
		
		createInventoryItemPanel(item);
		
		inventoryItemFrame.setContentPane(inventoryItemPanel);
	}
	
	JPanel createInventoryItemPanel(inventory item) {
		
		inventoryItemPanel.setLayout(null);
		
		inventoryItemPanel.add(createItemName(item.getName()));
		inventoryItemPanel.add(createItemID(item.getId()));
		inventoryItemPanel.add(createItemPrice(item.getPrice()));
		inventoryItemPanel.add(createItemQuantity(item.getAvailable()));
		if(item.getBulk()) inventoryItemPanel.add(createItemWeight(item.getWeight()));
		if(item.getAvailable() < item.getThreshold()) {
			inventoryItemPanel.add(createOrderQuantity());
			inventoryItemPanel.add(createPlaceOrderButton());
		}
		inventoryItemPanel.add(createItemCancelButton());
		inventoryItemPanel.add(createOrderErrorMessage());
		inventoryItemPanel.add(createOrderSuccessMessage());
		
		return inventoryItemPanel;
	}
	
	JTextArea createItemName(String name) {
		
		itemName = new JTextArea("Name : " + name);
		itemName.setBounds(85, 100, 230, 20);
		itemName.setEditable(false);
		
		return itemName;
	}
	
	JTextArea createItemID(String id) {
		
		itemID = new JTextArea("ID : " + id);
		itemID.setBounds(85, 120, 230, 20);
		itemID.setEditable(false);
		
		return itemID;
	}
	
	JTextArea createItemPrice(float price) {
		
		itemPrice = new JTextArea("Price : " + price);
		itemPrice.setBounds(85, 140, 230, 20);
		itemPrice.setEditable(false);
		
		return itemPrice;
	}
	
	JTextArea createItemWeight(float weight) {
		
		itemWeight = new JTextArea("Weight : " + weight);
		itemWeight.setBounds(85, 180, 230, 20);
		itemWeight.setEditable(false);
		
		return itemWeight;
	}
	
	JTextArea createItemQuantity(int available) {
		
		itemQuantity = new JTextArea("Quantity Available : " + available);
		itemQuantity.setBounds(85, 160, 230, 20);
		itemQuantity.setEditable(false);
		
		return itemQuantity;
	}
	
	JTextField createOrderQuantity() {
		
		orderQuantity = new JTextField();
		orderQuantity.setBounds(50, 210, 190, 30);
		
		return orderQuantity;
	}
	
	JButton createPlaceOrderButton() {
		
		placeOrderButton = new JButton("PLACE ORDER");
		placeOrderButton.setBounds(240, 208, 100, 35);
		
		placeOrderButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Integer.parseInt(orderQuantity.getText());
					orderErrorMessage.setVisible(false);
					orderSuccessMessage.setVisible(true);
				}
				catch(NumberFormatException e1) {
					
					orderSuccessMessage.setVisible(false);
					orderErrorMessage.setVisible(true);
				}
			}
		});
		return placeOrderButton;
	}
	
	JButton createItemCancelButton() {
		
		itemCancelButton = new JButton("CANCEL");
		itemCancelButton.setBounds(315, 340, 80, 35);
		
		itemCancelButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				inventoryItemFrame.setVisible(false);
				
				inventoryItemPanel.remove(itemName);
				itemName = null;
				inventoryItemPanel.remove(itemID);
				itemID = null;
				inventoryItemPanel.remove(itemPrice);
				itemPrice = null;
				inventoryItemPanel.remove(itemQuantity);
				itemQuantity = null;
				inventoryItemPanel.remove(orderErrorMessage);
				orderErrorMessage = null;
				inventoryItemPanel.remove(orderSuccessMessage);
				orderSuccessMessage = null;
				
				if(itemWeight != null) {
					inventoryItemPanel.remove(itemWeight);
					itemWeight = null;
				}
				if(orderQuantity != null) {
					orderQuantity.setText(null);
					inventoryItemPanel.remove(orderQuantity);
					orderQuantity = null;
				}
				if(placeOrderButton != null) {
					inventoryItemPanel.remove(placeOrderButton);
					placeOrderButton = null;
				}
				
				inventoryItemPanel.remove(itemCancelButton);
				itemCancelButton = null;

				inventoryItemPanel = new JPanel();
				inventoryItemFrame = new JFrame();
			}
			
		});
		
		return itemCancelButton;
	}
	
	JLabel createOrderErrorMessage() {
		
		orderErrorMessage = new JLabel("~~Invalid order quantity~~");
		orderErrorMessage.setBounds(62, 230, 190, 30);
		orderErrorMessage.setVisible(false);
		
		return orderErrorMessage;
	}
	
	JLabel createOrderSuccessMessage() {
		
		orderSuccessMessage = new JLabel("~~Order successfully placed~~");
		orderSuccessMessage.setBounds(49, 230, 200, 30);
		orderSuccessMessage.setVisible(false);
		
		return orderSuccessMessage;
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
}