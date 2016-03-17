package org.vaadin.example.paymentdialog;

public class ElementStyle implements Style {
	private BlockStyle blockStyle;
	private String name;

	public ElementStyle(BlockStyle blockStyle, String name) {
		this.blockStyle = blockStyle;
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + blockStyle + "__" + name;
	}
}
