package org.example.oop.composition;

// 상속보다는 조합을 사용
public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto winningLotto, final int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(final Lotto winningLotto, final int bonusNumber) {
        if (winningLotto.has(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public int drawLottoRank(final Lotto lotto) {
        return winningLotto.calculateCountOfMatching(lotto);
    }

}
