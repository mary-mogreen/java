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
public class Walkman2Test {

	@Test
	public void testPlug() {
		Walkman2 w2 = new Walkman2();
		Jack j1 = new Jack();
		w2.plug(j1, 0);

		Jack[] jacks = {j1, null};
		boolean[] hasJacks = {true, false};
		assertThat(w2.getJacks(), is(jacks));
		assertThat(w2.hasJacks(), is(hasJacks));
	}

	@Test
	public void testUnplug() {
		Walkman2 w2 = new Walkman2();
		Jack j1 = new Jack();
		w2.plug(j1, 0);
		w2.unplug(0);
		Jack[] jacks = {null, null};
		boolean[] hasJacks = {false, false};

		assertThat(w2.getJacks(), is(jacks));
		assertThat(w2.hasJacks(), is(hasJacks));
	}
}
