package pl.org.kata.test.fest.sample.card.generator;

import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.org.kata.test.fest.sample.card.CardDeck;
import pl.org.kata.test.fest.sample.card.CardRank;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 24/05/2013
 */
@Test
public class SortedCardDeckGeneratorTest {

	public static final int TEST_NUMBER_OF_CARDS = CardRank.values().length;

	private SortedCardDeckGenerator objectUnderTest;

	@BeforeMethod
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		objectUnderTest = new SortedCardDeckGenerator(new AllCardsGenerator());
	}

	@Test
	public void shouldCreateDeckOfCards(){
		//given

		//when
		final CardDeck cardDeck = objectUnderTest.createDeckOfCards();

		//then
		/*DeckOfCardsAssertions.assertThat(cardDeck)
				.deckIsNotEmpty()
				.nextCardsAreOrderedInSuit(TEST_NUMBER_OF_CARDS, CardSuit.SPADE)
				.nextCardsAreOrderedInSuit(TEST_NUMBER_OF_CARDS, CardSuit.HEART)
				.nextCardsAreOrderedInSuit(TEST_NUMBER_OF_CARDS, CardSuit.DIAMOND)
				.nextCardsAreOrderedInSuit(TEST_NUMBER_OF_CARDS, CardSuit.CLUB)
				.deckIsEmpty();*/
	}

}
