/**
 *
 */
package ch14.ex02;

/**
 * @author mary-mogreen
 *
 */
public class PrintJob {
	private final String text;

	public PrintJob(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
