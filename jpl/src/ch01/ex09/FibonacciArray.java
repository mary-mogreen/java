/**
 *
 */
package ch01.ex09;

/**
 * @author yuuya katoh
 *
 */
public class FibonacciArray {
	static final String TITLE = "値が50未満のフィボナッチ数列を表示する";
	static final int MAX = 50;
	static final int ARRAY_SIZE = 50;
	/**
	 * 値が50未満のフィボナッチ数列を表示する
	 * 出力リストにタイトルを追加する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int[] fibonacci = new int[ARRAY_SIZE];
		int i = 0;
		fibonacci[i] = hi;
		while(hi < 50) {
			fibonacci[++i] = hi;
			hi = lo + hi;
			lo = hi - lo;
		}

		System.out.println(TITLE);
		for (int j = 0; j <= i; j++)
			System.out.println(fibonacci[j]);
	}
}
