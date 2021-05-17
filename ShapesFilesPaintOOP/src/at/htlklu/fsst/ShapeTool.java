package at.htlklu.fsst;

import java.awt.Color;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShapeTool {

	public static void main(String[] args) {
		List<Shape> shapes = generateRandomShapes(100);
		writeShapesToFile(shapes, "sorted_shapes.txt");
		readSettings("settings.txt");
	}

	public static void setPositionAndColors(List<Settings> settings, List<Shape> shape, int maxX, int maxY) {
		shape.forEach(e -> {
			final int x = (int) (Math.random() * maxX);
			final int y = (int) (Math.random() * maxY);

			e.setPosition(new Point(x, y));
			settings.stream().filter((t) -> t.getClass().getSimpleName().equals(e.getClass().getSimpleName()))
					.forEach(s -> {
						e.setColor(s.getColor());
						e.setFilled(s.isFilled());
					});
			
			if (e instanceof Circle) {
				e.setColor(Color.BLUE);
			} else if (e instanceof Square) {
				e.setColor(Color.GREEN);
			} else if (e instanceof Rectangle) {
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

	public static List<Settings> readSettings(String filename) {
		List<Settings> settings = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename));) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split(" ");

				@SuppressWarnings("unchecked")
				Class<Shape> type = (Class<Shape>) Class.forName(data[0]);

				Color color = getColorFromString(data[1]);
				
				boolean filled = data.length == 3 && data[2].equals("filled");

				settings.add(new Settings(type, color, filled));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return settings;
	}

	private static Color getColorFromString(String value) {
		switch (value) {
		case "blue":
			return Color.BLUE;
		case "red":
			return Color.RED;
		case "green":
			return Color.GREEN;
		default:
			return null;
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
