/**
 *
 */
package ch02.ex11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListTest {

	@Test
	public void test() {
		LinkedList nextList = new LinkedList("List2");
		LinkedList list = new LinkedList("List1", nextList);

		String expected = "this: List1\nnext: List2";

		assertThat(list.toString(), is(expected));
	}

}
