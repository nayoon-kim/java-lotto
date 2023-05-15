package lotto;

import lotto.domain.*;

import lotto.domain.winning.Rank;
import lotto.domain.winning.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ResultView.printCostOfLotto();
        int cost = InputView.inputCostOfLotto();

        ResultView.printNumberOfManualLotto();
        int numberOfManualLottos = InputView.inputNumberOfManualLottos();

        ResultView.printManualLottosNumber();
        List<String> manualLottosNumber = InputView.inputManualLottos(numberOfManualLottos);

        LottoMachine lottoMachine = new LottoMachine(cost, numberOfManualLottos);
        ResultView.printNumbersOfLotto(lottoMachine.getNumberOfManualLottos(), lottoMachine.getNumberOfAutoLottos());

        Lottos lottos = lottoMachine.generate(manualLottosNumber);

        ResultView.printLottos(lottos);

        ResultView.printWinningNumber();
        String winningNumbers = InputView.inputWinningNumber();

        ResultView.printBonusBall();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);

        LottoStatistics statistics = new LottoStatistics(cost, winningLotto.checkWinningNumbers(lottos));

        ResultView.printStatistics(statistics.getStatistics(), Rank.getWinningCounts());
        ResultView.printLottoRate(statistics.getRate());
    }
}
