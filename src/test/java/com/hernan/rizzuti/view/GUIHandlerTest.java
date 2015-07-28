package com.hernan.rizzuti.view;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.hernan.rizzuti.model.Values;
import com.hernan.rizzuti.model.validator.Validator;

import static org.mockito.Mockito.*;

public class GUIHandlerTest {
	ByteArrayInputStream in;
	Scanner scanner;
	GUIHandler guiHandler;
	Validator validator;
	Values val;
	
	@Before
	public void setUp(){
		val = new Values();
		guiHandler = new GUIHandler();
		validator = new Validator();
		guiHandler.setVal(val);
		guiHandler.setValidator(validator);
	}
	
	@Test
	public void testRequestHandlerReturnsStringHelloAnd1WhenBothArgswerePAssedIn() throws FileNotFoundException {
		in = new ByteArrayInputStream("Hello\n1\n3".getBytes());
		
		//in = getByteArray("Hello\n1\n3");
		scanner = new Scanner(in);
		guiHandler.setScanner(scanner);
		val = guiHandler.requestHandler();
		assertEquals("Hello", val.getParagraph());
		assertEquals(1, val.getWords());
		assertEquals(3, val.getWordspermin());
	}

	@Test
	public void testresponseHandlerverifiesthatgetMethodFromArrayListhasBeencalled() throws FileNotFoundException{
		List<String> list =new ArrayList<String>();
		guiHandler = new GUIHandler();
		guiHandler.responseHandler(list);
	}

	@Test
	public void testresponseHandlerverifiesthatTextCheckerisCalled(){
		in = getByteArray("\ntext\na\n1\n4");
		scanner = new Scanner(in);
		guiHandler.setScanner(scanner);
		guiHandler.requestHandler();
		assertEquals("text", val.getParagraph());
		assertEquals(1,val.getWords());
		assertEquals(4, val.getWordspermin());
	}
	
	@Test
	public void testgetwordperMinReturnStringcontainingNumberofwords(){
		in = getByteArray("3");
		scanner = new Scanner(in);
		guiHandler.setScanner(scanner);
		assertEquals("3",guiHandler.getwordperMin());
	}

	private ByteArrayInputStream getByteArray(String input) {
		in = new ByteArrayInputStream(input.getBytes());
		return in;
	}
}