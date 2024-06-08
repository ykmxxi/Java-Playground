package org.example.chap1_generic;

public class RawTypeGeneric {

    public static void main(String[] args) {
        GenericBox integerBox = new GenericBox(); // raw type: <>를 사용하지 않음, 내부에서 Object 처럼 동작

        integerBox.setValue(10);

        Integer value = (Integer) integerBox.getValue();
        System.out.println("value = " + value);
    }

}
