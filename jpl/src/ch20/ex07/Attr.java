/**
 * 
 */
package ch20.ex07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author mary-mogreen
 *
 */
public class Attr {
	private final String name;
	private Object value = null;
	
	
	public Attr(String name) {
		this.name = name;
	}
	
	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 追加
	 * @param name
	 * @param in
	 * @throws IOException
	 */
	public Attr(String name, InputStream in) throws IOException {
		this.name = name;
		DataInputStream din = new DataInputStream(in);
		value = din.readDouble();
		din.close();
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
	public Object setValue(Object value) {
		this.value = value;
		return value;
	}
	
	/**
	 * 追加
	 * @param file
	 * @param value
	 * @throws IOException
	 */
	public void writeData(String file, Object value) throws IOException {
		DataOutputStream dout = new DataOutputStream(new FileOutputStream(file));
		dout.writeBytes(value.toString());
		dout.close();
	}
	
	
	
}
