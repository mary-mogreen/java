/**
 *
 */
package ch09.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class BitCountTest {

	/**
	 * {@link ch09.ex02.BitCount#bitCount(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testBitCount() {
		assertThat(BitCount.bitCount(0), is(0));
		assertThat(BitCount.bitCount(10), is(2));
		assertThat(BitCount.bitCount(255), is(7));
	}

}
