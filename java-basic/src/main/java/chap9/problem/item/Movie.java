package chap9.problem.item;

public class Movie extends Item {

    private final String director;
    private final String actor;

    public Movie(final String name, final int price, final String director, final String actor) {
        super(name, price);
        this.director = director;
        this.actor = actor;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("감독 : " + director + ", 배우 : " + actor);
    }

}
