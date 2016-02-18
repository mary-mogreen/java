/**
 *
 */
package ch02.ex16;

/**
 * LinkedListの要素
 * @author mary-mogreen
 *
 */
public class Node {
	private Object value;
	private Node nextNode;

	Node() {
		value = null;
		nextNode = null;
	}

	Node(Object value) {
		this.value = value;
		nextNode =null;
	}

	/**
	 * valueを取得する
	 */
	public Object getValue() {
		return value;
	}

	/**
	 * valueをセットする
	 * @param value
	 */
	public void setValue(Object value) {
		this.value = value;
	}

	/**
	 * 次のNodeを取得する
	 * @return
	 */
	public Node getNextNode() {
		return nextNode;
	}

	/**
	 * 次のNodeをセットする
	 * @param nextNode
	 */
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	/**
	 * toString
	 */
	public String toString() {
		String desc = "this: " + value + "\n";
		if (nextNode != null)
			desc += "next: " + nextNode.value;
		return desc;
	}
}
