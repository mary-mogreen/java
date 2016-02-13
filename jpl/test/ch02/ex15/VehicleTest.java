/**
 *
 */
package ch02.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {


	@Test
	public void testChangeSpeed() {
		Vehicle vehicle = new Vehicle("mary");
		vehicle.changeSpeed(68.1);
		assertThat(vehicle.getSpeed(), is(68.1));
	}

	@Test
	public void testStop() {
		Vehicle vehicle = new Vehicle("mogreen");
		vehicle.changeSpeed(88.8);
		vehicle.stop();
		assertThat(vehicle.getSpeed(), is(0.0));
	}

}
