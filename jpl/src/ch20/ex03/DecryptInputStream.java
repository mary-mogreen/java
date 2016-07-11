/**
 * 
 */
package ch20.ex03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mary-mogreen
 *
 */
public class DecryptInputStream extends FilterInputStream {
	private final int key;
	
	protected DecryptInputStream(InputStream in, int key) {
		super(in);
		this.key = key;
	}
	
	@Override
	public int read() throws IOException {
		int b = super.read();
		return(b ^ key);
	}
	
	@Override
	public int read(byte[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i = offset; i < last; i++)
			buf[i] = (byte)(buf[i] ^ key);
		return nread;
	}

}
