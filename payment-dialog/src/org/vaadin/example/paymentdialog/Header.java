package org.vaadin.example.paymentdialog;

import com.vaadin.shared.ui.label.ContentMode;

final class Header extends com.vaadin.ui.Label {
	Header(String title, String subtitle) {
		super("<header><h1>" + title + "</h1><p>" + subtitle + "</p></header>");
		addStyleName("v-panel-caption");
		setContentMode(ContentMode.HTML);
		setSizeUndefined();
	}
}