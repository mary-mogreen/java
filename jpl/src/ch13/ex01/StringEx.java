/**
 *
 */
package ch13.ex01;

/**
 * @author mary-mogreen
 *
 */
public class StringEx {

	/**
	 * 文字列中に、指定された文字が出現する回数を数える。
	 * @param str
	 * @param ch
	 * @return chの出現回数
	 */
	static int countCharactor(String str, char ch) {
		int count = 0;
		int idx = -1;
		System.out.println("--");
		do {
			idx = str.indexOf(ch, idx + 1);//ccc
			System.out.println(idx);
			count++;
		} while (idx != -1);
		return count - 1;
	}
}
