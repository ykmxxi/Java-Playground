package chap03.item10;

import java.awt.Color;
import java.util.Objects;

public class ColorPoint extends Point {

    private final Color color;

    public ColorPoint(final int x, final int y, final Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Point)) {
            return false;
        }
        // Point 색상을 무시하고 비교
        if (!(o instanceof ColorPoint)) {
            return o.equals(this);
        }
        // ColorPoint 색상까지 비교
        return super.equals(o) && ((ColorPoint) o).color == this.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }

}
