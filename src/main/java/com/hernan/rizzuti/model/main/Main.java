package com.hernan.rizzuti.model.main;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hernan.rizzuti.controller.Controller;
import com.hernan.rizzuti.model.StringHandler;
import com.hernan.rizzuti.model.Values;
import com.hernan.rizzuti.model.validator.Validator;
import com.hernan.rizzuti.view.GUIHandler;
import com.hernan.rizzuti.view.Scan;

public class Main {
	
	public static void main(String[] args){
		//Scanner scanner = new Scanner(System.in);
		/*Scan scanner = new Scan();
		Values val = new Values();
		GUIHandler guihandler = new GUIHandler();
		guihandler.setScanner(scanner.getScanner());
		guihandler.setVal(val);
		Validator validator = new Validator();
		guihandler.setValidator(validator);
		List<String> singlewordls = new ArrayList<String>();
		List<String> groupedwordls = new ArrayList<String>();
		StringHandler handler = new StringHandler(singlewordls, groupedwordls);
		Controller controller = new Controller(handler, guihandler);*/

		Controller controller = (Controller) new ClassPathXmlApplicationContext("context.xml").getBean("controller");
		controller.handler();
	}
}