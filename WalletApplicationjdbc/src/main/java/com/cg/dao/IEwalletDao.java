package com.cg.dao;

import com.cg.bean.AccountDetails;

public interface IEwalletDao {
	AccountDetails login(String userName, String password);

	int createAccount(AccountDetails adetails);

	int deposit(double amount);

	void showbalance();

	int fundtransfer(int accountNumber, double amount);

	void printtransaction();

}
