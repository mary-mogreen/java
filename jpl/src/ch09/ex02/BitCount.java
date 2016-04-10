/**
 *
 */
package ch09.ex02;

/**
 * @author mary-mogreen
 *
 */
public class BitCount {

	public static int bitCount(int i) {
		int count = 0;
		while (i != 0) {
			if ((i & 0x01) == 1) {
				count++;
				i = i >>> 1;
			}
		}
		return count;
	}

	/**
	 * JavaのInteger.bitCount?
	 */
//	public static int bitCount(int i) {
//        i = i - ((i >>> 1) & 0x55555555);
//        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
//        i = (i + (i >>> 4)) & 0x0f0f0f0f;
//        i = i + (i >>> 8);
//        i = i + (i >>> 16);
//        return i & 0x3f;
//    }

	public static String intToBinaryString(int i) {
		String binary = Integer.toBinaryString(i);
		for (int j = binary.length(); j < 32; j++)
			binary = 0 + binary;
		return binary.substring(0, 4) + " " + binary.substring(4, 8) + " " + binary.substring(8, 12) + " " + binary.substring(12,  16)
		+ " " + binary.substring(16, 20) + " " + binary.substring(20, 24) + " " + binary.substring(24, 28) + " " + binary.substring(28, 32);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("0x07 => " + BitCount.bitCount(7));
		int i = 12345;
		System.out.println("line: 1");
		System.out.printf("i:\t\t\t%s%n", intToBinaryString(i));
		System.out.printf("i >>> 2:\t%s%n", intToBinaryString(i >>> 2));
		System.out.printf("0x33333333:\t%s%n", intToBinaryString(0x33333333));
		System.out.printf("(i >>> 1) & 0x55555555:%n\t\t\t%s%n", intToBinaryString((i >>> 1) & 0x55555555));
		System.out.printf("i - ((i >>> 1) & 0x55555555):%n\t\t\t%s%n", intToBinaryString(i - ((i >>> 1) & 0x55555555)));
		i = i - ((i >>> 1) & 0x55555555);

		System.out.println("line: 2");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);
		System.out.printf("i >>> 2:\t%s%n", intToBinaryString(i >>> 2));
		System.out.printf("0x33333333:\t%s%n", intToBinaryString(0x33333333));
		System.out.printf("i & 0x33333333:%n\t\t\t%s%n", intToBinaryString(i & 0x33333333));
		System.out.printf("(i >>> 2) & 0x33333333:%n\t\t\t%s%n", intToBinaryString((i >>> 2) & 0x33333333));
		System.out.printf("(i & 0x33333333) + ((i >>> 2) & 0x33333333):%n\t\t\t%s%n", intToBinaryString((i & 0x33333333) + ((i >>> 2) & 0x33333333)));
		i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);

		System.out.println("line: 3");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);
		System.out.printf("i >>> 4:\t%s%n", intToBinaryString(i >>> 4));
		System.out.printf("0x0f0f0f0f:\t%s%n", intToBinaryString(0x0f0f0f0f));
		System.out.printf("i + (i >>> 4):%n\t\t\t%s%n", intToBinaryString(i + (i >>> 4)));
		System.out.printf("(i + (i >>> 4)) & 0x0f0f0f0f0f:%n\t\t\t%s%n", intToBinaryString((i + (i >>> 4)) & 0x0f0f0f0f));
		i = (i + (i >>> 4)) & 0x0f0f0f0f;

		System.out.println("line: 4");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);
		System.out.printf("i >>> 8:\t%s%n", intToBinaryString(i >>> 8));
		System.out.printf("i + (i >>> 8):%n\t\t\t%s%n", intToBinaryString(i + (i >>> 8)));
		i = i + (i >>> 8);

		System.out.println("line: 5");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);
		System.out.printf("i >>> 16:\t%s%n", intToBinaryString(i >>> 16));
		System.out.printf("i + (i >>> 16):%n\t\t\t%s%n", intToBinaryString(i + (i >>> 16)));
		i = i + (i >>> 16);

		System.out.println("line: 6");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);
		System.out.printf("0x3f:\t\t%s%n", intToBinaryString(0x3f));
		System.out.printf("i & 0x3f:\t%s%n", intToBinaryString(i & 0x3f));
		i = i & 0x3f;

		System.out.println("return:");
		System.out.printf("i:\t\t\t%s(%d)%n", intToBinaryString(i), i);

	}

}
