package org.vaadin.example.logindialog;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

class Presenter {
	private LoginDialog dialog = new LoginDialog(event -> login(event));
	private String cost = "$499.99";

	public Presenter(UI ui) {
		super();
		ui.addWindow(dialog);
	}

	private void login(ClickEvent event) {
		Notification.show("Logged in!");
	}
}
