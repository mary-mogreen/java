/**
 *
 */
package ch14.ex06;

import java.util.LinkedList;

/**
 * @author mary-mogreen
 *
 */
public class TimeThread extends Thread {

	private long second = 0;
	private LinkedList<MessageThread> messages;

	TimeThread(MessageThread message, MessageThread... messages) {
		this.messages = new LinkedList<MessageThread>();
		message.start();
		this.messages.add(message);
		for (MessageThread mt: messages) {
			mt.start();
			this.messages.add(mt);
		}

	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			printTime();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// e.printStackTrace();
			}
			for (MessageThread mt: messages) {
				mt.tick();
			}
		}
	}


	synchronized public void printTime() {
		System.out.println(second + "s");
		second++;
	}
}
