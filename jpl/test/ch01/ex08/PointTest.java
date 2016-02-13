package ch01.ex08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testSet() {
		Point p1 = new Point();
		Point p2 = new Point();
		p2.x = 1.2;
		p2.y = 10.0;
		p1.set(p2);
		double delta = 0.1;
		assertEquals(1.2, p1.x, delta);
		assertEquals(10.0, p1.y, delta);
	}

}
