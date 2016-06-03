package org.formation.transfertbank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private List<Customer> customerList;
	private List<Account> accountList;
	private String name;
	
	public Bank(){
		this.name = new String();
		this.customerList = new ArrayList<Customer>();
		this.accountList = new ArrayList<Account>();
	}
	
	public List<Customer> getCustomers(String name){
		Connection connection = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		String url = "jdbc:postgresql://localhost:5432/transfertbank";
		String user = "admin";
		String passwd = "frct..035";
		try {
			connection = DriverManager.getConnection(url, user, passwd);
			stmt = connection.createStatement();
			String request = "SELECT customer.firstname, customer.lastname FROM customer, bank WHERE bank.name='"+name+"';";
			resultSet =stmt.executeQuery(request);
			while (resultSet.next()) {
				String firstName = resultSet.getString("firstname");
				String lastName  = resultSet.getString("lastname");
				Customer customer = new Customer(firstName,lastName);
				customerList.add(customer);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			 try { connection.close(); } catch (Exception e) { /* ignored */ }
			 try { stmt.close(); } catch (Exception e) { /* ignored */ }
			 try { resultSet.close(); } catch (Exception e) { /* ignored */ }
		}
	return customerList;
	}

	public List<Account> getAccounts(String name) {
		String url = "jdbc:postgresql://localhost:5432/transfertbank";
		String user = "admin";
		String passwd = "frct..035";
		try {
			Connection connection = DriverManager.getConnection(url, user, passwd);
			Statement stmt = connection.createStatement();
			String request = "SELECT account.number, account.balance FROM account, bank WHERE bank.name='"+name+"';";
			ResultSet resultSet =stmt.executeQuery(request);
			while (resultSet.next()) {
				String number = resultSet.getString("number");
				double balance  = resultSet.getDouble("balance");
				Account account = new Account(number,balance);
				accountList.add(account);
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
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