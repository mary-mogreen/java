/**
 *
 */
package ch13.ex05;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	public static String[] delimitedString(String from, char start, char end) {
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		List<String> strs = new ArrayList<String>();
		if (startPos == -1)
			return null;
		else if (endPos == -1) {
			strs.add(from.substring(startPos));
			return strs.toArray(new String[strs.size()]);
		} else if (startPos > endPos)
			return null;
		else {
			for (int startIdx = startPos;
				 startIdx != -1;
				 startIdx = from.indexOf(start, startIdx + 1)) {
				int endIdx = from.indexOf(end, startIdx);
				while (endIdx != -1) {
					String str = from.substring(startIdx, endIdx + 1);
					if (!strs.contains(str))
						strs.add(str);
					endIdx = from.indexOf(end, endIdx + 1);
				}
			}
			return strs.toArray(new String[strs.size()]);
		}
	}

	/**
	 * 文字列中の10進数を右から3桁ずつカンマ区切りしたものに置き換える。
	 * @param str 10進数を含んだ文字列
	 * @return 10進数の数字が右から3桁ずつカンマ区切りされた文字列に置き換えられている文字列
	 */
	public static String insertDelimiter(String str) {
		StringBuffer buf = new StringBuffer();
		String regex = "[0-9]+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			StringBuffer buff = new StringBuffer(matcher.group());
			for (int i = buff.length() - 3; i > 0; i -= 3)
				buff.insert(i, ",");
			matcher.appendReplacement(buf, buff.toString());
		}
		matcher.appendTail(buf);
		return buf.toString();
	}
}
