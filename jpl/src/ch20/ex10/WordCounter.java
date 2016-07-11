/**
 * 
 */
package ch20.ex10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mary-mogreen
 *
 */
public class WordCounter {

	private String path;
	private Map<String, Integer> wordCount = new HashMap<>();
	
	public WordCounter(String path) {
		this.path = path;
	}
	
	public void setNewPath(String path) {
		this.path = path;
	}
	
	/**
	 * ファイル内に出現する単語とその出現回数をカウントして，表示する。
	 * @throws IOException
	 */
	public void showWordAndCount() throws IOException {
		StreamTokenizer in = new StreamTokenizer(new FileReader(path));
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				String word = in.sval;
				Integer count = wordCount.get(word);
				wordCount.put(word, count == null ? 1 : count + 1);
			}
		}
		
		for (String token: wordCount.keySet()) {
			System.out.println(token + ": " + wordCount.get(token));
		}
		System.out.println("---------End.---------");
	}
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			args = new String[1];
			args[0] = "/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex10/WordCounter.java";
		}
		WordCounter wc = new WordCounter(args[0]);
		wc.showWordAndCount();
		wc.setNewPath("/Users/katouyuuya/git/java_training2015/jpl/src/ch20/ex09/FileProperty.java");
		wc.showWordAndCount();
	}

}
