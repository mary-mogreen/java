package ch16.ex09;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.util.LinkedHashSet;
import java.util.Set;

public class ClassContents {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			printClass(c, 0);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}
	
	private static void printClass(Class<?> c, int indent) {
		for (int i = 0; i < indent; i++)
			System.out.print("    ");
		System.out.print(c);
		System.out.println(" {");
		printMembers(removeDuplicateMembers(c.getFields(), c.getDeclaredFields()), c.getName() + ".", indent + 1);
		printMembers(removeDuplicateMembers(c.getConstructors(), c.getDeclaredConstructors()), strip(c.getName(), c.getSimpleName()), indent + 1);
		printMembers(removeDuplicateMembers(c.getMethods(), c.getDeclaredMethods()), c.getName() + ".", indent + 1);
		for (Class<?> cls: c.getDeclaredClasses()) {
			printClass(cls, indent + 1);
		}
		for (int i = 0; i < indent; i++)
			System.out.print("    ");
		System.out.println("}");
	}
	
	/**
	 * Objectから継承されているメンバーを除いて，メンバを説明する文字列を表示する。
	 * @param mems メンバーの配列
	 * @param prefix クラス名
	 */
	private static void printMembers(Member[] mems, String prefix, int indent) {
		for (Member m: mems) {
			if (m.getDeclaringClass() == Object.class)
				continue;
			String decl = m.toString();
			for (int i = 0; i < indent; i++)
				System.out.print("    ");
			System.out.println(strip(strip(decl, "java.lang."), prefix) + ";");
			printAnnotation(m);
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
	
	private static void printAnnotation(Member mem) {
		if (mem instanceof AnnotatedElement) {
			for (Annotation a: ((AnnotatedElement)mem).getAnnotations())
				System.out.println("        " + a);
		}
			
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
