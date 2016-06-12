/**
 * 
 */
package interpret.ui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import interpret.ui.component.TablePane;

/**
 * @author katouyuuya
 *
 */
public class ArrayElementView {
	private JPanel panel;
	
	public ArrayElementView() {
		JComponent[] comps1 = {new JLabel("インデックス"), new JLabel("要素"), new JLabel("Create"), new JLabel("remove")};
		JComponent[] comps2 = new ArrayElementTableLine(0, "a").getLine();
		JComponent[] comps3 = new ArrayElementTableLine(1, "b").getLine();
		JComponent[] comps4 = new ArrayElementTableLine(2, "c").getLine();
		JComponent[][] comps = {comps1, comps2, comps3, comps4};
		panel = new TablePane(comps).getPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}

}
