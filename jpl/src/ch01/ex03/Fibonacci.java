/**
 *
 */
package ch01.ex03;

/**
 * @author mary-mogreen
 *
 */
public class Fibonacci {

	/**
	 * 値が50未満のフィボナッチ数列を表示する
	 * 出力リストにタイトルを追加する
	 */
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		System.out.println("値が50未満のフィボナッチ数列を表示する");
		System.out.println(lo);
		while(hi < 50) {
			System.out.println(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
