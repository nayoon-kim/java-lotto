package lotto.model;

import java.util.Arrays;

public enum Prize {
	FIRST(6, 2_000_000_000),
	THIRD(5, 1_500_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000),
	MISS(0, 0);

	private final int countOfMatch;
	private final int winningMoney;

	Prize(int countOfMatch, int winningMoney) {
		this.countOfMatch = countOfMatch;
		this.winningMoney = winningMoney;
	}

	public int getCountOfMatch() {
		return countOfMatch;
	}

	public int getWinningMoney() {
		return winningMoney;
	}

	public static Prize getWinnersStatus(int countOfMatch) {
		return Arrays.stream(Prize.values())
			.filter(r -> r.countOfMatch == countOfMatch)
			.findFirst()
			.orElse(MISS);
	}

}
