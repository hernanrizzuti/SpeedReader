package com.hernan.rizzuti.view;

import java.util.List;
import java.util.Scanner;

import com.hernan.rizzuti.model.Values;

public interface IView {
	
	Values requestHandler();
	void responseHandler(List<String> lines);
	String getText();
	String getWordNum();
}
