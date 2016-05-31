package org.formation.transfertbank;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class BankTest {

	private static final Customer ONE_CUSTOMER = new Customer("Kevin","VAYSSE");
	private static final Account ONE_ACCOUNT = new Account("123456789",0);
	private Bank bank;
	private Customer customer;
	private Account account;
	
	
	@Before
	public void setup() {
	// Initialization of test parameters
		bank = new Bank();
		customer = ONE_CUSTOMER;
		account = ONE_ACCOUNT;
	}
	
	@Test
	public void returnListCustomers(){
		//GIVEN
		//WHEN
		List<Customer> result = bank.getCustomers("CM");
		//THEN
		assertEquals(2, result.size());
	}
	
	@Test
	public void returnListAccounts(){
		//GIVEN
		//WHEN
		List<Account> result = bank.getAccounts();
		//THEN
		assertTrue(result.isEmpty());
	}
	
	@Test
	public void returnListAccountsAdded(){
		//GIVEN	
		bank.getAccounts().add(account);
		//WHEN
		List<Account> result = bank.getAccounts();
		//THEN
		assertFalse(result.isEmpty());
	}
	
//	@Test
//	public void returnOneClient(){
//		//GIVEN	
//		bank.getCustomers().add(customer);
//		//WHEN
//		Customer result = bank.getCustomer("Kevin", "VAYSSE");
//		//THEN
//		assertEquals(result,ONE_CUSTOMER);
//	}
	
//	@Test
//	public void returnMissingClient(){
//		//GIVEN	
//		bank.getCustomers().add(customer);
//		//WHEN
//		Customer result = bank.getCustomer("Kevin", "Veisse");
//		//THEN
//		assertNull(result);
//	}
	
	@Test
	public void returnOneAccount(){
		//GIVEN	
		bank.getAccounts().add(account);
		//WHEN
		Account result = bank.getAccount("123456789");
		//THEN
		assertEquals(result,ONE_ACCOUNT);
	}
	
	@Test
	public void returnMissingAccount(){
		//GIVEN	
		bank.getAccounts().add(account);
		//WHEN
		Account result = bank.getAccount("000000000");
		//THEN
		assertNull(result);
	}
	
	@Test
	public void addNewCustomer(){
		//GIVEN	
		//WHEN
		Customer result = bank.addCustomer(ONE_CUSTOMER);
		//THEN
		assertEquals(result,ONE_CUSTOMER);
	}
	
	@Test
	public void addExistingCustomer(){
		//GIVEN
		Customer ExistedCustomer = bank.addCustomer(ONE_CUSTOMER);
		//WHEN
		Customer result = bank.addCustomer(ExistedCustomer);
		//THEN
		assertEquals(result,ExistedCustomer);
	}
	
}
