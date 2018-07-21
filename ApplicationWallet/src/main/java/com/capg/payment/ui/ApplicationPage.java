package com.capg.payment.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.capg.payment.bean.AccountDetails;
import com.capg.payment.bean.Application;
import com.capg.payment.dao.ApplicationDao;
import com.capg.payment.service.ApplicationService;
import com.capg.payment.service.ValidateApplicationService;

public class ApplicationPage {

	public static void main(String[] args) 
	{
		Random rand=new Random();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ValidateApplicationService vservice=new ValidateApplicationService();
		
		
		int choice;
		int choice1;
		    do 
		    {
			
		
	                 System.out.println("Welcome to the eWallet Application");
	                 System.out.println("1.Create Account");
	                 System.out.println("2.Login");
	                 System.out.println("3.Logout");
	                 System.out.println("Enter your choice");
	                 Scanner sc=new Scanner(System.in);
	                 
	                 choice=sc.nextInt();
	    
			
		
	                 switch (choice) 
	                 {
	                 	case 1:
	                 		ApplicationService applnservice=new ApplicationService();
	                		ApplicationDao dao=new ApplicationDao();
	                		AccountDetails adetails=new AccountDetails();
	                		Application app=new Application();
	                 			
	                		
	                 			try{
	                 				System.out.println("Enter customerName:");
	                 				String customerName=br.readLine();
	                 				System.out.println("Enter your Gender(male/female)");
	                 				String gender = br.readLine();
	                 				System.out.println("Enter your age");
	                 				String age=br.readLine();
	                 				System.out.println("Enter your phoneNumber:");
	                 				String phoneNumber=br.readLine();
	                 				System.out.println("Enter your emailId:");
	                 				String emailId=br.readLine();
	                 				System.out.println("Enter your aadharNumber");
	                 				String aadharNumber=br.readLine();
	                 				System.out.println("Enter your User name:");
	                 				String username=br.readLine();
	                 				System.out.println("Enter your password");
	                 				String password=br.readLine();
	                 				System.out.println("");
				
	                 				
				
	                 				int accountNumber = rand.nextInt(9000000)+10000000;
	                 				System.out.println(accountNumber);
				
				
				
	                 				app.setCustomerName(customerName);
	                 				app.setGender(gender);
	                 				app.setAge(Integer.parseInt(age));
	                 				app.setPhoneNumber(phoneNumber);
	                 				app.setEmailId(emailId);
	                 				app.setAadharNumber((aadharNumber));
	                 				app.setUsername(username);
	                 				app.setPassword(password);
				
	                 				adetails.setAccountNumber(accountNumber);
	                 				adetails.setApp(app);
				
	                 				boolean isValidcustomerName=vservice.validatecustomerName(customerName);
	                 				boolean isValidage=vservice.validateage(Integer.parseInt(age));
	                 				boolean isValidgender=vservice.validateaadharNumber(gender);
	                 				boolean isValidphoneNumber=vservice.validatephoneNumber(phoneNumber);
	                 				boolean isValidemailId=vservice.validateemailId(emailId);
	                 				boolean isValidaadharNumber=vservice.validateaadharNumber(aadharNumber);
	                 				boolean isValidpassword=vservice.validatepassword(password);
				 
				
	                 				if(isValidcustomerName && isValidphoneNumber && isValidage && isValidgender && isValidemailId && isValidaadharNumber && isValidpassword)
	                 				{
	                 					if (applnservice.createAccount(adetails) == 1) {
	                 					System.out.println("Your account has been created and the account number is:"+" "+accountNumber);
	                 					}
	                 					
	                 				     else System.out.println("Enter valid information");
	                 					
	                                 }else {}
	                 				
	                 			}catch (IOException e) {
				
	                 				e.printStackTrace();
	                 			}
	    	
	                 			break;
		
	    
	    
	                 	case 2:
	                 		ApplicationService applnservice1=new ApplicationService();
	                 		
	                 		try {
	                 		System.out.println("Enter your User name:");
             				String username1=br.readLine();
             				System.out.println("Enter your password");
             				String password=br.readLine();
	                 			if (applnservice1.login(username1, password) == 1) 
	                 			{
	                 			
	                 				do
	                 				{
	                 					System.out.println("3.Show Balance");
	                 					System.out.println("4.Deposit");
	                 					System.out.println("5.Withdraw");
	                 					System.out.println("6.Fund Transfer");
	                 					System.out.println("7.Print Transaction");
	                 					System.out.println("8.exit");
	                 					System.out.println("Enter your choice");
				  
	                 					choice1=sc.nextInt();
				    
	                 					switch(choice1) 
	                 					{
	                 						case 3:
	                 							ApplicationService applnservice2=new ApplicationService();
	                 							System.out.println("enter the account number");
	                 							int accountNumber = sc.nextInt();
	                 							applnservice2.showBalance(accountNumber);
	                 							break;
				    
				    
	                 						case 4:
	                 							ApplicationService applnservice3=new ApplicationService();

	                 							System.out.println("Enter the amount to deposit:");
	                 							double amount = sc.nextDouble();
	                 							System.out.println("Enter your username:");
	                 							String username2=br.readLine();
	                 							System.out.println("Enter your password");
	                             				String password2=br.readLine();

	                 							if  (applnservice3.login(username2, password2) == 1) 
	                 							{
	                 								if (applnservice3.deposit(amount) == 1) 
	                 								
	                 									System.out.println("The amount has been deposited successfully");
	                 							}
	                 								
	                 							 
	                 							else 
	                 								System.out.println("Invalid username or password");
	                 							
	                 							break;

	                 							
							
	                 						case 5:
	                 							ApplicationService applnservice4=new ApplicationService();
	                 							System.out.println("Enter the amount to withdraw");
	                 							double wamount = sc.nextDouble();
	                 							System.out.println("Enter your username:");
	                 							String username3=br.readLine();
	                 							System.out.println("Enter your password");
	                             				String password3=br.readLine();

	                 							if (applnservice4.login(username3, password3) == 1)
	                 							{
	                 								if (applnservice4.withdraw(wamount) == 0)
	                 								
	                 									System.out.println("Amount has been withdrawn");
	                 							}
	                 							
	                 							else System.out.println("Invalid username or password");
	                 							break;
				    
	                 						case 6:
	                 							ApplicationService applnservice5=new ApplicationService();
	                 							System.out.println(" Enter the account number to transfer:");
	                 							accountNumber = sc.nextInt();
	                 							System.out.println("Enter the amount");
	                 							double famount = sc.nextDouble();
	                 							System.out.println("Enter your username:");
	                 							String username4=br.readLine();
	                 							System.out.println("Enter your password");
	                             				String password4=br.readLine();
	                 								if (applnservice5.login(username4, password4) == 1) 
	                 								{
	                 									if (applnservice5.fundTransaction(accountNumber, famount) == 0) 
	                 									
	                 										System.out.println("The amount has been transferred.");
	                 								}
	                 								
	                 								else System.out.println("Invalid username or password");

	                 								break;
				    
	                 						case 7:
	                 							ApplicationService applnservice6=new ApplicationService();
	                 							System.out.println("Transaction");
	                 							System.out.println(applnservice6.printTransaction());
	                 							break;
			
				
	   
	                 						case 8:
	                 							
	                 							break;
	                 					}
	                 				}while(choice1!=8);
	                 				
	                 			}else System.out.println("invalid user name or password");
	                 		} catch (IOException e) {
	        					// TODO Auto-generated catch block
	        					e.printStackTrace();
	        				}
	                 	case 3:
	                 		
	                 		break;	
	                 }
	                 
		    }while(choice !=3);
	    
		      }
}
