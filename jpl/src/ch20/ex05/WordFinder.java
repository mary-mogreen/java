/**
 * 
 */
package ch20.ex05;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;

import ch20.ex04.LineReader;

/**
 * @author mary-mogreen
 * 20: 	public static void main(String[] args) throws IOException {
 * 21: 		if (args.length != 2) {
 * 22: 			args = new String[2];
 * 23: 			args[0] = "args";
 * 24: 			args[1] =  "/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex05/WordFinder.java";
 * 27: 		String match = args[0];
 * 28: 		FileReader fileIn = new FileReader(args[1]);
 */
public class WordFinder  {
	
	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			args = new String[2];
			args[0] = "args";
			args[1] =  "/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex05/WordFinder.java";
		}
			
		String match = args[0];
		FileReader fileIn = new FileReader(args[1]);
		LineNumberReader in = new LineNumberReader(fileIn);
		String str;
		while ((str = in.readLine()) != null) {
			if (str.contains(match))
				System.out.println(in.getLineNumber() + ": " + str);
		}
	} 
}
