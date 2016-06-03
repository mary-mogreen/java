/**
 * 
 */
package ch14.ex09;

/**
 * @author mary-mogreen
 *
 */
public class ThreadHierarchie {

	/**
	 * 受け取ったスレッドグループ内のスレッドとスレッドグループの階層を定期的に表示するスレッドを開始する。
	 * @param tg
	 */
	public void showThreadGroupHierarchie(final ThreadGroup tg) {
		new Thread(() -> {
			for (;;) {
				showThreads(tg, 0);
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					break;
				}
			}
		}).start();
	}
	
	/**
	 * 再帰的にスレッドグループ内直下のスレッドを表示する
	 * @param tg
	 * @param kaisou 現在の階層
	 */
	private void showThreads(ThreadGroup tg, int kaisou) {
		StringBuilder sb = new StringBuilder();
		if (kaisou == 0)
			System.out.println(tg.getName());
		for (int i = 0; i < kaisou; i++)
			sb.append("  ");
		int allThreads = tg.activeCount();
		Thread[] threads = new Thread[allThreads];
		int setThreads = tg.enumerate(threads, false);
		for (int i = 0; i < setThreads; i++) {
			System.out.println(sb.toString() + "|- " + threads[i].getName());
		}
		int allSubGroup = tg.activeGroupCount();
		ThreadGroup[] subGroups = new ThreadGroup[allSubGroup];
		int setSubGroup = tg.enumerate(subGroups, false);
		for (int i = 0; i < setSubGroup; i++) {
			System.out.println(sb.toString() +"|- " + subGroups[i].getName());
			showThreads(subGroups[i], kaisou+1);
		}
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup grp = new ThreadGroup("Parent");
		ThreadGroup grp2 = new ThreadGroup(grp, "Children2");
		ThreadGroup grp21 = new ThreadGroup(grp2, "Grandson2-1");
		ThreadGroup grp22 = new ThreadGroup(grp2, "Grandson2-2");
		ThreadGroup grp221 = new ThreadGroup(grp22, "Great-Grandson2-2-1");
		ThreadGroup grp3 = new ThreadGroup(grp, "Children3");
		
		// Parentのスレッド
		for (int i = 0; i < 3; i++) {
			new Thread(grp, () -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		// Children2のスレッド
		for (int i = 3; i < 7; i++) {
			new Thread(grp2, () -> {
				try {
					Thread.sleep(10500);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		// Grandson2-1のスレッド
		for (int i = 7; i < 10; i++) {
			new Thread(grp21, () -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		// Grandson2-2のスレッド
		for (int i = 10; i < 12; i++) {
			new Thread(grp22, () -> {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		// Great-Grandson2-2-1
		for (int i = 12; i < 20; i++) {
			new Thread(grp221, () -> {
				try {
					Thread.sleep(5005);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		// Children3のスレッド
		for (int i = 20; i < 24; i++) {
			new Thread(grp3, () -> {
				try {
					Thread.sleep(5600);
				} catch (InterruptedException e) {
					// e.printStackTrace();
				}
			}, "th" + i).start();
		}
		
		new ThreadHierarchie().showThreadGroupHierarchie(grp);
		
	}

}
