package com.example.dialog;

import com.vaadin.shared.ui.label.ContentMode;

final class Header extends com.vaadin.ui.Label {
	Header(String content) {
		super("<header>" + content + "</header>");
		addStyleName("v-panel-caption");
		setContentMode(ContentMode.HTML);
		setSizeUndefined();
	}
}