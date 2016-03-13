/**
 *
 */
package ch05.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import ch05.ex02.BankAccount.Action;
import ch05.ex02.BankAccount.History;

/**
 * @author mary-mogreen
 *
 */
public class BankAccountTest {

	@Test
	public void testHistory0() {
		BankAccount ba = new BankAccount();
		assertThat(ba.history().next(), is((Action)null));
	}

	@Test
	public void testHistory6() {
		BankAccount ba = new BankAccount();
		for (int i = 0; i < 6; i++) {
			ba.deposit(10000L);
		}
		History history = ba.history();
		System.out.println(history);
		Action action = ba.new Action("deposit", 10000L);
		for (int i = 0; i < 6; i++) {
			assertThat(history.next().toString(), is(action.toString()));
		}
		//7こ目はなし
		assertThat(history.next(), is((Action)null));
	}

	@Test
	public void testHistory11() {
		BankAccount ba = new BankAccount();
		for (int i = 0; i < 10; i++) {
			ba.deposit(10000L);
		}
		System.out.println("11こめ追加");
		ba.withdraw(2000L);
		History history = ba.history();
		System.out.println(history);
		Action action = ba.new Action("deposit", 10000L);
		Action wdAction = ba.new Action("withdraw", 2000L);
		// 配列の順番的には11個目は先頭に来る。
		assertThat(history.next().toString(), is(wdAction.toString()));
		for (int i = 0; i < 9; i++) {
			assertThat(history.next().toString(), is(action.toString()));
		}

	}

}
