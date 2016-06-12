/**
 * 
 */
package interpret.ui;

import javax.swing.JPanel;

/**
 * @author katouyuuya
 *
 */
interface TabView {
	public JPanel getPanel();
	public int getViewType();
	public String getTitle();
}
