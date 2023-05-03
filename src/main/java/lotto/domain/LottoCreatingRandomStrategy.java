package lotto.domain;

import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Lotto.MAX_LOTTO_NUMBER;
import static lotto.domain.Lotto.LOTTO_NUMBER;

public class LottoCreatingRandomStrategy implements LottoCreatingStrategy {
    private static final int ZERO = 0;
    @Override
    public Lotto create() {
        List<Integer> numbers = IntStream.range(ZERO, MAX_LOTTO_NUMBER).boxed().collect(Collectors.toList());

        Collections.shuffle(numbers);

        return new Lotto(numbers.subList(ZERO, LOTTO_NUMBER));
    }
}
