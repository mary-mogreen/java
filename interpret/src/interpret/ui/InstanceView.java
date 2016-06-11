/**
 * 
 */
package interpret.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import interpret.ui.component.ClosableTabbedPane;

/**
 * @author katouyuuya
 *
 */
public class InstanceView {
	private JTabbedPane instanceView;
	
	public InstanceView() {
		instanceView = new ClosableTabbedPane();
		
		instanceView.addTab("tab1", new JButton("tab1"));
		instanceView.addTab("tab1", new JButton("tab2"));
		

	}
	
	public JTabbedPane getInstanceView() {
		return instanceView;
	}

}
