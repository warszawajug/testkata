package pl.org.kata.test.fest.sample.card.generator;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.org.kata.test.fest.sample.card.Card;
import pl.org.kata.test.fest.sample.card.CardDeck;

@Service
public class RandomCardDeckGenerator implements CardDeckGenerator{

	private final AllCardsGenerator allCardsGenerator;

	//@Autowired
	public RandomCardDeckGenerator(final AllCardsGenerator allCardsGenerator) {
		this.allCardsGenerator = allCardsGenerator;
	}

	@Override
	public CardDeck createDeckOfCards() {
		final List<Card> cards = allCardsGenerator.generateAllCards();
		Collections.shuffle(cards);
		return new CardDeck(cards);
	}
}
