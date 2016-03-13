package ch06.ex04;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class TrafficSignalColorTest {

	@Test
	public void testGetColor() {
		Color amber = new Color("amber");
		assertThat(TrafficSignalColor.AMBER.getColor().toString(),
					is(amber.toString()));
	}

}
