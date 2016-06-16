/**
 * 
 */
package interpret;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author katouyuuya
 *
 */
public class ObjectData {
	private static ObjectData instance;
	private Map<String, Object> map;
	
	private ObjectData() {
		map = new LinkedHashMap<String, Object>();
	}
	
	public static ObjectData getInstance() {
		if (instance == null)
			instance = new ObjectData();
		return instance;
	}
	
	public Object put(String insName, Object obj) {
		return map.put(insName, obj);
	}
	
	public Object[] getKeys() {
		return map.keySet().toArray();
	}
	
	public boolean get(String insName) {
		return map.get(insName) == null ? false : true;
	}
}
