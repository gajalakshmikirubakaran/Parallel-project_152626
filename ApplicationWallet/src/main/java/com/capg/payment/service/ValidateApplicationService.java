package com.capg.payment.service;

import com.capg.payment.bean.Application;
import java.util.ArrayList;
import java.util.List;

public class ValidateApplicationService {
	Application app=new Application();
	List<Application> list = new ArrayList<Application>();

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
		if(emailId.endsWith(".com"))
		{
			
			return true;
		}
		
		else {
			System.err.println("invalid email id");
			return false;
			
		}
		
	}
	public boolean validategender(String gender) {
		
		if((gender.equals("male"))||(gender.equals("female"))) {
			
			return true;
		}else
		{
			System.err.println("invalid gender");
			return false;
		}

	
		
	}
	public boolean validateage(int age) {
		
		if(age>0) {
			
			return true;
		}else
		{
			System.err.println("invalid age entry");
			return false;
		}
}
}
		
	
	


	
		
	

