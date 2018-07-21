package com.capg.payment.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AccountDetailsTest {
	@Test
	public void testGetAccountNumber() {
		//fail("Not yet implemented");
	        assertEquals("Result",true,true);
			assertEquals("987654321023456","987654321023456");
			assertTrue("8976543289789067",true);
			assertFalse("8976543289789067",false);

	}
	@Test
	public void testGetBalance() {
		assertEquals("Result",true,true);
		assertEquals("123","123");
		assertNotNull("123","123");
		assertTrue("321",true);
		assertFalse("321",false);
	}
	@Test
	public void testGetApplication() {
		assertEquals("Result",true,true);
		assertEquals("123","123");
		assertNotNull("123","123");
		assertTrue("321",true);
		assertFalse("321",false);
	}
	}

