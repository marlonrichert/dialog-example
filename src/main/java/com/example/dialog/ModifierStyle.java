package com.example.dialog;

public class ModifierStyle implements Style {
	private BlockStyle blockStyle;
	private String name;

	public ModifierStyle(BlockStyle blockStyle, String name) {
		this.blockStyle = blockStyle;
		this.name = name;
	}

	@Override
	public String toString() {
		return "" + blockStyle + "--" + name;
	}
}
