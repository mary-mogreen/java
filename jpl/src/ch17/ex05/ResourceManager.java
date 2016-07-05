/**
 * 
 */
package ch17.ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


/**
 * @author mary-mogreen
 *　刈り取りスレッドを使用しないようにリソースマネージャを再設計する。
 */
public final class ResourceManager {
	
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	// final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		// reaper = new ReaperThread();
		// reaper.start();
	
		// ... リソースの初期化 ...
	}
	
	/**
	 * リソースを全て解放して，シャットダウンする。
	 */
	public synchronized void shutdown() {
		if (!shutdown) {
			shutdown = true;
			// reaper.interrupt();
			// リソースを全て解放する
			for (Reference<?> ref: refs.keySet()) {
				Resource res = null;
				synchronized(ResourceManager.this) {
					res = refs.get(ref);
					refs.remove(ref);
				}
				res.release();
				ref.clear();;
			}			
		}
	}
	
	/**
	 * 呼び出されるごとに，キューを poll して，到達不可能になったリソースを解放する。
	 * @param key
	 * @return リソース
	 */
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		reap();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
		refs.put(ref, res);
		return res;
	}
	
	public void reap() {
		Reference<?> ref = queue.poll();
		while (ref != null) {
			Resource res = null;
			synchronized(ResourceManager.this) {
				res = refs.get(ref);
				refs.remove(ref);
			}
			res.release();
			refs.remove(ref);
			ref = queue.poll();
		}
	}
	
	
	/**
	 * @author mary-mogreen
	 *
	 */
	public static class ResourceImpl implements Resource {

		// int keyHash;
		WeakReference<Object> keyRef;
		boolean needRelease = false;
		
		ResourceImpl(Object key) {
			// keyHash = System.identityHashCode(key);
			keyRef = new WeakReference<Object>(key);
			
			// .. 外部リソースの設定
			
			needRelease = true;
		}
		
		@Override
		public void use(Object key, Object... args) {
			// if (System.identityHashCode(key) != keyHash)
			if (keyRef.get().equals(key))
				throw new IllegalArgumentException("wrong key");
			
			// ... リソースの使用 ...

		}
		
		@Override
		public void release() {
			if (needRelease) {
				needRelease = false;
				
				// .. リソースの解放 ..
			}
		}

	}

}
