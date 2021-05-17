package at.htlklu.fsst.presentation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface Paintable {

	public void paint(Graphics2D graphics);
	public void setColor(Color color);
	public Color getColor();
	public void setPosition(Point pint);
}
