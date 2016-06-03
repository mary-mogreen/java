/**
 * 
 */
package ch14.ex08;

/**
 * @author mary-mogreen
 *
 */
public class DeadLockScenario {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");
		
		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);
		
		new Thread(() -> {jareth.hug();}, "Thread1").start();
		
		new Thread(() -> {cory.hug();}, "Thread2").start();

	}

	// Mac
	// 1回目
	// Thread1 in jareth.hug() trying to invoke cory.hugBack()
	// Thread2 in cory.hug() trying to invoke jareth.hugBack()

	
	// 2回目〜10回目の結果
	// Thread1 in jareth.hug() trying to invoke cory.hugBack()
	// Thread1 in cory.hugBack()
	// Thread2 in cory.hug() trying to invoke jareth.hugBack()
	// Thread2 in jareth.hugBack()
	
	
}
