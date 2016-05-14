/**
 *
 */
package ch13.ex05;

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

	@Test
	public void testInsertDelimiter() {
		String str = "123456789";
		assertThat(StringEx.insertDelimiter(str), is("123,456,789"));
	}

	@Test
	public void testInsertDelimiter2() {
		String str = "1234567";
		assertThat(StringEx.insertDelimiter(str), is("1,234,567"));
	}

	@Test
	public void testInsertDelimiter3() {
		String str = "123";
		assertThat(StringEx.insertDelimiter(str), is("123"));
	}

	@Test
	public void testInsertDelimiter4() {
		String str = "+159876123";
		assertThat(StringEx.insertDelimiter(str), is("+159,876,123"));
	}

	@Test
	public void testInsertDelimiter5() {
		String str = "-4159876123";
		assertThat(StringEx.insertDelimiter(str), is("-4,159,876,123"));
	}

	@Test
	public void testInsertDelimiter6() {
		String str = "A4159876123";
		assertThat(StringEx.insertDelimiter(str), is("A4,159,876,123"));
	}

	@Test
	public void testInsertDelimiter7() {
		String str = "ewfogjwp3584958923vribeoirh934eo39u0eb09-08980sg4029gjb;e34390u90hu30hbo340";
		assertThat(StringEx.insertDelimiter(str), is("ewfogjwp3,584,958,923vribeoirh934eo39u0eb09-08,980sg4,029gjb;e34,390u90hu30hbo340"));
	}
}
