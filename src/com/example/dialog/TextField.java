package com.example.dialog;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Image;

public class TextField extends CssLayout {
	static final String SECTION_TOP = "text-field--section-top";
	static final String SECTION_RIGHT = "text-field--section-right";
	static final String SECTION_BOTTOM = "text-field--section-bottom";
	static final String SECTION_LEFT = "text-field--section-left";

	static final String REQUIRED_HIDDEN = "text-field--required-hidden";

	private com.vaadin.ui.TextField input;
	private Set<TextChangeListener> listeners = new HashSet<>();

	public TextField(String label) {
		setPrimaryStyleName("text-field");

		addComponent(new Image() {
			{
				addStyleName("text-field__icon");
				setSource(new ThemeResource("star_12x11.png"));
			}
		});
		addComponent(input = new com.vaadin.ui.TextField() {
			{
				addStyleName("text-field__input");
				setInputPrompt(label);
			}
		});

		input.addTextChangeListener(event -> notifyTextChangeListeners(event));
	}

	public TextField(String label, String... styles) {
		this(label);

		Stream.of(styles).forEach(s -> addStyleName(s));
		if (Stream.of(styles).anyMatch(s -> REQUIRED_HIDDEN.equals(s))) {
			input.setRequired(true);
		}
		;
	}

	public String getValue() {
		return input.getValue();
	}

	public boolean isEmpty() {
		return input.isEmpty();
	}

	public void addTextChangeListener(TextChangeListener listener) {
		listeners.add(listener);
	}

	public void removeTextChangeListener(TextChangeListener listener) {
		listeners.remove(listener);
	}

	private void notifyTextChangeListeners(TextChangeEvent event) {
		listeners.stream().forEach(l -> l.textChange(new TextChangeEvent(TextField.this) {

			@Override
			public String getText() {
				return event.getText();
			}

			@Override
			public int getCursorPosition() {
				return event.getCursorPosition();
			}
		}));
	}
}