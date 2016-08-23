/**
 * 
 */
package ch22.ex05;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * @author mary-mogreen
 *
 */
public class Dice {

	public static final int RANDOM = 0;
	public static final int MATH_RANDOM = 1;
	private int count;
	Map<Integer, Integer> wa = new HashMap<>();
	
	
	public Dice(int count) {
		this.count = count;
		init();
	}
	
	private void init() {
		for (int i = count; i < count * 6; i++)
			wa.put(i, 0);
	}
	
	public void show() {
		init();
		int[] p = new int[count * 6];
		Arrays.fill(p, 0);
		int[][] dp = new int[2][];
		dp[0] = p;
		dp[1] = p.clone();
		for (int i = 0; i < 6; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i < count; i++) {
			int[] d = new int[count * 6];
			Arrays.fill(d, 0);
			dp[i % 2] = d;
			for (int j = 0; j < (count * 6 - 1); j++) {
				dp[i % 2][j + 1] += dp[(i - 1) % 2][j];
				if (j + 6 + 1 < count * 6)
					dp[i % 2][j + 6 + 1] -= dp[(i - 1) % 2][j];
			}
			int cur = 0;
			for (int j = 0; j < count * 6; j++) {
				cur += dp[i % 2][j];
				dp[i % 2][j] = cur;
			}	
		}
		
//		for (int i = 0; i < dp.length; i++) {
//			for (int j = 0; j < dp[i].length; j++)
//				System.out.println("(" + i + ", " + j + "): " + dp[i][j]);
//		}
		
		for (int j = count - 1; j < dp[1 - (count % 2)].length; j++) {
				wa.put(j + 1, dp[1 - (count % 2)][j]);
				// System.out.println("i: " + i + ", j: " + j + ", " + dp[i][j]);
		}
		
		for (Entry<Integer, Integer> e: wa.entrySet()) {
			System.out.printf("%d: %d (%f)%n", e.getKey(), e.getValue(), (float)(e.getValue() / (Math.pow(6, count))));
		}
		
		
	}
	
	public void simulate(long times, int r) {
		init();
		for (long l = 0; l < times; l++) {
			int sum = 0;
			for (int i = 0; i < this.count; i++) {
				if (r == RANDOM)
					sum += new Random().nextInt(6) + 1;
				else
					sum += (Math.random() * 100) % 6 + 1;
			}
			wa.put(sum, wa.get(sum) + 1);
		}
		
		for (Entry<Integer, Integer> e: wa.entrySet()) {
			System.out.printf("%d: %d (%f)%n", e.getKey(), e.getValue(), (float)(e.getValue() / (float)times));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Dice sd = new Dice(10);
		
		System.out.println("和: 組合せ (確率)");
		
		System.out.println("↓理論的確率");
		sd.show();
		
		System.out.println("和: 出た回数 (確率)");
		System.out.println("↓サイコロ振った（Randomクラス）");
		sd.simulate(10000L, Dice.RANDOM);
		
		System.out.println("↓サイコロ振った（Math.random）");
		sd.simulate(10000L, Dice.MATH_RANDOM);
		

	}

}
