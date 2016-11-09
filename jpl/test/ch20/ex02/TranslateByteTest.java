package ch20.ex02;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class TranslateByteTest {

	@Test
	public void testTranslateString() throws IOException {
		byte from = (byte) 'b';
		byte to	  = (byte) 'B';
		InputStream in = new TranslateByte(new ByteArrayInputStream("abracadabra!".getBytes()), from, to);
		int b;
		StringBuilder sb = new StringBuilder();
		while ((b = in.read()) != -1) {
			sb.append((char)b);
		}
		assertTrue("aBracadaBra!".equals(sb.toString()));
	}

}
