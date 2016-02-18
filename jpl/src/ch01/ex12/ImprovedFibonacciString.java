/**
 *
 */
package ch01.ex12;

/**
 * @author mary-mogreen
 *
 */
public class ImprovedFibonacciString {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に’＊’をつけて、フィボナッチ数列の
	 * 最初の方の要素を表示する。
	 * Stringオブジェクトを作成して配列に入れるようにしてみる。
	 */
	public static void main(String[] args) {
		int lo = 0,
			hi = 1;
		String fibonacci = "";
		for (int i = 0; i < MAX_INDEX; i++) {
			if (hi % 2 == 0)
				fibonacci += hi + " *\n";
			else
				fibonacci += hi + "\n";
			hi = lo + hi;
			lo = hi - lo;
		}
		System.out.println(fibonacci);
	}
}
