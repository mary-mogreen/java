package ch03.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 *
 * @author mary-mogreen
 *
 */

public class PassengerVehicleTest {

	@Test
	public void testCloneFailed() {
		PassengerVehicle pv = new PassengerVehicle("Test", 2);

		Passenger p = new Passenger("test");

		try {
			pv.takeInPassenger(p);
		} catch (CapacityOverException e) {
			e.printStackTrace();
		}

		PassengerVehicle copy = pv.clone();

		assertThat(copy, is((PassengerVehicle) null));
	}

	@Test
	public void testClone() {
		PassengerVehicle pv = new PassengerVehicle("Test", 2);
		PassengerVehicle copy = pv.clone();
		assertThat(copy.getId(), is(pv.getId()));
		assertThat(copy.getAngle(), is(pv.getAngle()));
		assertThat(copy.getOwner(), is(pv.getOwner()));
		assertThat(copy.getSpeed(), is(pv.getSpeed()));
		assertThat(copy.getSeats(), is(pv.getSeats()));
		assertThat(copy.isCloned(), is(true));
	}

}
