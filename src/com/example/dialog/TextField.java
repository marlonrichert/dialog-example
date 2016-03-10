package com.example.dialog;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

public class TextField extends CssLayout {
	static final String TOP = "text-field--top";
	static final String LOWER_LEFT = "text-field--lower-left";
	static final String LOWER_RIGHT = "text-field--lower-right";

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
	
	public TextField(String label, String style) {
		this(label);
		addStyleName(style);
	}
}