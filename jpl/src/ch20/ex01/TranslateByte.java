/**
 * 
 */
package ch20.ex01;

import java.io.*;

/**
 * @author mary-mogreen
 *
 */
public class TranslateByte {
	public static void main(String[] args)
		throws IOException
	{
		byte from = (byte) args[0].charAt(0);
		byte to	  = (byte) args[1].charAt(0);
		InputStream in = System.in;
		OutputStream out = System.out;
		translate(from, to, in, out);
	}
	
	public static void translate(byte from, byte to, InputStream in, OutputStream out)
		throws IOException
	{
		int b;
		while ((b = in.read()) != -1)
			out.write(b == from ? to : b);
	}
}
