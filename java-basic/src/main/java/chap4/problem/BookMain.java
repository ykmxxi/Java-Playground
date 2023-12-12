package chap4.problem;

public class BookMain {

    public static void main(String[] args) {
        // 1. 기본 생성자 사용
        Book book1 = new Book();
        book1.displayInfo();

        // 2. title, author만 매개변수로 받는 생성자
        Book book2 = new Book("Hello Java", "Seo");
        book2.displayInfo();

        // 3. 모든 필드를 매개변수로 받는 생성자
        Book book3 = new Book("JPA 프로그래밍", "kim", 700);
        book3.displayInfo();
    }

}
