package com.cg.service;

import junit.framework.TestCase;

public class DataValidationTest extends TestCase {
	DataValidation val=new DataValidation();

	public void testValidateadhaarnumber() {
		
		assertEquals("Result",true,val.validateadhaarnumber("231456789023"));
		//fail("Not yet implemented");
	}

	public void testValidateemailId() {
		assertEquals("Result",true,val.validateemailId("gaja@gmail.com"));
		//fail("Not yet implemented");
	}

	public void testValidatephonenumber() {
		assertEquals("Result",true,val.validatephonenumber("9840143293"));
		//fail("Not yet implemented");
	}

	public void testValidatecustomerName() {
		assertEquals("Result",true,val.validatecustomerName("lakshmi"));
		//fail("Not yet implemented");
	}

	public void testValidategender() {
		
		assertEquals("Result",true,val.validategender("male"));
		assertEquals("Result",true,val.validategender("female"));
	//	fail("Not yet implemented");
	}

	public void testValidateage() {
		assertEquals("Result",true,val.validateage(21));
		//fail("Not yet implemented");
	}

	public void testValidatepassword() {
		
		assertEquals("Result",true,val.validatepassword("glksks96@gmail.com"));
		//fail("Not yet implemented");
	}

}
