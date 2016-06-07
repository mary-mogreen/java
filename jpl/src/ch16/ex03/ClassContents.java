/**
 * 
 */
package ch16.ex03;

import java.lang.reflect.*;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 * @author mary-mogreen
 *
 */
public class ClassContents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			System.out.println(c);
			printMembers(removeDuplicateMembers(c.getFields(), c.getDeclaredFields()));
			printMembers(removeDuplicateMembers(c.getConstructors(), c.getDeclaredConstructors()));
			printMembers(removeDuplicateMembers(c.getMethods(), c.getDeclaredMethods()));
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	/**
	 * Objectから継承されているメンバーを除いて，メンバを説明する文字列を表示する。
	 * @param mems
	 */
	private static void printMembers(Member[] mems) {
		for (Member m: mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			System.out.print("    ");
			System.out.println(strip(decl, "java.lang."));
		}
	}
	
	/**
	 * 指定された文字列を取り除いた文字列を返す。
	 * @param str 文字列
	 * @param target 取り除く文字列
	 * @return 指定された文字列を取り除いたもの
	 */
	private static String strip(String str, String target) {
		return str.replaceAll(target, "");
	}
	
	/**
	 * 与えられた二つのメンバーを結合して，重複を取り除く
	 * @param mem1
	 * @param mem2
	 * @return 二つのメンバーを重複なく結合した新しいメンバー
	 */
	private static Member[] removeDuplicateMembers(Member[] mem1, Member[] mem2) {
		Set<Member> set = new LinkedHashSet<Member>();
		for (Member m: mem1) {
			set.add(m);
		}
		for (Member m: mem2) {
			set.add(m);
		}
		return set.toArray(new Member[set.size()]);
	}

}
