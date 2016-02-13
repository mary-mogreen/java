/**
 *
 */
package ch02.ex07;

/**
 * @author mary-mogreen
 *
 */
public class Vehicle {
	public double speed; // 速度
	public double angle; // 方向
	public String name; // 所有者の名前
	// Answer. finalにすべき。IDは変わらない。
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

	public void printVehicleInfo() {
		System.out.println("===== ID: " + id + " =====");
		System.out.println("Owner: " + name);
		System.out.println("Speed: " + speed + "km/h");
		System.out.println("Angle: " + angle + "°");
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
