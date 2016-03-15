package com.example.dialog;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public class Dialog extends Window {
	protected Dialog() {
		super();
		setResizable(false);
		setDraggable(true);
		center();
	}
	
	public Dialog(Component content) {
		this();
		setContent(content);
	}
}
