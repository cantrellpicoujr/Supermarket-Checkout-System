import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

public class paymentController implements ActionListener{
	
	private JFrame customerDisplayFrame = new JFrame();
	private JFrame cashierDisplayFrame = new JFrame();
	private JFrame receiptDisplayFrame = new JFrame();
	
	private JPanel customerDisplayPanel = new JPanel(); //for total including tax
	private JPanel customerDisplayPanel2 = new JPanel(); //for change back
	private JPanel customerDisplayPanel3 = new JPanel(); //for credit or debit
	private JPanel customerDisplayPanel4 = new JPanel(); //for card information
	private JPanel cashierDisplayPanel = new JPanel(); //for payment option
	private JPanel cashierDisplayPanel2 = new JPanel(); //for cash amount:
	private JPanel cashierDisplayPanel3 = new JPanel(); //for change amount:
	private JPanel cashierDisplayPanel4 = new JPanel(); //for order cancelled
	private JPanel cashierDisplayPanel5 = new JPanel(); //for pending card transcation
	private JPanel receiptDisplayPanel = new JPanel();
	
	private JLabel welcomeLabel;
	private JLabel cashAmountLabel;
	private JLabel changeAmountLabel;
	private JLabel cashFailedLabel;
	private JLabel ccNumberLabel;
	private JLabel dcNumberLabel;
	private JLabel cvcLabel;
	private JLabel expLabel;
	private JLabel pinLabel;
	private JLabel checkLabel;
	private JLabel pendingLabel;
	
	private JButton cashButton;
	private JButton cardButton;
	private JButton checkButton;
	private JButton noneButton;
	private JButton confirmButton;
	private JButton creditButton;
	private JButton debitButton;
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
	private JButton deleteButton;
	private JButton enterButton;
	private JButton enterButton2;
	private JButton dotButton;
	private JButton proceedButton;
	
	private JTextField weightTextField; //need explaining
	private JTextArea TextArea; //^
	private JTextArea customerOrder2TextArea; //^
	private JTextArea recieptTextArea;
	
	Boolean firstItemScanned = false;
	Boolean paymentSuccess = false;
	
	String weight = "0";
	
	/**
	 * Place this block of code where the debit/credit will be called,
	 */
	
	/*
	buffer buff = new buffer();
	
	store storeObj = new store(buff, "1111111111111111", "1111", 1.00); //First argument is number, second is pin, third is total 
	
	bank bankObj = new bank(buff);
	
	authorizationNumber authNumObj = new authorizationNumber(buff);
	
	
	try { 
		
		bankObj.t.join();
		storeObj.t.join();
		authNumObj.t.join();
		
	} catch(InterruptedException e) {
		
		
	}
	
	System.out.println(authNumObj.reply); // makes sure you are getting back authorization number
	*/
		
	//checkoutController checkout = new checkoutController();
	
	loyaltyController createAccFrame = new loyaltyController(); 
	
	int W = 1000;
	int H = 1000;
	int choice = 0;
	int button = 0;
	int loop = 0;
	int ccNumber;
	int cvc;
	int exp;
	int pin;
	int inc = 0;
	int num = 0; //keeps track of what input is asked for
	int num2 = 0;
	
	boolean debit = true;
	double total = 0;
	double ptTotal;
	double taxTotal = 0;
	double cash = 0;
	double change = 0;
	double checkAmount = 0;
	double tmp;
	String name = "";
	boolean enterPressed = false;
	

	ArrayList<inventory> cart;
	
	
	checkoutController obj = new checkoutController();
	
	
	public void printCart() {
		
		cart = obj.getOrder();
		
		for(inventory item:cart) {
			
			System.out.println(item.getName());
			System.out.println(item.getQuantityPurchased());
			tmp = (item.getPrice()) * (item.getQuantityPurchased());
			total += tmp;
			
		}
		System.out.println("The total is" + total);
		
		
	}
	
	
	public static String removeLastChar(String str) {
		   String result = null;
		   if ((str != null) && (str.length() > 0)) {
		      result = str.substring(0, str.length() - 1);
		   }
		   return result;
	}
	
	public double toDouble(String str) {
		double temp = Double.parseDouble(str); 
		return temp;
	}
	
	public int toInt(String str) {
		int temp = Integer.parseInt(str); 
		return temp;
	}
	
	double calculateTotal(double preTaxTotal) {
		double tax = .0875;
		taxTotal = preTaxTotal * tax;
		taxTotal = Math.round(taxTotal*100.0)/100.0;
		preTaxTotal = preTaxTotal + (preTaxTotal * tax);
		preTaxTotal = Math.round(preTaxTotal*100.0)/100.0;
		return preTaxTotal;
	}
	
	void displayTotal() { 
		customerOrder2TextArea.setText("Total including tax: " + total);
	}
	
	void createNumpad(int paymentChoice) {
		if(paymentChoice == 2 || paymentChoice == 3) { //card numPad
			customerDisplayPanel.add(createTextArea());
			customerDisplayPanel.add(createDeleteButton());
			customerDisplayPanel.add(createOneButton());
			customerDisplayPanel.add(createTwoButton());
			customerDisplayPanel.add(createThreeButton());
			customerDisplayPanel.add(createFourButton());
			customerDisplayPanel.add(createFiveButton());
			customerDisplayPanel.add(createSixButton());
			customerDisplayPanel.add(createSevenButton());
			customerDisplayPanel.add(createEightButton());
			customerDisplayPanel.add(createNineButton());
			customerDisplayPanel.add(createZeroButton());
			customerDisplayPanel.add(createEnter2Button());
		} else if(paymentChoice == 1) { //cash numPad
			cashierDisplayPanel.add(createCashDisplayMessage());
			cashierDisplayPanel.add(createTextArea());
			cashierDisplayPanel.add(createDeleteButton());
			cashierDisplayPanel.add(createOneButton());
			cashierDisplayPanel.add(createTwoButton());
			cashierDisplayPanel.add(createThreeButton());
			cashierDisplayPanel.add(createFourButton());
			cashierDisplayPanel.add(createFiveButton());
			cashierDisplayPanel.add(createSixButton());
			cashierDisplayPanel.add(createSevenButton());
			cashierDisplayPanel.add(createEightButton());
			cashierDisplayPanel.add(createNineButton());
			cashierDisplayPanel.add(createZeroButton());
			cashierDisplayPanel.add(createEnterButton());
			cashierDisplayPanel.add(createDotButton());
		} else if(paymentChoice == 4) {
			//cashierDisplayPanel.add(createCashDisplayMessage());
			cashierDisplayPanel.add(createTextArea());
			cashierDisplayPanel.add(createDeleteButton());
			cashierDisplayPanel.add(createOneButton());
			cashierDisplayPanel.add(createTwoButton());
			cashierDisplayPanel.add(createThreeButton());
			cashierDisplayPanel.add(createFourButton());
			cashierDisplayPanel.add(createFiveButton());
			cashierDisplayPanel.add(createSixButton());
			cashierDisplayPanel.add(createSevenButton());
			cashierDisplayPanel.add(createEightButton());
			cashierDisplayPanel.add(createNineButton());
			cashierDisplayPanel.add(createZeroButton());
			cashierDisplayPanel.add(createEnterButton3());
			cashierDisplayPanel.add(createDotButton());
		}
	}
	
	JTextArea createCustomerDisplayTextArea() {
		
		customerOrder2TextArea = new JTextArea();
		customerOrder2TextArea.setBounds(240,220,500,250);
		customerOrder2TextArea.setEditable(false);
		
		return customerOrder2TextArea;
	}
	/**
	 * 
	 */
	public void cashierDisplayFrame() {
		
		cashierDisplayFrame.setSize(W,H);
		cashierDisplayFrame.setTitle("Cashier Display");
		cashierDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cashierDisplayFrame.setVisible(true); // true or false
		
		createCashierDisplayPanel();
		customerDisplayFrame();
		
		cashierDisplayFrame.setContentPane(cashierDisplayPanel);
		
		cashierDisplayPanel.setVisible(true);

	}
	
	public void customerDisplayFrame() {
		
		customerDisplayFrame.setSize(W,H);
		customerDisplayFrame.setTitle("Customer Display");
		customerDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		customerDisplayFrame.setVisible(false);
		
		createCustomerDisplayPanel();
		
		customerDisplayFrame.setContentPane(customerDisplayPanel);
		
		customerDisplayFrame.setVisible(true);
		
		
	}
	
	public void createRecieptDisplayFrame() {
		receiptDisplayFrame.setSize(W,H);
		receiptDisplayFrame.setTitle("Reciept");
		receiptDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		receiptDisplayFrame.setVisible(true); // true or false
		
		createReceiptDisplayPanel();
		
		receiptDisplayFrame.setContentPane(receiptDisplayPanel);
		receiptDisplayPanel.setVisible(true);
		
	}
	
	
	JPanel createReceiptDisplayPanel() {
		receiptDisplayPanel.setLayout(null);
		receiptDisplayPanel.add(createRecieptTextArea());

		return receiptDisplayPanel;
	}
	
	// Creates customer display panel and components 
	
	JPanel createCustomerDisplayPanel() {
		
		customerDisplayPanel.setLayout(null);
		customerDisplayPanel.add(createCustomerDisplayTextArea());
		ptTotal = total;
		ptTotal = Math.round(ptTotal*100.0)/100.0;
		if(loop == 0) {
			total = calculateTotal(total);
		}
		loop += 1;
		displayTotal();
		
		return customerDisplayPanel;
	}
	
	JPanel createCustomerDisplayPanel2() {
		
		//customerDisplayPanel.add(createCustomerDisplayTextArea());
		//if(cash)
		customerOrder2TextArea.setText("Change:" + change);
		
		return customerDisplayPanel;
	}
	
	JPanel createCustomerDisplayPanel3() {
		
		//customerDisplayPanel.setLayout(null);
		customerDisplayPanel.removeAll();
		customerDisplayPanel.updateUI();
		
		customerDisplayPanel.add(createDebitButton());
		customerDisplayPanel.add(createCreditButton());

		return customerDisplayPanel;
	}
	
	JPanel createCustomerDisplayPanel4() {
		
		//customerDisplayPanel.setLayout(null);
		customerDisplayPanel.removeAll();
		customerDisplayPanel.updateUI();
		
			if(button == 0) { //credit
				customerDisplayPanel.setLayout(null);
				if(choice == 2) {
					customerDisplayPanel.add(createDCNumberLabelDisplayMessage());
					
		 		} else if(choice == 3) {
					customerDisplayPanel.add(createCCNumberLabelDisplayMessage());
				}
				createNumpad(choice);
				
				
			}
			if(choice == 3) {
				//add pin part
			}
			
	
		return customerDisplayPanel;
	}
	
	JPanel createCustomerDisplayPanel5() {
		customerDisplayPanel.removeAll();
		customerDisplayPanel.updateUI();
		
		customerDisplayPanel.add(createCashFailedDisplayMessage());
		
		return customerDisplayPanel;
	}
	
	JTextArea createRecieptTextArea() {
		
		recieptTextArea = new JTextArea();
		recieptTextArea.setBounds(240,220,500,250);
		recieptTextArea.setEditable(false);
		
		return recieptTextArea;
	}
	
	JPanel createCashierDisplayPanel() {
		customerDisplayPanel.removeAll();
		customerDisplayPanel.updateUI();
		cashierDisplayPanel.setLayout(null);
		
		cashierDisplayPanel.add(createCashierDisplayMessage());
		cashierDisplayPanel.add(createCashButton());
		cashierDisplayPanel.add(createCardButton());
		cashierDisplayPanel.add(createCheckButton());
		cashierDisplayPanel.add(createNoneButton());
		
		return cashierDisplayPanel;
		
	}

	JPanel createCashierDisplayPanel2() {
	
	//cashierDisplayPanel.setLayout(null);
		
		cashierDisplayPanel.removeAll();
		cashierDisplayPanel.updateUI();
		
		cashierDisplayPanel.setLayout(null);
		createNumpad(choice);

	return cashierDisplayPanel;
}

	JPanel createCashierDisplayPanel3() {
		
	//cashierDisplayPanel.setLayout(null);
		cashierDisplayPanel.removeAll();
		cashierDisplayPanel.updateUI();
		cashierDisplayPanel.add(createChangeDisplayMessage());
		cashierDisplayPanel.add(createProceedButton2());
		return cashierDisplayPanel;
}
	
	JPanel createCashierDisplayPanel5() {
		
		//cashierDisplayPanel.setLayout(null);
		cashierDisplayPanel.removeAll();
		cashierDisplayPanel.updateUI();

		cashierDisplayPanel.add(createPendingDisplayMessage());


		return cashierDisplayPanel;
	}
	
	JPanel createCashierDisplayPanel6() {
		cashierDisplayPanel.removeAll();
		cashierDisplayPanel.updateUI();

		cashierDisplayPanel.add(createCashFailedDisplayMessage());
		cashierDisplayPanel.add(createProceedButton());
		
		return cashierDisplayPanel;
	}
	
	JPanel createCashierDisplayPanel7() {
		cashierDisplayPanel.removeAll();
		cashierDisplayPanel.updateUI();

		cashierDisplayPanel.add(createCheckDisplayMessage());
		createNumpad(choice);
		
		return cashierDisplayPanel;
	}
	
	JLabel createCheckDisplayMessage() {
		
		checkLabel = new JLabel("Enter check amount");
		checkLabel.setBounds(395,-100,1000,250);
		
		return checkLabel;
	}
	
	JLabel createNameDisplayMessage() {
		
		checkLabel = new JLabel("Enter full name");
		checkLabel.setBounds(395,-100,1000,250);
		
		return checkLabel;
	}
	
	JLabel createCashierDisplayMessage() {
		
		welcomeLabel = new JLabel("Select a form of payment");
		welcomeLabel.setBounds(395,-100,1000,250);
		
		return welcomeLabel;
	}
	
	JLabel createPendingDisplayMessage() {
		
		pendingLabel = new JLabel("Credit / Debit Transcation Pending ...");
		pendingLabel.setBounds(395,-100,1000,250);
		
		return pendingLabel;
	}
	
	JLabel createCashDisplayMessage() {
		
		cashAmountLabel = new JLabel("Enter cash amount:");
		cashAmountLabel.setBounds(395,-100,1000,250);
		
		return cashAmountLabel;
	}
	
	JLabel createChangeDisplayMessage() {
		
		change = cash - total;
		change = Math.round(change*100.0)/100.0;
		changeAmountLabel = new JLabel("Change amount:" + change);
		changeAmountLabel.setBounds(395,-100,1000,250);
		
		return changeAmountLabel;
	}
	
	JLabel createCCNumberLabelDisplayMessage() {
		
		ccNumberLabel = new JLabel("Enter credit card number:");
		ccNumberLabel.setBounds(395,-100,1000,250);
		
		return ccNumberLabel;
	}
	
	JLabel createDCNumberLabelDisplayMessage() {
		
		dcNumberLabel = new JLabel("Enter debit card number:");
		dcNumberLabel.setBounds(395,-100,1000,250);
		
		return dcNumberLabel;
	}
	
	JLabel createCVCLabelDisplayMessage() {
		
		cvcLabel = new JLabel("Enter cvc number:");
		cvcLabel.setBounds(395,-100,1000,250);
		
		return cvcLabel;
	}
	
	JLabel createExpLabelDisplayMessage() {
		
		expLabel = new JLabel("Enter expiration date:");
		expLabel.setBounds(395,-100,1000,250);
		
		return expLabel;
	}
	
	JLabel createPinLabelDisplayMessage() {
		
		pinLabel = new JLabel("Enter 4-digit pin:");
		pinLabel.setBounds(395,-100,1000,250);
		
		return pinLabel;
	}
	
	JLabel createCashFailedDisplayMessage() {
		cashFailedLabel = new JLabel("Error cash insufficient for purchase total");
		cashFailedLabel.setBounds(395,-100,1000,250);
		return cashFailedLabel;
	}
	
	JButton createCashButton() {
		
		cashButton = new JButton("CASH");
		cashButton.setBounds(100,150,250,100);
		cashButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				choice = 1;
				createCashierDisplayPanel2();
				
				//cashierDisplayPanel.removeAll();
				//cashierDisplayPanel
				//checkOutFrame();
				//switchToCheckOutFrame();
				
			}
			
		});
		
		return cashButton;
	}
	
	JButton createCardButton() {
		
		cardButton = new JButton("CARD");
		cardButton.setBounds(100,40,250,100);
		cardButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//choice = 2;
				createCashierDisplayPanel5();
				createCustomerDisplayPanel3();
				
				
			}
			
		});
		
		return cardButton;
	}
	
	JButton createCheckButton() {
		
		checkButton = new JButton("CHECK");
		checkButton.setBounds(600,150,250,100);
		checkButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				choice = 4;
				createCashierDisplayPanel7();
				//checkOutFrame();
				//switchToCheckOutFrame();
				
			}
			
		});
		
		return checkButton;
	}
	
	JButton createNoneButton() {
		
		noneButton = new JButton("NONE");
		noneButton.setBounds(600,40,250,100);
		noneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				// also make sure to delete everything inside the cart
				customerDisplayFrame.setVisible(false);
				cashierDisplayFrame.setVisible(false);
				
			}
			
		});
		
		return noneButton;
	}
	
	JButton createConfirmButton() {
		
		confirmButton = new JButton("CONFIRM");
		confirmButton.setBounds(600,40,250,100);
		confirmButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//checkOutFrame();
				//switchToCheckOutFrame();
				
			}
			
		});
		
		return noneButton;
	}
	
	JTextField createWeightTextField() {
		
		weightTextField = new JTextField();
		weightTextField.setBounds(395,50,70,50);
		
		return weightTextField;
		
	}
	
	JButton createOneButton() {
		
		oneButton = new JButton("1");
		oneButton.setBounds(700,300,50,50);
		
		oneButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("1");
				
			}
			
			
		});
		
		return oneButton;
		
		
	}
	
	JButton createTwoButton() {
		
		twoButton = new JButton("2");
		twoButton.setBounds(760,300,50,50);
		
		twoButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("2");
				
			}
			
		});
		
		return twoButton;
		
	}
	
	JButton createThreeButton() {
		
		threeButton = new JButton("3");
		threeButton.setBounds(820,300,50,50);
		
		threeButton.addActionListener( new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("3");
				
			}
			
		});
		
		return threeButton;
		
	}
	
	JButton createFourButton() {
		
		fourButton = new JButton("4");
		fourButton.setBounds(700,360,50,50);
		
		fourButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("4");
				
			}
			
		});
		
		return fourButton;
		
	}
	
	JButton createFiveButton() {
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(760,360,50,50);
		
		
		fiveButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("5");
				
			}
			
		});
		
		return fiveButton;
		
	}
	
	JButton createSixButton() {
		
		sixButton = new JButton("6");
		sixButton.setBounds(820,360,50,50);
		
		
		sixButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("6");
				
			}
			
		});
		
		
		return sixButton;
		
	}
	
	JButton createSevenButton() {
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(700,420,50,50);
		
		
		sevenButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("7");
				
			}
			
		});
		
		
		return sevenButton;
		
	}
	
	JButton createEightButton() {
		
		eightButton = new JButton("8");
		eightButton.setBounds(760,420,50,50);
	
		eightButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("8");
				
			}
			
		});
		
		
		return eightButton;
		
	}
	
	JButton createNineButton() {
		
		nineButton = new JButton("9");
		nineButton.setBounds(820,420,50,50);
		
		nineButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("9");
				
			}
			
		});
		
		
		return nineButton;
		
	}
	
	JButton createZeroButton() {
		
		zeroButton = new JButton("0");
		zeroButton.setBounds(760,480,50,50);
		
		
		zeroButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				TextArea.append("0");
				
			}
			
		});
		
		
		return zeroButton;
		
	}
	
	JButton createDeleteButton() {
		
		deleteButton = new JButton("<-");
		deleteButton.setBounds(700,480,50,50);
		
		
		deleteButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String temp = TextArea.getText();
				temp = removeLastChar(temp);
				System.out.println(temp);
				TextArea.setText(temp);
				
				
			}
			
		});
		
		
		return deleteButton;
		
	}
	
	JButton createEnterButton() { //enter button for cash
		
		enterButton = new JButton("ENT");
		enterButton.setBounds(760,540,50,50);

		enterButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				String temp = TextArea.getText();
				System.out.println("The amount entered is " + temp);
				System.out.println("choice 1");
				cash = toDouble(temp);

				if(cash >= total) {
					createCashierDisplayPanel3();
					createCustomerDisplayPanel2();
				} else {
					createCustomerDisplayPanel5();
					createCashierDisplayPanel6();
				}

			}
			
		});
		
		
		return enterButton;
		
	}
	
	JButton createEnter2Button() {
		
		enterButton2 = new JButton("ENT");
		enterButton2.setBounds(820,480,50,50);
		
		enterButton2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String temp = TextArea.getText();
				System.out.println("The number entered is " + temp);
				System.out.println("choice 2 or 3");
				if(num == 0) {
					ccNumber = toInt(temp);
					System.out.println("The card number is" + ccNumber);
					num += 1;
					customerDisplayPanel.removeAll();
					customerDisplayPanel.updateUI();
					customerDisplayPanel.add(createCVCLabelDisplayMessage());
					createNumpad(choice);
				} else if(num == 1) {
					cvc = toInt(temp);
					System.out.println("The cvc number is" + cvc);
					num += 1;
					customerDisplayPanel.removeAll();
					customerDisplayPanel.updateUI();
					customerDisplayPanel.add(createExpLabelDisplayMessage());
					createNumpad(choice);
				} else if(num == 2) {
					exp = toInt(temp);
					System.out.println("The exp number is" + exp);
					if(choice == 2) {
						num += 1;
						customerDisplayPanel.removeAll();
						customerDisplayPanel.updateUI();
						customerDisplayPanel.add(createPinLabelDisplayMessage());
						createNumpad(choice);
					} else if(choice == 3) {
						//this is where you call the panel to verify the bank info 
						System.out.println("verifying bank info");
						customerDisplayPanel.removeAll();
						customerDisplayPanel.updateUI();
					}
				} else if(num == 3) {
					pin = toInt(temp);
					System.out.println("The pin number is" + pin);
					
					//verify debit card
					System.out.println("verifying bank info");
					customerDisplayPanel.removeAll();
					customerDisplayPanel.updateUI();
				}

			}
			
		});
		
		
		return enterButton2;
		
	}
	
	JButton createEnterButton3() { //enter button for cash
		
		enterButton = new JButton("ENT");
		enterButton.setBounds(760,540,50,50);

		enterButton.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				String temp = TextArea.getText();
				System.out.println("The amount entered is " + temp);
				System.out.println("choice 1");
				if(num2 == 0) {
					checkAmount = toDouble(temp);
					System.out.println("The check amount is " + checkAmount);
					num2 += 1;
					cashierDisplayPanel.removeAll();
					cashierDisplayPanel.updateUI();
					cashierDisplayPanel.add(createNameDisplayMessage());
					createNumpad(choice);
				} else if(num2 == 1) {
					name = temp;
					System.out.println("The name is " + name);

				}
			}
			
		});
		
		
		return enterButton;
		
	}
	
	JButton createDotButton() {
		
		dotButton = new JButton(".");
		dotButton.setBounds(820,480,50,50);
		
		
		dotButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				TextArea.append(".");
				
				
			}
			
		});
		
		
		return dotButton;
		
	}
	
	JButton createProceedButton() { //used to go back to main menu when payment fails
		proceedButton = new JButton("Proceed");
		proceedButton.setBounds(100,40,250,100);
		
		proceedButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("going back to total screen");
				
				cashierDisplayPanel.removeAll();
				cashierDisplayPanel.updateUI();
				
				//resetData();
				
				createCashierDisplayPanel();
				customerDisplayFrame();	
				
				
			}
			
		});
		
		return proceedButton;
	}
	
	JButton createProceedButton2() { //used when payment succeeds and resets cart
		proceedButton = new JButton("Proceed");
		proceedButton.setBounds(100,40,250,100);
		
		proceedButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("going back to main menu");
				createRecieptDisplayFrame();
				for(inventory item:cart) {
					recieptTextArea.append(item.getName());
					recieptTextArea.append("-----$" + item.getPrice());
					recieptTextArea.append("------Quantity/" + item.getQuantityPurchased());
					if(item.getBulk() == true) {
						recieptTextArea.append("------" + item.getWeight() + "kg\n");
					} else {
						recieptTextArea.append("\n");
					}
					
				}
				recieptTextArea.append("--------------------------------------------\n");
				recieptTextArea.append("pretax: $" + ptTotal + "\n");
				recieptTextArea.append("tax: $" + taxTotal + "\n");
				recieptTextArea.append("total: $" + total + "\n");
				recieptTextArea.append("change: $" + change + "\n");
				if(choice == 2 || choice == 3) {
					recieptTextArea.append("card number: \n");
					recieptTextArea.append("authorization code: \n");
				}
				cashierDisplayPanel.removeAll();
				cashierDisplayPanel.updateUI();
				
				customerDisplayFrame.setVisible(false);
				cashierDisplayFrame.setVisible(false);
				
			}
			
		});
		
		return proceedButton;
	}

	JButton createDebitButton() {
		
		debitButton = new JButton("DEBIT");
		debitButton.setBounds(100,40,250,100);
		
		
		debitButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("debit");
				choice = 2;
				createCustomerDisplayPanel4();
				//String temp = cashAmountTextArea.getText();
				//System.out.println("The amount entered is " + temp);
				
				
			}
			
		});
		
		
		return debitButton;
		
	}
	
	JButton createCreditButton() {
		
		creditButton = new JButton("CREDIT");
		creditButton.setBounds(600,40,250,100);
		
		
		creditButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("credit");
				choice = 3;
				createCustomerDisplayPanel4();
				//String temp = cashAmountTextArea.getText();
				//System.out.println("The amount entered is " + temp);
				
				
			}
			
		});
		
		
		return creditButton;
		
	}
	
	JTextArea createTextArea() {
		
		TextArea = new JTextArea();
		TextArea.setBounds(700,255,170,30);
		
		return TextArea;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	

}
