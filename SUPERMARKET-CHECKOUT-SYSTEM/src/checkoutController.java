
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

public class checkoutController implements ActionListener {
	
	private JFrame mainMenuFrame = new JFrame();
	private JFrame checkOutFrame = new JFrame();
	private JFrame scaleFrame = new JFrame();
	private JFrame customerDisplayFrame = new JFrame();
	
	private JPanel mainMenuPanel = new JPanel();
	private JPanel checkOutPanel = new JPanel();
	private JPanel customerDisplayPanel = new JPanel();
	private JPanel scalePanel = new JPanel();
	
	private JLabel welcomeLabel;
	private JLabel checkOutLabel;
	private JLabel itemIdLabel;
	private JLabel enterWeightLabel;
	
	private JButton cashierButton;
	private JButton managerButton;
	private JButton itemIdButton;
	private JButton scaleButton;
	private JButton oneButton;
	private JButton twoButton;
	private JButton threeButton;
	private JButton fourButton;
	private JButton fiveButton;
	private JButton sixButton;
	private JButton sevenButton;
	private JButton eightButton;
	private JButton nineButton;
	private JButton zeroButton;
	private JButton createLoyaltyAccButton;
	private JButton totalButton;
	private JButton exitButton;
	
	private JTextField weightTextField;
	
	private JTextArea itemIdTextArea;
	private JTextArea order;
	private JTextArea customerOrderTextArea;
	
	Boolean firstItemScanned = false;
	
	String weight = "0";
	
	ArrayList<inventory> items = new ArrayList<inventory>();
	ArrayList<inventory> cart = new ArrayList<inventory>();
	
	loyaltyController createAccFrame = new loyaltyController(); 
	
	int W = 1000;
	int H = 1000;
	
	
	/**
	 * 
	 */
	public void mainMenuFrame() {
		
		mainMenuFrame.setSize(W,H);
		mainMenuFrame.setTitle("MAIN MENU");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenuFrame.setVisible(true);
		
		createMainMenuPanel();
		
		mainMenuFrame.setContentPane(mainMenuPanel);
		
		mainMenuPanel.setVisible(true);

		
	}
	
	/**
	 * 
	 */
	public void checkOutFrame() {
		
		checkOutFrame.setSize(W,H);
		checkOutFrame.setTitle("CHECK OUT");
		checkOutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkOutFrame.setVisible(false);
		
		createCheckOutPanel();
		customerDisplayFrame();
		
		checkOutFrame.setContentPane(checkOutPanel);
		

		checkOutPanel.setVisible(true);
		
	}
	
	public void scaleFrame() {
		
		scaleFrame.setSize(300,200);
		scaleFrame.setTitle("SCALE");
		scaleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		scaleFrame.setVisible(true);
		
		createScalePanel();
		
		scaleFrame.setContentPane(scalePanel);
		
		scalePanel.setVisible(true);
		
	}
	
	public void customerDisplayFrame() {
		
		customerDisplayFrame.setSize(W,H);
		customerDisplayFrame.setTitle("CUSTOMER DISPLAY");
		customerDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customerDisplayFrame.setVisible(false);
		
		createCustomerDisplayPanel();
		
		customerDisplayFrame.setContentPane(customerDisplayPanel);
		
		customerDisplayFrame.setVisible(true);
		
		
	}
	
	// Switch between frames
	
	void switchToMainMenuFrame() {
		
		checkOutFrame.setVisible(false);
		mainMenuFrame.setVisible(true);
		customerDisplayFrame.setVisible(false);
		
	}
	
	void switchToCheckOutFrame() {
		
		mainMenuFrame.setVisible(false);
		checkOutFrame.setVisible(true);
		customerDisplayFrame.setVisible(true);
		
	}
	
	// Creates scale components and frame
	
	JPanel createScalePanel() {
		
		scalePanel.setLayout(null);
		
		scalePanel.add(createWeightTextField());
		scalePanel.add(createEnterWeightLabel());
		scalePanel.add(createScaleButton());
		
		
		return scalePanel;
		
		
	}
	
	JTextField createWeightTextField() {
		
		weightTextField = new JTextField();
		weightTextField.setBounds(140,50,70,50);
		
		return weightTextField;
		
	}
	
	JLabel createEnterWeightLabel() {
		
		enterWeightLabel = new JLabel("Enter weight:");
		enterWeightLabel.setBounds(50,50,100,50);
		
		return enterWeightLabel;
		
	}
	
	JButton createScaleButton() {
		
		scaleButton = new JButton("SCALE");
		scaleButton.setBounds(110,100,100,50);
		
		scaleButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					addItemToCart(itemIdTextArea.getText(), weightTextField.getText());	
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				scaleFrame.setVisible(false);
				itemIdTextArea.setText("");
				
			}
			
		});
		
		return scaleButton;
		
	}
	
	// Creates main menu components and panel
	
	JPanel createMainMenuPanel() {
		
		mainMenuPanel.setLayout(null);
		
		mainMenuPanel.add(createMainMenuMessage());
		mainMenuPanel.add(createCashierButton());
		mainMenuPanel.add(createManagerButton());
		
		return mainMenuPanel;
		
	}
	
	JLabel createMainMenuMessage() {
		
		welcomeLabel = new JLabel("WELCOME TO THE STORE");
		welcomeLabel.setBounds(395,300,1000,250);
		
		return welcomeLabel;
	}
	
	JButton createCashierButton() {
		
		cashierButton = new JButton("CASHIER");
		cashierButton.setBounds(200,480,250,100);
		cashierButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				checkOutFrame();
				switchToCheckOutFrame();
				
			}
			
		});
		
		return cashierButton;
	}
	
	JButton createManagerButton() {
		
		managerButton = new JButton("MANAGER");
		managerButton.setBounds(500,480,250,100);
		
		return managerButton;
		
	}
	
	///////////////////////////////////
	
	// Creates customer display panel and components 
	
	JPanel createCustomerDisplayPanel() {
		
		customerDisplayPanel.setLayout(null);
		
		customerDisplayPanel.add(createCustomerDisplayTextArea());
		
		return customerDisplayPanel;
		
		
	}
	
	JTextArea createCustomerDisplayTextArea() {
		
		customerOrderTextArea = new JTextArea();
		customerOrderTextArea.setBounds(240,220,500,500);
		customerOrderTextArea.setEditable(false);
		
		return customerOrderTextArea;
		
	}

	// Creates checkout panel and components
	
	JPanel createCheckOutPanel() {
		
		checkOutPanel.setLayout(null);
		
		checkOutPanel.add(createCheckOutLabel());
		checkOutPanel.add(createExitButton());
		checkOutPanel.add(createOneButton());
		checkOutPanel.add(createTwoButton());
		checkOutPanel.add(createThreeButton());
		checkOutPanel.add(createFourButton());
		checkOutPanel.add(createFiveButton());
		checkOutPanel.add(createSixButton());
		checkOutPanel.add(createSevenButton());
		checkOutPanel.add(createEightButton());
		checkOutPanel.add(createNineButton());
		checkOutPanel.add(createZeroButton());
		checkOutPanel.add(createItemIdButton());
		checkOutPanel.add(createItemIdTextArea());
		checkOutPanel.add(createItemIdLabel());
		checkOutPanel.add(createCreateLoyaltyAccButton());
		checkOutPanel.add(createTotalButton());
		checkOutPanel.add(createOrderTextArea());
		
		return checkOutPanel;
		
	}
	
	JLabel createCheckOutLabel() {
		
		checkOutLabel = new JLabel("CHECKOUT");
		checkOutLabel.setBounds(460,-50,200,200);
		
		return checkOutLabel;
		
	}
	
	JButton createExitButton() {
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(100,830,200,50);
		
		exitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				switchToMainMenuFrame();
				
			}
			
		});
		return exitButton;
		
	}
	
	
	JButton createOneButton() {
		
		oneButton = new JButton("1");
		oneButton.setBounds(700,300,50,50);
		
		oneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("1");
				
			}
			
			
		});
		
		return oneButton;
		
		
	}
	
	JButton createTwoButton() {
		
		twoButton = new JButton("2");
		twoButton.setBounds(760,300,50,50);
		
		twoButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("2");
				
			}
			
		});
		
		return twoButton;
		
	}
	
	JButton createThreeButton() {
		
		threeButton = new JButton("3");
		threeButton.setBounds(820,300,50,50);
		
		threeButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("3");
				
			}
			
		});
		
		return threeButton;
		
	}
	
	JButton createFourButton() {
		
		fourButton = new JButton("4");
		fourButton.setBounds(700,360,50,50);
		
		fourButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("4");
				
			}
			
		});
		
		return fourButton;
		
	}
	
	JButton createFiveButton() {
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(760,360,50,50);
		
		
		fiveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("5");
				
			}
			
		});
		
		return fiveButton;
		
	}
	
	JButton createSixButton() {
		
		sixButton = new JButton("6");
		sixButton.setBounds(820,360,50,50);
		
		
		sixButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("6");
				
			}
			
		});
		
		
		return sixButton;
		
	}
	
	JButton createSevenButton() {
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(700,420,50,50);
		
		
		sevenButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("7");
				
			}
			
		});
		
		
		return sevenButton;
		
	}
	
	JButton createEightButton() {
		
		eightButton = new JButton("8");
		eightButton.setBounds(760,420,50,50);
	
		eightButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("8");
				
			}
			
		});
		
		
		return eightButton;
		
	}
	
	JButton createNineButton() {
		
		nineButton = new JButton("9");
		nineButton.setBounds(820,420,50,50);
		
		nineButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("9");
				
			}
			
		});
		
		
		return nineButton;
		
	}
	
	JButton createZeroButton() {
		
		zeroButton = new JButton("0");
		zeroButton.setBounds(760,480,50,50);
		
		
		zeroButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itemIdTextArea.append("0");
				
			}
			
		});
		
		
		
		return zeroButton;
		
	}
	
	JButton createItemIdButton(){
		
		itemIdButton = new JButton("ITEM-ID");
		itemIdButton.setBounds(735,540,100,50);
		fileParser obj = new fileParser();
		
		
		itemIdButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					items = obj.invArr();
					
					if(!firstItemScanned) {
						
						createAccFrame.createVerifyAccFrame();
						
						firstItemScanned = true;
						
					}
					
					for(inventory item:items) {
			
						if(item.getId().equals(itemIdTextArea.getText()) & item.bulk == true) {
							
							scaleFrame();
							break;
							
						} else {
							
							addItemToCart(itemIdTextArea.getText(), "0");
							itemIdTextArea.setText("");
							break;
							
						}
						
					}
							
 				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ParseException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		
		return itemIdButton;
		
	}
	
	JTextArea createItemIdTextArea() {
		
		itemIdTextArea = new JTextArea();
		itemIdTextArea.setBounds(700,255,170,30);
		
		return itemIdTextArea;
		
	}
	
	JLabel createItemIdLabel() {
		
		itemIdLabel = new JLabel("ITEM ID:");
		itemIdLabel.setBounds(705,130,200,200);
		
		return itemIdLabel;
		
	}
	
	JButton createCreateLoyaltyAccButton() {
		
		createLoyaltyAccButton = new JButton("CREATE LOYALTY ACCOUNT");
		createLoyaltyAccButton.setBounds(390,830,200,50);
		createLoyaltyAccButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				createAccFrame.createLoyaltyFrame(); 
				
			}
			
		});
		
		return createLoyaltyAccButton;
		
	}
	
	JButton createTotalButton() {
		
		totalButton = new JButton("TOTAL");
		totalButton.setBounds(680,830,200,50);
		
		return totalButton;
		
	}
	
	JTextArea createOrderTextArea() {
		
		order = new JTextArea();
		order.setBounds(50,150,500,500);
		order.setEditable(false);
		
		return order;
		
	}
	

	//////////////////////////////////
	
	
	
	/**
	 * 
	 * @param id
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws Exception
	 */
	void addItemToCart(String id, String weight) throws FileNotFoundException, ParseException, Exception {
		fileParser obj = new fileParser();
		items = obj.invArr();		
		
		Double total = 0.00;
		
		Boolean inCart = false;
		
		for(inventory item:items) {
			
			if(id.equals(item.getId())) {
				
				for(inventory itemInCart:cart) {
						
					if(itemInCart.getId().equals(id)) {
						
						if(itemInCart.bulk == true) {
							
							inCart = true;
							itemInCart.weight += 0.0;
							itemInCart.quantityPurchased++;
							break;
							
						} else {
							
							inCart = true;
							itemInCart.quantityPurchased++;
							break;
							
						}
							
					}					

				}
				if(!inCart) {		
					item.weight = Float.parseFloat(weight);
					cart.add(item);
					item.quantityPurchased++;
				}
				
				break;
				
			}
 			
		}
		
		order.setText("");
		customerOrderTextArea.setText("");
		
		for(inventory cartItem:cart) {
			
		
			for(int i = 0; cartItem.quantityPurchased > i; i++) {
				
				if(cartItem.getWeight() > 0) {
					
					order.append(cartItem.getName() + ".......$" + cartItem.getPrice() + "............Weight:" + cartItem.getWeight() + "\n");
					customerOrderTextArea.append(cartItem.getName() + ".......$" + cartItem.getPrice() + "............Weight:" + cartItem.getWeight() + "\n");
					
				} else {
	
					order.append(cartItem.getName() + ".......$" + cartItem.getPrice() + "\n");
					customerOrderTextArea.append(cartItem.getName() + ".......$" + cartItem.getPrice() + "\n");
					
				}
				
				total += cartItem.getPrice();
				
			}

		}
		
		order.append("................................\n");
		order.append("Total:" + total + "\n");
		customerOrderTextArea.append("................................\n");
		customerOrderTextArea.append("Total:" + total + "\n");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
