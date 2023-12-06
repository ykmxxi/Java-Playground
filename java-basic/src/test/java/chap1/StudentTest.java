package chap1;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StudentTest {

    @DisplayName("자바의 대입 연산자(=)는 항상 변수의 값을 복사한다.")
    @Test
    void 대입_연산자_테스트() {
        Student student = new Student("학생1", 15, 90);
        Student[] students = new Student[1];
        students[0] = student; // student 참조값 복사

        assertThat(student.age).isEqualTo(15);
        assertThat(students[0].age).isEqualTo(15);

        students[0].age = 20; // 메모리에 접근해 값을 변경하기 때문에 원본에도 영향을 준다

        assertThat(student.age).isEqualTo(20);
        assertThat(students[0].age).isEqualTo(20);
    }

}
