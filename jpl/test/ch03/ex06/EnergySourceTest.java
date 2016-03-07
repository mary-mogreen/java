/**
 *
 */
package ch03.ex06;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author mary-mogreen
 *
 */
public class EnergySourceTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testEmptyGasTank() throws CapacityOverException {
		// Lで最大容量を設定
		EnergySource gt = new GasTank(1000);
		assertThat(gt.empty(), is(true));
		//
		gt.setEnergy(10);
		assertThat(gt.empty(), is(false));
		assertThat(gt.getEnergy(), is(10L));
	}

	@Test
	public void testEmptyBattery() throws CapacityOverException {
		// mAで最大容量を設定
		EnergySource bt = new Battery(1000);
		assertThat(bt.empty(), is(true));
		bt.setEnergy(10);
		assertThat(bt.empty(), is(false));
		assertThat(bt.getEnergy(), is(10L));
	}

	@Test
	public void testSetEnergy() throws CapacityOverException {
		EnergySource bt = new Battery(5);
		exception.expect(CapacityOverException.class);
		exception.expectMessage("最大容量オーバー");

		bt.setEnergy(10);
	}

}
