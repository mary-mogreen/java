/**
 *
 */
package ch02.ex09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {
	static final int MAX = 5;
	@Test
	public void test() {
		Vehicle[] vehicles = new Vehicle[MAX];
		for (int i = 0; i < MAX; i++) {
			vehicles[i] = new Vehicle("owner" + (i + 1));
		}

		assertThat(Vehicle.getCurrentMaxID(), is((long)MAX - 1));
	}

}
