package com.capg.payment.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.capg.payment.bean.AccountDetails;
import com.capg.payment.bean.Application;
import com.capg.payment.service.ApplicationService;
import com.capg.payment.service.ValidateApplicationService;

public class AppPage {
	public static void main(String[] args) {
		int choice;
		int choice2;
		ValidateApplicationService vservice=new ValidateApplicationService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner in = new Scanner(System.in);
		Random rand = new Random();
do {
			
			System.out.println( "Welcome to the ewallet payment" );
			
			System.out.println( " 1.create account" );
			System.out.println( "2.login" );
			System.out.println( "3.logout" );

			System.out.println( "Enter your choice" );
			choice = in.nextInt();
			
			switch (choice) {

			case 1:
				ApplicationService applnservice=new ApplicationService();
				Application app=new Application();
				AccountDetails adetails=new AccountDetails();
				
				try {
					System.out.println("Enter customer name:");
					String customerName = br.readLine();
					System.out.println("Enter gender:");
					String gender = br.readLine();
					System.out.println("Enter age");
					String age = br.readLine();
					System.out.println("Enter aadharnumber:");
					String aadhaarNumber = br.readLine();
					System.out.println("Enter phone number:");
					String phoneNumber = br.readLine();
					System.out.println("Enter emailid:");
					String emailId = br.readLine();
					System.out.println("Enter username");
					String username = br.readLine();
					System.out.println("Enter password:");
					String password = br.readLine();
					int accountNumber = rand.nextInt(900000) + 100000;
					
					app.setCustomerName(customerName);
					app.setGender(gender);
					app.setAge(Integer.parseInt(age));
					app.setEmailId(emailId);
					app.setPhoneNumber(phoneNumber);
					app.setAadharNumber(aadhaarNumber);
					app.setUsername(username);
					app.setPassword(password);
					
					adetails.setAccountNumber(accountNumber);
					adetails.setApp(app);
					boolean isValidcustomerName = vservice.validatecustomerName(customerName);
					boolean isValidGender = vservice.validategender(gender);
					boolean isValidAge = vservice.validateage(Integer.parseInt(age));
					boolean isValidEmailId = vservice.validateemailId(emailId);
					boolean isValidPhoneNumber = vservice.validatephoneNumber(phoneNumber);
					boolean isValidAdhaarNumber = vservice.validateaadharNumber(aadhaarNumber);
					boolean isValidPassword=vservice.validatepassword(password);
					
					if (isValidAdhaarNumber && isValidAge && isValidEmailId && isValidGender && isValidcustomerName
							&& isValidPhoneNumber &&isValidPassword) {
						
						applnservice.createAccount(adetails);
						System.out.println("Your account has been created and the account number is:"+" "+accountNumber);
						System.out.println("\n");

					} else {
						System.out.println("invalid data");
					}

				} catch (IOException e) {
					
					e.printStackTrace();
				}

				break;
				
			case 2:
				ApplicationService applnservice2=new ApplicationService();

				try {

					System.out.println("Enter username to login:");
					String userName;
					userName = br.readLine();
					System.out.println("Enter password:");
					String password = br.readLine();
					if (applnservice2.login(userName, password) == 1) {
						do {
							
							System.out.println( "3:Deposit" );
							System.out.println( "4:Withdraw" );
							System.out.println( "5:Show balance" );
							System.out.println("6:Fundtransaction" );
							System.out.println( "7:Print transaction" );
							System.out.println( "8:Logout" );
							

							System.out.println("Enter your choice");
							choice2 = in.nextInt();
							switch (choice2) {
							case 3:
								ApplicationService applnservice3=new ApplicationService();

								System.out.println("Enter the amount");
								double amount = in.nextDouble();
								
								if (applnservice3.deposit(amount) == 1) {
									System.out.println("depostion successful");
								}

								
								else {
									System.out.println("Invalid username or password");
								}

								break;
							case 4:

								ApplicationService applnservice4=new ApplicationService();
								System.out.println("Enter the amount");
								double wamount = in.nextDouble();
								
								if (applnservice4.withdraw(wamount) == 0) {
									System.out.println("withdrawn successful");
								}
								
								break;
								
							case 5:
								int accountNumber = 0;
								ApplicationService applnservice5=new ApplicationService();
								
								applnservice5.showBalance(accountNumber);

								break;
								
							case 6:
								ApplicationService applnservice6=new ApplicationService();
								System.out.println(" Enter account number of the receiver");
								accountNumber = in.nextInt();
								System.out.println("Enter the amount");
								double famount = in.nextDouble();
								
								if (applnservice6.fundTransaction(accountNumber, famount) == 0) {
									System.out.println("Amount has been transferred");
								} else {
									System.out.println("Transaction failed");
								}
								

								break;
							case 7:
								ApplicationService applnservice7=new ApplicationService();
								System.out.println("The transaction is");
								applnservice7.printTransaction();
								break;

							case 8:
								break;

							}

						} while (choice2 != 8);

					} else {
						System.out.println("Invalid username or password");
					}
				} catch (IOException e) {
					
					e.printStackTrace();
				}

				break;

			case 3:
				break;

			}
		} while (choice != 3);

	}

}
