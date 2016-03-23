package org.vaadin.example;

import java.util.stream.Stream;

public interface ValueChangeListener extends com.vaadin.data.Property.ValueChangeListener {
	public static void bind(ValueChangeListener listener, TextField...fields) {
		Stream.of(fields).forEach(f -> f.addValueChangeListener(listener));
	}

	public static Binder when(TextField... fields) {
		return new Binder(fields);
	}

	public class Binder {
		private TextField[] fields;

		public Binder(TextField... fields) {
			this.fields = fields;
		}

		public void call(ValueChangeListener listener) {
			Stream.of(fields).forEach(f -> f.addValueChangeListener(listener));
		}
	}
}
