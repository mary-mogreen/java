/**
 *
 */
package ch01.ex13;

/**
 * @author mary mogreen
 *
 */
public class ImprovedFibonacciPrintf {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に’＊’をつけて、フィボナッチ数列の
	 * 最初の方の要素を表示する。
	 * Stringオブジェクトを作成して配列に入れるようにしてみる。
	 */
	public static void main(String[] args) {
		int lo = 0,
			hi = 1;
		String mark;
		for (int i = 0; i < MAX_INDEX; i++) {
			if (hi % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.printf("%d %s%n", hi, mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
