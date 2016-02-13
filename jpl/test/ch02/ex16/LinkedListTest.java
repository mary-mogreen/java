/**
 *
 */
package ch02.ex16;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListTest {

	@Test
	public void testSize() {
		LinkedList list = new LinkedList("Test1");
		list.add("Test2");
		list.add("Test3");
		list.add("Test4");
		assertThat(list.size(), is(4));
	}


}
