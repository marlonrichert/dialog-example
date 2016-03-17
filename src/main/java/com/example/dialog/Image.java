package com.example.dialog;

import java.util.stream.Stream;

import com.vaadin.server.ThemeResource;

public class Image extends com.vaadin.ui.Image {
	public Image(ThemeResource source, String... styles) {
		setSource(source);
		Stream.of(styles).forEach(s -> addStyleName(s));
	}

	public Image setElementStyle(ElementStyle elementStyle) {
		addStyleName("" + elementStyle);
		return this;
	}
}