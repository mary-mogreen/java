/**
 *
 */
package ch04.ex02;

/**
 * @author mary-mogreen
 * SortHaenessの実装Stringオブジェクト用
 *
 */
public class SortString extends SortHarness {

	@Override
	public void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = i + 1; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
	}

	@Override
	public int doCompare(Object value1, Object value2) {
		String str1 = (String) value1;
		String str2 = (String) value2;
		return str1.compareTo(str2);
	}

}
