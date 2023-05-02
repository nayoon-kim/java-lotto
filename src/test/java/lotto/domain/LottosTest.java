package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    @DisplayName("로또 생성")
    void create() {
        Lottos lottos = new Lottos(14, new LottoCreatingRandomStrategy(){
            @Override
            public Lotto create() {
                return new Lotto("1, 2, 3, 4, 5, 6");
            }
        });

        assertThat(lottos).isEqualTo(14);
    }
}
