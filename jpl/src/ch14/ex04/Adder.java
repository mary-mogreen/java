/**
 *
 */
package ch14.ex04;

/**
 * @author mary-mogreen
 *
 */
public class Adder {

	private static int value = 0;

	/**
	 * 現在の値に加算して新たな値を表示する
	 * @param val
	 */
	public static synchronized void add(int val) {
		value += val;
		System.out.println("value: " + value);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Runnable r = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					Adder.add(1);
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
