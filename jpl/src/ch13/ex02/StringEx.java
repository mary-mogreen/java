/**
 *
 */
package ch13.ex02;

/**
 * @author mary-mogreen
 *
 */
public class StringEx {

	/**
	 * 文字列中に、指定された文字が出現する回数を数える。
	 * @param str 文字列
	 * @param ch 指定された文字
	 * @return count 指定された文字の出現回数
	 */
	static int countCharactor(String str, char ch) {
		int count = 0;
		int idx = -1;
		do {
			idx = str.indexOf(ch, idx + 1);
			count++;
		} while (idx != -1);
		return count - 1;
	}

	/**
	 * 文字列中に、特定文字列が出現する回数を数える。
	 * @param str 文字列
	 * @param sStr 特定文字列
	 * @return count 特定文字列の出現回数
	 */
	static int countString(String str, String sStr) {
		int count = 0;
		int idx = -1;
		do {
			idx = str.indexOf(sStr, idx + 1);
			count++;
		} while (idx != -1);
		return count - 1;
	}
}
