package at.htlklu.fsst;

import java.awt.Color;

public class Settings {

	private final Class<Shape> type;
	private final Color color;
	private final boolean filled;
	
	public Settings(Class<Shape> type, Color color, boolean filled) {
		this.type = type;
		this.color = color;
		this.filled = filled;
	}

	public Class<Shape> getType() {
		return type;
	}

	public Color getColor() {
		return color;
	}

	public boolean isFilled() {
		return filled;
	}
	
	
}
