/**
 *
 */
package ch01.ex10;

/**
 * @author yuuya katoh
 *
 */
public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に’＊’をつけて、フィボナッチ数列の
	 * 最初の方の要素を表示する。
	 */
	public static void main(String[] args) {
		int lo = 0,
			hi = 1;
		FibonacciNumber[] fibonacci = new FibonacciNumber[MAX_INDEX];
		for (int i = 0; i < MAX_INDEX; i++) {
			FibonacciNumber fn = new FibonacciNumber();
			if (hi % 2 == 0)
				fn.isEven = true;
			else
				fn.isEven = false;
			fn.num = hi;
			fibonacci[i] = fn;
			hi = lo + hi;
			lo = hi - lo;
		}

		//for (int i = 0; i < MAX_INDEX; i++)
		//	System.out.println((i + 1) + ": " + fibonacci[i].num + (fibonacci[i].isEven ? " *": ""));
	}
}
