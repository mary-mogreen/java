/**
 * 
 */
package ch14.ex08;

/**
 * @author mary-mogreen
 * 共有オブジェクトで同期を取らせる
 */
public class SafeFriendly {
	private static Object lock = new Object();
	private SafeFriendly partner;
	private String name;
	
	public SafeFriendly(String name) {
		this.name = name;
	}
	
	public void hug() {
		synchronized(lock) {
			System.out.println(Thread.currentThread().getName() +
					" in " + name + ".hug() trying to invoke " +
					partner.name + ".hugBack()");
			partner.hugBack();
		}
	}
	
	private void hugBack() {
		synchronized(lock) {
			System.out.println(Thread.currentThread().getName() +
					" in " + name + ".hugBack()");
		}
	}
	
	public void becomeFriend(SafeFriendly partner) {
		this.partner = partner;
	}
}
