/**
 *
 */
package ch03.ex06;

/**
 * @author mary-mogreen
 *
 */
public class Battery extends EnergySource {

	public Battery() {
		super();
	}

	public Battery(long capacity) {
		super(capacity);
	}

	/* (非 Javadoc)
	 * @see ch03.ex06.EnergySource#empty()
	 */
	@Override
	boolean empty() {
		if (getEnergy() == 0)
			return true;
		return false;
	}

}
