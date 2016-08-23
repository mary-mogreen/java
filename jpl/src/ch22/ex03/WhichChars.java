/**
 * 
 */
package ch22.ex03;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author mary-mogreen
 *
 */
public class WhichChars {

	private Map<Byte, BitSet> used = new HashMap<>();
	
	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			byte b = (byte)(c >> 8);
			BitSet bs;
			if (!used.containsKey(b)) {
				bs = new BitSet();
			} else {
				bs = used.get(b);
			}
			bs.set(c & 0xff);
			used.put(b, bs);
		}
	}
	
	@Override
	public String toString() {
		String desc = "[";
		for (Entry<Byte, BitSet> e: used.entrySet()) {
			byte b = e.getKey();
			BitSet bs = e.getValue();
			for (int i = bs.nextSetBit(0);
					i >= 0;
					i = bs.nextSetBit(i + 1)) {
				desc += (char)(b << 8 | i);
			}
		}
		return desc + "]";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(new WhichChars("Hello, World. 今日は。"));
	}

}
