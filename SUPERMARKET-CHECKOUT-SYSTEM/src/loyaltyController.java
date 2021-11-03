
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.*;

public class loyaltyController implements ActionListener{
	
	private JLabel responseLabel;
	
	private JFrame createLoyaltyAccFrame = new JFrame();
	private JPanel createLoyaltyAccPanel = new JPanel();
	
	private JLabel enterName;
	private JLabel enterPin;
	private JLabel enterPhoneNum;
	
	private JTextField enterNameTextField;
	private JTextField enterPinTextField;
	private JTextField enterPhoneNumTextField;
	
	private JButton createAccButton;
	private JButton cancelCreateButton;
	
	//
	
	private JPanel createLoyaltyAccInfoPanel = new JPanel();
	private JButton confirm;
	private JTextArea infoTextArea;
	
	private JFrame verifyLoyaltyAccFrame = new JFrame();
	private JPanel verifyLoyaltyAccPanel = new JPanel();
	
	private JLabel verifyPin;
	private JLabel verifyPhoneNum;
	
	private JTextField verifyPinTextField;
	private JTextField verifyPhoneNumTextField;
	
	private JButton verifyAccButton;
	private JButton cancelVerifyButton;
	

	fileParser obj = new fileParser();
	
	ArrayList<loyaltyAccounts> acc;
	
	private int W = 400;
	private int H = 400;
	
	public void createLoyaltyFrame() {
		
		createLoyaltyAccFrame.setSize(W,H);
		createLoyaltyAccFrame.setTitle("CREATE LOYALTY ACCOUNT");
		createLoyaltyAccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		createLoyaltyAccFrame.setVisible(true);
		
		createLoyaltyAccPanel();
		
		createLoyaltyAccFrame.setContentPane(createLoyaltyAccPanel);
		
		
		
		
	}
	

	
	public void createVerifyAccFrame() throws Exception {
		
		verifyLoyaltyAccFrame.setSize(W,H);
		verifyLoyaltyAccFrame.setTitle("VERIFY LOYALTY ACCOUNT");
		verifyLoyaltyAccFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		verifyLoyaltyAccFrame.setVisible(true);
		
		createVerifyAccPanel();
		
		verifyLoyaltyAccFrame.setContentPane(verifyLoyaltyAccPanel);
		
	}
	
	// Create verify account panel and components
	
	public void changeToInfoPanel() throws Exception {
		
		verifyLoyaltyAccFrame.setTitle("CONFIRMATION");
		verifyLoyaltyAccPanel.setVisible(false);
		createLoyaltyAccInfoPanel.setVisible(true);
		
		createLoyaltyAccInfoPanel();
	
		verifyLoyaltyAccFrame.setContentPane(createLoyaltyAccInfoPanel);
		
	}
	
	JPanel createLoyaltyAccInfoPanel() throws Exception {
		
		createLoyaltyAccInfoPanel.setLayout(null);
		
		createLoyaltyAccInfoPanel.add(createConfirmButton());
		createLoyaltyAccInfoPanel.add(createInfoTextArea());
		createLoyaltyAccInfoPanel.add(createResponseLabel());
		
		return createLoyaltyAccInfoPanel;
		
	}
	
	JPanel createVerifyAccPanel() throws Exception {
		
		verifyLoyaltyAccPanel.setLayout(null);
		
		verifyLoyaltyAccPanel.add(createVerifyAccButton());
		verifyLoyaltyAccPanel.add(createCancelVerifyAccButton());
		verifyLoyaltyAccPanel.add(createResponseLabel());
		verifyLoyaltyAccPanel.add(createVerifyPinLabel());
		verifyLoyaltyAccPanel.add(createVerifyPhoneNumLabel());
		verifyLoyaltyAccPanel.add(createPhoneNumTextField());
		verifyLoyaltyAccPanel.add(createVerifyPinTextField());
		
		
		
		return verifyLoyaltyAccPanel;
		
	}
	
	JButton createVerifyAccButton() throws Exception  {
		
		acc = obj.loyaltyAccArr();
		
		verifyAccButton = new JButton("VERIFY");
		verifyAccButton.setBounds(120,235,80,60);
		
		verifyAccButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				if(verifyPhoneNumTextField.getText().matches("[0-9]+") != true || 
						verifyPinTextField.getText().length() != 4 || 
						verifyPinTextField.getText().matches("[0-9]+") != true) {
					
					responseLabel.setText("INVALID INFORMATION");
					
				} else {
					
					for(loyaltyAccounts obj:acc) {
						
						if(obj.getPhoneNumber().equals(verifyPhoneNumTextField.getText()) != true) {
							
							responseLabel.setText("ACCOUNT DOES NOT EXIST");
							
						} else if(obj.getPhoneNumber().equals(verifyPhoneNumTextField.getText()) & 
								obj.getPin().equals(verifyPinTextField.getText())) {
						
							
							try {
								changeToInfoPanel();
							} catch(Exception e1) {
								e1.printStackTrace();
							}
							
							infoTextArea.append("Name: " + obj.getName() + "\n");
							infoTextArea.append("Phone Number: " + obj.getPhoneNumber() + "\n");
							infoTextArea.append("Points: " + obj.getPoints() + "\n");

						}
						
					}
					
				}
	
			}
 			
		});
		
		return verifyAccButton;
		
	}
	
	JButton createCancelVerifyAccButton() {
		
		cancelVerifyButton = new JButton("CANCEL");
		cancelVerifyButton.setBounds(200,235,80,60);
		
		cancelVerifyButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				verifyLoyaltyAccFrame.setVisible(false);
				
			}
 			
		});
		
		return cancelVerifyButton;
		
	}
	
	JTextField createPhoneNumTextField() {
		
		verifyPhoneNumTextField = new JTextField();
		verifyPhoneNumTextField.setBounds(120,80,140,30);
		
		return verifyPhoneNumTextField;
		
	}
	
	JTextField createVerifyPinTextField() {
		
		verifyPinTextField = new JTextField();
		verifyPinTextField.setBounds(120,130,140,30);
		
		return verifyPinTextField;
		
	}
	
	JLabel createVerifyPinLabel() {
		
		verifyPin = new JLabel("Enter Pin:");
		verifyPin.setBounds(120,100,140,50);
		
		return verifyPin;
		
	}
	
	JLabel createVerifyPhoneNumLabel() {
		
		verifyPhoneNum = new JLabel("Enter Phone Number:");
		verifyPhoneNum.setBounds(120,50,140,50);
		
		return verifyPhoneNum;
		
	}
	
	JLabel createResponseLabel() {
		
		responseLabel = new JLabel("");
		responseLabel.setBounds(120,1,180,100);
		
		return responseLabel;
		
	}
	
	JButton createConfirmButton() {
		
		confirm = new JButton("CONFIRM");
		confirm.setBounds(150,280,80,60);
		
		confirm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				verifyLoyaltyAccFrame.setVisible(false);
				
			}
			
		});
		
		return confirm;
		
	}
	
	JTextArea createInfoTextArea() {
		
		infoTextArea = new JTextArea();
		infoTextArea.setEditable(false);
		infoTextArea.setBounds(55,50,280,200);
		
		return infoTextArea;
	}
	
	// Create Loyalty account panel and components
	
	JPanel createLoyaltyAccPanel() {
		
		createLoyaltyAccPanel.setLayout(null);
		
		createLoyaltyAccPanel.add(createEnterNameLabel());
		createLoyaltyAccPanel.add(createEnterNameTextField());
		createLoyaltyAccPanel.add(createEnterPhoneNumLabel());
		createLoyaltyAccPanel.add(createEnterPhoneNumTextField());
		createLoyaltyAccPanel.add(createEnterPinLabel());
		createLoyaltyAccPanel.add(createPinTextField());
		createLoyaltyAccPanel.add(createCreateAccButton());		
		createLoyaltyAccPanel.add(createCancelButton());
		createLoyaltyAccPanel.add(createResponseLabel());
		
		return createLoyaltyAccPanel;
		
	}
	 
	JLabel createEnterNameLabel() {
		
		enterName = new JLabel("ENTER NAME:");
		enterName.setBounds(55,80,100,50);
		
		return enterName;
		
	}
	
	JTextField createEnterNameTextField() {
		
		enterNameTextField = new JTextField();
		enterNameTextField.setBounds(50,110,190,30);
		
		return enterNameTextField;
	}
	
	JLabel createEnterPhoneNumLabel() {
		
		enterPhoneNum = new JLabel("ENTER PHONE NUMBER:");
		enterPhoneNum.setBounds(55,130,150,50);
		
		return enterPhoneNum;
		
	}
	
	JTextField createEnterPhoneNumTextField() {
		
		enterPhoneNumTextField = new JTextField();
		enterPhoneNumTextField.setBounds(50,160,190,30);
		
		
		return enterPhoneNumTextField;
		
	}
	
	JLabel createEnterPinLabel() {
		
		enterPin = new JLabel("ENTER PIN:");
		enterPin.setBounds(55,175,150,50);
		
		return enterPin;
		
	}
	
	JTextField createPinTextField() {
		
		enterPinTextField = new JTextField();
		enterPinTextField.setBounds(50,205,190,30);
		
		return enterPinTextField;
		
	}
	
	JButton createCreateAccButton() {
		
		createAccButton = new JButton("CREATE");
		createAccButton.setBounds(50,235,80,60);
		
		createAccButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				createAcc(enterNameTextField.getText(), enterPhoneNumTextField.getText(), enterPinTextField.getText());
				
				//enterNameTextField.setText(null);
				//enterPinTextField.setText(null);;
				//enterPhoneNumTextField.setText(null);;
				
				//createLoyaltyAccFrame.setVisible(false);
				
			}
			
		});
		
		return createAccButton;
		
	}
	
	JButton createCancelButton() {
		
		cancelCreateButton = new JButton("CANCEL");
		cancelCreateButton.setBounds(160,235,80,60);
		
		cancelCreateButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				enterNameTextField.setText(null);
				enterPinTextField.setText(null);
				enterPhoneNumTextField.setText(null);
				
				createLoyaltyAccFrame.setVisible(false);

			}
			
		});
		
		return cancelCreateButton;
		
	}
	
	///////////////////////////////////
	
	void createAcc(String name, String phoneNum, String pinNum) {
		
		if(name.matches("[a-z]+") || phoneNum.matches("[0-9]+") || pinNum.length() != 4) {
			responseLabel.setText("INVALID INFORMATION");
		} else {
			try {
				obj.createLoyaltyAcc(name,phoneNum,pinNum);
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
	
			
	}
 	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
}
