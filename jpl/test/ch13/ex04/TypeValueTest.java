/**
 *
 */
package ch13.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class TypeValueTest {

	String test = "Boolean true\n"
			+ "Character a\n"
			+ "Integer 123\n"
			+ "Double 10.0\n"
			+ "Float 0.5f\n"
			+ "Short 20\n"
			+ "Long 56\n"
			+ "Byte 2\n";

	List<Object> expectedList = new ArrayList();
	{
		expectedList.add(Boolean.valueOf(true));
		expectedList.add(Character.valueOf('a'));
		expectedList.add(Integer.valueOf(123));
		expectedList.add(Double.valueOf(10.0));
		expectedList.add(Float.valueOf(0.5f));
		expectedList.add(Short.valueOf("20"));
		expectedList.add(Long.valueOf(56));
		expectedList.add(Byte.valueOf("2"));
	}

	String bad = "Boolean true\n"
			+ "Character a\n"
			+ "Integer 123\n"
			+ "Double 10.0\n"
			+ "Float 0.5f\n"
			+ "Short 20\n"
			+ "Longo 56\n"
			+ "Byte 2\n";

	String nullTest = "Boolean null\n"
			+ "Character null\n"
			+ "Integer null\n"
			+ "Double null\n"
			+ "Float null\n"
			+ "Short null\n"
			+ "Longo null\n"
			+ "Byte null\n";

	@Test
	public void testReadTypeValueLine() throws InvalidLineException {
		Iterator<Object> i = expectedList.iterator();
		List<Object> result = TypeValue.readTypeValueLine(test);
		for (Object r: result) {
			assertThat(r, is(i.next()));
		}
		assertThat(result.equals(expectedList), is(true));
	}

	@Test(expected=InvalidLineException.class)
	public void testReadTypeValueLineBad() throws InvalidLineException {
		List<Object> result = TypeValue.readTypeValueLine(bad);
	}

	@Test(expected=NullPointerException.class)
	public void testReadTypeValueLineNull() throws InvalidLineException {
		List<Object> result = TypeValue.readTypeValueLine(null);
	}
	@Test(expected=NumberFormatException.class)
	public void testReadTypeValueLineNullData() throws InvalidLineException {
		List<Object> result = TypeValue.readTypeValueLine(nullTest);
	}
}
