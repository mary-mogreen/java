/**
 *
 */
package ch03.ex09;

import ch03.ex08.CapacityOverException;
import ch03.ex08.PassengerVehicle;
import ch03.ex08.Vehicle;

/**
 * @author mary-mogreen
 *
 */
public class Garage implements Cloneable{
	private Vehicle[] vehicles;

	/**
	 * 保管できる乗り物の台数を必ず設定する
	 * @param capacity
	 */
	public Garage(int capacity) {
		vehicles = new Vehicle[capacity];
	}

	public int getCapacity() {
		return vehicles.length;
	}

	/**
	 * 空きスペースの数
	 * @return
	 */
	public int getEmptySpaces() {
		int emptySpaces = 0;
		for (Vehicle v : vehicles) {
			if (v == null)
				emptySpaces++;
		}
		return emptySpaces;
	}

	/**
	 * 空いているスペースに乗り物を入庫させる。
	 * 空きがなければ、ガレージのキャパオーバー例外。
	 * @param vehicle
	 * @throws CapacityOverException
	 */
	public void setVehicle(Vehicle vehicle) throws CapacityOverException {
		if (getEmptySpaces() == 0)
			throw new CapacityOverException("空きがありません");
		else {
			for (int i = 0; i < getEmptySpaces(); i++) {
				if (vehicles[i] == null) {
					vehicles[i] = vehicle;
					System.out.println("No." + i + "に入庫しました。");
					break;
				}
			}
		}
	}

	@Override
	public String toString() {
		String dest = "There are " + getCapacity() + "spaces in the garage.\n";
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] == null) {
				dest += "No." + i + ": empty.\n";
			} else {
				dest += "No." + i + ": " + vehicles[i].getOwner() + "'s vehicle.";
			}
		}
		return dest;
	}

	/**
	 * ガレージにVehicleが入っている場合はガレージの複製が不可としてnullを返す。
	 */
	public Garage clone() {
		if (getEmptySpaces() == 0) {
			return null;
		} else {
			try {
				return (Garage) super.clone();
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.toString());
			}
		}
	}

	public static void main(String[] args) {
		Garage g = new Garage(1);
		Vehicle v1 = new Vehicle("Test1");
		PassengerVehicle v2 = new PassengerVehicle("Test2", 2);

		System.out.println("空きは1のはず。結果 => " + g);

		Garage copy1 = g.clone();

		System.out.println("Vehicleが入っていないはずなので、複製ができるはず。結果 => " + copy1);


		try {
			g.setVehicle(v1);
		} catch (CapacityOverException e) {
			System.out.println("空きがあるはずなので、ここにはこない。");
		}

		System.out.println("空きは0のはず。Test1さんが入っている。結果 => " + g);

		Garage copy2 = g.clone();

		if (copy2 == null)
			System.out.println("Vehicleが入っているので複製不可で、これが表示される。");

		try {
			g.setVehicle(v2);
		} catch (CapacityOverException e) {
			System.out.println("空きがないはずなので、ここにこないとダメ。");
		}
	}



}
