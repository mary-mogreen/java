/**
 * 
 */
package ch23.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import ch23.ex01.LSFailedException;

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
	 * コマンドを実行して出力文字列の配列を返す
	 * @param cmdArray
	 * @return 出力結果
	 * @throws IOException
	 */
	public static String[] exec(String... cmdArray) throws IOException{
		return execute(null, cmdArray);
	}
	
	/**
	 * コマンドを実行して出力文字列の配列を返す
	 * @param cmdArray
	 * @return 出力結果
	 * @throws IOException
	 */
	public static String[] execute(String exit, String... cmdArray) throws IOException{
		try {
			Process child = Runtime.getRuntime().exec(cmdArray);
			InputStream execOut = child.getInputStream();			
			InputStreamReader r = new InputStreamReader(execOut);
			LineNumberReader in = new LineNumberReader(r);
			
			List<String> lines = new ArrayList<>();
			String line;
			while ((line = in.readLine()) != null) {
				if (exit != null && line.contains(exit)) {
					System.out.println("exit token is found.");
					child.destroy();
					break;
				}
				lines.add(line);
			}
			if (child.waitFor() != 0)
				throw new IOException("return: " + child.exitValue());
			return lines.toArray(new String[lines.size()]);
		} catch (Exception e) {
			throw new IOException(e);
		}
	}
	
	/**
	 * 出力結果の行数付き
	 * @param cmdArray
	 * @return
	 * @throws IOException
	 */
	public static String[] execWithLineNumber(String... cmdArray) throws IOException {
		String[] execOut = exec(cmdArray);
		String[] out = new String[execOut.length];
		for (int i = 0; i < execOut.length; i++) {
			out[i] = (i + 1) + ":" + execOut[i];
		}
		return out;
		
	}
	


	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		String[] rslt;
		if (args.length < 2) {
			// exec with line number
			rslt = execute("project", "ls", "-al");
		} else {
			String[] cmd = new String[args.length - 1];
			for (int i = 1; i < args.length; i++)
				cmd[i - 1] = args[i];
			if ("null".equals(args[0]))
				args[0] = null;
			rslt = execute(args[0], cmd);
		}

		for (String s: rslt)
			System.out.println(s);
		

	}

}
