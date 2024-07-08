package org.example.chap8_collection_set;

import java.util.Objects;

public class Rectangle {

    private final int width;
    private final int weight;

    public Rectangle(final int width, final int weight) {
        this.width = width;
        this.weight = weight;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) object;
        return width == rectangle.width && weight == rectangle.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, weight);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", weight=" + weight +
                '}';
    }

}
