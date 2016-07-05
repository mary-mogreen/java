/**
 * 
 */
package ch17.ex01;

/**
 * @author mary-mogreen
 *
 * 結果
 * 【起動時】 Free Memory: 126248336
 * 【オブジェクト生成後】 Free Memory: 101609224
 * 【GC呼び出し後】 Free Memory: 127821184
 *
 */
public class GarbageCollectionTest {

	public static void checkFreeMemory() {
		System.out.println("Free Memory: " + Runtime.getRuntime().freeMemory());
	}
	
	public static void checkFreeMemory(String str) {
		System.out.print("【" + str + "】 ");
		checkFreeMemory();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		checkFreeMemory("起動時");
		for (int i = 0; i < 1000000; i++) {
			new String("Number" + i);
		}
		checkFreeMemory("オブジェクト生成後");
		Runtime.getRuntime().gc();
		checkFreeMemory("GC呼び出し後");
		
	}

}
