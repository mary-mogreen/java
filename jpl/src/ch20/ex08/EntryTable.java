/**
 * 
 */
package ch20.ex08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mary-mogreen
 *
 */
public class EntryTable {
	
	private final String separator;
	private final String filePath;
	private String tablePath;
	
	public EntryTable(String separator, String filePath) {
		this.separator = separator;
		this.filePath = filePath;
		this.tablePath = filePath.replaceFirst("\\..*$", ".table");
	}

	public void createTable() {
		List<Long> table = new ArrayList<Long>();
		try {
			RandomAccessFile in = new RandomAccessFile(new File(filePath), "r");
			long fp = in.getFilePointer();
			String line = in.readLine();
			if (line.startsWith(separator))
				table.add(in.getFilePointer());
			else
				table.add(fp);
			while ((line = in.readLine()) != null) {
				if (line.startsWith(separator))
					table.add(in.getFilePointer());
			}
			
			
			File tableFile = new File(tablePath);
			tableFile.createNewFile();
			FileWriter out = new FileWriter(tableFile);
			for (Long l: table) {
				out.write(l.toString());
				out.write(System.lineSeparator());
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found.");
		} catch (IOException e) {
			System.out.println("Exception");
		}
	}
	
	public void showTable() throws IOException {
		List<Long> list = new ArrayList<>();
		File tableFile = new File(tablePath);
		if (!tableFile.exists())
			createTable();
		RandomAccessFile tf = new RandomAccessFile(tableFile, "r");
		String line;
		while ((line = tf.readLine()) != null) {
			list.add(Long.valueOf(line));
		}
		int i = (int) (Math.random() * list.size());
		RandomAccessFile in = new RandomAccessFile(new File(filePath), "r");
		in.seek(list.get(i));
		while ((line = in.readLine()) != null) {
			if (line.startsWith(separator))
				break;
			System.out.println(line);
		}
	}
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		EntryTable et = new EntryTable("%%", "/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex08/test.txt");
		et.createTable();
		
		for (int i = 0; i < 5; i++) {
			et.showTable();
			System.out.println("================");
		}
		
	}

}
