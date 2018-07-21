package com.capg.payment.service;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidateApplicationServiceTest {
	
ValidateApplicationService sr=new ValidateApplicationService();
	@Test
	public void testValidatecustomerName() {
		//fail("Not yet implemented");
		
		assertEquals("Result",true,sr.validatecustomerName("lakshmi"));
	}

	@Test
	public void testValidatephoneNumber() {
		//fail("Not yet implemented");
		assertEquals("Result",true,sr.validatephoneNumber("9840143293"));
	}

	@Test
	public void testValidateaadharNumber() {
		//fail("Not yet implemented");
		assertEquals("Result",true,sr.validateaadharNumber("231456789023"));
	}

	@Test
	public void testValidateaccountNumber() {
		//fail("Not yet implemented");
		assertEquals("Result",true,sr.validateaccountNumber("890765432123456"));
	}
		@Test
		public void testValidatepassword() {
			assertEquals("Result",true,sr.validatepassword("glksks96@gmail.com"));
	}
		@Test
		public void testValidategender() {
			//fail("Not yet implemented");
			assertEquals("Result",true,sr.validategender("male"));
			assertEquals("Result",true,sr.validategender("female"));

}
		public void testValidateage() {
			//fail("Not yet implemented");
			assertEquals("Result",true,sr.validateage(21));
			
}
}
