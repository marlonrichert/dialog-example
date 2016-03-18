package org.vaadin.example;

import com.vaadin.shared.ui.label.ContentMode;

public final class Header extends com.vaadin.ui.Label {
	public Header(String title) {
		super("<header><h1>" + title + "</h1>");
		addStyleName("v-panel-caption");
		setContentMode(ContentMode.HTML);
		setSizeUndefined();
	}

	public Header(String title, String subtitle) {
		this(title);
		setValue("<header><h1>" + title + "</h1><p>" + subtitle + "</p></header>");
	}
}