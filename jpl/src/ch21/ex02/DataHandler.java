/**
 * 
 */
package ch21.ex02;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author mary-mogreen
 *
 */
public class DataHandler {
// 	private File lastFile;
// 	private WeakReference<byte[]> lastData;
	private WeakHashMap<File, byte[]> map = new WeakHashMap<File, byte[]>();
	
	
	byte[] readFile(File file) {
		byte[] data;
		
//		if(file.equals(lastFile)) {
//			data = lastData.get();
//			if(data != null)
//				return data;
//		}
		
		if (map.containsKey(file)) {
			data = map.get(file);
			if (data != null)
				return data;
		}
		
		data = readBytesFromFile(file);
// 		lastFile = file;
// 		lastData = new WeakReference<byte[]>(data);
		map.put(file, data);

		return data;
		
	}
	
	byte[] readBytesFromFile(File file) {
		return new byte[0];
	}
}
