package pl.org.kata.test.fest.sample.card;

/**
 * @author Jacek Kiljański <jacek.kiljanski@javart.eu>
 * @since 24/05/2013
 */
public class Card {

	private final CardRank cardRank;

	private final CardSuit cardSuit;

	public Card(final CardRank cardRank, final CardSuit cardSuit) {
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}

	public CardRank getCardRank() {
		return cardRank;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}

	@Override
	public String toString() {
		return "Card[" + cardRank + " of " + cardSuit + "S]";
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof Card)) return false;

		final Card card = (Card) o;

		if (cardRank != card.cardRank) return false;
		if (cardSuit != card.cardSuit) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = cardRank != null ? cardRank.hashCode() : 0;
		result = 31 * result + (cardSuit != null ? cardSuit.hashCode() : 0);
		return result;
	}
}
