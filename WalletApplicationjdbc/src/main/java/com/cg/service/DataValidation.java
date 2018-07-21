package com.cg.service;

public class DataValidation {
	public boolean validateadhaarnumber(String adhaarNumber) {

		if ((adhaarNumber.length() == 12)) {

			return true;

		}

		else {
			System.out.println("invalid adhaar number");
			return false;

		}
	}

	public boolean validateemailId(String emailId) {

		if (emailId.endsWith(".com")) {

			return true;
		}

		else {
			System.err.println("invalid email id");
			return false;

		}
	}

	public boolean validatephonenumber(String phoneNumber) {

		if (phoneNumber.length() == 10) {

			return true;
		}

		else {
			System.err.println("phone number invalid");
			return false;
		}
	}

	public boolean validatecustomerName(String customerName) {

		if (!(customerName.isEmpty())) {

			return true;
		}

		else {
			System.out.println("Customer name is empty");
			return false;
		}
	}

	public boolean validategender(String gender) {

		if ((gender.equals("male")) || (gender.equals("female"))) {

			return true;
		} else {
			System.err.println("invalid gender entry");
			return false;
		}

	}

	public boolean validateage(int age) {

		if (age > 0) {

			return true;
		} else {
			System.err.println("invalid age entry");
			return false;
		}

	}
	public boolean validatepassword(String password) {
		if(password.length()>=4) {
			return true;
		
		}
		else System.out.println("invalid password");
		return false;
	}

}
