/**
 *
 */
package ch04.ex04;

import java.util.concurrent.TimeUnit;

/**
 * @author mary-mogreen
 *
 */
public interface BlockingQueue<E> extends Queue<E> {


	/**
	 * このキューに指定された要素を追加
	 */
	boolean add(E o) throws NullPointerException, IllegalStateException;

	/**
	 * 利用可能なすべての要素をこのキューから削除、その後指定されたコレクションに追加
	 * @param c
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalStateException
	 */
	int drainTo(Collection<? extends E> c) throws NullPointerException, IllegalStateException;

	/**
	 * 指定された数以内の利用可能な要素をキューから削除して、指定されたコレクションに追加
	 * @param c
	 * @param maxElements
	 * @return
	 * @throws NullPointerException
	 * @throws IllegalStateException
	 */
	int drainTo(Collection<? super E> c, int maxElements) throws NullPointerException, IllegalStateException;

	/**
	 * 可能な場合、指定された要素をこのキューに挿入
	 */
	boolean offer(E o) throws NullPointerException;

	/**
	 * 指定された要素をこのキューに挿入。必要に応じて、空間が利用可能になるのを指定された時間まで大気
	 * @param o
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws NullPointerException
	 */
	boolean offer(E o, long timeout, TimeUnit unit) throws NullPointerException;

	/**
	 * このキューの先頭を取得及び削除
	 * @param timeout
	 * @param unit
	 * @return
	 * @throws InterruptedException
	 */
	E poll(long timeout, TimeUnit unit) throws InterruptedException;

	/**
	 * 指定された要素をこのキューに追加
	 * @param o
	 * @throws InterruptedException
	 */
	void put(E o) throws InterruptedException;

	/**
	 * このキューが理想的な状態でブロッキングなしに受け入れることができる要素の数を返す
	 * @return
	 */
	int remainingCapacity();

	/**
	 * このキューの先頭を取得及び削除
	 * @return
	 * @throws InterruptedException
	 */
	E take() throws InterruptedException;
}
