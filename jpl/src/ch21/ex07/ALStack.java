/**
 * 
 */
package ch21.ex07;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * @author mary-mogreen
 *
 */
public class ALStack<E> {
	private final List<E> stack = new ArrayList<E>();
	
	/**
	 * スタックへオブジェクトを追加する
	 * @param e
	 * @return 追加したオブジェクト
	 */
	public E push(E e) {
		stack.add(0, e);
		return e;
	}
	
	/**
	 * スタックからトップの要素を取り除く
	 * @return 取り出した要素
	 */
	public E pop() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		return stack.remove(0);
	}
	
	/**
	 * スタックのトップの要素を取り除くことなく返す
	 * @return スタックのトップの要素
	 */
	public E peek() {
		if (stack.isEmpty())
			throw new EmptyStackException();
		return stack.get(0);
	}
	
	/**
	 * スタックが空であればtrueを返す。
	 * @return
	 */
	public boolean empty() {
		return stack.isEmpty();
	}
	
	/**
	 * スタックの先頭からのオブジェクトの距離
	 * 1であればスタックの先頭
	 * オブジェクトが見つからなければ，-1を返す
	 * @param e
	 * @return
	 */
	public int search(E e) {
		int index = stack.indexOf(e);
		if (index != -1)
			return index + 1;
		return index;
	}
	
}
