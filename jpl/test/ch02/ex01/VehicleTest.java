/**
 *
 */
package ch02.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author p000526463
 *
 */
public class VehicleTest {

	@Test
	public void test() {
		Vehicle vehicle = new Vehicle();
		vehicle.speed = 100;
		vehicle.angle = 60;
		vehicle.name = "mogreen";

		assertThat(vehicle.speed, is(100));
		assertThat(vehicle.angle, is(60));
		assertThat(vehicle.name, is("mogreen"));
	}

}
