package chap1.problem;

public class MovieReview {

    private final String title;
    private final String review;

    public MovieReview(final String title, final String review) {
        this.title = title;
        this.review = review;
    }

    public void printReview() {
        System.out.println(
                String.join(", ", createReviewDetail("영화 제목", title), createReviewDetail("리뷰", review)));
    }

    private String createReviewDetail(final String description, final String detail) {
        return String.join(": ", description, detail);
    }

}
