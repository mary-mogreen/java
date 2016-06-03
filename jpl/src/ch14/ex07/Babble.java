/**
 *
 */
package ch14.ex07;

/**
 * @author mary-mogreen
 *
 * true 2 Did DidNot
 * Windows
 * 1. Did Did DidNot DidNot
 * 2. Did Did DidNot DidNot
 * 3. Did DidNot DidNot Did
 * 4. Did Did DidNot DidNot
 * 5. Did DidNot Did DidNot
 *
 * Mac
 * 1. Did DidNot Did DidNot
 * 2. Did Did DidNot DidNot
 * 3. Did Did DidNot DidNot
 * 4. Did Did DidNot DidNot
 * 5. Did Did DidNot DidNot
 */
public class Babble extends Thread {

	static boolean doYield;	// 他のスレッドに実行を譲るか？
	static int howOften;	// 表示する回数
	private String word;	// このスレッドの単語

	Babble(String whatToSay) {
		word = whatToSay;
	}

	public void run() {
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if (doYield)
				Thread.yield(); // 他のスレッドを走らせる
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		doYield = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		for (int i = 2; i < args.length; i++)
			new Babble(args[i]).start();
	}
}
