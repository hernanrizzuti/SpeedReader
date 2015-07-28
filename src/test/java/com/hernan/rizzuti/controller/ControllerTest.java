package com.hernan.rizzuti.controller;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.hernan.rizzuti.model.IHandler;
import com.hernan.rizzuti.model.Values;
import com.hernan.rizzuti.view.IView;

import static org.mockito.Mockito.*;

public class ControllerTest {
	IHandler mockedIH;
	IView mockedIV;
	Controller c;
	Values mockedval;
	
	@Before
	public void setup(){
		mockedIH = mock(IHandler.class);
		mockedIV = mock(IView.class);
		mockedval = mock(Values.class);
		c = new Controller(mockedIH, mockedIV);
		when(mockedIV.requestHandler()).thenReturn(mockedval);
	}

	@Test
	public void testHandlerVerifiesthatRequestHandlerIscalled() {
		c.handler();
		verify(mockedIV).requestHandler();
	}
	
	@Test
	public void testHandlerverifiesthatStringHandlerIscalled(){
		c.handler();
		verify(mockedIH).wordHandler(anyString(), anyInt());
	}
}