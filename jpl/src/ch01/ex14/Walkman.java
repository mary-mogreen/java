/**
 *
 */
package ch01.ex14;

/**
 * @author mary-mogreen
 * 初代ウォークマンのクラス
 * 1人がテープを聞くための1個の端子をもつ
 */

public class Walkman {
	private Jack jack;
	private boolean hasJack;

	Walkman(){
		hasJack = false;
	}

	/**
	 * 1つの端子でテープを聞く
	 * @param tape
	 */
	public void listen(Tape tape) {
		if (hasJack) {
			System.out.println("Walkman: Playing...");
			this.jack.output(tape.getSongs());
		}
	}

	/**
	 * Jackに挿す
	 * @param jack
	 */
	public void plug(Jack jack) {
		this.jack = jack;
		this.hasJack = true;
	}
	/**
	 * Jackから抜く
	 */
	public void unplug() {
		this.jack = null;
		this.hasJack = false;
	}

	/**
	 * jackを返す
	 * @return
	 */
	public Jack getJack() {
		return jack;
	}

	/**
	 * jackにささっているか
	 * @boolean
	 */
	public boolean hasJack() {
		return hasJack;
	}
}
