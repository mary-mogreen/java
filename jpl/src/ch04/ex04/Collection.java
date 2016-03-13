/**
 *
 */
package ch04.ex04;

import java.util.Iterator;

/**
 * @author mary-mogreen
 * Java Platform SE5.0 Documentより
 */
public interface Collection<E> {
	/**
	 * コレクションが指定した要素を格納
	 * @param o
	 * @return
	 */
	boolean add(E o)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * 指定されたコレクションのすべての要素をこのコレクションに追加
	 * @param c
	 * @return
	 */
	boolean addAll(Collection<? extends E> c)
			throws	UnsupportedOperationException,
					ClassCastException,
					NullPointerException,
					IllegalArgumentException;

	/**
	 * コレクションからすべての要素を削除
	 */
	void clear() throws UnsupportedOperationException;

	/**
	 * コレクションに指定された要素がある場合にtrue
	 * @param o
	 * @return
	 */
	boolean contains(Object o) throws ClassCastException, NullPointerException;

	/**
	 * コレクション内に指定されたコレクションがすべてある場合にtrue
	 * @param c
	 * @return
	 */
	boolean containsAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException;

	/**
	 * 指定されたオブジェクトとこのコレクションが等しいかどうか
	 * @param o
	 * @return
	 */
	@Override
	boolean equals(Object o);

	/**
	 * コレクションのハッシュコード値を返す
	 * @return
	 */
	@Override
	int hashCode();

	/**
	 * コレクションに要素がない場合にtrue
	 * @return
	 */
	boolean isEmpty();

	/**
	 * コレクションの要素の反復子を返す
	 * @return
	 */
	Iterator<E> iterator();

	/**
	 * 指定された要素の1つのインスタンスがこのコレクション内にある場合、それをこのコレクションから削除
	 * @param o
	 * @return
	 */
	boolean remove(Object o)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * 指定されたコレクションにも格納されているこの子rくしょんのすべての要素を削除
	 * @param c
	 * @return
	 */
	boolean removeAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;

	/**
	 * このコレクションにおいて、指定されたコレクションに格納されている要素だけを保持
	 * @param c
	 * @return
	 */
	boolean retainAll(Collection<?> c)
		throws	ClassCastException,
				NullPointerException,
				UnsupportedOperationException;


	/**
	 * コレクションの要素数を返す
	 * @return
	 */
	int size();

	/**
	 * コレクションのすべての要素が格納されている配列を返す
	 * @return
	 */
	Object[] toArray();

	/**
	 * このコレクション内のすべての要素を保持する配列を返す
	 * @param a
	 * @return
	 */
	<T> T[] toArray(T[] a) throws ArrayStoreException, NullPointerException;


}
