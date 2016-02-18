/**
 *
 */
package ch01.ex14;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class JackTest {

	@Test
	public void test() {
		Jack jack = new Jack();
		jack.input("test message");
		assertThat(jack.getMessage(), is("test message"));
	}

}
