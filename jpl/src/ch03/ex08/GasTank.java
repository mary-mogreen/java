package ch03.ex08;

public class GasTank extends EnergySource {

	public GasTank() {
		super();
	}

	public GasTank(long capacity) {
		super(capacity);
	}

	@Override
	boolean empty() {
		if (getEnergy() == 0)
			return true;
		return false;
	}

}
