package com.capg.payment.service;

import java.util.List;

import com.capg.payment.bean.AccountDetails;
import com.capg.payment.dao.ApplicationDao;

public class ApplicationService {
	
	ApplicationDao dao=new ApplicationDao();

	public int createAccount(AccountDetails adetails) {
		
		return dao.createAccount(adetails);
	}
	public double deposit(double amount) {
		return dao.deposit(amount);
	}
	public double withdraw(double amount) {
		return dao.withdraw(amount);
	}
	public int fundTransaction(int accountNumber,double amount) {
		return dao.fundTransaction(accountNumber,amount);
		}
	public List printTransaction() {
		return dao.printtransaction();
	}
	

	public double showBalance(int accountNumber) {
		
		return dao.deposit(accountNumber);
	}
	
	public int login(String username,String password)
	{
		return dao.login(username,password); 
		
		
		
		
	}
	

}
