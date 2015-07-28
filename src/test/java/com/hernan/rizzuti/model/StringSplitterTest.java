package com.hernan.rizzuti.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hernan.rizzuti.model.StringHandler;

public class StringSplitterTest {
	ArrayList<String> ls;
	StringHandler sh;
	List<String> actual;
	ArrayList<String> wordlist;
	
	@Before
	public void setup(){
		wordlist = new ArrayList<String>();
		ls = new ArrayList<String>();
		sh = new StringHandler(ls, wordlist);
	}
	
	@Test
	public void testStringSplitterReturnsElementHelloAndElementWorldWhenStringHello_WorldIsPAssedIn(){
		actual = sh.stringSplitter("hello World");
		assertEquals(2, actual.size());	
	}
	
	@Test
	public void testWordHandlerReturnsHelloWhenWhenNumberofWordspassedInIsOne(){
		List<String> actual = sh.wordHandler("hello World",1);
		assertEquals("hello",actual.get(0));
	}
	
	@Test
	public void testWordHandlerReturnsHello_WorldWhenWhenNumberofWordspassedInIsTwo(){
		sh.stringSplitter("hello World");
		List<String> actual = sh.wordHandler("hello World",2);
		assertEquals("hello World",actual.get(0));
	}
	
	@Test
	public void testWordHandlerReturnsThis_is_a_stringWhenWhenNumberofWordspassedInIs4(){
		List<String> actual = sh.wordHandler("this is a string for testing this method here",4);
		assertEquals("this is a string",actual.get(0));
		assertEquals("for testing this method",actual.get(1));
	}
	
	@Test
	public void testWordHandlerReturnsTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelveWhenTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve(){
		List<String> actual = sh.wordHandler("This is a string but I only Want Three out of twelve",3);
		assertEquals("This is a", actual.get(0));
		assertEquals("string but I", actual.get(1));
		assertEquals("only Want Three", actual.get(2));
		assertEquals("out of twelve", actual.get(3));
	}
	
	@Test
	public void testWordHandlerReturnsTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plus_thisWhenTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plus_this(){
		List<String> actual = sh.wordHandler("This is a string but I only Want Three out of twelve, plus this",3);
		assertEquals("This is a", actual.get(0));
		assertEquals("string but I", actual.get(1));
		assertEquals("only Want Three", actual.get(2));
		assertEquals("out of twelve,", actual.get(3));
		assertEquals("plus this", actual.get(4));
	}
	
	@Test
	public void testWordHandlerReturnsTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plusWhenTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plus(){
		List<String> actual = sh.wordHandler("This is a string but I only Want Three out of twelve, plus",3);
		assertEquals("This is a", actual.get(0));
		assertEquals("string but I", actual.get(1));
		assertEquals("only Want Three", actual.get(2));
		assertEquals("out of twelve,", actual.get(3));
		assertEquals("plus", actual.get(4));
	}
	
	@Test
	public void testWordHandlerReturnsStringWithOneWhiteSpaceOnlyWhenMultiplewhitespacesarePassedIn(){
		List<String> actual = sh.wordHandler("This is a   string but  I only Want  Three out of  twelve, plus",3);
		assertEquals("This is a", actual.get(0));
		assertEquals("string but I", actual.get(1));
		assertEquals("only Want Three", actual.get(2));
		assertEquals("out of twelve,", actual.get(3));
	}
	
	@Test
	public void testWordHandlerReturnTherightNumberOflinesWithoutRepentingThem(){
		List<String> actual = sh.wordHandler("Next Sunday sees the starter's flag fall " +
				"on the 2013 World Solar Challenge, and on the grid in Darwin will be Cambridge " +
				"University Eco Racing's Resolution - a sleek carbon-fibre monocoque chassis " +
				"solar-powered vehicle, featuring a game-changing solar tracking system.",5);
		assertEquals("Next Sunday sees the starter's", actual.get(0));
		assertEquals("flag fall on the 2013", actual.get(1));
		assertEquals("World Solar Challenge, and on", actual.get(2));
		assertEquals("the grid in Darwin will", actual.get(3));
		assertEquals("be Cambridge University Eco Racing's", actual.get(4));
		assertEquals("Resolution - a sleek carbon-fibre", actual.get(5));
		assertEquals("monocoque chassis solar-powered vehicle, featuring", actual.get(6));
		assertEquals("a game-changing solar tracking system.", actual.get(7));
	}
	
	@Test
	public void testWordHandlerReturnsTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plusWhenTheStringIsThis_is_a_string_but_I_only_Want_Three_out_of_twelve_plus1(){
		List<String> actual = sh.wordHandler("This is a string but I only Want Three out of twelve, plus",5);
		assertEquals("This is a string but", actual.get(0));
		assertEquals("I only Want Three out", actual.get(1));
		assertEquals("of twelve, plus", actual.get(2));
		//assertEquals("of twelve, plus", actual.get(3));
	}
	
	@Test
	public void test(){
		List<String> actual = sh.wordHandler("Robust systems We can process millions of transactions every day – and undreds of simultaneous transactions a second. Flexibility When your business  rows, we’ll make it easy to scale up. Security We’ll help you minimise the risk of fraud. Reach We operate across the globe, supporting 120 different currencies and ore than 200 payment types. Additional services We can also help you manage cash flow, currency and fraud risk, tailoring services to your exact needs. Easy start-up When you work with us, you will see how easy it is to start taking payments."
				+ "Robust systems We can process millions of transactions every day – and undreds of simultaneous transactions a second. Flexibility When your business  rows, we’ll make it easy to scale up. Security We’ll help you minimise the risk of fraud. Reach We operate across the globe, supporting 120 different currencies and ore than 200 payment types. Additional services We can also help you manage cash flow, currency and fraud risk, tailoring services to your exact needs. Easy start-up When you work with us, you will see how easy it is to start taking payments."
				+ "Robust systems We can process millions of transactions every day – and undreds of simultaneous transactions a second. Flexibility When your business  rows, we’ll make it easy to scale up. Security We’ll help you minimise the risk of fraud. Reach We operate across the globe, supporting 120 different currencies and ore than 200 payment types. Additional services We can also help you manage cash flow, currency and fraud risk, tailoring services to your exact needs. Easy start-up When you work with us, you will see how easy it is to start taking payments.", 2);
	}
	
}
