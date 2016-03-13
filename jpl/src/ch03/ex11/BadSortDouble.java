/**
 *
 */
package ch03.ex11;

/**
 * @author mary-mogreen
 *
 */
public class BadSortDouble extends SortDouble {
	public static boolean illegal = false;

	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
		if (!illegal) {
			illegal = true;
			sort(new double[] {0.0});
		}
	}
}
