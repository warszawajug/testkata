package info.solidsoft.testkata.mockito;

/**
 * For educational purposes only.
 */
public class SpaceShip {

	private final TacticalStation tacticalStation;
	private final OperationsStation operationsStation;

	public SpaceShip(TacticalStation tacticalStation, OperationsStation operationsStation) {
		this.tacticalStation = tacticalStation;
		this.operationsStation = operationsStation;
	}

	public void generateNPE() {
		operationsStation.returnNull().sendMessageToAll();
	}

	public TacticalStation getTacticalStation() {
		return tacticalStation;
	}

	public OperationsStation getOperationsStation() {
		return operationsStation;
	}
}
