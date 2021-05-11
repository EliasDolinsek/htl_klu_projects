package at.htlklu.fsst;

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
        return getClass().getSimpleName() + ": id: " + getId() + ", Area: " + getArea() + ", Circumference: " + getCircumference() + ", size [" + getWidth() + "/" + getHeight() + "]";
    }
}
