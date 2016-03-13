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
public class ColorAttrTest {

	@Test
	public void testColorAttr1() {
		ColorAttr ca = new ColorAttr("red");
		ScreenColor sc = new ScreenColor("transparent");
		assertThat(ca.getName(), is("red"));
		assertThat(ca.getValue(), is("transparent"));
		assertThat(ca.getColor(), is(sc));
	}

	@Test
	public void testColorAttr2() {
		ScreenColor red = new ScreenColor(0xff0000);
		ColorAttr ca = new ColorAttr("red", 0xff0000);
		assertThat(ca.getName(), is("red"));
		assertThat(ca.getValue(), is(0xff0000));
		assertThat(ca.getColor(), is(red));
	}

	@Test
	public void testColorAttr3() {
		ScreenColor red = new ScreenColor(0xff0000);
		ColorAttr ca = new ColorAttr("red", red);
		assertThat(ca.getName(), is("red"));
		assertThat(ca.getValue(), is(((Integer)0xff0000).toString()));
		assertThat(ca.getColor(), is(red));
	}

	@Test
	public void testSetValueObject() {
		ScreenColor red = new ScreenColor(0xff0000);
		ScreenColor yellow = new ScreenColor(0xffff00);
		ColorAttr ca = new ColorAttr("red");
		ca.setValue(0xff0000);
		assertThat(ca.setValue(0xffff00), is(0xff0000));
		assertThat(ca.getColor(), is(yellow));
	}

	@Test
	public void testSetValueScreenColor() {
		ScreenColor red = new ScreenColor(0xff0000);
		ScreenColor yellow = new ScreenColor(0xffff00);
		ColorAttr ca = new ColorAttr("red", red);
		assertThat(ca.setValue(yellow), is(red));
		assertThat(ca.getColor(), is(yellow));
	}


}
