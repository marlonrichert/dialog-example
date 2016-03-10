package com.example.dialog;

import com.vaadin.ui.themes.ValoTheme;

final class Button extends com.vaadin.ui.Button {
	protected static final String PRIMARY = ValoTheme.BUTTON_PRIMARY;

	Button(String caption, String style) {
		super(caption);
		addStyleName(style);
	}
}