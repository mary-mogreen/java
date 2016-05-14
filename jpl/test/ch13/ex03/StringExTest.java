/**
 *
 */
package ch13.ex03;

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

	@Test
	public void testCountString() {
		String str = "indexOf(int ch, int start);";
		String sStr = "end";
		assertThat(StringEx.countString(str, sStr), is(0));
	}

	@Test
	public void testCountString2() {
		String str = "indexOf(int ch, int start);";
		String sStr = "in";
		assertThat(StringEx.countString(str, sStr), is(3));
	}

	@Test
	public void testCountString3() {
		String str = "indexOf(int ch, int start);";
		String sStr = "int";
		assertThat(StringEx.countString(str, sStr), is(2));
	}

	@Test
	public void testCountString4() {
		String str = "Baaaaaaaaaaaaaaa!!";
		String sStr = "a";
		assertThat(StringEx.countString(str, sStr), is(15));
	}

	@Test
	public void testCountString5() {
		String str = "Baaaaaaaaaaaaaaa!!";
		String sStr = "aaa";
		assertThat(StringEx.countString(str, sStr), is(13));
	}

	@Test
	public void testDelimitedString() {
		String str = "ccccatttt";
		char start  = 'c';
		char end = 't';
		assertThat(StringEx.delimitedString(str, start, end).length, is(16));
	}

	@Test
	public void testDelimitedString2() {
		String str = "Baaaaaaaaaa!!";
		char start  = 'a';
		char end = 'a';
		assertThat(StringEx.delimitedString(str, start, end).length, is(10));
	}

	@Test
	public void testDelimitedString3() {
		String str = "Baaaaaaaaaa!!";
		char start = 'b';
		char end = '?';
		assertThat(StringEx.delimitedString(str, start, end), is((String[])null));
	}

	@Test
	public void testDelimitedString4() {
		String str = "Baaaaaaaaaa!!";
		char start = 'B';
		char end = '?';
		assertThat(StringEx.delimitedString(str, start, end).length, is(1));
	}

	@Test
	public void testDelimitedString5() {
		String str = "Baaaaaaaaaa!!";
		char start = 'a';
		char end = 'B';
		assertThat(StringEx.delimitedString(str, start, end), is((String[])null));
	}
}
