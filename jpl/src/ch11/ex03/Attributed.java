/**
 *
 */
package ch11.ex03;

import ch11.ex02.AttrAsGeneric;

/**
 * @author mary-mogreen
 */
public interface Attributed<V> {
	void add(AttrAsGeneric<V> attr);
	AttrAsGeneric<V> find(String attrName);
	AttrAsGeneric<V> remove(String attrName);
	java.util.Iterator<AttrAsGeneric<V>> attrs();
}
