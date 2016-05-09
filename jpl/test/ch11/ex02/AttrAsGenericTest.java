/**
 * 
 */
package ch11.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class AttrAsGenericTest {

	@Test
	public void testAttrAsGeneric() {
		AttrAsGeneric<String> attrString = new AttrAsGeneric<String>("testName");
		assertThat(attrString.getName(), is("testName"));
		assertThat(attrString.getValue(), is((String)null));
	}
	
	@Test
	public void testAttrAsGeneric2() {
		AttrAsGeneric<Float> attrFloat = new AttrAsGeneric<Float>("testName", Float.valueOf(123.4f));
		assertThat(attrFloat.getName(), is("testName"));
		assertThat(attrFloat.getValue(), is(123.4f));
	}
	
	@Test
	public void testSetValue() {
		AttrAsGeneric<Integer> attrInteger = new AttrAsGeneric<Integer>("testName", Integer.valueOf("5"));
		assertThat(attrInteger.setValue(Integer.valueOf(10)), is(5));
		assertThat(attrInteger.getValue(), is(10));
	}

}
