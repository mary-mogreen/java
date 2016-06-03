/**
 * 
 */
package ch14.ex08;

/**
 * @author mary-mogreen
 *
 */
public class Friendly {

	private Friendly partner;
	private String name;
	
	public Friendly(String name) {
		this.name = name;
	}
	
	public synchronized void hug() {
		System.out.println(Thread.currentThread().getName() +
				" in " + name + ".hug() trying to invoke " +
				partner.name + ".hugBack()");
		Thread.yield(); // デッドロック頻発！！！！
		partner.hugBack();
	}
	
	private synchronized void hugBack() {
		System.out.println(Thread.currentThread().getName() +
				" in " + name + ".hugBack()");
	}
	
	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}
}
