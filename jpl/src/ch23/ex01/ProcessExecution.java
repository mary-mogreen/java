/**
 * 
 */
package ch23.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mary-mogreen
 *
 */
public class ProcessExecution {


	public static Process userProg(String cmd) throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}
	
	private static void plugTogether(OutputStream out, InputStream in) {
		Thread th = new Thread(() -> {
			int ch;
			try {
				while ((ch = in.read()) != -1)
					out.write(ch);
			} catch (IOException e) {
				System.err.println(e);
			}
		}); 
	}

	public static void plugTogether(InputStream in, OutputStream out) {
		Thread th = new Thread(() -> {
			int ch;
			try {
				while ((ch = in.read()) != -1)
					out.write(ch);
			} catch (IOException e) {
				System.err.println(e);
			}
		});
	}
	
	public static String[] ls(String dir, String opts) throws LSFailedException {
		try {
			String cmd = "ls " + opts + " " + dir;
			// String[] cmdArray = {"ls", opts, dir};
			Process child = Runtime.getRuntime().exec(cmd);
			InputStream lsOut = child.getInputStream();			
			InputStreamReader r = new InputStreamReader(lsOut);
			BufferedReader in = new BufferedReader(r);
			
			List<String> lines = new ArrayList<>();
			String line;
			while ((line = in.readLine()) != null) {
				lines.add(line);
			}
			if (child.waitFor() != 0)
				throw new LSFailedException(child.exitValue());
			return lines.toArray(new String[lines.size()]);
		} catch (LSFailedException e) {
			throw e;
		} catch (Exception e) {
			throw new LSFailedException(e.toString());
		}
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException, LSFailedException {
		// userProg
		Process proc = userProg("ls -al");
		InputStream in = proc.getInputStream();
		InputStreamReader r = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(r);
		
		String line;
		while ((line = br.readLine()) != null)
			System.out.println(line);
		
		// ls
		String[] result = ls("", "-al");
		for (String s: result)
			System.out.println(s);

	}

}
