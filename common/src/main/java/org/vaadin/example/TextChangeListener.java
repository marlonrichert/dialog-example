package org.vaadin.example;

import java.util.stream.Stream;

public interface TextChangeListener extends com.vaadin.event.FieldEvents.TextChangeListener {
	public static void bind(TextChangeListener listener, TextField...fields) {
		Stream.of(fields).forEach(f -> f.addTextChangeListener(listener));
	}

	public static Binder when(TextField... fields) {
		return new Binder(fields);
	}

	public class Binder {
		private TextField[] fields;

		public Binder(TextField... fields) {
			this.fields = fields;
		}

		public void call(TextChangeListener listener) {
			Stream.of(fields).forEach(f -> f.addTextChangeListener(listener));
		}
	}
}
