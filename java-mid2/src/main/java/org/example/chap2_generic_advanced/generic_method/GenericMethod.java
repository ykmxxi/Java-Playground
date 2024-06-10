package org.example.chap2_generic_advanced.generic_method;

public class GenericMethod {

    public static Object objMethod(final Object object) {
        System.out.println("object = " + object);
        return object;
    }

    public static <T> T genericMethod(final T t) {
        System.out.println("t = " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(final T t) {
        System.out.println("t = " + t);
        return t;
    }

}
