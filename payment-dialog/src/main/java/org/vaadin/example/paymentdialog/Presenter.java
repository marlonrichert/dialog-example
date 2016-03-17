package org.vaadin.example.paymentdialog;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

class Presenter {
	private PaymentDialog dialog = new PaymentDialog(event -> pay(event));
	private String cost = "$499.99";

	public Presenter(UI ui) {
		super();
		dialog.setPayAmount(cost);
		ui.addWindow(dialog);
	}

	private void pay(ClickEvent event) {
		Notification.show(String.format("Payment confirmation for %s sent to %s", cost, dialog.getEmail()));
	}
}
