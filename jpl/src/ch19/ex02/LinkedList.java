/**
 * 
 */
package ch19.ex02;

/**
 * 単方向の連結リスト
 * 
 * @author mary-mogreen
 *
 */
public class LinkedList {
	
	/** 要素の値 */
	private Object element;

	/** 次の要素への参照 */
	private LinkedList next;
	
	/**
	 * 
	 * @param element 要素に設定する値
	 */
	public LinkedList(Object element) {
		this.element = element;
	}
	
	/**
	 * 
	 * @param element 要素に設定する値
	 * @param next 次の要素
	 */
	public LinkedList(Object element, LinkedList next) {
		this.element = element;
		this.next = next;
	}
	
	
	/**
	 * この要素の値を返す。
	 * @return この要素の値
	 */
	public Object getElement() {
		return element;
	}

	/**
	 * この要素の値を指定した値で上書きする。
	 * @param element この要素に新たに設定する値
	 */
	public void setElement(Object element) {
		this.element = element;
	}

	/**
	 * この要素に連結されている次の要素を取得する。
	 * @return 次の要素，なければ null
	 */
	public LinkedList getNext() {
		return next;
	}

	/**
	 * 指定した要素をこの要素の後ろに連結する。
	 * @param next 連結する要素
	 */
	public void setNext(LinkedList next) {
		this.next = next;
	}
	
	/**
	 * 連結リストの要素の数を返す。
	 * @return 要素の数
	 */
	public int size() {
		int size = 0;
		LinkedList list = this;
		while (list != null) {
			size++;
			list = list.getNext();
		}
		return size;
	}

}
