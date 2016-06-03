/**
 * 
 */
package ch14.ex08;

/**
 * @author mary-mogreen
 *
 */
public class SafeScenario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final SafeFriendly jareth = new SafeFriendly("jareth");
		final SafeFriendly cory = new SafeFriendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(() -> {jareth.hug();}, "Thread1").start();
		
		new Thread(() -> {cory.hug();}, "Thread2").start();

	}	
}
