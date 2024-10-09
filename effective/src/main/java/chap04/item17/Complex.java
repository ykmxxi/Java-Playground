package chap04.item17;

public class Complex {

    private final double re;
    private final double im;

    public static final Complex ZERO = new Complex(0, 0);
    public static final Complex ONE = new Complex(1, 0);
    public static final Complex I = new Complex(0, 1);

    public Complex(final double re, final double im) {
        this.re = re;
        this.im = im;
    }

    public double realPart() {
        return re;
    }

    public double imaginaryPart() {
        return im;
    }

    public Complex plus(final Complex complex) {
        return new Complex(re + complex.re, im + complex.im);
    }

    // 정적 팩터리(private 생성자와 함께 사용)
    public static Complex valueOf(final double re, final double im) {
        return new Complex(re, im);
    }

    public Complex minus(final Complex complex) {
        return new Complex(re - complex.re, im - complex.im);
    }

    public Complex times(final Complex complex) {
        return new Complex(re * complex.re - im * complex.im,
                re * complex.im + im * complex.re);
    }

    public Complex dividedBy(final Complex complex) {
        double tmp = complex.re * complex.re + complex.im * complex.im;
        return new Complex((re * complex.re + im * complex.im) / tmp,
                (im * complex.re - re * complex.im) / tmp);
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Complex c)) {
            return false;
        }

        return Double.compare(c.re, re) == 0
                && Double.compare(c.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return 31 * Double.hashCode(re) + Double.hashCode(im);
    }

    @Override
    public String toString() {
        return "(" + re + " + " + im + "i)";
    }

}
