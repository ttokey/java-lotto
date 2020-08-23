package domain;

import strategy.PassivityLottoNumberGenerator;
import strategy.RandomLottoNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int autoCount, int passivityCount, List<String> passivityLottos) {
        return new Lottos(issueLottos(autoCount, passivityCount, passivityLottos));
    }

    private static List<Lotto> issueLottos(int autoCount, int passivityCount, List<String> passivityLottos) {
        return IntStream.range(0, autoCount + passivityCount)
                .mapToObj(i -> i < passivityCount
                        ? Lotto.of(passivityLottos.get(i), new PassivityLottoNumberGenerator())
                        : Lotto.of(new RandomLottoNumberGenerator()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public LottoResults getLottoResult(WinningLotto winningLotto) {
        LottoResults result = LottoResults.of();

        for (Lotto lotto : lottos) {
            result.win(winningLotto.getRank(lotto));
        }

        return result;
    }
}