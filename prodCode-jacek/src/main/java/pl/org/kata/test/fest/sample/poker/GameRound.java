package pl.org.kata.test.fest.sample.poker;

public enum GameRound {

	FLOP(3), TURN(4), RIVER(5);

	private int howManyCardsOnTable;

	private GameRound(int howManyCardsOnTable){

		this.howManyCardsOnTable = howManyCardsOnTable;
	}

	public int howManyCardsOnTable() {
		return howManyCardsOnTable;
	}
}
