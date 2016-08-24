/**
 * 
 */
package ch22.ex10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author mary-mogreen
 *
 */
public class CommentSkip {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader input = null;
        try {
            input = new BufferedReader(new FileReader("/Users/katouyuuya/git/java_training2015/jpl/src/ch22/ex10/test.txt"));
            List<String> result = CommentSkip.skipCommentLines(input);
            for (String line : result) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

	}
	
	public static List<String> skipCommentLines(Readable source) {
		Scanner in = null;
		List<String> lines = new ArrayList<>();
		try {
			in = new Scanner(source);
			in.useDelimiter("//.*\n");
			while (in.hasNext()) {
				String line = in.next();
				if (!line.equals(""))
					lines.add(line);
			}
		} finally {
			in.close();
		}
		return lines;
		
	}

}
