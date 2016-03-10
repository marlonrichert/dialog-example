package com.example.dialog;

import com.vaadin.ui.Component;
import com.vaadin.ui.Window;

public class Dialog extends Window {
	public Dialog(Component content) {
		setContent(content);
		setResizable(false);
		setDraggable(true);
		center();
	}
}
