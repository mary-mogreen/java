/**
 *
 */
package ch02.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {
	@Test
	public void test() {
		Vehicle vehicle = new Vehicle("mary");
		vehicle.speed = 123.0;
		vehicle.angle = 90.5;
		String expected = "ID: 0(owner: mary) / speed: 123.0km/h / angle: 90.5°";
		assertThat(vehicle.toString(), is(expected));
	}

}
