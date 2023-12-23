package chap9.problem.item;

public class Album extends Item {

    private final String artist;

    public Album(final String name, final int price, final String artist) {
        super(name, price);
        this.artist = artist;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 아티스트 : " + artist);
    }

}
