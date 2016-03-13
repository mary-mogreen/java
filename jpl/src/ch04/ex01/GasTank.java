package ch04.ex01;

public class GasTank extends EnergySource {

	public GasTank() {
		super();
	}

	public GasTank(long capacity) {
		super(capacity);
	}

	@Override
	public boolean empty() {
		if (getEnergy() == 0)
			return true;
		return false;
	}

}
