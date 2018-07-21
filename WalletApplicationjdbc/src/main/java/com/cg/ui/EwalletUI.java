package com.cg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import com.cg.bean.AccountDetails;
import com.cg.bean.CustomerDetails;
import com.cg.service.DataValidation;
import com.cg.service.EwalletService;

public class EwalletUI {
	public static void main(String[] args) {
		

		int choice;
		int choice2;
		DataValidation validate = new DataValidation();
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
				EwalletService service = new EwalletService();
				CustomerDetails details = new CustomerDetails();
				AccountDetails adetails = new AccountDetails();

				try {
					System.out.println("Enter customer name:");
					String customerName = br.readLine();
					System.out.println("Enter gender:");
					String gender = br.readLine();
					System.out.println("Enter age");
					String age = br.readLine();
					System.out.println("Enter aadharnumber:");
					String adhaarNumber = br.readLine();
					System.out.println("Enter phone number:");
					String phoneNumber = br.readLine();
					System.out.println("Enter emailid:");
					String emailId = br.readLine();
					System.out.println("Enter username");
					String userName = br.readLine();
					System.out.println("Enter password:");
					String password = br.readLine();
					int accountNumber = rand.nextInt(900000) + 100000;
					details.setCustomerName(customerName);
					details.setGender(gender);
					details.setAge(Integer.parseInt(age));
					details.setEmailId(emailId);
					details.setPhoneNumber(phoneNumber);
					details.setAdhaarNumber(adhaarNumber);
					details.setUserName(userName);
					details.setPassword(password);

					
					adetails.setAccountNumber(accountNumber);
					adetails.setDetails(details);
					boolean isValidcustomerName = validate.validatecustomerName(customerName);
					boolean isValidGender = validate.validategender(gender);
					boolean isValidAge = validate.validateage(Integer.parseInt(age));
					boolean isValidEmailId = validate.validateemailId(emailId);
					boolean isValidPhoneNumber = validate.validatephonenumber(phoneNumber);
					boolean isValidAdhaarNumber = validate.validateadhaarnumber(adhaarNumber);
					boolean isValidPassword=validate.validatepassword(password);

					if (isValidAdhaarNumber && isValidAge && isValidEmailId && isValidGender && isValidcustomerName
							&& isValidPhoneNumber &&isValidPassword) {
						
						service.createAccount(adetails);
						System.out.println("The account has been created");
						System.out.println("\n");

					} else {
						System.out.println("invalid data");
					}

				} catch (IOException e) {
					
					e.printStackTrace();
				}

				break;

			case 2:
				EwalletService service2 = new EwalletService();

				try {

					System.out.println("Enter username to login:");
					String userName;
					userName = br.readLine();
					System.out.println("Enter password:");
					String password = br.readLine();
					if (service2.login(userName, password) == 1) {
						do {
							
							System.out.println( "3:Deposit" );
							System.out.println( "4:Withdraw" );
							System.out.println( "5:Show balance" );
							System.out.println("6:Fundtransfer" );
							System.out.println( "7:Print transaction" );
							System.out.println( "8:Logout" );
							

							System.out.println("Enter your choice");
							choice2 = in.nextInt();
							switch (choice2) {

							case 3:
								EwalletService service3 = new EwalletService();

								System.out.println("Enter the amount");
								double amount = in.nextDouble();
								
								if (service3.deposit(amount) == 1) {
									System.out.println("depostion successful");
								}

								
								else {
									System.out.println("Invalid username or password");
								}

								break;
							case 4:

								EwalletService service4 = new EwalletService();
								System.out.println("Enter the amount");
								double wamount = in.nextDouble();
								
								if (service4.withdraw(wamount) == 0) {
									System.out.println("withdrawn successful");
								}
								
								break;
							case 5:
								int accountNumber;
								EwalletService service5 = new EwalletService();
								
								service5.showbalance();

								break;
							case 6:
								EwalletService service6 = new EwalletService();
								System.out.println(" Enter account number of the receiver");
								accountNumber = in.nextInt();
								System.out.println("Enter the amount");
								double famount = in.nextDouble();
								
								if (service6.fundtransfer(accountNumber, famount) == 0) {
									System.out.println("Amount has been transferred");
								} else {
									System.out.println("Transaction failed");
								}
								

								break;

							case 7:
								EwalletService service7 = new EwalletService();
								System.out.println("The transaction is");
								service7.printtransaction();
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
