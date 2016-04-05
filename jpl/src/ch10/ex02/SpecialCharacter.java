/**
 *
 */
package ch10.ex02;

/**
 * @author mary-mogreen
 *
 */
public class SpecialCharacter {

	public static String returnSpecialCharacter(String str) {
		String result = "";
		for (char c: str.toCharArray()) {
			switch (c) {
			case '\n':
				result += "\\\"";
				break;
			case '\t':
				result += "\\t";
				break;
			case '\b':
				result += "\\b";
				break;
			case '\r':
				result += "\\r";
				break;
			case '\\':
				result += "\\\\";
				break;
			case '\'':
				result += "\\\'";
				break;
			case '\"':
				result += "\\\"";
				break;
			default:
				result += "\\" + Integer.toOctalString(Character.getNumericValue(c));
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aiueo\t\najidjigjr\"\'\rds\b";
		String str2 = SpecialCharacter.returnSpecialCharacter(str);
		System.out.println("str: " + str + "=> SpecialCharacter: " + str2);
	}

}
