/**
 *
 */
package ch04.ex04;

import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author mary-mogreen
 *
 */
public interface SortedSet<E> extends Set<E> {
	/**
	 * ソートセットに関連したコンパレータを返す
	 * @return
	 */
	Comparator<? super E> comparator();

	/**
	 * ソートセット内に現在ある最初の要素を返す
	 * @return
	 * @throws NoSuchElementException
	 */
	E first() throws NoSuchElementException;

	/**
	 * ソートセットのtoElementまでのビューを返す
	 * @param toElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> headSet(E toElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;

	/**
	 * ソートセット内に現在ある最後の要素を返す
	 * @return
	 * @throws NoSuchElementException
	 */
	E last()  throws NoSuchElementException;
	/**
	 * ソートセットのfromからtoまでのビューを返す
	 * @param fromElement
	 * @param toElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> subSet(E fromElement, E toElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;

	/**
	 * ソートセットのfromElement以上の要素を持つ部分のビューを返す
	 * @param fromElement
	 * @return
	 * @throws ClassCastException
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	SortedSet<E> tailSet(E fromElement)
		throws	ClassCastException,
				IllegalArgumentException,
				NullPointerException;
}
