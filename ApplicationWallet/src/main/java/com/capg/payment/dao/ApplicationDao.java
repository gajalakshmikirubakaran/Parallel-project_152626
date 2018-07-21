package com.capg.payment.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capg.payment.bean.AccountDetails;

public class ApplicationDao {
	double balance;
	int flag = 0;
	AccountDetails adetails=new AccountDetails();
	public static  Map<Integer,AccountDetails> map1 = new HashMap<Integer, AccountDetails>();
	public static  List<String> transactions= new ArrayList<String>();
	
	

public int createAccount(AccountDetails adetails) {
		
		map1.put(adetails.getAccountNumber(), adetails);
		return 1;
}

	public void showbalance(int accountNumber)
	{
    
		for(Integer key:map1.keySet()) {
			
			   adetails=map1.get(key)	;
			   if(adetails.getAccountNumber()==accountNumber) {
				   System.out.println("Your account balance is:"+" "+adetails.getBalance());
			   }
			
		}
		
		
		
	}
	public int login(String username,String password)
	{
		for(Integer key:map1.keySet()) {
			
			adetails=map1.get(key)	;
			if(adetails.getApp().getUsername().equals(username)&&(adetails.getApp().getPassword().equals(password)))
					{
				return 1;
				        
				
					}
		}
	
		return 0;
	}
		
public int deposit(double amount) {
		
		balance=adetails.getBalance()+amount;
		adetails.setBalance(balance);
		
		
		String deposit="Amount deposited is:"+" "+amount;
		transactions.add(deposit);
		
		return 1;
		
		
	}
			
public int withdraw(double amount) {
	
	
	if(amount<adetails.getBalance()) {
	balance=adetails.getBalance()-amount;
	adetails.setBalance(balance);		
	
	System.out.println(adetails.getBalance());
   String withdraw="Amount withdrawn from your account is"+" "+amount;
 	transactions.add(withdraw);
	}else
	{
		System.out.println("You cannot withdraw the amount you have entered, since the account balance is low");
	}
	return 0;
}
		
		
		
		
	

public int fundTransaction(int accountNumber, double amount) {
	
if(adetails.getBalance()>amount) {
	for(Integer key:map1.keySet()) {
		
		   adetails=map1.get(key)	;
		   if(adetails.getAccountNumber()==accountNumber) {
			  balance= adetails.getBalance()+amount;
			  adetails.setBalance(balance);
			  flag=1;
		   }
		   if(flag==0) {
			   
			   balance=adetails.getBalance()-amount;
				adetails.setBalance(balance);	
				String transfer="The amount transferred is:"+" "+amount;
				transactions.add(transfer);
					
		   }
		
	}
	}
else
{
System.err.println("You cannot transfer the amount you have entered, since the account balance is low");
}
	
	
	
	return 0;
}

	

	public List printtransaction() {
		return transactions;
		
		
	}


}
