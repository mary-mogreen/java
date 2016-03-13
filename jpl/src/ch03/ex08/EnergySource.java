/**
 *
 */
package ch03.ex08;

/**
 * @author mary-mogreen
 *
 */
public abstract class EnergySource {
	private long energy;
	private long capacity;

	public EnergySource() {
		this.capacity = 0;
	}

	public EnergySource(long capacity) {
		this.capacity = capacity;
	}



	public final long getEnergy() {
		return this.energy;
	}
	/**
	 * energyをセットする
	 * @throws CapacityOverException
	 */
	public void setEnergy(long energy) throws CapacityOverException {
		if (energy > capacity) {
			throw new CapacityOverException("最大容量オーバー");
		} else {
			this.energy = energy;
		}
	};

	/**
	 * 空かどうかチェックする
	 */
	abstract boolean empty();
}
