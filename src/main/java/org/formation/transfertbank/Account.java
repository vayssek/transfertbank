package org.formation.transfertbank;

class Account {
	
	//private Customer customer;
	private String number;
	private double balance;
	
	public Account(String number, double balance){
		this.number=number;
		this.balance=balance;
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
