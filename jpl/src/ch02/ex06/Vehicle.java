/**
 *
 */
package ch02.ex06;

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
}
