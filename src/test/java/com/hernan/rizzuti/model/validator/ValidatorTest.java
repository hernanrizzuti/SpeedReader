package com.hernan.rizzuti.model.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ValidatorTest {
	private Validator val;
	
	@Before
	public void setUp(){
		val = new Validator();
	}
	
	@Test
	public void testTextValReturnsFalseWhenTextIsblank() {
	
		assertFalse(val.textChecker(" "));
		assertEquals(false,val.textChecker(""));
	}
	
	@Test
	public void testWordNumCheckerReturnsFalseWhenInputIsBlankOrNotaNumber(){
		
		assertEquals(false,val.wordNumChecker(""));
		assertEquals(false,val.wordNumChecker(" "));
		assertEquals(false,val.wordNumChecker("a"));
	}
	
	@Test
	public void testWordNumCheckerReturnsTrueWhenInputIsaNumber(){
	
		assertTrue(val.wordNumChecker("1"));
		assertEquals(false,val.wordNumChecker("-1"));
		assertEquals(true,val.wordNumChecker("0"));
	}
	
	
	
	
	
	
	
}