/**
 *
 */
package ch03.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import ch03.ex08.Vehicle;

/**
 * @author mary-mogreen
 *
 */
public class LinkedListTest {

	@Test
	public void testClone() {
		LinkedList list = new LinkedList("test1");
		Vehicle v = new Vehicle("test2");
		list.add(v);
		list.add("test3");

		LinkedList copy = list.clone();

		//copy.set(1, "new test2");

		// リストが参照しているオブジェクトに対する変更は他方のリストから見えること
		Vehicle copyV = (Vehicle) copy.get(1);
		copyV.setOwner("new test2");

		assertThat(((Vehicle) list.get(1)).getOwner(), is("new test2"));
		// １つのリストに対する変更は、他方のリストに影響がないこと
		list.add("test4");

		assertThat(list.contains("test4"), is(true));
		assertThat(copy.contains("test4"), is(false));

		System.out.println("list\n" + list);
		System.out.println("copy\n" + copy);

	}

	@Test
	public void testGet() {
		LinkedList list = new LinkedList("test1");
		list.add("test2");
		list.add("test3");

		assertThat(list.get(1), is("test2"));
		assertThat(list.get(10), is((Object)null));
	}

}
