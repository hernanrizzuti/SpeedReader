package com.hernan.rizzuti.view;

import java.util.Scanner;

public class Scan {
	
	public Scan() {
		System.out.println("Calling Scan constructor!!!!!!!");
	}
	
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
}
