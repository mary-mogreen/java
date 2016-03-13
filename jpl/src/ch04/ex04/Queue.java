/**
 *
 */
package ch04.ex04;

import java.util.NoSuchElementException;

/**
 * @author mary-mogreen
 *
 */
public interface Queue<E> extends Collection<E> {

	/**
	 * キューの先頭を取得するが、削除しない
	 * @return
	 * @throws NoSuchElementException
	 */
	E element() throws NoSuchElementException;

	/**
	 * 可能な場合、指定された要素をこのキューに挿入する
	 * @param o
	 * @return
	 */
	boolean offer(E o);

	/**
	 * キューの先頭を取得するが、削除しない
	 * @return
	 */
	E peek();
	/**
	 * キューの先頭を取得及び削除
	 * @return キューの先頭、キューが空ならnull
	 */
	E poll();

	/**
	 * キューの先頭を取得及び削除
	 * @return
	 * @throws NoSuchElementException
	 */
	E remove() throws NoSuchElementException;
}
