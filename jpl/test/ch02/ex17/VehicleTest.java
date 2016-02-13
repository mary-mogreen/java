/**
 *
 */
package ch02.ex17;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class VehicleTest {


	@Test
	public void testTurnAngle() {
		Vehicle vehicle = new Vehicle("mary");
		vehicle.turn(400.0);
		assertThat(vehicle.getAngle(), is(40.0));
	}

	@Test
	public void testTurnLiteral() {
		Vehicle vehicle = new Vehicle("mogreen");
		vehicle.turn(Vehicle.TURN_LEFT);
		assertThat(vehicle.getAngle(), is(-90.0));
	}

}
