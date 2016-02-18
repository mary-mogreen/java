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
public class NodeTest {

	@Test
	public void testGetValue() {
		Node node = new Node("Test1");
		assertThat(node.getValue(), is("Test1"));
		assertThat(node.getNextNode(), is((Node)null));
	}

	@Test
	public void testSetValue() {
		Node node = new Node("Test1");
		node.setValue("Test2");
		assertThat(node.getValue(), is("Test2"));
	}

	@Test
	public void testGetNextNode() {
		Node node = new Node("Test1");
		Node nextNode = new Node("TestNext");
		node.setNextNode(nextNode);
		assertThat(node.getNextNode(), is(nextNode));
	}

}
