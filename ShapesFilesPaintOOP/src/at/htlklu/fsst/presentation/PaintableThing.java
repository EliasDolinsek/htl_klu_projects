package at.htlklu.fsst.presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class PaintableThing implements Paintable {

	private Point position;
	private Color color;
	private boolean isFilled;
	
	public PaintableThing(Point position, Color color, boolean isFilled) {
		this.position = position;
		this.color = color;
		this.isFilled = isFilled;
	}
	
	public PaintableThing() {
		this(new Point(0, 0), Color.BLACK, false);
	}


	public Point getPosition() {
		return position;
	}

	@Override
	public void setPosition(Point position) {
		this.position = position;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
	@Override
	public void setFilled(boolean filled) {
		this.isFilled = filled;
	}
	
	@Override
	public boolean isFilled() {
		return isFilled;
	}
	
}
