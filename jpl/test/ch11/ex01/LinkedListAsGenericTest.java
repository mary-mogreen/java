/**
 *
 */
package ch11.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListAsGenericTest {

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#LinkedListAsGeneric()} のためのテスト・メソッド。
	 */
	@Test
	public void testLinkedListAsGeneric() {
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>();
		assertThat(linkedListAsString.getHeader(), is((Integer)null));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#LinkedListAsGeneric(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testLinkedListAsGenericV() {
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>("TEST");
		assertThat(linkedListAsString.getHeader(), is("TEST"));
		assertThat(linkedListAsString.getTail(), is("TEST"));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#getHeader()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetHeader() {
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>();
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
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>();
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
		LinkedListAsGeneric<Integer> linkedListAsInteger = new LinkedListAsGeneric<Integer>(Integer.valueOf(20));
		linkedListAsInteger.add(Integer.valueOf(10));
		linkedListAsInteger.add(Integer.valueOf("50"));
		assertThat(linkedListAsInteger.size(), is(3));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#add(java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testAdd() {
		LinkedListAsGeneric<Integer> linkedListAsInteger = new LinkedListAsGeneric<Integer>(Integer.valueOf(20));
		linkedListAsInteger.add(Integer.valueOf(10));
		assertThat(linkedListAsInteger.get(1), is(10));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#get(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testGet() {
		LinkedListAsGeneric<Boolean> linkedListAsBoolean = new LinkedListAsGeneric<Boolean>();
		assertThat(linkedListAsBoolean.get(0), is((Boolean)null));
		linkedListAsBoolean.add(Boolean.valueOf(true));
		assertThat(linkedListAsBoolean.get(0), is(true));
	}

	/**
	 * {@link ch11.ex01.LinkedListAsGeneric#set(int, java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testSet() {
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>();
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
		LinkedListAsGeneric<String> linkedListAsString = new LinkedListAsGeneric<String>();
		for (int i = 0; i < 10; i++)
			linkedListAsString.add("TEST" + i);
		assertThat(linkedListAsString.contains("TEST100"), is(false));
		assertThat(linkedListAsString.contains("TEST5"), is(true));
	}
}
