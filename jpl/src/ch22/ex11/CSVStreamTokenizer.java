/**
 * 
 */
package ch22.ex11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

import ch22.ex07.CSVScanner;

/**
 * @author mary-mogreen
 *
 */
public class CSVStreamTokenizer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String testpath = "/Users/katouyuuya/git/java_training2015/jpl/src/ch22/ex11/test.csv";
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(testpath));
		
			List<String[]> list = CSVScanner.readCSVTable(in, 4);
			for (String[] values: list) {
				for (int i = 0; i < values.length; i++)
					System.out.print(values[i] + "\t");
				System.out.println();
			}
		} catch (IOException e) {
			System.err.println("");
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch(IOException e) {
					System.err.println("finally");
				}
			}
		}
	}
	
	public static List<String[]> readCSVTable(Reader source, int n) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		in.ordinaryChar(',');
		List<String[]> vals = new ArrayList<>();
		String[] strs = new String[n];
		int i = 0;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			switch (in.ttype) {
			case StreamTokenizer.TT_WORD:
				strs[i] = in.sval;
				i++;
				break;
			case StreamTokenizer.TT_EOL:
				vals.add(strs);
				strs = new String[n];
				i = 0;
				break;
			default:
				break;
			}
		}
		vals.add(strs);
		return vals;
	}

}
