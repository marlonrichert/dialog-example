package org.vaadin.example;

import java.util.stream.Stream;

public interface TextChangeListener extends com.vaadin.event.FieldEvents.TextChangeListener {
	public static void bind(TextChangeListener listener, TextField...fields) {
		Stream.of(fields).forEach(f -> f.addTextChangeListener(listener));
	}
}
