package org.vaadin.example.paymentdialog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;

@SuppressWarnings("serial")
@Theme("dialog-example")
public class UI extends com.vaadin.ui.UI {
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = UI.class, widgetset = "com.example.dialog.widgetset.Dialog_exampleWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		new Presenter(this);
	}
}