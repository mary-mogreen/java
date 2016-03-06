/**
 *
 */
package ch03.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class XTest {

	@Test
	public void testMask() {
		X x = new X();
		assertThat(x.mask(0x0ff0), is(0x00ff & 0x0ff0));

	}

}
