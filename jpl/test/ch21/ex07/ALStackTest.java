package ch21.ex07;

import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ALStackTest {

	private ALStack<String> target;
	
	@Before
	public void before() {
		System.out.println("test before.");
		this.target = new ALStack<String>();
	}
	
	@After
	public void after() {
		System.out.println("test after.");
		this.target = null;
	}
	
	@Test
	public void testPush() {
		String test = "test str";
		target.push(test);
		assertTrue(test.equals(target.pop()));
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPop_beforePush() {
		target.pop();
	}
	
	@Test
	public void testPop() {
		String[] str = {"1", "2", "3"};
		for (int i = 0; i < str.length; i++)
			target.push(str[i]);
		for (int i = str.length - 1; i >= 0; i--)
			assertTrue(str[i].equals(target.pop()));
	}
	
	@Test(expected = EmptyStackException.class)
	public void testPeek_beforePush() {
		target.peek();
	}
	
	@Test
	public void testPeek() {
		String[] str = {"1", "2", "3"};
		for (int i = 0; i < str.length; i++)
			target.push(str[i]);
		for (int i = str.length - 1; i >= 0; i--) {
			assertTrue(str[i].equals(target.peek()));
			assertTrue(str[i].equals(target.pop()));
		}
	}
	
	@Test
	public void testEmpty_isEmpty() {
		assertTrue(target.empty());
	}
	
	@Test
	public void testEmpty_isNotEmpty() {
		target.push("test");
		assertFalse(target.empty());
	}
	
	@Test
	public void testSearch_notFound() {
		String[] str = {"1", "2", "3"};
		for (String s: str)
			target.push(s);
		assertTrue(-1 == target.search("4"));
	}
	
	@Test
	public void testSearch_found() {
		String[] str = {"1", "2", "3"};
		for (String s: str)
			target.push(s);
		assertTrue(1 == target.search("3"));
		assertTrue(2 == target.search("2"));
		assertTrue(3 == target.search("1"));
	}
}
