package org.vaadin.example.paymentdialog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

@Theme("payment-dialog")
public class PaymentUI extends com.vaadin.ui.UI {
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = PaymentUI.class, productionMode = false)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		new Presenter(this);
	}
}