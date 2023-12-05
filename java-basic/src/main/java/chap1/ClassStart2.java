package chap1;

public class ClassStart2 {

    public static void main(String[] args) {
        String[] studentNames = {"학생1", "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for (int idx = 0; idx < studentNames.length; idx++) {
            System.out.println("이름: " + studentNames[idx] + " 나이: " + studentAges[idx] + " 성적: " + studentGrades[idx]);
        }
    }

}
