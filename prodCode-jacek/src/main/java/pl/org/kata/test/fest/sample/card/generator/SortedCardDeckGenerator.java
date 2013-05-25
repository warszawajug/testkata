package pl.org.kata.test.fest.sample.card.generator;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.org.kata.test.fest.sample.card.Card;
import pl.org.kata.test.fest.sample.card.CardDeck;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 24/05/2013
 */
@Service
public class SortedCardDeckGenerator implements CardDeckGenerator {

	private final AllCardsGenerator allCardsGenerator;

	@Autowired
	public SortedCardDeckGenerator(final AllCardsGenerator allCardsGenerator) {
		this.allCardsGenerator = allCardsGenerator;
	}

	@Override
	public CardDeck createDeckOfCards() {
		final List<Card> cards = allCardsGenerator.generateAllCards();

		return new CardDeck(cards);
	}


}
