package ch02.ex14;

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

	/**
	 * LinkedListの最後尾に追加する
	 * @param value
	 */
	public void add(Object value) {
		Node tailNode = getTailNode();
		tailNode.setNextNode(new Node(value));
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




	public static void main(String[] args) {
		LinkedList list = new LinkedList(new Vehicle("mary"));
		list.add(new Vehicle("mogreen"));
		list.add(new Vehicle("oyu"));
		System.out.println("Header: " + list.getHeaderNode());
		System.out.println("Tail: " + list.getTailNode());
		System.out.println("LinkedList: " + list);

	}
}
