/**
 * 
 */
package ch21.ex06;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * @author mary-mogreen
 *
 */
public class Concat {
	
	@SuppressWarnings("resource")
	public static void cat(String... args) throws IOException {
		InputStream in;
		if (args.length == 0)
			throw new IllegalArgumentException("1つ以上のファイルパス");
		Enumeration<InputStream> files = new ConcatEnumration(args);
		in = new SequenceInputStream(files);
		int ch;
		while ((ch = in.read()) != -1)
			System.out.write(ch);
	}
	
	public static void main(String[] args) throws IOException {
		if (args.length > 0)
			cat(args);
		else {
			String file1 = "/Users/katouyuuya/git/java_training2015/jpl/src/ch21/ex06/testfile.txt";
			String file2 = "/Users/katouyuuya/git/java_training2015/jpl/src/ch21/ex06/testfile2.txt";
			String[] files = {file1, file2};
			cat(files);
		}
	}
	
	static class ConcatEnumration implements Enumeration<InputStream> {

		private String[] files;
		private int index;
		private InputStream in;
		
		ConcatEnumration(String[] files) {
			this.files = files.clone();
		}
		
		@Override
		public boolean hasMoreElements() {
			return index < files.length;
		}

		@Override
		public InputStream nextElement() {
			if (!hasMoreElements())
				throw new NoSuchElementException("nothing");
			if (in != null) {
				try {
					in.close();
					System.out.printf("%n[%s] close.%n ", files[index]);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			InputStream fileIn;
			try {
				System.out.printf("%n[%s] open.%n ", files[index]);
				fileIn = new FileInputStream(files[index++]);
				in = new BufferedInputStream(fileIn);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			return in;
		}
		
	} 
}
