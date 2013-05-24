package info.solidsoft.testkata.mockito;

/**
 * For educational purposes only.
 */
public class ShipSearchCriteria {

	private final int minimumRange;
	private final int numberOfPhasers;

	public ShipSearchCriteria(int minimumRange, int numberOfPhasers) {
		this.minimumRange = minimumRange;
		this.numberOfPhasers = numberOfPhasers;
	}

	public int getMinimumRange() {
		return minimumRange;
	}

	public int getNumberOfPhasers() {
		return numberOfPhasers;
	}
}
