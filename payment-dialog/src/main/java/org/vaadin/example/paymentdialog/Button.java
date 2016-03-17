package org.vaadin.example.paymentdialog;

import java.util.stream.Stream;

import com.vaadin.ui.themes.ValoTheme;

final class Button extends com.vaadin.ui.Button {
	protected static final String PRIMARY = ValoTheme.BUTTON_PRIMARY;
	protected static final String DISABLED = "v-button--disabled";

	Button(String caption, ClickListener listener, String... styles) {
		super();
		setCaption(caption);
		addClickListener(listener);

		Stream.of(styles).forEach(s -> addStyleName(s));
		if (Stream.of(styles).anyMatch(s -> DISABLED.equals(s))) {
			setEnabled(false);
		};
	}
}