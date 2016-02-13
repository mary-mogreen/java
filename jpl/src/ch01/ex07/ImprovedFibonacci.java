/**
 *
 */
package ch01.ex07;

/**
 * @author yuuya katoh
 *
 */
public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に’＊’をつけて、フィボナッチ数列の
	 * 最初の方の要素を表示する。
	 * iが逆順に値が減るようにループを書き直す
	 */
	public static void main(String[] args) {
		int lo = 21,
			hi = 34;
		String mark = " *";

		for (int i = MAX_INDEX;  i > 0; i--) {
			if (hi % 2 == 0)
				mark = " *";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			lo = hi - lo;
			hi = hi - lo;
		}

	}

}
