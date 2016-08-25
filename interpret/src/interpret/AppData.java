/**
 * 
 */
package interpret;

import interpret.ui.component.ClosableTabbedPane;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author katouyuuya
 *
 */
public class AppData {
	private static AppData instance;
	private Map<String, Object> map;
	
	public static final String TABPANE = "tabpane";
	
	private AppData() {
		map = new LinkedHashMap<String, Object>();
		map.put(TABPANE, new ClosableTabbedPane());
	}
	
	public static AppData getInstance() {
		if (instance == null)
			instance = new AppData();
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
	
	public Object getObject(String key) {
		return map.get(key);
	}
}
