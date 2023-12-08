package chap2;

public class Method1 {

    public static void main(String[] args) {
//      Student student1 = initStudent(student1, "학생1", 15, 90);
//      Student student2 = initStudent(student2, "학생2", 16, 80);
        Student student1 = createStudent("학생1", 15, 90);
        Student student2 = createStudent("학생2", 16, 80);

        printStudent(student1);
        printStudent(student2);
    }

    static void initStudent(final Student student, final String name, final int age, final int grade) {
        student.name = name;
        student.age = age;
        student.grade = grade;
    }

    static Student createStudent(final String name, final int age, final int grade) {
        Student student = new Student();
        student.name = name;
        student.age = age;
        student.grade = grade;
        return student;
    }

    static void printStudent(final Student student) {
        System.out.println("이름: " + student.name + " 나이: " + student.age + " 성적: " + student.grade);
    }

}
