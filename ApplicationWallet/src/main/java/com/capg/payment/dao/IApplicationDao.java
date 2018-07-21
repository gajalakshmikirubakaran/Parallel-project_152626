package com.capg.payment.dao;

import com.capg.payment.bean.AccountDetails;
import com.capg.payment.bean.Application;

public interface IApplicationDao {
	public int createAccount(Application appln);
	public void showBalance(long accountNumber);
	public double deposit(double amount);
	public double withdraw(double amount);
	public void fundTransaction(long accountNumber, double amount);
	public void printTransaction();
	 public int login(String username,String password);

}
