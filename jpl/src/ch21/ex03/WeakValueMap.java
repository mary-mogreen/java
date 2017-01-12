/**
 * 
 */
package ch21.ex03;

import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mary-mogreen
 *
 *　WeakValueMapのValueには null を入れてはいけない。
 */
public class WeakValueMap<K, V> implements Map<K, V> {
	private final HashMap<K, WeakReference<V>> map;
	
	public WeakValueMap(int initialCapacity) {
		map = new HashMap<>(initialCapacity);
	}
	
	public WeakValueMap() {
		map = new HashMap<>();
	}
	
	/**
	 * マップを元にWeakValueMapを生成する。
	 * Valueに null が入っていた場合は生成を破棄する。
	 * @param m 任意のマップ
	 * @throws NullPointerException マップの値がnullだったとき
	 */
	public WeakValueMap(Map<? extends K, ? extends V> m) {
		HashMap<K, WeakReference<V>> tmp = new HashMap<>();
		for (Entry<? extends K, ? extends V> e: m.entrySet()) {
			if (e.getValue() == null) {
				throw new NullPointerException("WeakValueMapの値にnullは認めない");
			}
			tmp.put(e.getKey(), new WeakReference<V>(e.getValue()));
		}
		map = tmp;
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		for (WeakReference<V> v: map.values()) {
			// v.getはnullの可能性がある
			if (v.get() != null && v.get().equals(value))
				return true;
		}
		return false;
	}

	/**
	 * 
	 */
	@Override
	public V get(Object key) {
		WeakReference<V> v = map.get(key);
		return v == null ? null : v.get();
	}

	@Override
	public V put(K key, V value) {
		WeakReference<V> v = map.put(key, new WeakReference<V>(value));
		return v == null ? null : v.get();
	}

	@Override
	public V remove(Object key) {
		WeakReference<V> v = map.remove(key);
		return v == null ? null : v.get();
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		for (Entry<? extends K, ? extends V> e: m.entrySet()) {
			map.put(e.getKey(), new WeakReference<V>(e.getValue()));
		}
	}

	@Override
	public void clear() {
		for (WeakReference<V> wr: map.values())
			wr.clear();
		map.clear();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public Collection<V> values() {
		Collection<V> values = new ArrayList<V>();
		for (WeakReference<V> wr: map.values()) {
			if (!wr.isEnqueued())
				values.add(wr.get());
		}
		return values;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		Set<java.util.Map.Entry<K, V>> s = new HashSet<>();
		for (Entry<K, WeakReference<V>> e: map.entrySet()) {
			if (!e.getValue().isEnqueued()) {
				s.add(new AbstractMap.SimpleEntry<K, V>(e.getKey(), e.getValue().get()));
			}
		}
		return s;
	}
	
}
