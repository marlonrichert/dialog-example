package org.vaadin.example;

import java.util.stream.Stream;

import com.vaadin.ui.themes.ValoTheme;

public final class Button extends com.vaadin.ui.Button {
	public static final String PRIMARY = ValoTheme.BUTTON_PRIMARY;
	public static final String DISABLED = "v-button--disabled";

	public Button(String caption, ClickListener listener, String... styles) {
		super();
		setCaption(caption);
		addClickListener(listener);

		Stream.of(styles).forEach(s -> addStyleName(s));
		if (Stream.of(styles).anyMatch(s -> DISABLED.equals(s))) {
			setEnabled(false);
		};
	}
}