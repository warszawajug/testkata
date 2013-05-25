package pl.org.kata.test.fest.sample.card.generator;

import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.org.kata.test.fest.sample.card.Card;
import pl.org.kata.test.fest.sample.card.CardRank;
import pl.org.kata.test.fest.sample.card.CardSuit;

@Service
public class AllCardsGenerator {

	public List<Card> generateAllCards() {
		final List<Card> cards = Lists.newArrayList();
		final List<CardRank> cardRanks = Lists.newArrayList(CardRank.values());

		for(CardSuit cardSuite : CardSuit.values()){
			for(CardRank cardRank : cardRanks) {

				cards.add(new Card(cardRank, cardSuite));
			}
		}
		return cards;
	}

}
