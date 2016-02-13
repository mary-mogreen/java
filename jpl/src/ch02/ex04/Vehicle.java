/**
 *
 */
package ch02.ex04;

/**
 * @author mary-mogreen
 * 識別番号をfinalにすべきかどうか。
 */
public class Vehicle {
	public double speed; // 速度
	public double angle; // 方向
	public String name; // 所有者の名前
	// Answer. finalにすべき。IDは変わらない。
	public long id; // 識別番号

	public static long nextID = 0; // 次の識別番号
}
