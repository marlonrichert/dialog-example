package com.example.dialog;

import static com.example.dialog.Button.DISABLED;
import static com.example.dialog.Button.PRIMARY;
import static com.example.dialog.TextField.REQUIRED_HIDDEN;
import static com.example.dialog.TextField.SECTION_BOTTOM;
import static com.example.dialog.TextField.SECTION_LEFT;
import static com.example.dialog.TextField.SECTION_RIGHT;
import static com.example.dialog.TextField.SECTION_TOP;

import java.util.stream.Stream;

import org.vaadin.viritin.form.AbstractForm;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;

public class PaymentDialog extends Dialog {
	public static final String PAY_CAPTION = "Pay %s";

	private static final String BADGE = "badge";

	private TextField email;
	private TextField cardNumber;
	private TextField mmyy;
	private TextField cvc;
	private Button payControl;
	private CheckBox rememberMe;

	private TextField[] requiredFields;

	public PaymentDialog(ClickListener listener) {
		super();
		setContent(new Layout() {
			{
				add(new Image(new ThemeResource("icon-beta.png"), BADGE));
				add(new Layout(VERTICAL) {
					{
						add(new Header("September golf trip", "Robert Trent Jones Golf Trail"));
						add(new Layout(VERTICAL, PADDED) {
							{
								add(email = new TextField("Email", REQUIRED_HIDDEN));
								space();
								add(new Layout(VERTICAL) {
									{
										add(cardNumber = new TextField("Card number", REQUIRED_HIDDEN, SECTION_BOTTOM));
										add(new Layout(HORIZONTAL) {
											{
												add(mmyy = new TextField("MM / YY", REQUIRED_HIDDEN, SECTION_TOP,
														SECTION_RIGHT));
												add(cvc = new TextField("CVC", REQUIRED_HIDDEN, SECTION_TOP,
														SECTION_LEFT));
											}
										});
									}
								});
								space();
								add(rememberMe = new CheckBox("Remember me"));
								space(2);
								add(payControl = new Button(PAY_CAPTION, listener, DISABLED, PRIMARY));
							}

						});

					}
				});
			}

		});

		setRequiredFields(email, cardNumber, mmyy, cvc);
	}

	private void setRequiredFields(TextField... fields) {
		requiredFields = fields;
		Stream.of(fields).forEach(f -> {
			f.addTextChangeListener(event -> {
				checkRequired(event);
			});
		});
	}

	private void checkRequired(TextChangeEvent event) {
		boolean filledOut = !event.getText().isEmpty();
		boolean othersFilledOut = Stream.of(requiredFields).filter(f -> !f.equals(event.getSource()))
				.allMatch(f -> !f.isEmpty());
		payControl.setEnabled(filledOut && othersFilledOut);
	}

	public void setPayAmount(String dollars) {
		payControl.setCaption(String.format(PAY_CAPTION, dollars));
	}

	public String getEmail() {
		return email.getValue();
	}
}
