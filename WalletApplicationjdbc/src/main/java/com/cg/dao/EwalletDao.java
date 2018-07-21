package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.bean.AccountDetails;

public class EwalletDao {
	double balance;
	int flag = 0;
	String details;
	static int accno;
	int accountNumber;
	AccountDetails acdetails = new AccountDetails();
	

	public int login(String userName, String password) {
		Connection conn = JdbcUtil.getConnection();
		Statement smt;
		try {
			smt = conn.createStatement();

			String select = "select customerdetails.userName ,customerdetails.password,customerdetails.accountNumber from customerdetails,accountdetails  where customerdetails.accountNumber=accountdetails.accountNumber";
			smt.executeQuery(select);

			ResultSet rs = smt.executeQuery(select);

			while (rs.next()) {

				String uname = rs.getString("userName");
				String pass = rs.getString("password");
				if (uname.equals(userName) && pass.equals(password)) {
					

					accno = rs.getInt("accountNumber");

					return 1;

				}

			}
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 0;
	}

	public int createAccount(AccountDetails adetails) {

		Connection conn = JdbcUtil.getConnection();
		int accountNumber = adetails.getAccountNumber();

		double balance = adetails.getBalance();

		int age = adetails.getDetails().getAge();
		String gender = adetails.getDetails().getGender();
		String customerName = adetails.getDetails().getCustomerName();
		String phoneNumber = adetails.getDetails().getPhoneNumber();
		String adhaarNumber = adetails.getDetails().getAdhaarNumber();
		String emailId = adetails.getDetails().getEmailId();
		String userName = adetails.getDetails().getUserName();
		String password = adetails.getDetails().getPassword();
		
		String insertquery = "INSERT INTO accountdetails VALUES(?,?)";
		String insertquery2 = "INSERT INTO customerdetails  VALUES (?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement psmt = conn.prepareStatement(insertquery);
			PreparedStatement psmt2 = conn.prepareStatement(insertquery2);
			psmt.setLong(1, accountNumber);
			psmt.setDouble(2, balance);
			psmt2.setString(1, customerName);
			psmt2.setInt(2, age);
			psmt2.setString(3, gender);
			psmt2.setString(4, phoneNumber);
			psmt2.setString(5, adhaarNumber);
			psmt2.setString(6, userName);
			psmt2.setString(7, password);
			psmt2.setInt(8, accountNumber);

			psmt2.execute();
			psmt.execute();
			conn.close();
			return 1;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 1;

	}

	public int deposit(double amount) {

		accountNumber = accno;
		
		Connection con = JdbcUtil.getConnection();

		try {
			String deposit = " The amount deposited is" +" "+amount;
			String insertq = "INSERT INTO Transaction values(?,?)";
			String Query = "update accountdetails SET balance= balance+? where accountNumber=?";
			PreparedStatement pstmt, psmt2;

			pstmt = con.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, accountNumber);
			pstmt.execute();
			psmt2 = con.prepareStatement(insertq);
			psmt2.setLong(1, accountNumber);
			psmt2.setString(2, deposit);
			psmt2.execute();
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 1;

	}

	public int withdraw(double amount) {
		

		accountNumber = accno;
		
		Connection conn = JdbcUtil.getConnection();

		try {
			Statement smt = conn.createStatement();
			String withdraw = " The amount withdrawn is"+" " +amount;
			String insertw = "INSERT INTO Transaction values(?,?)";

			String query = "select * from accountdetails where accountNumber='" + accountNumber + "'";

			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}
			if (balance > amount) {
				String Query = "update accountdetails SET balance= balance-? where accountNumber=?";
				PreparedStatement pstmt, pt;
				pstmt = conn.prepareStatement(Query);
				pstmt.setDouble(1, amount);
				pstmt.setInt(2, accountNumber);

				pstmt = conn.prepareStatement(insertw);
				pstmt.setLong(1, accountNumber);
				pstmt.setString(2, withdraw);
				pstmt.executeUpdate();
				pstmt.execute();
				conn.close();

				return 0;
			} else {
				System.out.println("amount exceeds");

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 1;
	}

	public void showbalance() {

		accountNumber = accno;

		Connection conn = JdbcUtil.getConnection();
		try {
			Statement smt = conn.createStatement();
			String query = "select * from accountdetails where accountNumber='" + accountNumber + "'";

			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}

			System.out.println("The balance is" + balance);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public int fundtransfer(int accountNumber2, double amount) {
		

		Connection conn = JdbcUtil.getConnection();
		accountNumber = accno;

		try {
			String fdt = " The amount "+ " " +"transferred to" + accountNumber2+"is" +" "+amount;
			String insertfund = "INSERT INTO Transaction values(?,?)";
			String Query = "update accountdetails SET balance= balance+? where accountNumber=?";
			PreparedStatement pstmt, pstmt3;
			pstmt = conn.prepareStatement(Query);
			pstmt.setDouble(1, amount);
			pstmt.setInt(2, accountNumber2);
			pstmt.execute();

			Statement smt = conn.createStatement();
			String query = "select * from accountdetails where accountNumber='" + accountNumber + "'";

			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {
				balance = rs.getDouble("balance");

			}
			if (balance > amount) {
				String fd = "update accountdetails SET balance= balance-? where accountNumber=?";

				pstmt = conn.prepareStatement(fd);
				pstmt.setDouble(1, amount);
				pstmt.setInt(2, accountNumber);
				pstmt3 = conn.prepareStatement(insertfund);
				pstmt3.setLong(1, accountNumber);
				pstmt3.setString(2, fdt);
				pstmt3.execute();
				pstmt.execute();
				conn.close();
				return 0;
			} else {
				System.out.println("Transaction failed");

			}

			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 0;
	}

	public void printtransaction() {
		accountNumber = accno;

		Connection conn = JdbcUtil.getConnection();
		try {
			Statement smt = conn.createStatement();
			String query = "select * from transaction where accountNumber='" + accountNumber + "'";

			ResultSet rs = smt.executeQuery(query);

			while (rs.next()) {
				System.out.println();
				details = rs.getString("transactioninfo");
				System.out.println("the transactions are \n" + details);

			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
