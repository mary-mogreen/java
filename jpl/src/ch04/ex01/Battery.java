/**
 *
 */
package ch04.ex01;

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


	@Override
	public boolean empty() {
		if (getEnergy() == 0)
			return true;
		return false;
	}

}
