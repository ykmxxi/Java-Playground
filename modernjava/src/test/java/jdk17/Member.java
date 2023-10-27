package jdk17;

public record Member(String name, int age) {

    @Override
    public String toString() {
        return "이름 = " + name + ", 나이 = " + age;
    }

}
