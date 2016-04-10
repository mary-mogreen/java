/**
 *
 */
package ch09.ex04;

/**
 * @author mary-mogreen
 *
 */
public class Answer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//答え合わせ

		//(1)
		// 3 << 2L - 1
		// 3 << 1L
		// 6: int
		System.out.println("(1) 3 << 2L - 1 = " + (3 << 2L - 1));

		//(2)
		// (3L << 2) - 1
		// (12L) - 1
		// 11L
		System.out.println("(2) (3L << 2) - 1 = " + ((3L << 2) - 1));

		//(3)
		// 関係のほうが等価より優先度高い
		// 10 < 12 == 6 > 17
		// true == false
		// false
		System.out.println("(3) 10 < 12 == 6 > 17: " + (10 < 12 == 6 > 17));

		//(4)
		//シフトのほうが等価より優先度高い
		// 10 << 12 == 6 >> 17
		// 0000 0000 0000 0000 1010 0000 0000 0000 == 0000 0000 0000 0000 0000 0000 0000 0000
		// false
		System.out.println("(4) 10 << 12 == 6 >> 17: " + (10 << 12 == 6 >> 17));

		//(5)
		// 1.35e-1 % +∞
		// p.177より、 「x % +∞ = x」
		// 1.35: float
		System.out.println("(5) 13.5e-1 % Float.POSITIVE_INFINITY = " + (13.5e-1 % Float.POSITIVE_INFINITY));

		//(6)
		// +∞ + (-∞)
		// NaN: double?
		System.out.println("(6) Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY = " + (Float.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY));

		//(7)
		// +∞ - (-∞)
		// +∞: double?
		System.out.println("(7) Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY = " + (Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY));

		//(8)
		// 0.0 / -0.0 == -0.0 / 0.0
		// NaN == NaN
		// false
		System.out.println("(8) 0.0 / -0.0 == -0.0 / 0.0: " + (0.0 / -0.0 == -0.0 / 0.0));

		//(9)
		// -2^31 <= int <= 2^31 - 1
		// 2^31 - 1 + (-2^31)
		// 2^31 - 2^31 -1
		// -1: int
		System.out.println("(9) Integer.MAX_VALUE + Integer.MIN_VALUE = " + (Integer.MAX_VALUE + Integer.MIN_VALUE));

		//(10)
		// 0x7FFFFFFFFFFFFFFF + 5
		// 0x0FFF FFFFFFFFFFFFFFF + 5
		// 0x1000 000000000000004
		// 0x800000000000004
		// 0x 1000 00000000000000 0100
		// 0x 0111 FFFFFFFFFFFFFF 1011 + 1
		// 0x 0111 FFFFFFFFFFFFFF 1100
		// 0x 7FFFFFFFFFFFFFFC
		// 9223372036854775804
		// -9223372036854775804
		System.out.println("(10) Long.MAX_VALUE + 5 = " + (Long.MAX_VALUE + 5));

		//(11)
		//50: int
		System.out.println("(11) (short) 5 * (byte) 10 = " + ((short) 5 * (byte) 10));

		//(12) iは？
		//System.out.println("(12) (i < 15 ? 1.72e3f : 0): " + (i < 15 ? 1.72e3f : 0));

		//(13)
		// i++ + i++ + --i
		// 3++ + 4++ + --4
		// 3 + 4 + 4
		// 11: int
		int i = 3;
		System.out.println("(13) i++ + i++ + --i = " + (i++ + i++ + --i));



	}

}
