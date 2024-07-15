package org.example.problem;

public class Card implements Comparable<Card> {

    private final int number;
    private final Suit suit;

    public Card(final int number, final Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    @Override
    public int compareTo(final Card o) {
        // 작은 숫자가 먼저 나온다
        if (this.number != o.number) {
            return this.number - o.number;
        }
        return this.suit.compareTo(o.suit);
    }

    public int getNumber() {
        return number;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return number + "(" + suit.getIcon() + ")";
    }

}
