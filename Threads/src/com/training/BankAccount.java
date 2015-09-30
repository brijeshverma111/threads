package com.training;

public class BankAccount {

	
	private double balance =2000;

	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public synchronized double deposit(double amt){
		
		balance=balance+amt;
		
		System.out.println("Amount deposited " +balance);
		
		notify();  //notify that has been deeposited 
		
		return balance;
		
	}
	public synchronized double withdraw(double amt){
		
		if(balance < amt)
		{
			 System.out.println("Insufficient balance in your account : will wait for transfer ");
			 try {
				wait();
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("Got the amont through transfer");

		}
		//else
			balance=balance-amt;
		System.out.println("got the money -amount withdrawn " +balance);
		
		return balance;
	}
}
