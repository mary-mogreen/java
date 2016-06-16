/**
 * 
 */
package interpret.ui;

import interpret.listener.ChangeTitleListener;

/**
 * @author katouyuuya
 *
 */
public interface Creator {
	public boolean addChangeTitleListener(ChangeTitleListener listener);
	public boolean removeChangeTitleListener(ChangeTitleListener listener);
}
