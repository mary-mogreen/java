/**
 * 
 */
package ch17.ex02;

/**
 * @author mary-mogreen
 *
 */

import java.lang.ref.WeakReference;
import java.io.File;

/**
 * 17.2 DataHandler を修正して，lastFile も弱く保存されるようにしなさい。
 * @author mary-mogreen
 *
 */

class DataHandler {
	// private File lastFile;						// 最後に読んだファイル
	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;		// (おそらく)最後のデータ
	
	
	/**
	 * データをファイルからメモリに読み込んで返す。
	 * 他のファイルから読み込むことなく，同じファイルから連続して何回か指定され，
	 * かつ，データの読み込みに処理を要すると想定して，最適化している。
	 * @param file
	 * @return
	 */
	byte[] readFile(File file) {
		byte[] data;
		
		// データを記憶しているか調べる
		if(file.equals(lastFile.get())) {
			data = lastData.get();
			if(data != null) // 最後に返されてからデータがGCされていない
				return data;
		}
			
		// 記憶していないので、読み込む
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}


	/**
	 * ファイルからバイト配列を読み込んで返す。のスタブ。
	 * @param file
	 * @return
	 */
	private byte[] readBytesFromFile(File file) {
		return null;
	} 
}
