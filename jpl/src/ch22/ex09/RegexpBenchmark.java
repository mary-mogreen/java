package ch22.ex09;

public class RegexpBenchmark {
	private static final String PATTERN1 = "(.*),(.*)";
	private static final String PATTERN2 = "([^,]*),([^,]*)";
	private static final String PATTERN3 = "(.+),(.+)";
	private static final String PATTERN4 = "(.+?),(.+?)";

	private static final String CSV1 = "1, 2";
	private static final String CSV2 = "jaljughobnose214u9358290q920u9503hfinjg,briepwhfshg";
	
	
	private static final int COUNT = 100000; 
	
	private static long match(String csvStr, String regex) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < COUNT; i++) {
			csvStr.matches(regex);		
		}
		long end = System.currentTimeMillis();
		return (end - start);
	}
	
	public static void main(String[] args) {
		System.out.println("パターン1(短): " + match(CSV1, PATTERN1) + "ms." + " (長): " + match(CSV2, PATTERN1) + "ms.");
		System.out.println("パターン2(短): " + match(CSV1, PATTERN2) + "ms." + " (長): " + match(CSV2, PATTERN2) + "ms.");
		System.out.println("パターン3(短): " + match(CSV1, PATTERN3) + "ms." + " (長): " + match(CSV2, PATTERN3) + "ms.");
		System.out.println("パターン4(短): " + match(CSV1, PATTERN4) + "ms." + " (長): " + match(CSV2, PATTERN4) + "ms.");
	}
}
