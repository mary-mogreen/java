/**
 * 
 */
package ch20.ex04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author mary-mogreen
 *
 */
public class LineReader extends FilterReader {

	public LineReader(Reader in) {
		super(in);
	}
	
	/**
	 * １行ごとに文字列を返す。
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException {
		StringBuilder sb = new StringBuilder();
		String ls = System.lineSeparator();
		int b;
		while ((b = super.read()) != -1) {
			sb.append((char) b);
			if (ls.equals(String.valueOf((char) b))) {
				return sb.toString();
			}
		}
		return(sb.length() != 0 ? sb.toString() : null);
	}

}
