package ch20.ex06;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class NameOpValueTest {
	
//	@Rule
//    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testCalc() throws FileNotFoundException, IOException {
		NameOpValue.calc(new FileReader("/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex06/test.txt"));
		String expect = "a = 3.2\nb = 0.5\nc = 3.8\n";
		assertTrue(expect.equals(NameOpValue.getResult()));
	}
}
