package com.hernan.rizzuti.controller;

import java.util.List;

import com.hernan.rizzuti.model.IHandler;
import com.hernan.rizzuti.model.Values;
import com.hernan.rizzuti.view.IView;

public class Controller {

	private IHandler handler;
	private IView iview;

	public Controller(IHandler handler, IView guihandler) {
		System.out.println("Calling cntroller constructor!!!!!!!!!!!!");
		this.handler=handler;
		this.iview = guihandler;
	}

	public void handler() {
		Values val = iview.requestHandler();
		List<String> lines = handler.wordHandler(val.getParagraph(), val.getWords());
		iview.responseHandler(lines);
	}
}