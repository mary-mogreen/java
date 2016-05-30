/**
 *
 */
package ch14.ex02;


/**
 * @author mary-mogreen
 *
 */
class PrintQueue {
	private SingleLinkQueue<PrintJob> queue = new SingleLinkQueue<PrintJob>();

	public synchronized void add(PrintJob job) {
		queue.add(job);
		notifyAll(); // 待っているスレッドに知らせる：プリントジョブが追加された
	}

	public synchronized PrintJob remove() throws InterruptedException {
		while (queue.size() == 0)
			wait();
		return queue.remove();
	}
}
