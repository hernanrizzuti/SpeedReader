package com.hernan.rizzuti.model;

import java.util.List;

public interface IHandler {
	List<String> stringSplitter(String paragraph);
	List<String> wordHandler(String text, int wordnumber);
	void wordConcatinator(int word, List<String> elements);
}