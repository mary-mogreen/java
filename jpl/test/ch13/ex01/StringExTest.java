/**
 *
 */
package ch13.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class StringExTest {

	/**
	 * {@link ch13.ex01.StringEx#countCharctor(java.lang.String, char)} のためのテスト・メソッド。
	 */
	@Test
	public void testCountCharactor() {
		String str = "abcdefg";
		char ch = 'h';
		assertThat(StringEx.countCharactor(str, ch), is(0));
	}

	@Test
	public void testCountCharactor2() {
		String str = "abcdefg";
		char ch = 'c';
		assertThat(StringEx.countCharactor(str, ch), is(1));
	}

	@Test
	public void testCountCharactor3() {
		String str = "accdcfcg";
		char ch = 'c';
		assertThat(StringEx.countCharactor(str, ch), is(4));
	}

	@Test
	public void testCountCharactor4() {
		String str = "cccccccc";
		char ch = 'c';
		assertThat(StringEx.countCharactor(str, ch), is(8));
	}

}
