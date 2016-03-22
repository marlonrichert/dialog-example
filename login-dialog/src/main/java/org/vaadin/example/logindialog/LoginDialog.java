package org.vaadin.example.logindialog;

import static org.vaadin.example.Button.PRIMARY;
import static org.vaadin.example.Layout.VERTICAL;
import static org.vaadin.example.TextField.PASSWORD;

import java.util.regex.Pattern;

import org.vaadin.example.Button;
import org.vaadin.example.Dialog;
import org.vaadin.example.Header;
import org.vaadin.example.Layout;
import org.vaadin.example.TextField;

import com.vaadin.ui.Button.ClickListener;

public class LoginDialog extends Dialog {
	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	private TextField email;
	private TextField password;
	private Button submit;

	public LoginDialog(ClickListener listener) {
		super();
		setClosable(false);

		setContent(new Layout(VERTICAL) {
			{
				add(new Header("Log in"));
				add(new Layout(VERTICAL, PADDED) {
					{
						add(email = new TextField("Email"));
						space();
						add(password = new TextField("Password", PASSWORD, TextField.HIDDEN));
						space();
						add(submit = new Button("Submit", listener, PRIMARY, Button.HIDDEN));
					}
				});
			}
		});

		email.setId("email");

//		password.setVisible(false);
		email.addTextChangeListener(event -> {
			if (validEmailAddress(event.getText())) {
				password.removeModifierStyle(TextField.HIDDEN);
			} else {
				password.addModifierStyle(TextField.HIDDEN);
			}
		});
		
//		submit.setVisible(false);
		password.addTextChangeListener(event -> {
			if(!event.getText().isEmpty()) {
				submit.removeModifierStyle(Button.HIDDEN);
			} else {
				submit.addModifierStyle(Button.HIDDEN);
			}
		});
	}

	private boolean validEmailAddress(String text) {
		return VALID_EMAIL_ADDRESS_REGEX.matcher(text).find();
	}
}
