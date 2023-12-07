package chap1.problem;

import java.util.ArrayList;
import java.util.List;

public class MovieReviewMain {

    public static void main(String[] args) {
        MovieReview inception = new MovieReview("인셉션", "인생은 무한 루프");
        MovieReview aboutTime = new MovieReview("어바웃 타임", "인생 시간 영화!");

        inception.printReview();
        aboutTime.printReview();

        List<MovieReview> movieReviews = new ArrayList<>(List.of(inception, aboutTime));
        movieReviews.forEach(MovieReview::printReview);
    }

}
