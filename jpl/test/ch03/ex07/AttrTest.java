/**
 *
 */
package ch03.ex07;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class AttrTest {

	@Test
	public void testAttr1() {
		ch03.ex07.Attr attr = new ch03.ex07.Attr("test");
		assertThat(attr.getName(), is("test"));
	}

	@Test
	public void testAttr2() {
		ch03.ex07.Attr attr = new ch03.ex07.Attr("test", 100);
		assertThat(attr.getName(), is("test"));
		assertThat(attr.getValue(), is(100));
	}

	@Test
	public void testSetValue() {
		ch03.ex07.Attr attr = new ch03.ex07.Attr("test");
		attr.setValue("value");
		assertThat(attr.setValue("object"), is("value"));
	}

	@Test
	public void testToString() {
		ch03.ex07.Attr attr = new ch03.ex07.Attr("test", 100);
		assertThat(attr.toString(), is("test" + "='" + 100 + "'"));
	}

}
