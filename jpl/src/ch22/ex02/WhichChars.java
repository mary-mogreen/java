/**
 * 
 */
package ch22.ex02;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mary-mogreen
 * 
 */
public class WhichChars {

	// private BitSet used = new BitSet();
	private Set<Character> used = new HashSet<>(); 
	
	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++)
			used.add(str.charAt(i)); // 文字に対応したビットを設定
	}
	
	@Override
	public String toString() {
		String desc = "[";
		// for (int i = used.nextSetBit(0);
		// 		i >= 0;
		// 		i = used.nextSetBit(i + 1)) {
		//	desc += (char) i;
		// }
		for (Character c: used)
			desc += c;
		return desc + "]";
	}
	
	public static void main(String[] args) {
		System.out.println(new WhichChars("Hello, World. こんにちは。"));
	}
}
