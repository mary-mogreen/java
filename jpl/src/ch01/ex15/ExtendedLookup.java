/**
 *
 */
package ch01.ex15;

/**
 * @author mary-mogreen
 *
 */
public interface ExtendedLookup extends Lookup {
	/**
	 * nameと値を関連付けて追加する
	 */
	void add(String name, Object value);

	/**
	 * nameと関連付けられた値を削除する
	 * 削除した値を返す
	 * そのような値がなければnullを返す
	 */
	Object remove(String name);
}
