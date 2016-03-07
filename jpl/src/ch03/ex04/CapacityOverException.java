/**
 *
 */
package ch03.ex04;

/**
 * @author mary-mogreen
 *
 */
public class CapacityOverException extends Exception {
	public CapacityOverException(int seats) {
		super(seats + "人乗りです");
	}
}
