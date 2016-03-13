/**
 *
 */
package ch04.ex01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author mary-mogreen
 * 3.4あるとしたらgetterはfinal
 */
public class PassengerVehicle extends Vehicle {
	private int seats;
	private Set<Passenger> passengers = new HashSet<Passenger>();

	/**
	 * デフォルトは座席ひとつ
	 */
	public PassengerVehicle() {
		super();
		this.seats = 1;
	}

	/**
	 * 受け付ける座席数は1以上。
	 * それ以外を受け取ったら座席数1で作成する。
	 * @param seats
	 */
	public PassengerVehicle(int seats) {
		super();
		try {
			setSeats(seats);
		} catch (IllegalArgumentException e) {
			this.seats = 1;
		}
	}

	/**
	 * 座席数1で所有者つきで作成
	 * @param owner
	 */
	public PassengerVehicle(String owner) {
		super(owner);
		this.seats = 1;
	}

	/**
	 * 所有者と座席数を設定。
	 * @param owner
	 * @param seats
	 */
	public PassengerVehicle(String owner, int seats) {
		super(owner);
		try {
			setSeats(seats);
		} catch (IllegalArgumentException e) {
			this.seats = 1;
		}
	}

	/**
	 * 乗り物から人を降ろす。Passengerの名前で検索。
	 * 該当する人物を乗車からはずす。
	 * 該当する人物がいなければnullを返す。
	 * @param name
	 * @return
	 */
	public Passenger getOutPassenger(String name) {
		Iterator<Passenger> ps = passengers.iterator();
        while (ps.hasNext()) {
        	Passenger p = ps.next();
            if (name.equals(p.getName())) {
            	passengers.remove(p);
            	return p;
            }
        }
        return null;
	}

	/**
	 * 座席数を返す
	 * @return
	 */
	public final int getSeats() {
		return this.seats;
	}

	/**
	 * 座席数をセットする。
	 * 1以上で正常。それ以外だと例外を投げる。
	 * @param seats
	 */
	private void setSeats(int seats) {
		if (seats > 0) {
			this.seats = seats;
		} else {
			throw new IllegalArgumentException("座席数はひとつ以上です。座席をひとつ作成します");
		}
	}

	/**
	 * 乗車させる。Passengerを受け取る。
	 * 座席数までしか乗れない。それ以上は定員オーバーの例外を投げる。
	 * @param passenger
	 * @throws CapacityOverException
	 */
	public void takeInPassenger(Passenger passenger) throws CapacityOverException {
		if (passengers.size() < getSeats()) {
			passengers.add(passenger);
		} else {
			throw new CapacityOverException(getSeats() + "人乗りです");
		}

	}

	/**
	 * 現在乗車中の人数を返す。
	 * @return
	 */
	public final int getCurrentPassengers() {
		return passengers.size();
	}

	@Override
	public String toString() {
		String desc = super.toString();
		desc += " / seats: " + seats + " seats / ";
		desc += "Current Passengers: " + getCurrentPassengers() + " persons";
		return desc;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PassengerVehicle pv1 = new PassengerVehicle("Mary", 8);
		PassengerVehicle pv2 = new PassengerVehicle(3);

		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();
		Passenger p3 = new Passenger();
		Passenger p4 = new Passenger();

		try {
			pv1.takeInPassenger(p1);
			pv2.takeInPassenger(p2);
			pv2.takeInPassenger(p3);
			pv2.takeInPassenger(p4);
		} catch (CapacityOverException e) {
			e.printStackTrace();
		}

		System.out.println(pv1);
		System.out.println(pv2);
	}

}
