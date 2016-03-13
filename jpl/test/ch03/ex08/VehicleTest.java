/**
 * 
 */
package ch03.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {

	@Test
	public void testClone() {
		Vehicle v = new Vehicle("Test");
		Vehicle copy = v.clone();
		
		assertThat(v.isCloned(), is(false));
		assertThat(copy.isCloned(), is(true));
	}

}
