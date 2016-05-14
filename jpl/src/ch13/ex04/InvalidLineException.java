/**
 *
 */
package ch13.ex04;

/**
 * @author mary-mogreen
 *
 */
public class InvalidLineException extends Exception {
	String errLine;

	InvalidLineException(String errLine) {
		super("Invalid Line: " + errLine);
		this.errLine = errLine;
	}
}
