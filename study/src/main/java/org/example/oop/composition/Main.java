package org.example.oop.composition;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        System.out.println(winningLotto.drawLottoRank(lotto));
    }

}
