/**
 *
 */
package ch02.ex05;

/**
 * @author mary-mogreen
 *
 */
public class Vehicle {
	public double speed; // 速度
	public double angle; // 方向
	public String name; // 所有者の名前
	// Answer. finalにすべき。IDは変わらない。
	public long id; // 識別番号

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
			vehicles[i] = new Vehicle();
			vehicles[i].speed = 100.0 * (i + 1);
			vehicles[i].angle = ((i + 1) * 90.0);
			vehicles[i].name = "owner" + i;
			vehicles[i].id = nextID++;
		}

		for (int i = 0; i < 3; i++) {
			vehicles[i].printVehicleInfo();
		}
	}
}
