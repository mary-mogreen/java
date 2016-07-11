package ch20.ex04;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringReader;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class LineReaderTest {

	@Test
	public void testReadLine() {
		String expected1 = "line 1: aaaaaaaaaa";
		String expected2 = "line 2: bbbbbbbbbb";
		String str = expected1 + "\n" + expected2;
		System.out.println(str);
		
		StringReader sReader = new StringReader(str);
		LineReader reader = new LineReader(sReader);
		try {
			assertThat(reader.readLine(), is(expected1 + "\n"));
			assertThat(reader.readLine(), is(expected2));
			assertThat(reader.readLine(), is((String) null));
		} catch (IOException e) {
			fail();
		}	
	}
}
