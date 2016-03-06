/**
 *
 */
package ch03.ex03;

/**
 * @author mary-mogreen
 *
 */

/**
 *Step 	 事象 	 xMask 	 yMask 	 fullMask
4 	 Xのフィールドが初期化される 	 ff 	 0 	 0
5 	 Xのコンストラクタが実行される 	 ff 	 0 	 0
6 	 Yのフィールドが初期化される 	 ff 	 ff00 	 0
7 	 Yのコンストラクタが実行される 	 ff 	 ff00 	 ff00

 *
 *
 */
public class Y extends X {
	protected int yMask;// = 0xff00;

	public Y() {
		System.out.printf("%d \t Yのフィールドが初期化される \t %x \t %x \t %x%n", 6, xMask, yMask, fullMask);
		init();
		//fullMask |= yMask;
		System.out.printf("%d \t Yのコンストラクタが実行される \t %x \t %x \t %x%n", 7, xMask, yMask, fullMask);
	}
	/**
	 * 3.3 init()みたいな初期化関数を作ってその中で初期化すればよい？
	 */
	@Override
	public void init() {
		yMask = 0xff00;
		fullMask |= yMask;
	}

	@Override
	public int mask(int orig) {
		return (orig & yMask);
	}

	public static void main(String[] args) {
		System.out.printf("Step \t 事象 \t xMask \t yMask \t fullMask%n");
		Y y = new Y();
	}
}
