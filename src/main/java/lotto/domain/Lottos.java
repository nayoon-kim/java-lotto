package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_REWARD_LIMIT = 3;
    private static final int BONUS_BALL_CHECK = 5;

    private static final int MIN_NUM_OF_LOTTO = 1;

    private List<Lotto> lottos;

    public Lottos(int numberOfLotto) {
        this.lottos = createLottos(numberOfLotto);
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> createLottos(int numberOfLotto) {
        return IntStream.range(MIN_NUM_OF_LOTTO, numberOfLotto).boxed().map(lotto -> create()).collect(Collectors.toList());
    }

    private Lotto create() {
        return LottoFactory.create();
    }

    public List<WinningCount> matchesLottos(Lotto winningLotto, LottoNumber bonusBall) {
        return lottos.stream()
                .filter(lotto -> lotto.getMatchingNumberCount(winningLotto) >= LOTTO_REWARD_LIMIT)
                .map(lotto -> WinningCount.of(lotto.getMatchingNumberCount(winningLotto)
                        , checkBonusBall(lotto, bonusBall, lotto.getMatchingNumberCount(winningLotto))))
                .collect(Collectors.toList());
    }

    private boolean checkBonusBall(Lotto lotto, LottoNumber bonusBall, int count) {
        if (count != BONUS_BALL_CHECK) {
            return false;
        }
        return lotto.contains(bonusBall);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    @Override
    public String toString() {
        return lottos.stream().map(String::valueOf).collect(Collectors.joining());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
