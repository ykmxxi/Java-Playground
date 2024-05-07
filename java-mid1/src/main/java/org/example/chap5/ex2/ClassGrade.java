package org.example.chap5.ex2;

/**
 * 직접 구현한 타입 안전 열거형 패턴(Type-Safe Enum Pattern)
 */
public class ClassGrade {

    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    private ClassGrade() {}

}
