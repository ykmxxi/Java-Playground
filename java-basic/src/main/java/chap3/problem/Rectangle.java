package chap3.problem;

public class Rectangle {

    private final int width;
    private final int height;

    public Rectangle(final int width, final int height) {
        this.width = width;
        this.height = height;
    }

    public int calculateArea() {
        return width * height;
    }

    public int calculatePerimeter() {
        return 2 * (width + height);
    }

    public boolean isSquare() {
        return width == height;
    }

}
