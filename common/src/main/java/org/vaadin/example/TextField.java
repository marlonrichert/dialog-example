package org.vaadin.example;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.CssLayout;

public class TextField extends CssLayout {
	private static final BlockStyle BLOCK_STYLE = new BlockStyle("v-text-field");
	private static final ElementStyle ICON = new ElementStyle(BLOCK_STYLE, "icon");
	private static final ElementStyle INPUT = new ElementStyle(BLOCK_STYLE, "input");

	public static final ModifierStyle SECTION_TOP = new ModifierStyle(BLOCK_STYLE, "section-top");
	public static final ModifierStyle SECTION_RIGHT = new ModifierStyle(BLOCK_STYLE, "section-right");
	public static final ModifierStyle SECTION_BOTTOM = new ModifierStyle(BLOCK_STYLE, "section-bottom");
	public static final ModifierStyle SECTION_LEFT = new ModifierStyle(BLOCK_STYLE, "section-left");
	public static final ModifierStyle REQUIRED_HIDDEN = new ModifierStyle(BLOCK_STYLE, "required-hidden");

	private Set<TextChangeListener> listeners = new HashSet<>();
	private com.vaadin.ui.TextField input;

	public TextField(String label, ModifierStyle... styles) {
		this(label, null, styles);
	}

	public TextField(String label, ThemeResource icon, ModifierStyle... styles) {
		if (icon != null) {
			addComponent(new Image(icon).setElementStyle(ICON));
		}
		addComponent(input = new TextInput(label).setElementStyle(INPUT));

		input.addTextChangeListener(event -> notifyTextChangeListeners(event));

		setBlockStyle(BLOCK_STYLE);
		addModifierStyles(styles);
	}

	protected void setBlockStyle(BlockStyle blockStyle) {
		setPrimaryStyleName("" + blockStyle);
	}

	public void addModifierStyles(ModifierStyle... styles) {
		Stream.of(styles).forEach(s -> addModifierStyle(s));
		if (Stream.of(styles).anyMatch(s -> REQUIRED_HIDDEN.equals(s))) {
			input.setRequired(true);
		}
	}

	public void addModifierStyle(ModifierStyle style) {
		addStyleName("" + style);
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

	private final class TextInput extends com.vaadin.ui.TextField {
		public TextInput(String label) {
			setInputPrompt(label);
		}

		public TextInput setElementStyle(ElementStyle style) {
			addStyleName("" + style);
			return this;
		}
	}
}