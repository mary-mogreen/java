/**
 *
 */
package ch02.ex14;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListTest {

	@Test
	public void testGetTailNode() {
		LinkedList list = new LinkedList("Test1");
		assertThat(list.getTailNode().getValue(), is("Test1"));

		list.add("Test2");
		assertThat(list.getTailNode().getValue(), is("Test2"));
	}

	@Test
	public void testAdd() {
		LinkedList list = new LinkedList("Test1");
		list.add("Test2");

		assertThat(list.getHeaderNode().getNextNode(), is(list.getTailNode()));
	}

}
