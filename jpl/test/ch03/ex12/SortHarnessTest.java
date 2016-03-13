/**
 *
 */
package ch03.ex12;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import ch03.ex11.SortMetrics;

/**
 * @author mary-mogreen
 *
 */
public class SortHarnessTest {

	static String[] testData = {
			"lemon", "apple", "grape", "banana"
	};

	String[] sortedData = {
			"apple", "banana", "grape", "lemon"
	};
	/**
	 * Stringオブジェクトを辞書的に並び替えるテスト
	 */
	@Test
	public void testDoCompareString() {
		SortHarness sortString = new SortString();
		SortMetrics metrics = sortString.sort(testData);
		for (int i = 0; i < testData.length; i++)
			assertThat(testData[i], is(sortedData[i]));
		System.out.println("Metrics: " + metrics);
	}

}
