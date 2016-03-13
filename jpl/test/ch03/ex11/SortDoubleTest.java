/**
 *
 */
package ch03.ex11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class SortDoubleTest {

	static double[] testData = {
			0.3, 1.3e-2, 7.9, 3.17
		};
	static double[] testData2 = {
			0.3, 1.3e-2, 7.9, 3.17
		};

	@Test
	public void testDoSortSecurityHall() {
		System.out.println("SortDouble.");
		SortDouble bsort = new BadSortDouble();
		SortMetrics metrics = bsort.sort(testData);
		assertThat(metrics.toString(), is(not("0 probes 6 compares 2 swaps")));
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++)
			System.out.println("\t" + testData[i]);
	}

	@Test
	public void testDoSortSecure() {
		System.out.println("SecureSortDouble.");
		SecureSortDouble bsort = new BadSortDouble2();
		SortMetrics metrics = bsort.sort(testData2);
		assertThat(metrics.toString(), is("0 probes 6 compares 2 swaps"));
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData2.length; i++)
			System.out.println("\t" + testData2[i]);

	}
}
