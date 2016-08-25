/**
 * 
 */
package ch22.ex14;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author mary-mogreen
 *
 */
public class StringNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			double result = sum("0.5 23.00003 -4.78 0.10005 -3.987654321");
			double ans = 0.5 + 23.00003 - 4.78 + 0.10005 - 3.987654321;
			if (result == ans)
				System.out.println("○");
			else
				System.out.println("×");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static double sum(String str) throws IOException {
		Scanner in = new Scanner(str);
		double sum = 0.0;
		while (in.hasNext()) {
			if (in.hasNextDouble())
				sum += in.nextDouble();
			else
				in.next();
		}
		
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;
		
		
		return sum;
	}

}
