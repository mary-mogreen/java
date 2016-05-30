/**
 *
 */
package ch14.ex02;

/**
 * @author mary-mogreen
 *
 */
public class PrintClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintServer ps = new PrintServer();
		for (int i = 0; i < 10; i++) {
			PrintJob job = new PrintJob("test" + i);
			ps.print(job);
		}
		ps.run();
	}

}
