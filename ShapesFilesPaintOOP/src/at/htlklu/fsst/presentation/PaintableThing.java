package at.htlklu.fsst.presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public abstract class PaintableThing implements Paintable {

	private Point position;
	private Color color;
	
	public PaintableThing(Point position, Color color) {
		this.position = position;
		this.color = color;
	}
	
	public PaintableThing() {
		this(new Point(0, 0), Color.BLACK);
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
	
}
