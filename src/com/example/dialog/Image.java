package com.example.dialog;

import com.vaadin.server.ThemeResource;

final class Image extends com.vaadin.ui.Image {
	public Image(ThemeResource source, String style){
		setSource(source);
		addStyleName(style);
	}
}