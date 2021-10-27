
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

public class checkoutController implements ActionListener {
	
	private JFrame mainMenuFrame = new JFrame();
	private JFrame checkOutFrame = new JFrame();
	private JPanel mainMenuPanel = new JPanel();
	private JPanel checkOutPanel = new JPanel();
	private JPanel customerDisplayPanel = new JPanel();
	
	private JLabel welcomeLabel;
	private JLabel checkOutLabel;
	private JLabel itemIdLabel;
	
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
	
	private JTextArea itemIdTextArea;
	private JTextArea order;
	
	ArrayList<inventory> items = new ArrayList<inventory>();
	ArrayList<inventory> cart = new ArrayList<inventory>();
	
	int W = 1000;
	int H = 1000;
	
	public void mainMenuFrame() {
		
		mainMenuFrame.setSize(W,H);
		mainMenuFrame.setTitle("MAIN MENU");
		mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenuFrame.setVisible(true);
		
		createMainMenuPanel();
		
		mainMenuFrame.setContentPane(mainMenuPanel);
		
		mainMenuPanel.setVisible(true);

		
	}
	
	public void checkOutFrame() {
		
		checkOutFrame.setSize(W,H);
		checkOutFrame.setTitle("CHECK OUT");
		checkOutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkOutFrame.setVisible(false);
		
		createCheckOutPanel();
		
		checkOutFrame.setContentPane(checkOutPanel);
		

		checkOutPanel.setVisible(true);
		
	}
	
	// Switch between frames
	
	void switchToMainMenuFrame() {
		
		checkOutFrame.setVisible(false);
		mainMenuFrame.setVisible(true);
		mainMenuFrame.setContentPane(mainMenuPanel);
		
	}
	
	void switchToCheckOutFrame() {
		
		mainMenuFrame.setVisible(false);
		checkOutFrame.setVisible(true);
		checkOutFrame.setContentPane(checkOutPanel);
		
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
		checkOutPanel.add(createScaleButton());
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
	
	JButton createItemIdButton() {
		
		itemIdButton = new JButton("ITEM-ID");
		itemIdButton.setBounds(690,540,100,50);
		
		itemIdButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					addItemToCart(itemIdTextArea.getText());
					
 				}catch(Exception m) {
 					
 					m.printStackTrace();
 					
 				}
				
				itemIdTextArea.setText("");
			}
			
		});
		
		return itemIdButton;
		
	}
	
	JButton createScaleButton() {
		
		scaleButton = new JButton("SCALE");
		scaleButton.setBounds(790,540,100,50);
		
		return scaleButton;
		
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
	
	// Creates customer display panel and display
	
	JPanel createsCustomerDisplayPanel() {
		
		customerDisplayPanel.setLayout(null);
		
		return customerDisplayPanel;
		
	}
	
	//////////////////////////////////
	
	
	/**
	 * 
	 * @param id
	 * @throws FileNotFoundException
	 * @throws ParseException
	 * @throws Exception
	 */
	void addItemToCart(String id) throws FileNotFoundException, ParseException, Exception {
		fileParser obj = new fileParser();
		items = obj.invArr();
		
		Boolean inCart = false;
		
		for(inventory item:items) {
			
			if(id.equals(item.getId())) {
				
				for(inventory itemInCart:cart) {
					
					if(itemInCart.getId().equals(id)) {
						
						inCart = true;
						itemInCart.quantityPurchased++;
						break;
						
					}
					
				}
				if(!inCart) {

					cart.add(item);
					item.quantityPurchased++;
					
				}
				
				break;
				
			} 
 			
		}
		
		order.setText("");
		
		for(inventory cartItem:cart) {
			
			//System.out.println(cartItem.getName());
			//System.out.println(cartItem.getQuantityPurchased());
			

			for(int i = 0; cartItem.quantityPurchased > i; i++) {
				
				order.append(cartItem.getName() + ".......$" + cartItem.getPrice() + "\n");
				
			}

			
		}
		
		order.append("................................\n");
		
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
}
