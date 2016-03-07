/**
 *
 */
package ch03.ex05;

/**
 * @author mary-mogreen
 *
 */
public class LoopBenchmark extends Benchmark {

	private int loopCount;

	public LoopBenchmark() {
		this.setLoopCount(0);
	}

	public LoopBenchmark(int loopCount) {
		this.setLoopCount(loopCount);
	}

	/**
	 * @return loopCount
	 */
	public int getLoopCount() {
		return loopCount;
	}

	/**
	 * @param loopCount セットする loopCount
	 */
	public void setLoopCount(int loopCount) {
		if (loopCount > -1) {
			this.loopCount = loopCount;
		} else {
			throw new IllegalArgumentException("不正な値");
		}
	}

	/**
	 * loopに要する時間のベンチマーク
	 */
	void benchmark() {
		for (int i = 0; i < this.loopCount; i++) {
		}
	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		int loopCount = Integer.parseInt(args[1]);
		long time = new LoopBenchmark(loopCount).repeat(count);
		System.out.println(loopCount + "loops in " + time / count + "nanoseconds(ave).");
	}

}
