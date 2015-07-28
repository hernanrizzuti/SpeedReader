package com.hernan.rizzuti.model;

public class Timer {

	public static long timecalc(int wordspermin, int wordnumber) {
		int minute = 60000;
		return (minute*wordnumber)/wordspermin;
	}
}