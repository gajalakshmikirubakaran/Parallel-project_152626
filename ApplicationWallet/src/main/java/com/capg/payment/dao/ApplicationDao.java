package com.capg.payment.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capg.payment.bean.Application;

public class ApplicationDao implements IApplicationDao {
	boolean flag = false;
	List<Application> list = new ArrayList<Application>();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Scanner sc=new Scanner(System.in);
	

	public boolean createAccount(Application app) {
		
		 flag=list.add(app);
		 return flag;
	}

	public void showBalance(int customerId,String password) {
		for(Application app:list) {
			
			if(app.getCustomerId()==customerId) 
				System.out.println("app");
				else System.out.println();
			
			}
		}
	
		
	public double deposit(int customerId) {
		System.out.println("Enter your customerId:");
		
		int cusId=sc.nextInt();
		for(Application app:list) {
			if(app.getCustomerId()==customerId) {
				
			}
		}
		return cusId;
			
			
		} 
		
		
		
		
	

	
		
		
	

	public double withdraw(double amount) {
		System.out.println("Enter your customerId;");
		
		return amount;
		
		
	}

	public void fundTransaction(long customerId1, long customerId2) {
		
		
	}

	public void printTransaction(long customerId1, long customerId2) {
		
		
	}

	public void showBalance(double balance) {
		// TODO Auto-generated method stub
		
	}

	public double deposit(double amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	
		
	

	
	}
	


