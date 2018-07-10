package com.capg.payment.dao;

import com.capg.payment.bean.Application;

public interface IApplicationDao {
	public boolean createAccount(Application appln);
	public void showBalance(double balance);
	public double deposit(double amount);
	public double withdraw(double amount);
	public void fundTransaction(long customerId1, long customerId2);
	public void printTransaction(long customerId1, long customerId2);

}
