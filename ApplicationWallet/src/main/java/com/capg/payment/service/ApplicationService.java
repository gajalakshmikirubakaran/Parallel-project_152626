package com.capg.payment.service;

import com.capg.payment.bean.Application;
import com.capg.payment.dao.ApplicationDao;

public class ApplicationService {
	
	ApplicationDao dao=new ApplicationDao();

	public boolean createAccount(Application app) {
		// TODO Auto-generated method stub
		return dao.createAccount(app);
	}
	public double deposit(double amount) {
		return dao.deposit(amount);
	}
	public double withdraw(double amount) {
		return dao.withdraw(amount);
	}

	public double showBalance(int cusId) {
		
		return dao.deposit(cusId);
	}

}
