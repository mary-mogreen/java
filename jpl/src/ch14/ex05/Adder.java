/**
 *
 */
package ch14.ex05;

/**
 * @author mary-mogreen
 *
 */
public class Adder {

	private static int value = 300;
	private static Object lock = new Object();

	/**
	 * 現在の値に加算して新たな値を表示する
	 * @param val
	 */
	public static void add(int val) {
		synchronized(lock) {
			value += val;
			System.out.println("value: " + value);
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					Adder.add(-1);
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// e.printStackTrace();
					}
				}
			}
		};

		new Thread(r).start();
		new Thread(r).start();
		new Thread(r).start();
	}

}
