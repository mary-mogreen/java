/**
 *
 */
package ch05.ex02;

/**
 * @author mary-mogreen
 *
 */
public class BankAccount {
	private History history = new History(); //過去10件の処理の履歴
	private long balance; // 現在の残高（単位はyen）
	private long number; // 口座番号

	public class History {
		private int cnt = 0;
		private int nextCnt = 0;
		private final int max = 10;
		private Action[] actions = new Action[max];

		public Action next() {
			Action action = actions[nextCnt];
			nextCnt = (nextCnt + 1) % max;
			return action;
		}

		public void addHistory(String act, long amount) {
			actions[cnt % max] = new Action(act, amount);
			cnt++; //11こめは１こめに追加
			System.out.println(cnt % max);
		}

		public String toString() {
			String desc = number + ":\n";
			for (int i = 9; i >= 0; i--) {
				if (actions[i] != null)
					desc += actions[i] + "\n";
			}
			return desc;
		}

	}


	public class Action {
		private String act;
		private long amount;

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			return act + " " + amount;
		}

	}



	public History history() {
		return history;
	}



	public void deposit(long amount) throws IllegalArgumentException {
		if (amount > 0) {
			balance += amount;
			history.addHistory("deposit", amount);
		} else
			throw new IllegalArgumentException();
	}



	public void withdraw(long amount) throws IllegalArgumentException {
		if (amount > 0) {
			balance -= amount;
			history.addHistory("withdraw", amount);
		} else
			throw new IllegalArgumentException();
	}

	public void transfer(BankAccount other, long amount) {
		other.withdraw(amount);
		deposit(amount);
		history.addHistory("transfer", amount);
		other.history.addHistory("transfer", amount);
	}

}
