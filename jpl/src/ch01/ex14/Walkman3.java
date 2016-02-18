/**
 *
 */
package ch01.ex14;

/**
 * @author mary-mogreen
 * 3代目のウォークマン
 * 2端子を用いて、双方向のコミュニケーションがとれる
 */
public class Walkman3 extends Walkman2 {
	Walkman3() {
		super();
		name = "Walkman3";
	}
	/**
	 * 双方向のコミュニケーション機能
	 * @param speaker
	 * @param listener
	 */
	public void communicate(int speaker, int listener) {
		getJack(listener).output(getJack(speaker).getMessage());
	}
}
