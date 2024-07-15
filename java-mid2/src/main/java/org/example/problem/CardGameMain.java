package org.example.problem;

public class CardGameMain {

    public static void main(String[] args) {
        Deck deck = new Deck();
        Player playerA = new Player("playerA");
        Player playerB = new Player("playerB");

        for (int i = 0; i < 5; i++) {
            playerA.drawCard(deck);
            playerB.drawCard(deck);
        }

        playerA.showHand();
        playerB.showHand();

        Player winner = getWinner(playerA, playerB);
        if (winner != null) {
            System.out.println(winner.getName() + " 승리");
        } else {
            System.out.println("무승부");
        }
    }

    private static Player getWinner(final Player playerA, final Player playerB) {
        if (playerA.rankSum() > playerB.rankSum()) {
            return playerA;
        }
        if (playerA.rankSum() < playerB.rankSum()) {
            return playerB;
        }
        return null;
    }

}
