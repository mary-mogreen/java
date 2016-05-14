/**
 *
 */
package ch11.ex03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import ch11.ex02.AttrAsGeneric;

/**
 * @author mary-mogreen
 */
public class AttributedImpl implements Attributed<String> {
	protected Map<String, AttrAsGeneric<String>> attrTable = new HashMap<String, AttrAsGeneric<String>>();

	@Override
	public void add(AttrAsGeneric<String> newAttr) {
		attrTable.put(newAttr.getName(), newAttr);

	}

	@Override
	public AttrAsGeneric<String> find(String name) {
		return attrTable.get(name);
	}

	@Override
	public AttrAsGeneric<String> remove(String name) {
		return attrTable.remove(name);
	}

	@Override
	public Iterator<AttrAsGeneric<String>> attrs() {
		return attrTable.values().iterator();
	}

	public static void main(String[] args) {
		AttrAsGeneric<String> attr = new AttrAsGeneric<String>("testName", "testValue");
		AttributedImpl impl = new AttributedImpl();
		impl.add(attr);
		System.out.println(impl.find("testName"));
		System.out.println(impl.find("testName2"));
	}
}
