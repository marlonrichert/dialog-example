package com.example.dialog;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

class Layout extends CssLayout {
	static final String VERTICAL = "layout--vertical";
	static final String HORIZONTAL = "layout--horizontal";
	static final String PADDED = "layout--padded";

	public Layout(String... styles) {
		for (int i = 0; i < styles.length; i++) {
			addStyleName(styles[i]);
		}
	}
	
	public void add(Component c) {
		super.addComponent(c);
	}

	public void addSpace() {
		addComponent(new Spacer());
	}
}