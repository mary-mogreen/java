/**
 * 
 */
package interpret;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
	
	public Object getObject(String insName) {
		return map.get(insName);
	}
	
	public String[] getSKeys(Class<?> type) {
		List<String> strs = new ArrayList<String>();
		for (String s: map.keySet()) {
			if (type == map.get(s).getClass())
				strs.add(s);
		}
		return strs.toArray(new String[strs.size()]);
	}
}
