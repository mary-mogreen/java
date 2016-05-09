/**
 *
 */
package ch11.ex02;

/**
 * @author mary-mogreen
 *
 */
public class AttrAsGeneric<T> {
	private final String name;
	private T value = null;

	public AttrAsGeneric(String name) {
		this.name = name;
	}

	public AttrAsGeneric(String name, T value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public T getValue() {
		return value;
	}

	public T setValue(T newValue) {
		T oldValue = value;
		value = newValue;
		return oldValue;
	}

	@Override
	public String toString() {
		return name + "='" + value + "'";
	}

}
