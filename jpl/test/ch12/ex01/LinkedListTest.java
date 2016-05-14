/**
 *
 */
package ch12.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListTest {

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#LinkedListAsGeneric()} のためのテスト・メソッド。
	 */
	@Test
	public void testLinkedList() {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		assertThat(linkedListAsString.getHeader(), is((Integer)null));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#LinkedListAsGeneric(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testLinkedListAsGenericV() {
		LinkedList<String> linkedListAsString = new LinkedList<String>("TEST");
		assertThat(linkedListAsString.getHeader(), is("TEST"));
		assertThat(linkedListAsString.getTail(), is("TEST"));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#getHeader()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetHeader() {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		linkedListAsString.add("TEST1");
		assertThat(linkedListAsString.getHeader(), is("TEST1"));
		linkedListAsString.set(0, "TEST2");
		assertThat(linkedListAsString.getHeader(), is("TEST2"));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#getTail()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetTail() {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		linkedListAsString.add("TEST1");
		assertThat(linkedListAsString.getTail(), is("TEST1"));
		linkedListAsString.add("TEST2");
		assertThat(linkedListAsString.getTail(), is("TEST2"));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#size()} のためのテスト・メソッド。
	 */
	@Test
	public void testSize() {
		LinkedList<Integer> linkedListAsInteger = new LinkedList<Integer>(Integer.valueOf(20));
		linkedListAsInteger.add(Integer.valueOf(10));
		linkedListAsInteger.add(Integer.valueOf("50"));
		assertThat(linkedListAsInteger.size(), is(3));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#add(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testAdd() {
		LinkedList<Integer> linkedListAsInteger = new LinkedList<Integer>(Integer.valueOf(20));
		linkedListAsInteger.add(Integer.valueOf(10));
		assertThat(linkedListAsInteger.get(1), is(10));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#get(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testGet() {
		LinkedList<Boolean> linkedListAsBoolean = new LinkedList<Boolean>();
		assertThat(linkedListAsBoolean.get(0), is((Boolean)null));
		linkedListAsBoolean.add(Boolean.valueOf(true));
		assertThat(linkedListAsBoolean.get(0), is(true));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#set(int, java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testSet() {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		linkedListAsString.add("TEST1");
		assertThat(linkedListAsString.getHeader(), is("TEST1"));
		linkedListAsString.set(0, "TEST2");
		assertThat(linkedListAsString.getHeader(), is("TEST2"));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#contains(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testContains() {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		for (int i = 0; i < 10; i++)
			linkedListAsString.add("TEST" + i);
		assertThat(linkedListAsString.contains("TEST100"), is(false));
		assertThat(linkedListAsString.contains("TEST5"), is(true));
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testFind() throws ObjectNotFoundException {
		LinkedList<String> linkedListAsString = new LinkedList<String>();
		linkedListAsString.find("val1");

	}

	@Test
	public void testFind2() throws ObjectNotFoundException {
		LinkedList<String> linkedListAsString = new LinkedList<String>("val1");
		assertThat(linkedListAsString.find("val1"), is(linkedListAsString.getNode(0)));
	}

	@Test(expected = ObjectNotFoundException.class)
	public void testFind3() throws ObjectNotFoundException {
		LinkedList<String> linkedListAsString = new LinkedList<String>("val1");
		linkedListAsString.add("val2");
		linkedListAsString.add("val3");
		linkedListAsString.add("val4");
		linkedListAsString.find("va12");
	}

}
