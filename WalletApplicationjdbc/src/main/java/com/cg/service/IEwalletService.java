package com.cg.service;

import com.cg.bean.AccountDetails;

public interface IEwalletService {
	int login(String userName, String password);

	int createAccount(AccountDetails adetails);

	int deposit(double amount);

	int withdraw(double amount);

	void showbalance();

	int fundtransfer(int accountNumber, double amount);

	void printtransaction();

}
