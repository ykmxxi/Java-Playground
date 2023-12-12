package chap4.problem;

public class Book {

    private final String title;
    private final String author;
    private final int page;

    public Book() {
        this("", "", 0);
    }

    public Book(final String title, final String author) {
        this(title, author, 0);
    }

    public Book(final String title, final String author, final int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    public void displayInfo() {
        System.out.println("제목: " + title + ", 저자: " + author + ", 페이지: " + page);
    }

}
