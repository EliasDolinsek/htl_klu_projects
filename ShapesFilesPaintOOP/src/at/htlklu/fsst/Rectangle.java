package at.htlklu.fsst;

import java.awt.Graphics2D;

public class Rectangle extends Shape {

	private double width, height;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getCircumference() {
		return 2 * width * height;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": id: " + getId() + ", Area: " + getArea() + ", Circumference: "
				+ getCircumference() + ", size [" + getWidth() + "/" + getHeight() + "]";
	}

	@Override
	public void paint(Graphics2D graphics) {
		final int startX = (int) (getPosition().x - getWidth() / 2);
		final int startY = (int) (getPosition().y - getHeight() / 2);

		graphics.setColor(getColor());
		if (isFilled()) {
			graphics.fillRect(startX, startY, (int) getWidth(), (int) getHeight());
		} else {
			graphics.drawRect(startX, startY, (int) getWidth(), (int) getHeight());
		}
	}
}
