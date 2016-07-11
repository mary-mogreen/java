/**
 * 
 */
package ch20.ex06;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mary-mogreen
 * a = 3.2
 * b = 0.5
 * c = 3.8
 */
public class NameOpValue {

	public static void calc(Reader reader) throws IOException {
		StreamTokenizer in = new StreamTokenizer(reader);
		Map<String, Double> nameValue = new HashMap<>();
		String name = null;
		int op = -1;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD)
				name = in.sval;
			else if (in.ttype == '=') {
				op = '=';
			} else if (in.ttype == '+') {
				op = '+';
			} else if (in.ttype == '-') {
				op = '-';
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				if (name == null || op == -1) {
					throw new IOException();
				}
				Double value = nameValue.get(name);
				if (value == null) {
					value = 0.0;
				}
				if (op == '=')
					value = in.nval;
				else if (op == '+')
					value += in.nval;
				else if (op == '-')
					value -= in.nval;
				
				nameValue.put(name, value);
				name = null;
				op = -1;
			}
			
		}
		for (String n: nameValue.keySet()) {
			System.out.println(n + " = " + nameValue.get(n));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			calc(new FileReader("/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex06/test.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
