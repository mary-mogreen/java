/**
 *
 */
package ch13.ex04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mary-mogreen
 *
 */
public class TypeValue {

	/**
	 *
	 * @param lines "type value\\n"となっているような複数の行
	 * @return 指定された型・値をもつArrayList
	 * @throws InvalidLineException "type value"が適切でないとき
	 * @throws NullPointerException 入力文字列がnullの場合
	 * @throws NumberFormatException 数値に変換できないvalueのとき
	 */
	public static List<Object> readTypeValueLine(String lines) throws InvalidLineException, NullPointerException, NumberFormatException {
		if (lines == null)
			throw new NullPointerException("lines is null");
		List<Object> list = new ArrayList<>();
		List<String> splitLines = Arrays.asList(lines.split("\n"));
		System.out.println(splitLines);
		for (String line: splitLines) {
			List<String> pair = Arrays.asList(line.split(" "));
			switch (pair.get(0)) {
			case "Boolean":
				list.add(new Boolean(pair.get(1)));
				break;
			case "Character":
				list.add(new Character(pair.get(1).charAt(0)));
				break;
			case "Byte":
				list.add(new Byte(pair.get(1)));
				break;
			case "Short":
				list.add(new Short(pair.get(1)));
				break;
			case "Integer":
				list.add(new Integer(pair.get(1)));
				break;
			case "Long":
				list.add(new Long(pair.get(1)));
				break;
			case "Float":
				list.add(new Float(pair.get(1)));
				break;
			case "Double":
				list.add(new Double(pair.get(1)));
				break;
			default:
				throw new InvalidLineException(line);
			}
		}
		return list;
	}

}
