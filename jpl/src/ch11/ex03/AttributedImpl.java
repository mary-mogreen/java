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
 * Attributedオブジェクトに対しては、取り出したAttrがどの型を扱っているかはわからない。
 */
public class AttributedImpl implements Attributed, Iterable<AttrAsGeneric<?>>{
	protected Map<String, AttrAsGeneric<?>> attrTable = new HashMap<String, AttrAsGeneric<?>>();

	@Override
	public void add(AttrAsGeneric<?> newAttr) {
		attrTable.put(newAttr.getName(), newAttr);

	}

	@Override
	public AttrAsGeneric<?> find(String name) {
		return attrTable.get(name);
	}

	@Override
	public AttrAsGeneric<?> remove(String name) {
		return attrTable.remove(name);
	}

	@Override
	public Iterator<AttrAsGeneric<?>> attrs() {
		return attrTable.values().iterator();
	}

	@Override
	public Iterator<AttrAsGeneric<?>> iterator() {
		return attrs();
	}

	public static void main(String[] args) {
		AttrAsGeneric<String> attr = new AttrAsGeneric<String>("testName", "testValue");
		AttrAsGeneric<Integer> attrInt = new AttrAsGeneric<Integer>("testName2", Integer.valueOf(10));
		AttributedImpl impl = new AttributedImpl();
		impl.add(attr);
		impl.add(attrInt);
		System.out.println(impl.find("testName"));
		System.out.println(impl.find("testName2"));
	}
}
