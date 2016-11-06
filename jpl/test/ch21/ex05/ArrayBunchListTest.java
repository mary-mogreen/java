package ch21.ex05;

import static org.junit.Assert.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import ch21.ex05.ArrayBunchList.ABLListIterator;

public class ArrayBunchListTest {
	String[][] arrays = {
			{"a", "b", "c"},
			{"d", "e", "f"},
			{"g", "h", "i"}
	};

	@Test(expected = IllegalStateException.class)
	public void testABLListIteratorSet_NG() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		li.set("0");
	}
	
	@Test
	public void testABLListIteratorSet_OK() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		String str = li.next();
		li.set("0");
		assertTrue("0".equals(li.next()));
	}
	
	@Test
	public void testABLListIteratorHasNext() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		for (int i = 0; i < 9; i++) {
			assertTrue(li.hasNext());
			li.next();
		}
		assertFalse(li.hasNext());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testABLListIteratorNext() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		assertTrue("a".equals(li.next()));
		assertTrue("b".equals(li.next()));
		assertTrue("c".equals(li.next()));
		assertTrue("d".equals(li.next()));
		assertTrue("e".equals(li.next()));
		assertTrue("f".equals(li.next()));
		assertTrue("g".equals(li.next()));
		assertTrue("h".equals(li.next()));
		assertTrue("i".equals(li.next()));
		li.next();
	}
	
	@Test
	public void testABLListIteratorHasPrevious() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		for (int i = 0; i < 9; i++)
			li.next();
		for (int i = 0 ; i < 9; i++) {
			boolean hasPrevious = li.hasPrevious();
			String str = li.previous();
			assertTrue(hasPrevious);
			System.out.println(hasPrevious + ": " + str);
		}
		assertFalse(li.hasPrevious());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testABLListIteratorPrevious() {
		ArrayBunchList<String> abl = new ArrayBunchList<>(arrays);
		ListIterator<String> li = abl.listIterator();
		for (int i = 0; i < 9; i++)
			System.out.println("previous test: " + li.next());
		assertTrue("i".equals(li.previous()));
		assertTrue("h".equals(li.previous()));
		assertTrue("g".equals(li.previous()));
		assertTrue("f".equals(li.previous()));
		assertTrue("e".equals(li.previous()));
		assertTrue("d".equals(li.previous()));
		assertTrue("c".equals(li.previous()));
		assertTrue("b".equals(li.previous()));
		assertTrue("a".equals(li.previous()));
		li.previous();
	}


}
