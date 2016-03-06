/**
 *
 */
package ch03.ex02;

/**
 * @author mary-mogreen
 *
 */
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		System.out.printf("%d \t Xのフィールドが初期化される \t %x \t %x \t %x%n", 4, xMask, 0x0000, fullMask);
		fullMask = xMask;
		System.out.printf("%d \t Xのコンストラクタが実行される \t %x \t %x \t %x%n", 5, xMask, 0x0000, fullMask);
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

}
