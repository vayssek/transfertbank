package org.formation.transfertbank;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	
	@Before
	public void setup() {
	// Initialization of test parameters
		customer = new Customer("Kevin","VAYSSE");
	}
	
	@Test
	public void findFirstName(){
		//GIVEN
		//WHEN
		String result = customer.getFirstName();
		//THEN
		assertEquals(result,"Kevin");
	}
	
	@Test
	public void findLastName(){
		//GIVEN
		//WHEN
		String result = customer.getLastName();
		//THEN
		assertEquals(result,"VAYSSE");
	}
	
	@Test
	public void findCompleteName(){
		//GIVEN
		//WHEN
		String result = customer.getCompleteName();
		//THEN
		assertEquals(result,"Kevin_VAYSSE");
	}
	
}
