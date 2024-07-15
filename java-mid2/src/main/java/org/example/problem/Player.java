package org.example.problem;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final List<Card> hand;

    public Player(final String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(final Deck deck) {
            hand.add(deck.drawCard());

    }

    public int rankSum() {
        return hand.stream()
                .mapToInt(Card::getNumber)
                .sum();
    }

    public void showHand() {
        hand.sort(null);
        System.out.println(name + "의 카드: " + hand + ", 합계: " + rankSum());
    }

    public String getName() {
        return name;
    }

}
