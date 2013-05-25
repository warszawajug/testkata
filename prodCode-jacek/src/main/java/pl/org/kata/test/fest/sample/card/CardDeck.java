package pl.org.kata.test.fest.sample.card;

import com.google.common.collect.Iterators;
import java.util.Iterator;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 24/05/2013
 */
public class CardDeck {

	private Iterator<Card> currentCardIterator;

	public CardDeck(final Iterable<Card> cardsInOrder){
		currentCardIterator = cardsInOrder.iterator();
	}

	private CardDeck(final Iterator<Card> cardsInOrder){
		currentCardIterator = cardsInOrder;
	}

	public Card getOneFromTheTop(){
		return currentCardIterator.next();
	}

	public boolean areAnyCardsLeft(){
		return currentCardIterator.hasNext();
	}

	public void returnAtTheBottom(Card card) {
		currentCardIterator = Iterators.concat(currentCardIterator, Iterators.singletonIterator(card));
	}
}
