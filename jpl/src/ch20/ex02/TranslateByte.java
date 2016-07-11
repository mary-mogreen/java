/**
 * 
 */
package ch20.ex02;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mary-mogreen
 *
 */
public class TranslateByte extends FilterInputStream {
	private final byte from;
	private final byte to;
	
	protected TranslateByte(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to   = to;
	}
	
	@Override
	public int read() throws IOException {
		int b = super.read();
		return (b == from ? to : b);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		byte from = (byte) args[0].charAt(0);
		byte to	  = (byte) args[1].charAt(0);
		InputStream in = new TranslateByte(System.in, from, to);
		int b;
		while ((b = in.read()) != -1) {
			System.out.print((char) b);
		}
	}

}
