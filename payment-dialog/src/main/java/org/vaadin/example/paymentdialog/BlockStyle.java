package org.vaadin.example.paymentdialog;

public class BlockStyle implements Style {
	private String name;

	public BlockStyle(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
