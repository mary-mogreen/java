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
public class WalkmanTest {

	@Test
	public void testPlug() {
		Walkman w = new Walkman();
		Jack jack = new Jack();
		w.plug(jack);
		assertThat(w.getJack(), is(jack));
		assertThat(w.hasJack(), is(true));
	}

	@Test
	public void testUnplug() {
		Walkman w = new Walkman();
		Jack jack = new Jack();
		w.plug(jack);
		w.unplug();
		assertThat(w.getJack(), is((Jack)null));
		assertThat(w.hasJack(), is(false));
	}

}
