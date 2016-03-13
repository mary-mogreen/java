package ch04.ex03;

public interface LinkedListInerface {

	/**
	 * リストのサイズを返す
	 * @return size
	 */
	int size();

	/**
	 * 最後尾にノードを追加する。
	 * @param value
	 */
	void add(Object value);

	/**
	 * 指定された位置の値を返す。存在しなければnullを返す。
	 * @param index
	 * @return value
	 */
	Object get(int index);

	/**
	 * 指定された位置の値を置き換える。
	 * 指定された位置にノードが存在しなければnullを返す。
	 * 成功時、置き換えられる前の値を返す。
	 * 引数にnullを与えると例外
	 * @param index
	 * @param value
	 * @return oldValue
	 */
	Object set(int index, Object value);

	/**
	 * 値が存在するか
	 * @param value
	 * @return true or false
	 */
	boolean contains(Object value);

}