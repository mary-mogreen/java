/**
 *
 */
package ch02.ex13;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {
	@Test
	public void testGetId() {
		Vehicle vehicle = new Vehicle("mary");
		assertThat(vehicle.getId(), is(Vehicle.getCurrentMaxID()));
	}

	@Test
	public void testGetSpeed() {
		Vehicle vehicle = new Vehicle("mary");
		vehicle.setSpeed(123.0);
		assertThat(vehicle.getSpeed(), is(123.0));
	}

	@Test
	public void testGetAngle() {
		Vehicle vehicle = new Vehicle("mary");
		vehicle.setAngle(90.5);
		assertThat(vehicle.getAngle(), is(90.5));
	}

	@Test
	public void testGetName() {
		Vehicle vehicle = new Vehicle("mary");
		assertThat(vehicle.getName(), is("mary"));
	}

}
