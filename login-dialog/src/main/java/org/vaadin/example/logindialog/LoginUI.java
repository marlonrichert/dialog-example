package org.vaadin.example.logindialog;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("login-dialog")
public class LoginUI extends UI {
	@WebServlet(urlPatterns = "/*", asyncSupported = true)
	@VaadinServletConfiguration(ui = LoginUI.class, productionMode = false)
	public static class LoginUIServlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		new Presenter(this);
	}
}
