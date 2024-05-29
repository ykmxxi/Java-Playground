package org.example.chap8.problem;

import org.junit.jupiter.api.Test;

class LibraryTest {

    @Test
    void test() {
        Library library = new Library(4);
        library.addBook("책1", "저자1");
        library.addBook("책2", "저자2");
        library.addBook("책3", "저자3");
        library.addBook("자바 ORM 표준 JPA 프로그래밍", "김영한");
        library.addBook("OneMoreThing", "잡스");
        library.showBooks(); // 도서관의 모든 도서 정보 출력
    }

}
