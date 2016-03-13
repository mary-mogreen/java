/**
 *
 */
package ch04.ex04;

import java.util.ListIterator;

/**
 * @author mary-mogreen
 * Javadocを書き直さなければならない部分はあるが、長くなるので新しく追加されたメソッドだけ書いた。
 */
public interface List<E> extends Collection<E> {
	/**
	 * リスト内の指定された位置に、指定された要素を挿入
	 * @param index
	 * @param element
	 */
	void add(int index, E element)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * 指定されたコレクション内のすべての要素を、指定されたコレクションの反復子によって返される順序でリストの最後に追加
	 * @param index
	 * @param c
	 * @return
	 */
	boolean addAll(int index, Collection<? extends E> c)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * リスト内に指定された位置にある要素を返す
	 * @param index
	 * @return
	 */
	E get(int index) throws IndexOutOfBoundsException;

	/**
	 * 指定されたリスト内で最初に検出された位置のインデックスを返す
	 * @param o
	 * @return
	 */
	int indexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * 指定されたリスト内で最後に検出された位置のインデックスを返す
	 * @param o
	 * @return
	 */
	int lastIndexOf(Object o) throws ClassCastException, NullPointerException;

	/**
	 * リスト内の要素を適切な順序で繰り返し処理する反復子を返す
	 * @return
	 */
	ListIterator<E> listIterator();

	/**
	 * リスト内の要素を適切な順序で繰り返し処理する、リスト内の指定された位置から開始する反復子を返す
	 * @param index
	 * @return
	 */
	ListIterator<E> listIterator(int index) throws IndexOutOfBoundsException;

	/**
	 * リスト内の指定された位置にある要素を削除する
	 * @param index
	 * @return
	 */
	E remove(int index) throws UnsupportedOperationException, IndexOutOfBoundsException;

	/**
	 * リスト内の指定された位置にある要素を、指定されたようそに置き換える
	 * @param index
	 * @param element
	 * @return
	 */
	E set(int index, E element)
		throws	UnsupportedOperationException,
				ClassCastException,
				NullPointerException,
				IllegalArgumentException,
				IndexOutOfBoundsException;

	/**
	 * fromからtoまでの範囲の部分を返す
	 * @param fromIndex
	 * @param toIndex
	 * @return
	 */
	List<E> subList(int fromIndex, int toIndex) throws IndexOutOfBoundsException;
}
