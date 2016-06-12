/**
 * 
 */
package interpret.ui;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author katouyuuya
 *
 */
public class ObjectView{
	private JPanel panel;
	private final JLabel insLabel;
	private final JLabel clsLabel;
	
	public ObjectView(String insName, String clsName) {
		panel = new JPanel();
		insLabel = new JLabel("Instance Name: " + insName);
		clsLabel = new JLabel("Class Name: " + clsName);
		
		panel.add(insLabel);
		panel.add(clsLabel);
	}
	
	public JPanel getPanel() {
		return panel;
	}

}
