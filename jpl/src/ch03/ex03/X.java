/**
 *
 */
package ch03.ex03;

/**
 * @author mary-mogreen
 *
 */
/**
 * Step 	 事象 	 xMask 	 yMask 	 fullMask
 * 4 	 Xのフィールドが初期化される 	 ff 	 0 	 0
 * 5 	 Xのコンストラクタが実行される 	 ff 	 0 	 0
 * 6 	 Yのフィールドが初期化される 	 ff 	 ff00 	 0
 * 7 	 Yのコンストラクタが実行される 	 ff 	 ff00 	 ff00
 * もしコンストラクタXがmaskを呼び出したとしたら
 *
 */
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		System.out.printf("%d \t Xのフィールドが初期化される \t %x \t %x \t %x%n", 4, xMask, 0x0000, fullMask);
		init();
		//fullMask = mask(xMask);
		System.out.printf("%d \t Xのコンストラクタが実行される \t %x \t %x \t %x%n", 5, xMask, 0x0000, fullMask);
	}

	public void init() {
		System.out.printf("X.init()");
		fullMask = xMask;
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

}
