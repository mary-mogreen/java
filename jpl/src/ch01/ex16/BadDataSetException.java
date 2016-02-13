/**
 *
 */
package ch01.ex16;

import java.io.IOException;

/**
 * @author mary-mogreen
 *
 */
public class BadDataSetException extends Exception {
	private String fileName;
	public BadDataSetException(String fileName, IOException e) {
		super(e);
		this.fileName = fileName;
	}

	public String getFileName() {
		return this.fileName;
	}

}
