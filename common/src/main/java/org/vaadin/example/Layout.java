package org.vaadin.example;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;

public class Layout extends CssLayout {
	public static final String VERTICAL = "layout--vertical";
	public static final String HORIZONTAL = "layout--horizontal";
	public static final String PADDED = "layout--padded";

	public Layout(String... styles) {
		for (int i = 0; i < styles.length; i++) {
			addStyleName(styles[i]);
		}
	}

	public void add(Component c) {
		super.addComponent(c);
	}

	public void space() {
		space(1);
	}

	public void space(int spacers) {
		for (int i = 0; i < spacers; i++) {
			addComponent(new Spacer());
		}
	}

	protected class Spacer extends Label {
		public Spacer() {
			addStyleName("layout__spacer");
		}
	}
}