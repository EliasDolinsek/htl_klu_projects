package at.htlklu.fsst;

import java.io.Serializable;

import at.htlklu.fsst.presentation.PaintableThing;

public abstract class Shape extends PaintableThing implements Serializable, Comparable<Shape> {

    public static final int DEFAULT_SIZE = 100;

    private static int idCount = 0;
    private int id;

    public Shape() {
        id = idCount;
        idCount++;
    }

    public int getId() {
        return id;
    }

    public abstract double getArea();

    public abstract double getCircumference();
    
    @Override
    public int compareTo(Shape o) {
    	int areaCompareResult = Double.compare(this.getArea(), o.getArea());
    	if(areaCompareResult == 0) {
    		return Double.compare(this.getCircumference(), o.getCircumference());
    	} else {
    		return areaCompareResult;
    	}
    }

}
