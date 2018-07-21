package com.capg.payment.bean;

public class AccountDetails {
	private int accountNumber;
	private double balance;
	public Application app;
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setApp(Application app) {
		// TODO Auto-generated method stub
		
	}
	public Application getApp() {
		return app;
	}
	
	@Override
	public String toString() {
		return "AccountDetails [accountNumber=" + accountNumber + ", balance=" + balance + ", application="
				+ app + "]";
	}
	
	
	

}
