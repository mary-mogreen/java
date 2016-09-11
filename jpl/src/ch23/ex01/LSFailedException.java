package ch23.ex01;

public class LSFailedException extends Exception {
	String str;
	int val;
	public LSFailedException(String str) {
		super("ls failed: " + str);
		this.str = str;
	}


	public LSFailedException(int exitValue) {
		super("ls failed, exit value: " + exitValue);
		this.val = exitValue;
	}
}
