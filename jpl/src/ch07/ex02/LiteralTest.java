/**
 *
 */
package ch07.ex02;

/**
 * @author mary-mogreen
 *
 */
public class LiteralTest {

	boolean boolLiteral = false;
	char charLiteral = 'a';
	byte byteLiteral = 100;
	short shortLiteral = 1000;
	int intLiteral = 10000;
	long longLiteral = 500L;
	float floatLiteral = 100.0f;
	double doubleLiteral = 100.0d;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LiteralTest literal = new LiteralTest();

		//intにfloatは出来ません
		//literal.intLiteral = 32.0f;

		//intにbyte
		literal.intLiteral = literal.byteLiteral;
		System.out.printf("int: %d%n", literal.intLiteral);

		//intにshort
		literal.intLiteral = literal.shortLiteral;
		System.out.printf("int: %d%n", literal.intLiteral);

		//intにlong
		literal.intLiteral = (int)literal.longLiteral;
		System.out.printf("int: %d%n", literal.intLiteral);

		//byteに200
		literal.byteLiteral = (byte)200;
		System.out.printf("byte: %d%n", literal.byteLiteral);

		//floatにdouble
		literal.floatLiteral = (float)1.23456789d;
		System.out.println("float: " + literal.floatLiteral);

		//doubleにfloat
		literal.doubleLiteral = 1.23456789f;
		System.out.println("double: " + literal.doubleLiteral);



	}

}
