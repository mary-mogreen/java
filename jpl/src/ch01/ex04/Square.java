/**
 *
 */
package ch01.ex04;

/**
 * @author yuuya katoh
 *
 */
public class Square {

	/**
	 * nが20までの平方を表示する
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("nが20までの平方を表示する");
		for (int n = 1; n <= 20; n++) {
			System.out.println("n=" + n + " " + n * n);
		}
	}

}
