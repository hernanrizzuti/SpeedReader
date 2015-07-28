package com.hernan.rizzuti.view;

import java.util.List;
import java.util.Scanner;

import com.hernan.rizzuti.model.Timer;
import com.hernan.rizzuti.model.Values;
import com.hernan.rizzuti.model.validator.Validator;

public class GUIHandler implements IView {

	//Logger log = Logger.getLogger(GUIHandler.class);
	private Validator validator;
	private Values val;
	private Scanner scanner;

	public GUIHandler() {
		this.scanner = new Scanner(System.in);
	}

	public void setVal(Values val) {
		this.val = val;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public Values requestHandler() {
		String text = getText();

		while(!validator.textChecker(text)){
			text = getText();
		}
		val.setParagraph(text);
		String wordnum = getWordNum();
		while(!validator.wordNumChecker(wordnum)){
			wordnum = getWordNum();
		}
		val.setWords(parser(wordnum));
		String wordspermin = getwordperMin();
		while(!validator.wordNumChecker(wordspermin)){
			wordspermin = getwordperMin();
		}
		//use validator to validate input
		val.setWordspermin(parser(wordspermin));
		return val;
	}

	public String getWordNum() {
		System.out.println("How many words per line you would like to split the paragraph into: ");
		return scanner.nextLine();
	}

	public String getText() {
		System.out.println("Please enter the paragraph you would like to read: ");
		return scanner.nextLine();
	}

	public String getwordperMin() {
		System.out.println("How many words per minutes you would like to read: ");
		return scanner.nextLine();
	}

	@Override
	public void responseHandler(List<String> lines) {
		for (String line : lines) {
			System.out.println(line);
			try {
				Thread.sleep(Timer.timecalc(val.getWordspermin(), val.getWords()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private int parser(String input) {
		return Integer.parseInt(input);
	}
}