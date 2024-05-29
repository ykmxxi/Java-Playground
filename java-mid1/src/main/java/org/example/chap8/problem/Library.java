package org.example.chap8.problem;

/**
 * 도서 관리 시스템
 * 각 도서는 도서 제목(title), 저자명(author)을 가지고 있음
 * 시스템은 도서를 추가하고, 모든 도서의 정보를 출력하는 기능을 제공
 */
public class Library {

    private static class Book {

        private final String title;
        private final String author;

        public Book(final String title, final String author) {
            this.title = title;
            this.author = author;
        }

    }

    private final Book[] books;
    private int cursor;

    public Library(final int size) {
        this.books = new Book[size];
        this.cursor = 0;
    }

    public void addBook(final String title, final String author) {
        if (cursor < books.length) {
            books[cursor++] = new Book(title, author);
        }
        System.out.println("도서관 저장 공간이 부족합니다");
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println("도서 제목: " + book.title + ", 저자: " + book.author);
        }
    }

}
