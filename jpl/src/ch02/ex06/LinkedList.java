package ch02.ex06;

/**
 * @author mary-mogreen
 * LinkedListはObject型のフィールドと、リストの中で次のLinkedList要素への参照を持つ
 */
public class LinkedList {
	public Object value;
	public LinkedList next;

	public static void main(String[] args) {
		LinkedList[] lists = new LinkedList[3];
		for (int i = 0; i < 3; i++) {
			Vehicle vehicle = new Vehicle();
			vehicle.speed = 100.0 * (i + 1);
			vehicle.angle = ((i + 1) * 90.0);
			vehicle.name = "owner" + i;
			vehicle.id = Vehicle.nextID++;
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
			((Vehicle)next.value).printVehicleInfo();
			next = next.next;
		}

	}
}
