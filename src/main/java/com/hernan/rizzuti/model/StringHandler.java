package com.hernan.rizzuti.model;

import java.util.List;

public class StringHandler implements IHandler{

	private List<String> singlewordls;
	private List<String> groupedwordls;
	private String words;
	private int elementscount;
	private int rowsnumbers;

	public StringHandler(List<String> singlewordls, List<String> groupedwordls) {
		this.singlewordls = singlewordls;
		this.groupedwordls = groupedwordls;
	}

	public List<String> stringSplitter(String paragraph) {
		//remove duplicate white spaces and split string
		String[] word = paragraph.replaceAll("\\s+", " ").split(" ");
		for(int i = 0; i < word.length;i++){
			singlewordls.add(word[i]);
		}
		return singlewordls;
	}

	public List<String> wordHandler(String text, int wordnumber) {

		List<String> elements = stringSplitter(text);
		elementscount = elements.size();
		rowsnumbers = elementscount/wordnumber;
		//iterate through the number of rows
		for(int j=0;j < rowsnumbers;j++){
			//if the number of words is one then get first element in the array
			if(elementscount == 1){
				words = elements.get(0);
				groupedwordls.add(words);
			} else {
				wordConcatinator(wordnumber, elements);
				for(int x = 0; x < wordnumber;x++){
					elements.remove(0);//removed unused elements
				}
			}
		}

		elementscount = elements.size();//check how many elements are left and if the number is lower than the wordnumber then count then individually
		if( elementscount < wordnumber && elementscount != 0){// possible problem -- use (elementscount < wordnumber) this causes it, 
			wordConcatinator(elementscount, elements);
		}
		return groupedwordls;
	}

	public void wordConcatinator(int word, List<String> elements) {
		for(int i=0;i < word;i++){
			if(i == 0){
				words = elements.get(i);//initialise words with first element in array
			}else{
				words = words + " " + elements.get(i); //concatenate the words
			}
		}
		groupedwordls.add(words);//add words to the array
	}
	/*work on:
	 * validate inputs
	 * use swing
	 * create a timer for number of words
	 * */
}