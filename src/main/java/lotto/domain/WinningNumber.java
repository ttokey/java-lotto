package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private Integer bonusNumber;

    public WinningNumber(List<Integer> winningNumber) {
        this(winningNumber, 0);
    }

    public WinningNumber(List<Integer> winningNumbers, Integer bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Stream<Integer> stream() {
        return winningNumbers.stream();
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
