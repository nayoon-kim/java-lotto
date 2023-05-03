package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoStaticsTest {
    @Test
    @DisplayName("통계 표현")
    void statics() {
        List<Integer> result = Arrays.asList(3, 4, 5, 5, 6);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3, 1);
        expected.put(4, 1);
        expected.put(5, 2);
        expected.put(6, 1);

        LottoStatics statics = new LottoStatics(5000, result, new LottoRewardStartAt3Strategy());

        assertThat(statics.getStatics()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률")
    void rate() {
        List<Integer> result = Arrays.asList(3);
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(3, 1);
        expected.put(4, 0);
        expected.put(5, 0);
        expected.put(6, 0);

        LottoStatics statics = new LottoStatics(14000, result, new LottoRewardStartAt3Strategy());

        assertThat(statics.getRate()).isEqualTo("0.35");
    }

    @Test
    @DisplayName("보상 확인")
    void rewardStrategy() {
        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1, 3000);
        expected.put(3, 5000);

        LottoStatics statics = new LottoStatics(1000, Arrays.asList(3, 4), new LottoRewardStartAt3Strategy() {
            @Override
            public Map<Integer, Integer> getReward() {
                Map<Integer, Integer> reward = new HashMap<>();
                reward.put(1, 3000);
                reward.put(3, 5000);

                return reward;
            }
        });

        assertThat(statics.getReward()).isEqualTo(expected);
    }
}
