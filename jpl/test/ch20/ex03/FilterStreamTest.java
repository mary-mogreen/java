package ch20.ex03;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.Test;

public class FilterStreamTest {

	private void print(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++)
			System.out.print((byte)bytes[i]);
		System.out.println();
	}
	
	@Test
	public void testFileterStream() {
		final int key = 2016;
		String str = "abracadabra!";
		byte[] src = str.getBytes();
		byte[] expected = str.getBytes();
		for (int i = 0; i < expected.length; i++)
			expected[i] = (byte)(expected[i] ^ key);
		System.out.println("Source: " + str);
		System.out.println("Source: ");
		print(src);
		System.out.println("Expected Encrypted: ");
		print(expected);
		
		ByteArrayOutputStream bytes_out = new ByteArrayOutputStream();
		
		OutputStream out = new EncryptOutputStream(bytes_out, key);
		try {
			out.write(src);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		byte[] encrypted = bytes_out.toByteArray();
		System.out.println("Encrypted: ");
		print(encrypted);
		
		if (expected.length != encrypted.length)
			fail("expected: " + expected.length + ", encrypted: " + encrypted.length);
		else {
			for (int i = 0; i < expected.length; i++)
				assertThat(encrypted[i], is(expected[i]));
		}
		ByteArrayInputStream bytes_in = new ByteArrayInputStream(encrypted);
		
		InputStream in = new DecryptInputStream(bytes_in, key);
		byte[] decrypted = new byte[src.length];
		try {
			in.read(decrypted);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("Decryped: ");
		print(decrypted);
		
		if (src.length != decrypted.length)
			fail("src: " + src.length + ", decrypted: " + decrypted.length);
		else {
			for (int i = 0; i < src.length; i++)
				assertThat(decrypted[i], is(src[i]));
		}
		System.out.println("Decrypted: " + new String(decrypted));
		
	}
}
