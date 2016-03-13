/**
 *
 */
package ch03.ex07;

/**
 * @author mary-mogreen
 *
 */
public class ColorAttr extends Attr {
	private ScreenColor myColor;

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue) {
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor() {
		return myColor;
	}

	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	/**
	 * 同値性に基づき、等しいかどうか判断する
	 */
	public boolean equals(Object obj) {
		String my = myColor.toString();
		String other = ((ColorAttr)obj).getColor().toString();
		if (my.equals(other))
			return true;
		else
			return false;
	}

	/**
	 * ScreenColorが返す文字列によってhashcodeを決定する。
	 */
	public int hashCode() {
		return myColor.toString().hashCode();
	}

	public static void main(String[] args) {
		ColorAttr ca1 = new ColorAttr("red");
		ColorAttr ca2 = new ColorAttr("green");
		System.out.println(ca1.equals(ca2));
		System.out.println("red: " + ca1.hashCode() + ", greeen: " + ca2.hashCode());
	}
}
