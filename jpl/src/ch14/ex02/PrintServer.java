/**
 *
 */
package ch14.ex02;

/**
 * @author mary-mogreen
 *
 */
public class PrintServer implements Runnable {

	private final PrintQueue requests = new PrintQueue();
	private final String threadName;

	public PrintServer() {
		Thread thread = new Thread(this);
		threadName = thread.getName();
		System.out.println("thread name is : " + threadName);
		thread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if (!Thread.currentThread().getName().equals(threadName)) {
			System.out.println("current thread(" + Thread.currentThread().getName() + ") is not created contructor.");
			return;
		}
		for (;;) {
			try {
				PrintJob job = requests.remove();
				System.out.println(job);
				realPrint(job);
			} catch (InterruptedException e) {
				System.out.println("IntteruptedException");
			}
		}
	}

	private void realPrint(PrintJob job) {
		// 印刷の実際の処理を行う
		System.out.println("real print: " + job);
	}

}
