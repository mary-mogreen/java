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
public class TapeTest {

	@Test
	public void test() {
		Tape tape = new Tape("test tape");
		assertThat(tape.getSongs(), is("test tape"));
		tape.setSongs("test tape tape");
		assertThat(tape.getSongs(), is("test tape tape"));
	}

}
