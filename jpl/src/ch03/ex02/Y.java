/**
 *
 */
package ch03.ex02;

/**
 * @author mary-mogreen
 *
 */
public class Y extends X {
	protected int yMask = 0xff00;

	public Y() {
		System.out.printf("%d \t Yのフィールドが初期化される \t %x \t %x \t %x%n", 6, xMask, yMask, fullMask);
		fullMask |= yMask;
		System.out.printf("%d \t Yのコンストラクタが実行される \t %x \t %x \t %x%n", 7, xMask, yMask, fullMask);
	}

	public static void main(String[] args) {
		System.out.printf("Step \t 事象 \t xMask \t yMask \t fullMask%n");
		Y y = new Y();
	}
}
