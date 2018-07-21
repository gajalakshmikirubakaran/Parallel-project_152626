package com.cg.service;

import com.cg.bean.AccountDetails;
import com.cg.dao.EwalletDao;

public class EwalletService {
	EwalletDao dao = new EwalletDao();

	public int login(String userName, String password) {
		return dao.login(userName, password);

	}

	public int createAccount(AccountDetails adetails) {

		return dao.createAccount(adetails);
	}

	public int deposit(double amount) {
		return dao.deposit(amount);

	}

	public int withdraw(double amount) {
		return dao.withdraw(amount);
	}

	public void showbalance() {
		dao.showbalance();
	}

	public int fundtransfer(int accountNumber, double amount) {
		return dao.fundtransfer(accountNumber, amount);

	}

	public void printtransaction() {
		dao.printtransaction();
	}

}
