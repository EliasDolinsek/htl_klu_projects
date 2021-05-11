package at.htlklu.fsst;

public class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public static Circle getCircleFromArea(double area) {
        return new Circle(Math.sqrt(area / Math.PI));
    }

    public static Circle getCircleFromCircumference(double circumference) {
        return new Circle(circumference / (2 * Math.PI));
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getCircumference() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle: id: " + getId() + ", Area: " + getArea() + ", Circumference: " + getCircumference() + ", radius [" + getRadius() + "]";
    }
}