package at.htlklu.fsst;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShapeTool {

	public static void main(String[] args) {
		List<Shape> shapes = generateRandomShapes(100);
		writeShapesToFile(shapes, "sorted_shapes.txt");
	}
	
	public static void setPositionAndColors(List<Shape> shape, int maxX, int maxY) {
		shape.forEach(e -> {
			final int x = (int) (Math.random() * maxX);
			final int y = (int) (Math.random() * maxY);
			
			e.setPosition(new Point(x, y));
			if(e instanceof Circle) {
				e.setColor(Color.BLUE);
			} else if(e instanceof Square) {
				e.setColor(Color.GREEN);
			} else if(e instanceof Rectangle) {
				e.setColor(Color.RED);
			}
		});
	}

	private static void writeShapesToFile(List<Shape> shapes, String filename) {
		Collections.sort(shapes);

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (Shape shape : shapes) {
				writer.write(shape.toString() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Shape> generateRandomShapes(int count) {
		ArrayList<Shape> shapes = new ArrayList<>();
		int oneThird = count / 3;

		for (int i = 0; i < oneThird; i++) {
			shapes.add(new Rectangle(Math.random() * Shape.DEFAULT_SIZE, Math.random() * Shape.DEFAULT_SIZE));
		}

		for (int i = oneThird; i < oneThird * 2; i++) {
			shapes.add(new Square(Math.random() * Shape.DEFAULT_SIZE));
		}

		for (int i = oneThird * 2; i < count; i++) {
			shapes.add(new Circle(Math.random() * Shape.DEFAULT_SIZE));
		}

		return shapes;
	}
}
