/**
 *
 */
package ch01.ex14;

/**
 * @author mery-mogreen
 *
 */
public class UseWalkman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Walkman w1 = new Walkman();
		Walkman2 w2 = new Walkman2();
		Walkman3 w3 = new Walkman3();

		Tape favoriteTape = new Tape("song1: Ahhhhhhhhhhhhhhhhh. songs2: Uhhhhhhhhhhhhhhhh.");

		Jack j1 = new Jack();
		Jack j2 = new Jack();

		w1.plug(j1);

		w2.plug(j1, 0);

		w3.plug(j2, 1);
		w3.plug(j1, 0);

		w1.listen(favoriteTape);
		w2.listen(favoriteTape);
		w3.listen(favoriteTape);

		w1.unplug();

		j1.input("コミュニケーション");
		w3.communicate(0, 1);

	}

}
