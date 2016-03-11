package com.example.dialog;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

public class TextField extends CssLayout {
	static final String SECTION_TOP = "text-field--section-top";
	static final String SECTION_RIGHT = "text-field--section-right";
	static final String SECTION_BOTTOM = "text-field--section-bottom";
	static final String SECTION_LEFT = "text-field--section-left";

	public TextField(String label) {
		addStyleName("text-field");

		addComponent(new Image() {
			{
				addStyleName("text-field__icon");
				setSource(new ThemeResource("star_12x11.png"));
			}
		});
		addComponent(new com.vaadin.ui.TextField() {
			{
				addStyleName("text-field__input");
				setInputPrompt(label);
			}
		});
	}
	
	public TextField(String label, String... styles) {
		this(label);
		for (int i = 0; i < styles.length; i++) {
			addStyleName(styles[i]);
		}
	}
}