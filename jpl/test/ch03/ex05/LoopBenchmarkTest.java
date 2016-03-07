/**
 *
 */
package ch03.ex05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author mary-mogreen
 *
 */
public class LoopBenchmarkTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testFailed() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("不正な値");

		LoopBenchmark loopBench = new LoopBenchmark(-1);
	}

	@Test
	public void testLoopCount() {
		LoopBenchmark loopBench = new LoopBenchmark(3);
		assertThat(loopBench.getLoopCount(), is(3));
		loopBench.setLoopCount(5);
		assertThat(loopBench.getLoopCount(), is(5));
	}

}
