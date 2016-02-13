/**
 *
 */
package ch01.ex16;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

/**
 * @author p000526463
 *
 */
public class BadDataSetExceptionTest {

	@Test
	public void test() {
		try {
			try {
				throw new IOException();
			} catch (IOException e) {
				throw new BadDataSetException("fileName", e);
			}
		}catch (BadDataSetException e) {
			assertEquals(e.getFileName(), "fileName");
		}
	}

}
