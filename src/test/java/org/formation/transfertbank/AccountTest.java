package org.formation.transfertbank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import org.junit.Test;

public class AccountTest {
	private static final Account FIRST_ACCOUNT = new Account("123_123456789",300);
	private static final Account SECOND_ACCOUNT = new Account("123_123456788",0);
	private Account firstAccount;
	private Account secondAccount;
	
	
	@Before
	public void setup() {
	// Initialization of test parameters
		firstAccount = FIRST_ACCOUNT;
		secondAccount = SECOND_ACCOUNT;
	}

	@Test
	public void checkFirstAccountBalance(){
		//GIVEN
		//WHEN
		boolean result= firstAccount.checkBalance(firstAccount.getBalance(),300);
		//THEN
		assertEquals(true,result);
	}
}
