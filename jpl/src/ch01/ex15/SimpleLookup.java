/**
 *
 */
package ch01.ex15;

/**
 * @author mery-mogreen
 *
 */
public class SimpleLookup implements ExtendedLookup {
	static final int MAX = 10;

	private String[] names = new String[MAX];
	private Object[] values = new Object[MAX];

	public Object find(String name) {
		for (int i = 0; i < names.length; i++) {
			if (name.equals(names[i]))
				return values[i];
		}
		return null;
	}

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
