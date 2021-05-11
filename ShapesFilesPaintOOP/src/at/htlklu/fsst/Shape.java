package at.htlklu.fsst;

public abstract class Shape {

    public static final int DEFAULT_SIZE = 100;

    private static int lastId = 0;
    private int id;

    public Shape() {
        id = lastId;
        lastId++;
    }

    public int getId() {
        return id;
    }

    public abstract double getArea();

    public abstract double getCircumference();

}
