/**
 * 
 */
package ex20.ch11;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author mary-mogreen
 *
 */
public class SuffixFilter implements FilenameFilter {

	private final String suffix;

	public SuffixFilter(String suffix) {
		this.suffix = suffix;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(suffix);
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 2) {
			args = new String[2];
			args[0] = "/Applications";
			args[1] = "app";
		}
		SuffixFilter filter = new SuffixFilter(args[1]);
		File dir = new File(args[0]);
		File[] list = dir.listFiles(filter);
		for (File file: list) {
			System.out.println(file.getName());
		}
	}
}


