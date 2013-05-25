package pl.org.kata.test.fest.sample.poker;

import static org.fest.assertions.Assertions.assertThat;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.org.kata.test.fest.assertions.assertions.enums.DataProviderValueAssertions;

public class GameRoundTest {

	@Test(dataProvider = "getRoundsWithNumberOfCards")
	public void shouldGetNumberOfCardsOnTheTable(GameRound gameRound, int expectedNumberOfCards) {
		//given

		//when
		final int numberOfCards = gameRound.howManyCardsOnTable();

		//then
		assertThat(numberOfCards).isEqualTo(expectedNumberOfCards);
	}

	@DataProvider
	public Object[][] getRoundsWithNumberOfCards() {
		return new Object[][]{
				new Object[]{GameRound.FLOP, 3},
				new Object[]{GameRound.TURN, 4},
				new Object[]{GameRound.RIVER, 5}
		};
	}

	@Test
	public void shouldDataProviderUsedAllEnums() {
		DataProviderValueAssertions.assertThatValuesWithId(getRoundsWithNumberOfCards(), 0).allEnumsAreUsed(GameRound.class);
	}

}
