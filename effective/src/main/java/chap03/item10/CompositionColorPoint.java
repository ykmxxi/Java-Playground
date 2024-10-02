package chap03.item10;

import java.awt.Color;
import java.util.Objects;

public class CompositionColorPoint {

    private final Point point;
    private final Color color;

    public CompositionColorPoint(final Point point, final Color color) {
        this.point = point;
        this.color = color;
    }

    public Point asPoint() {
        return point;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof CompositionColorPoint cp)) {
            return false;
        }
        return cp.asPoint().equals(point) && cp.color.equals(color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point, color);
    }

}
