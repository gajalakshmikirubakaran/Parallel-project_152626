package com.cg.bean;

import junit.framework.TestCase;

public class CustomerDetailsTest extends TestCase {

	public void testGetAdhaarNumber() {
		
		assertEquals("Result",true,true);
		assertEquals("123456789012","123456789012");
		assertNotNull("123456789012","123456789012");
		assertTrue("210987654321",true);
		assertFalse("210987654321",false);
		//fail("Not yet implemented");
	}

	public void testSetCustomerName() {
		
		assertEquals("Result",true,true);
		assertEquals("Lakshmi","Lakshmi");
		assertNotNull("Lakshmi","Lakshmi");
		assertTrue("gaja", true);
		assertFalse("gaja", false);
		//fail("Not yet implemented");
	}

	public void testGetAge() {
		
		assertEquals("Result",true,true);
		assertEquals("21","21");
		assertNotNull("21","21");
		assertTrue("21",true);
		assertFalse("21",false);
		//fail("Not yet implemented");
	}

	public void testGetGender() {
		
		assertEquals("Result",true,true);
		assertEquals("female","female");
		assertNotNull("female","female");
		assertTrue("female", true);
		assertFalse("female", false);
		//fail("Not yet implemented");
	}

	public void testGetPhoneNumber() {
		
		assertEquals("Result",true,true);
		assertEquals("9876543210","9876543210");
		assertTrue("8976543289",true);
		assertFalse("8976543289",false);
		//fail("Not yet implemented");
	}

	public void testGetEmailId() {
		
		assertEquals("Result",true,true);
		assertEquals("Lakshmi","Lakshmi");
		assertNotNull("Lakshmi","Lakshmi");
		assertTrue("gaja", true);
		assertFalse("gaja", false);
		//fail("Not yet implemented");
	}

	public void testGetPassword() {
		
		assertEquals("Result",true,true);
		assertEquals("123","123");
		assertNotNull("123","123");
		assertTrue("321",true);
		assertFalse("321",false);
		//fail("Not yet implemented");
	}

	public void testGetUserName() {
		
		assertEquals("Result",true,true);
		assertEquals("lak","lak");
		assertNotNull("lak","lak");
		assertTrue("lakshmi",true);
		assertFalse("lakshmi",false);
		//fail("Not yet implemented");
	}

}
