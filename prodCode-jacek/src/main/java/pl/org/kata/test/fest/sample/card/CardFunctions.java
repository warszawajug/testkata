package pl.org.kata.test.fest.sample.card;

import com.google.common.base.Function;
import pl.org.kata.test.fest.sample.card.Card;
import pl.org.kata.test.fest.sample.card.CardRank;
import pl.org.kata.test.fest.sample.card.CardSuit;

public interface CardFunctions {

	Function<Card,CardSuit> TO_SUITE_FUNCTION = new Function<Card, CardSuit>() {
		@Override
		public CardSuit apply(final Card input) {
			return input.getCardSuit();
		}
	};

	Function<Card,CardRank> TO_RANK_FUNCTION = new Function<Card, CardRank>() {
		@Override
		public CardRank apply(final Card input) {
			return input.getCardRank();
		}
	};

}
