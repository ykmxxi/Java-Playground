package org.example.chap2_generic_advanced.generic_method;

public class Box<T> {

    // static 메서드에 제네릭 메서드 도입 가능
    public static <S> S staticMethod1(final S s) {
        return s;
    }

    // 인스턴스 메서드에 제네릭 메서드 도입 가능
    public <I> I instanceMethod1(final I i) {
        return i;
    }

    // static 메서드에 제네릭 타입 T 사용 불가능
//    public static T staticMethod2(final T t) {
//        return t;
//    }

    // 인스턴스 메서드에 제네릭 타입 T 사용 가능
    public T instanceMethod2(final T t) {
        return t;
    }

}
