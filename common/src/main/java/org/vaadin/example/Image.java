package org.vaadin.example;

import java.util.stream.Stream;

import com.vaadin.server.ThemeResource;

public class Image extends com.vaadin.ui.Image {
	public static final String BADGE = "-badge";

	public Image(ThemeResource source, String... styles) {
		setSource(source);
		Stream.of(styles).forEach(s -> addStyleName(s));
	}

	public Image setElementStyle(ElementStyle elementStyle) {
		addStyleName("" + elementStyle);
		return this;
	}
}