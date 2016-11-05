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
	private static String result;
	
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
		StringBuilder sb = new StringBuilder();
		for (String n: nameValue.keySet()) {
			String s = String.format("%s = %s%n", n, nameValue.get(n));
			sb.append(s);
			System.out.print(s);
		}
		result = sb.toString();
	}
	
	public static String getResult() {
		if (result == null || result.isEmpty())
			throw new IllegalStateException("Not calculated.");
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0)
			args = new String[1]; args[0] = "./test.txt";
		try {
			calc(new FileReader(args[0]));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
