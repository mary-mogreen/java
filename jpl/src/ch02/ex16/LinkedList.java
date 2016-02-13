package ch02.ex16;

/**
 * @author mary-mogreen
 * LinkedListはObject型のフィールドと、リストの中で次のLinkedList要素(Node)への参照を持つ
 *
 */
public class LinkedList {
	private Node header;

	/**
	 * 初期化
	 */
	public LinkedList() {
		this.header = new Node();
	}

	/**
	 * 値のみ初期化
	 * @param value
	 */
	public LinkedList(Object value) {
		this.header = new Node(value);
	}


	public String toString() {
		String desc = "header -> " + header.getValue() + "\n";
		Node next = header.getNextNode();
		while (next != null) {
			desc += " -> " + next.getValue() + "\n";
			next = next.getNextNode();
		}
		desc += "-> tail";
		return desc;
	}

	public void add(Object value) {
		Node tailNode = getTailNode();
		tailNode.nextNode = new Node(value);
	}

	/**
	 * LinkedListの先頭のNodeを取得する
	 * @return
	 */
	public Node getHeaderNode() {
		return header;
	}
	/**
	 * LinkedListの最後尾のNodeを取得する
	 * @return
	 */
	public Node getTailNode() {
		Node next = header;
		while(next.getNextNode() != null)
			next = next.getNextNode();
		return next;
	}

	/**
	 * LinkedListの現在の要素数を返す
	 * @return
	 */
	public int size() {
		int size = 1;
		Node next = this.header;
		while (next.getNextNode() != null) {
			next = next.getNextNode();
			size++;
		}
		return size;
	}


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
		 * valueをセットする(不要？)
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
		 * 次のNodeをセットする(持つべきでない)
		 * LinkedListが次のNodeをセットすることがあっても、外から出来るようにしてはいけない。
		 * LinkedListの途中に挿入する場合は、単純にnextNodeを変更するだけでなく、
		 * 前のNodeのnextNodeを変更するなど複雑な処理が必要になるため。
		 * @param nextNode
		 */
//		public void setNextNode(Node nextNode) {
//			this.nextNode = nextNode;
//		}

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


	public static void main(String[] args) {
		LinkedList list = new LinkedList(new Vehicle("mary"));
		list.add(new Vehicle("mogreen"));
		list.add(new Vehicle("oyu"));

		System.out.println("LinkedList: " + list);
		System.out.println("Size: " + list.size());

	}
}
