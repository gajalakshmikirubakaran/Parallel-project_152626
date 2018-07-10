package com.capg.payment.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.capg.payment.bean.Application;
import com.capg.payment.service.ApplicationService;
import com.capg.payment.service.ValidateApplicationService;

public class ApplicationPage {
	static boolean a;
	public static void main(String[] args) {
		Random rand=new Random();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ValidateApplicationService service=new ValidateApplicationService();
		ApplicationService appln=new ApplicationService();
		
		boolean isValidcustomerName;
		boolean isValidphoneNumber;
		boolean isValidemailId;
		boolean isValidaadharNumber;
		boolean isValidaccountNumber;
		boolean isValidpassword;
		int choice = 0;
		
		
	    System.out.println("Welcome to the eWallet Application");
	    System.out.println("1.Create Account");
	    System.out.println("2.Show Balance");
	    System.out.println("3.Deposit");
	    System.out.println("4.Withdraw");
	    System.out.println("5.Fund Transfer");
	    System.out.println("6.Print Transaction");
	    System.out.println("7.exit");
	    System.out.println("Enter your choice");
	    try {
			try {
				choice=Integer.parseInt(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NumberFormatException e1) {
			
			e1.printStackTrace();
		} 
		
	    
	    switch (choice){
	    case 1:{
	    	System.out.println("Enter customerName:");
	    	try {
				String customerName=br.readLine();
				System.out.println("Enter your phoneNumber:");
				String phoneNumber=br.readLine();
				System.out.println("Enter your emailId:");
				String emailId=br.readLine();
				System.out.println("Enter your aadharNumber");
				String aadharNumber=br.readLine();
				System.out.println("Enter your AccountNumber:");
				String accountNumber=br.readLine();
				System.out.println("Enter your password");
				String password=br.readLine();
				
				System.out.println("");
				
				int customerId = rand.nextInt(9000000)+10000000;
				System.out.println(customerId);
				
				Application app=new Application();
				
				app.setCustomerName(customerName);
				app.setPhoneNumber(Integer.parseInt(phoneNumber));
				app.setEmailId(emailId);
				app.setAadharNumber(Integer.parseInt(aadharNumber));
				app.setCustomerId(customerId);
				
				isValidcustomerName=service.validatecustomerName(customerName);
				 isValidphoneNumber=service.validatephoneNumber(phoneNumber);
				 isValidemailId=service.validateemailId(emailId);
				 isValidaadharNumber=service.validateaadharNumber(aadharNumber);
				 isValidaccountNumber=service.validateaccountNumber(accountNumber);
				 isValidpassword=service.validatepassword(password);
				
				 if(isValidcustomerName && isValidphoneNumber && isValidemailId && isValidaadharNumber &&isValidaccountNumber &&isValidpassword) {
					 a = appln.createAccount(app);
				 }
				 else System.out.println("Enter valid information");
				
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	if(a)
	    	
	    		System.out.println("Your account has been created successfully");
	    	else System.err.println("Account is not created");
	    	break;
	    }
	    case 2:{
	    	System.out.println("Enter your customerID:");
	    	try {
				int cusId;
				
					try {
						cusId = Integer.parseInt(br.readLine());
						appln.showBalance(cusId);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
				
			catch (NumberFormatException e) {
				
				e.printStackTrace();
			}
	    	break;
	    }
	    	case 3:{
	    		System.out.println("Enter your customerId:");
	    		try {
					int cusId1=Integer.parseInt(br.readLine());
					System.out.println("Enter the amount to deposit:");
		    		int amount=Integer.parseInt(br.readLine());
		    		System.out.println("successfully deposited");
		    		break;
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		break;
	    		
	    	}
	    	case 4:{
	    		System.out.println("Enter your customerId:");
	    		try {
					int cusId2=Integer.parseInt(br.readLine());
				} catch (NumberFormatException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		System.out.println("Enter the amount to withdraw:");
	    		int amount;
				try {
					amount = Integer.parseInt(br.readLine());
					System.out.println("you have withdrawn the amount of"+amount);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		break;
	    		
	    	}
	    	case 5:{
	    		System.out.println("exit");
				System.exit(0);
	    	}
	    	
	  
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
	    
	    
	    
		
		
		
		
		
		
		
		
		
		
	}
		}
	
	

}

