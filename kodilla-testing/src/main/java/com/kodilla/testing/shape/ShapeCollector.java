package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    public List<Shape> getCollectorCollection() {
        return collectorCollection;
    }

    private final List<Shape> collectorCollection = new ArrayList<>();

    public void addFigure(Shape shape) {
        this.collectorCollection.add(shape);
    }

    public void removeFigure(Shape shape) {
        this.collectorCollection.remove(shape);
    }

    public Shape getFigure(int n) {
        return this.collectorCollection.get(n);
    }

    public String showFigures() {
        String result = "";
        for (Shape shape : this.collectorCollection) {
            result += shape.getShapeName();
        } return result;
    }

}
