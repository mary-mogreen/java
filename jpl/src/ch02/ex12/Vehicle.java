/**
 *
 */
package ch02.ex12;

/**
 * @author mary-mogreen
 * Answer. 現段階のVehicleクラスでは必要性はない。
 * 今後、移動をするメソッドを定義するときに
 * move(double speed, double angle, double second)を
 * move(double movingParams...)として、
 * movingParams[i]で、
 * i % 3 == 0となるものをspeed
 * i % 3 == 1となるものをangle
 * i % 3 == 2となるものをsecondとすることで、
 * 自動運転をさせるためのパラメータを一気に与えることができる。
 * （angleがない場合は、前回までのangle方向にspeed[km/h]進み続ける。
 * second[s]がない場合は、angle方向にspeed[km/h]進み続ける。）
 * と考えましたが、3つの意味をまとめるのは良くないと思います。
 */
public class Vehicle {
	public double speed = 0.0; // 速度(km/h)
	public double angle = 0.0; // 方向(°)
	public String name; // 所有者の名前
	public final long id; // 識別番号

	/**
	 * 初期化
	 */
	public Vehicle() {
		id = nextID++;
	}

	/**
	 * 所有者の名前つき初期化
	 * @param name
	 */
	public Vehicle(String name) {
		this.name = name;
		id = nextID++;
	}

	public static long nextID = 0; // 次の識別番号

	/**
	 * Vehicleの情報を表示する
	 */
	public void printVehicleInfo() {
		System.out.println("===== ID: " + id + " =====");
		System.out.println("Owner: " + name);
		System.out.println("Speed: " + speed + "km/h");
		System.out.println("Angle: " + angle + "°");
	}

	/**
	 * 現在の最大の識別番号を返す
	 * @return 現在の最大の識別番号
	 */
	public static long getCurrentMaxID() {
		return nextID - 1;
	}

	/**
	 * toString
	 */
	public String toString() {
		String desc = "ID: " + id;
		if (name != null)
			desc += "(owner: " + name + ") / ";
		desc += "speed: " + speed + "km/h / ";
		desc += "angle: " + angle + "°";
		return desc;
	}

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		for (int i = 0; i < 3; i++) {
			vehicles[i] = new Vehicle("owner" + i);
			vehicles[i].speed = 100.0 * (i + 1);
			vehicles[i].angle = ((i + 1) * 90.0);
		}

		for (int i = 0; i < 3; i++) {
			vehicles[i].printVehicleInfo();
		}
	}
}
