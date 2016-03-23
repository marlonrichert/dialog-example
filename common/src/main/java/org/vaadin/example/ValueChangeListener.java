package org.vaadin.example;

import java.util.stream.Stream;

public interface ValueChangeListener extends com.vaadin.data.Property.ValueChangeListener {
	public static void bind(ValueChangeListener listener, TextField...fields) {
		Stream.of(fields).forEach(f -> f.addValueChangeListener(listener));
	}
}
