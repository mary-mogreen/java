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
public class ArrayView {
	private JPanel panel;
	private final JLabel insLabel;
	private final JLabel clsLabel;
	private final JLabel szLabel;
	
	public ArrayView(String insName, String clsName, int arrSize) {
		panel = new JPanel();
		insLabel = new JLabel("Instance Name: " + insName);
		clsLabel = new JLabel("Class Name: " + clsName);
		szLabel = new JLabel("Array Size: " + arrSize);
		
		panel.add(insLabel);
		panel.add(clsLabel);
		panel.add(szLabel);
	}
	
	public JPanel getPanel() {
		return panel;
	}

}
