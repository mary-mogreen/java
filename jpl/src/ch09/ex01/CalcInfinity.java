/**
 *
 */
package ch09.ex01;

/**
 * @author mary-mogreen
 *
 */
public class CalcInfinity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Double x = Double.POSITIVE_INFINITY;
		Double y = Double.POSITIVE_INFINITY;
		Double z = Double.NEGATIVE_INFINITY;
		Double w = Double.NEGATIVE_INFINITY;

		System.out.printf("+∞, +∞%n");
		System.out.printf("【 + 】\t\t【 - 】\t\t【 * 】\t\t【 / 】%n");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", x + y, x - y, x * y, x / y);

		System.out.printf("+∞, -∞%n");
		System.out.printf("【 + 】\t\t【 - 】\t\t【 * 】\t\t【 / 】%n");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", x + z, x - z, x * z, x / z);

		System.out.printf("-∞, +∞%n");
		System.out.printf("【 + 】\t\t【 - 】\t\t【 * 】\t\t【 / 】%n");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", z + x, z - x, z * x, z / x);

		System.out.printf("-∞, -∞%n");
		System.out.printf("【 + 】\t\t【 - 】\t\t【 * 】\t\t【 / 】%n");
		System.out.printf("%2f\t\t%2f\t\t%2f\t\t%2f%n", z + w, z - w, z * w, z / w);



	}

}
