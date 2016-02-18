/**
 *
 */
package ch01.ex15;

/**
 * @author mary-mogreen
 *
 */
public class SimpleLookup implements ExtendedLookup {
	static final int MAX = 10;

	private String[] names = new String[MAX];
	private Object[] values = new Object[MAX];

	/**
	 * 名前から探す
	 * @param name
	 * @return {Object}
	 */
	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (name.equals(names[i]))
				return values[i];
		}
		return null;
	}

	/**
	 * 名前と値を設定する
	 * @param name
	 * @param value
	 */
	public void add(String name, Object value) {
		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				values[i] = value;
				return;
			}
		}
		System.out.println("can not add (" + name + ": " + value + ")");
	}

	/**
	 * 名前から削除する
	 * @param name
	 */
	public Object remove(String name) {
		for (int i = 0; i < names.length; i++) {
			if (name.equals(names[i])) {
				names[i] = null;
				return values[i];
			}
		}
		return null;
	}
}
