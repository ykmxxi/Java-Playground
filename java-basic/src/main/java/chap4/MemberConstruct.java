package chap4;

public class MemberConstruct {

    String name;
    int age;
    int grade;

    public MemberConstruct(final String name, final int age) {
        this(name, age, 50); // this()는 첫 줄에 작성해야 한다
        System.out.println("생성자 호출");
    }

    public MemberConstruct(final String name, final int age, final int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

}
