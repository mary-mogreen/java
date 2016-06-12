/**
 * 
 */
package interpret.actionlistener;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;

import interpret.ui.component.ClosableTabbedPane.TabPanel;

/**
 * @author katouyuuya
 *
 */
public class CloseTabActionListener implements ActionListener {
	private final JTabbedPane pane;
	private final Component content;

	public CloseTabActionListener(final JTabbedPane pane, final Component content) {
		this.pane = pane;
		this.content = content;
	}
	
	@Override public void actionPerformed(ActionEvent e) {
        int idx = pane.indexOfComponent(content);
        pane.removeTabAt(idx);
        int count = pane.getTabCount();
        if (count > idx) {
            TabPanel tab = (TabPanel) pane.getTabComponentAt(idx);
            tab.setButtonVisible(true);
        }
    }

}
