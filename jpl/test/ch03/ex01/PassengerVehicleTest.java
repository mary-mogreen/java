/**
 *
 */
package ch03.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author mary-mogreen
 *
 */
public class PassengerVehicleTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testPassengerVehicleIllegal() {
		PassengerVehicle pVehicle = new PassengerVehicle(-1);

		assertThat(pVehicle.getSeats(), is(1));
	}

	@Test
	public void testPassengerVehicle() {
		PassengerVehicle pVehicle = new PassengerVehicle();
		assertThat(pVehicle.getSeats(), is(1));
	}

	@Test
	public void testPassengerVehicleOwner() {
		PassengerVehicle pVehicle = new PassengerVehicle("John");
		assertThat(pVehicle.getSeats(), is(1));
		assertThat(pVehicle.getOwner(), is("John"));
	}

	@Test
	public void testPassengerVehicleOwnerAndSeats() {
		PassengerVehicle pVehicle = new PassengerVehicle("John", 3);
		assertThat(pVehicle.getSeats(), is(3));
		assertThat(pVehicle.getOwner(), is("John"));
	}

	@Test
	public void testGetSeats() {
		PassengerVehicle pVehicle = new PassengerVehicle(4);
		assertThat(pVehicle.getSeats(), is(4));
	}

	@Test
	public void testGetCurrentPassenger() throws CapacityOverException {
		PassengerVehicle pVehicle = new PassengerVehicle(4);
		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();

		pVehicle.takeInPassenger(p1);
		pVehicle.takeInPassenger(p2);

		assertThat(pVehicle.getCurrentPassengers(), is(2));
	}

	@Test
	public void testTakeInPassenger() throws CapacityOverException {
		PassengerVehicle pVehicle = new PassengerVehicle(2);
		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();

		pVehicle.takeInPassenger(p1);
		pVehicle.takeInPassenger(p2);
	}

	@Test
	public void testTakeInPassengerFailed() throws CapacityOverException {
		PassengerVehicle pVehicle = new PassengerVehicle(); // default seats:1
		Passenger p1 = new Passenger();
		Passenger p2 = new Passenger();

		exception.expect(CapacityOverException.class);
		exception.expectMessage(pVehicle.getSeats() + "人乗りです");

		pVehicle.takeInPassenger(p1);
		pVehicle.takeInPassenger(p2); // ここで例外
	}

	@Test
	public void testGetOutPassenger() throws CapacityOverException {
		PassengerVehicle pVehicle = new PassengerVehicle(); // default seats:1
		Passenger p1 = new Passenger("John");

		pVehicle.takeInPassenger(p1);
		assertThat(pVehicle.getCurrentPassengers(), is(1));

		assertThat(pVehicle.getOutPassenger("John"), is(p1));
		assertThat(pVehicle.getCurrentPassengers(), is(0));
	}

	@Test
	public void testGetOutPassengerNull() throws CapacityOverException {
		PassengerVehicle pVehicle = new PassengerVehicle(); // default seats:1
		Passenger p1 = new Passenger("John");

		pVehicle.takeInPassenger(p1);
		assertThat(pVehicle.getCurrentPassengers(), is(1));

		assertThat(pVehicle.getOutPassenger("Mary"), is((Passenger)null));
		assertThat(pVehicle.getCurrentPassengers(), is(1));
	}

}
