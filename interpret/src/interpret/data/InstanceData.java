/**
 * 
 */
package interpret.data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author katouyuuya
 *
 */
public class InstanceData {
	private static InstanceData instance;
	Map<String, Object> map;
	
	private InstanceData() {
		map = new LinkedHashMap<String, Object>();
	}
	
	public static InstanceData getInstance() {
		if (instance == null)
			instance = new InstanceData();
		return instance;
	}
	
	public Object get(String name) {
		return map.get(name);
	}
	
	public Object put(String name, Object instance) {
		return map.put(name, instance);
		
	}
	
	

}
