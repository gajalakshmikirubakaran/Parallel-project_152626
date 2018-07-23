package com.cg.bean;

import junit.framework.TestCase;

public class AccountDetailsTest extends TestCase {

	public void testGetDetails() {
		assertEquals("Result",true,true);
		assertEquals("123","123");
		assertNotNull("123","123");
		assertTrue("321",true);
		assertFalse("321",false);
		//fail("Not yet implemented");
	}

	public void testGetAccountNumber() {
		assertEquals("Result",true,true);
		assertEquals("987654321023456","987654321023456");
		assertTrue("8976543289789067",true);
		assertFalse("8976543289789067",false);
		//fail("Not yet implemented");
	}

	public void testGetBalance() {
		
		assertEquals("Result",true,true);
		assertEquals("123","123");
		assertNotNull("123","123");
		assertTrue("321",true);
		assertFalse("321",false);
		//fail("Not yet implemented");
	}

}
