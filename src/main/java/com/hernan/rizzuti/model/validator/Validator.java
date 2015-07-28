package com.hernan.rizzuti.model.validator;


public class Validator {

	public Validator() {
	}

	public boolean textChecker(String text) {
		text = text.replaceAll("\\n\\r\\s+", "");
		if(text.isEmpty() || text.equals(" ") || text == null){
			return false; 
		}
		return true;
	}

	public boolean wordNumChecker(String wordnum) {
		if(!textChecker(wordnum) || !wordnum.matches("^\\d*")){
			return false;
		}
		return true;
	}
}