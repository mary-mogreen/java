/**
 * 
 */
package ch20.ex03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @author mary-mogreen
 *
 */
public class EncryptOutputStream extends FilterOutputStream {
	private final int key;
	
	public EncryptOutputStream(OutputStream out, int key) {
		super(out);
		this.key = key;
	}
	
	/**
	 * 暗号化して書き込む。
	 */
	@Override
	public void write(int b) throws IOException {
		super.write(b ^ key);
	}

}
