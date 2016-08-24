/**
 * 
 */
package ch22.ex12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;

import ch11.ex02.AttrAsGeneric;
import ch11.ex03.Attributed;
import ch11.ex03.AttributedImpl;

/**
 * @author mary-mogreen
 *
 */
public class AttrScanner {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("/Users/katouyuuya/git/java_training2015/jpl/src/ch22/ex12/test.txt"));
			Attributed<String> attrs = readAttr(in);
			Iterator<AttrAsGeneric<String>> it = attrs.attrs();
			while (it.hasNext())
				System.out.println(it.next());
			
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (in != null)
				in.close();
		}

	}
	
	public static Attributed<String> readAttr(Reader source) throws IOException {
		Attributed<String> attrs = new AttributedImpl();
		Scanner in = null;
		
		try {
			in = new Scanner(source);
			
			while (in.hasNextLine()) {
				String[] nameValue = in.nextLine().split("=");
				attrs.add(new AttrAsGeneric<>(nameValue[0], nameValue[1]));
			}
		} finally {
			if (in != null)
				in.close();
		}
		return attrs;
		
	}

}
