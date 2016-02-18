/**
 *
 */
package ch01.ex14;

/**
 * @author mary-mogreen
 * 2代目のウォークマン
 * 同じテープを2人で聞けるように2個の端子をもつ
 */
public class Walkman2 extends Walkman {
	private final int JACK_NUM;
	private Jack[] jacks;
	private boolean[] hasJacks;
	protected String name;

	Walkman2() {
		JACK_NUM = 2;
		jacks = new Jack[JACK_NUM];
		hasJacks = new boolean[JACK_NUM];
		for (int i = 0; i < JACK_NUM; i++) {
			hasJacks[i] = false;
		}
		name = "Walkman2";
	}

	/**
	 * 1つ以上の端子でテープを聴く
	 * @param tape
	 */
	@Override
	public void listen(Tape tape) {
		System.out.println(name + ": Playing...");
		for (int i = 0; i < JACK_NUM; i++) {
			if (hasJacks[i])
				this.jacks[i].output(tape.getSongs());
		}
	}

	/**
	 *
	 */
	@Override
	public Jack getJack() {
		return null;
	}

	/**
	 *
	 */
	@Override
	public boolean hasJack() {
		return false;
	}

	/**
	 * 端子番号に対応する端子を返す
	 * @param jackNumber
	 * @return
	 */
	public Jack getJack(int jackNumber) {
		return jacks[jackNumber];
	}



	/**
	 * Jackに挿す
	 * @param jack
	 * @param jackNumber
	 */
	public void plug(Jack jack, int jackNumber) {
		if (jackNumber < JACK_NUM && !hasJacks[jackNumber]) {
			jacks[jackNumber] = jack;
			hasJacks[jackNumber] = true;
		} else {
			System.out.println("端子にセットできません");
		}
	}

	/**
	 * Jackから抜く
	 * @jackNumber
	 */
	public void unplug(int jackNumber) {
		if (jackNumber < JACK_NUM && hasJacks[jackNumber]) {
			jacks[jackNumber] = null;
			hasJacks[jackNumber] = false;
		} else {
			System.out.println("ささっていません");
		}
	}

	/**
	 * Jacksを返す
	 * @return
	 */
	public Jack [] getJacks() {
		return jacks;
	}

	/**
	 * hasJacksかどうか
	 * @return
	 */
	public boolean [] hasJacks() {
		return hasJacks;
	}
}
