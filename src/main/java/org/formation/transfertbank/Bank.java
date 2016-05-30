package org.formation.transfertbank;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Customer> customerList;
	private List<Account> accountList;
	
	public Bank(){
		this.customerList = new ArrayList<Customer>();
		this.accountList = new ArrayList<Account>();
	}
	
	public List<Customer> getCustomers(){
		return customerList;
	}

	public List<Account> getAccounts() {
		return accountList;
	}

	public Customer getCustomer(String firstName,String lastName){
		 for(Customer customer : customerList ){
			 if (firstName==customer.getFirstName() && lastName==customer.getLastName()){
				return customer;
			 }
		}
		 return null;
	}

	public Account getAccount(String num) {
		for(Account account : accountList ){
			 if (num==account.getNumber()){
				return account;
			 }
		}
		return null;
	}

	public Customer addCustomer(Customer newCustomer) {
		boolean contain = false;
		int index=-1;
		for(Customer customer : this.customerList){
			if (customer == newCustomer) {
				contain=true;
				index++;
				break;
		}}
		if(contain==false){
			this.customerList.add(newCustomer);
			index= this.customerList.lastIndexOf(newCustomer);
			return this.customerList.get(index);
		}	
		return this.customerList.get(index);
}
}