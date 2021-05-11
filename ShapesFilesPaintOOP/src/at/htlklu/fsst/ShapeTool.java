package at.htlklu.fsst;

import java.util.ArrayList;
import java.util.List;

public class ShapeTool {

    public static void main(String[] args) {
        generateRandomShapes(100).forEach(System.out::println);
    }

    private static List<Shape> generateRandomShapes(int count) {
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
