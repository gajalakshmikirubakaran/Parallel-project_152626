package com.capg.payment.service;

public class ValidateApplicationService {
	public boolean validatecustomerName(String customerName) {
		if(customerName.length()>4)
			return true;
		else return false;
	}
	public boolean validatephoneNumber(String phoneNumber) {
		if(phoneNumber.length()==10)
			return true;
		else
			return false;
	}
	public boolean validateaadharNumber(String aadharNumber) {
		if(aadharNumber.length()==12)
			return true;
		else return false;
	}
	public boolean validateaccountNumber(String accountNumber) {
		if(accountNumber.length()==15)
			return true;
		else return false;
	}
	public boolean validatepassword(String password) {
		if(password.length()>=8)
			return true;
		else return false;
	}
	public boolean validateemailId(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
