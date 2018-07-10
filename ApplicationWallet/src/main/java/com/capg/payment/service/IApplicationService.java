package com.capg.payment.service;

import com.capg.payment.bean.Application;

public interface IApplicationService {
	public boolean createAccount(Application appln);
	public void showBalance(double balance);
	public void deposit(double amount);
	public void withdraw(double amount);
	public void fundTransaction(long customerId1, long customerId2);
	public void printTransaction(long customerId1, long customerId2);

}
