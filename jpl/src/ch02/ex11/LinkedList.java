package ch02.ex11;

/**
 * @author mary-mogreen
 * LinkedListはObject型のフィールドと、リストの中で次のLinkedList要素への参照を持つ
 */
public class LinkedList {
	public Object value;
	public LinkedList next;

	/**
	 * 初期化
	 */
	public LinkedList() {
		next = null;
	}

	/**
	 * 値のみ初期化
	 * @param value
	 */
	public LinkedList(Object value) {
		this.value = value;
	}

	/**
	 * 値と次のLinkedListを初期化
	 * @param value
	 * @param next
	 */
	public LinkedList(Object value, LinkedList next) {
		this.value = value;
		this.next = next;
	}

	/**
	 * toString
	 */
	public String toString() {
		String desc = "this: " + value + "\n";
		if (next != null)
			desc += "next: " + next.value;
		return desc;
	}

	public static void main(String[] args) {
		LinkedList[] lists = new LinkedList[3];
		for (int i = 0; i < 3; i++) {
			Vehicle vehicle = new Vehicle("owner" + i);
			vehicle.speed = 100.0 * (i + 1);
			vehicle.angle = ((i + 1) * 90.0);
			lists[i] = new LinkedList();
			lists[i].value = vehicle;
		}
		for (int i = 0; i < 3; i++) {
			if (i + 1 < 3) {
				lists[i].next = lists[i + 1];
			} else {
				lists[i].next = null;
			}
		}

		LinkedList next = lists[0];
		while (next != null) {
			System.out.println("LinkedList: " + next);
			next = next.next;
		}

	}
}
