package pl.org.kata.test.fest.sample.service;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.org.kata.test.fest.sample.card.Card;
import pl.org.kata.test.fest.sample.card.CardDeck;
import pl.org.kata.test.fest.sample.card.CardRank;
import pl.org.kata.test.fest.sample.card.CardSuit;
import pl.org.kata.test.fest.sample.service.ifaces.Game;
import pl.org.kata.test.fest.sample.service.ifaces.WaterProvider;

@Service
public class Croupier {

	private final WaterProvider waterProvider;

	@Autowired
	public Croupier(final WaterProvider waterProvider) {
		this.waterProvider = waterProvider;
	}

	public void putNewCardDeckIntoTheGame(Game game) {
		final CardDeck deckOfCards = createNewCardDeck();
		game.setNewCardDeck(deckOfCards);
	}

	private CardDeck createNewCardDeck(){
		final List<Card> cards = Lists.newArrayList();
		final List<CardRank> cardRanks = Lists.newArrayList(CardRank.values());

		for(CardSuit cardSuite : CardSuit.values()){
			for(CardRank cardRank : cardRanks) {

				cards.add(new Card(cardRank, cardSuite));
			}
		}
		Collections.shuffle(cards);
		return new CardDeck(cards);
	}

	public void drinkWater() {
		waterProvider.provideWater().drinkMe();
	}
}
