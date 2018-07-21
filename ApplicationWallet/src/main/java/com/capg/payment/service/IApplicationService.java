package com.capg.payment.service;

import java.util.List;

import com.capg.payment.bean.Application;

public interface IApplicationService {
	public int createAccount(Application appln);
	public void showBalance(double balance);
	public int deposit(double amount);
	public int withdraw(double amount);
	public void fundTransaction(int accountNumber,double amount);
	List printTransaction();
	public int login(String username,String password);

}
