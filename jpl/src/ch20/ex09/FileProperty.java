/**
 * 
 */
package ch20.ex09;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mary-mogreen
 *
 */
public class FileProperty {
	
	private List<File> files = new ArrayList<>();
	
	public FileProperty(String path, String... paths) {
		if (path == null)
			return;
		files.add(new File(path));
		for (String p: paths)
			files.add(new File(p));
		
		for (File f: files)
			showProperties(f);
	}
	
	public void showProperties(File file) {
		System.out.println("=========== File Properties ==========");
		System.out.println("Name: " + file.getName());
		System.out.println("Path: " + file.getPath());
		System.out.println("Size: " + file.length() + " bytes");
		System.out.println("Permission: " + (file.canRead() ? "R" : "") + (file.canWrite() ? "W" : ""));
		System.out.println("Last Modified: " + file.lastModified());
		System.out.println();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileProperty fp = new FileProperty(
				"/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex09/FileProperty.java",
				"/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex08/test.txt",
				"/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex08/EntryTable.java",
				"/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex07/Attr.java"
				);
	}

}
