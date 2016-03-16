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
	private static final BlockStyle BLOCK_STYLE = new BlockStyle("v-text-field");
	
	static final ModifierStyle SECTION_TOP = new ModifierStyle(BLOCK_STYLE, "section-top");
	static final ModifierStyle SECTION_RIGHT = new ModifierStyle(BLOCK_STYLE, "section-right");
	static final ModifierStyle SECTION_BOTTOM = new ModifierStyle(BLOCK_STYLE, "section-bottom");
	static final ModifierStyle SECTION_LEFT = new ModifierStyle(BLOCK_STYLE, "section-left");
	static final ModifierStyle REQUIRED_HIDDEN = new ModifierStyle(BLOCK_STYLE, "required-hidden");

	private com.vaadin.ui.TextField input;
	private Set<TextChangeListener> listeners = new HashSet<>();

	public TextField(String label) {
		setPrimaryStyleName("" + BLOCK_STYLE);

		addComponent(new Image() {
			{
				addStyleName("" + new ElementStyle(BLOCK_STYLE, "icon"));
				setSource(new ThemeResource("star_12x11.png"));
			}
		});
		addComponent(input = new com.vaadin.ui.TextField() {
			{
				addStyleName("" + new ElementStyle(BLOCK_STYLE, "input"));
				setInputPrompt(label);
			}
		});

		input.addTextChangeListener(event -> notifyTextChangeListeners(event));
	}

	public TextField(String label, ModifierStyle... styles) {
		this(label);

		Stream.of(styles).forEach(s -> addStyleName("" + s));
		if (Stream.of(styles).anyMatch(s -> REQUIRED_HIDDEN.equals(s))) {
			input.setRequired(true);
		}
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