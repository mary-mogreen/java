/**
 *
 */
package ch14.ex06;

/**
 * @author mary-mogreen
 *
 */
public class MessageThread extends Thread {
	private final int INTERVAL;
	private int count = 1;
	private final String message;
	private boolean stop = false;

	public MessageThread(String message, int interval) {
		this.INTERVAL = interval;
		this.message = message;
	}


	@Override
	public void run() {
		while (!stop) {
			try {
				showMessage();
			} catch (InterruptedException e) {
				//e.printStackTrace();
			}
		}
	}

	synchronized void showMessage() throws InterruptedException {
		wait();
		if (count == INTERVAL) {
			System.out.println(message);
			count = 1;
		} else {
			count++;
		}
	}

	synchronized void tick() {
		notify();
	}


	public static void main(String[] args) {
		new TimeThread(new MessageThread("Message", 15), new MessageThread("メッセージ", 7)).start();
	}
}
