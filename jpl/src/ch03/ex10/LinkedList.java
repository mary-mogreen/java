/**
 *
 */
package ch03.ex10;

/**
 * @author mary-mogreen
 * 3章で作り直し
 */
public class LinkedList implements Cloneable {
	private Node header;

	/**
	 * 空の連結リスト
	 */
	public LinkedList() {
		header = null;
	}

	/**
	 * 先頭のノードを作成して初期化
	 * @param value
	 */
	public LinkedList(Object value) {
		add(value);
	}

	/**
	 * リストの先頭の値を返す
	 * @return value
	 */
	public Object getHeader() {
		if (header == null)
			return null;
		else
			return header.value;
	}

	/**
	 * 最後尾のNodeを返す。
	 * @return tailNode
	 */
	protected Node getTailNode() {
		if (header == null)
			return null;
		else {
			Node node = header;
			while(node.next != null)
				node = node.next;
			return node;
		}
	}

	/**
	 * リストの最後尾の値を返す
	 * @return value
	 */
	public Object getTail() {
		Node tailNode = getTailNode();
		if (tailNode == null)
			return null;
		else
			return tailNode.value;
	}



	/**
	 * リストのサイズを返す
	 * @return size
	 */
	public int size() {
		if (header == null)
			return 0;
		else {
			Node node = header;
			int size = 1;
			while(node.next != null) {
				size++;
				node = node.next;
			}
			return size;
		}
	}

	/**
	 * 最後尾にノードを追加する。
	 * @param value
	 */
	public void add(Object value) {
		if (value == null)
			throw new IllegalArgumentException("nullだめ");
		else {
			Node tailNode = getTailNode();
			if (tailNode == null)
				header = new Node(value);
			else
				tailNode.next = new Node(value);
		}
	}

	/**
	 * 指定された位置の値を返す。存在しなければnullを返す。
	 * @param index
	 * @return Node
	 */
	protected Node getNode(int index) {
		if (header == null)
			return null;
		else if (index == 0)
			return header;
		else {
			Node node = header;
			int i = 0;
			while (node != null) {
				if (i == index)
					return node;
				i++;
				node = node.next;
			}
			return null;
		}
	}

	/**
	 * 指定された位置の値を返す。存在しなければnullを返す。
	 * @param index
	 * @return value
	 */
	public Object get(int index) {
		Node node = getNode(index);
		if (node == null)
			return null;
		else
			return node.value;
	}

	/**
	 * 指定された位置の値を置き換える。
	 * 指定された位置にノードが存在しなければnullを返す。
	 * 成功時、置き換えられる前の値を返す。
	 * 引数にnullを与えると例外
	 * @param index
	 * @param value
	 * @return oldValue
	 */
	public Object set(int index, Object value) {
		Node node = getNode(index);
		if (node == null)
			return null;
		else if (value == null)
			throw new IllegalArgumentException("nullはダメ");
		else {
			Object oldValue = node.value;
			node.value = value;
			return oldValue;
		}
	}

	/**
	 * 値が存在するか
	 * @param value
	 * @return true or false
	 */
	public boolean contains(Object value) {
		if (header == null)
			return false;
		else {
			Node node = header;
			while (node != null) {
				if (node.value.equals(value))
					return true;
				node = node.next;
			}
			return false;
		}
	}

	/**
	 * すべてのノードを複製する
	 */
	public LinkedList clone() {
		try {
			LinkedList list = (LinkedList) super.clone();
			if (list.header == null)
				return list;
			else {
				Node sourceNode = header;
				Node node = sourceNode.clone();
				list.header = node;
				while (sourceNode.next != null) {
					node.next = sourceNode.next.clone();
					node = node.next;
					sourceNode = sourceNode.next;
				}
				return list;
			}
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}

	@Override
	public String toString() {
		if (header == null)
			return "empty";
		else {
			String desc = "header: " + header + "\n";
			Node node = header.next;
			while (node != null) {
				desc += "-> " + node + "\n";
				node = node.next;
			}
			return desc;
		}
	}

	class Node implements Cloneable {
		private Object value;
		private Node next;

		/**
		 * オブジェクト型のフィールドにセット
		 * @param value
		 */
		Node(Object value) {
			this(value, null);
		}

		/**
		 * オブジェクト型のフィールドと次のノードへの参照をセット
		 * @param value
		 * @param next
		 */
		Node(Object value, Node next) {
			this.value = value;
			this.next = next;
		}

		@Override
		public String toString() {
			return value.toString();
		}

		/**
		 * ノードの複製を許可する
		 */
		public Node clone() {
			try {
				Node node =  (Node) super.clone();
				if (node.next != null)
					node.next = null;
				return node;
			} catch (CloneNotSupportedException e) {
				throw new InternalError(e.toString());
			}
		}
	}
}
