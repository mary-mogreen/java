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
public class FieldView {
	private JPanel panel;
	
	public FieldView() {
		JComponent[] comps1 = {new JLabel("修飾子"), new JLabel("型"), new JLabel("フィールド名"), new JLabel("値")};
		JComponent[] comps2 = new FieldTableLine("public int num", 5).getLine();
		JComponent[] comps3 = {new JLabel("lbl1"), new JLabel("lbl2"), new JButton("btn1"), new JButton("btn2")};
		JComponent[] comps4 = {new JLabel("lbl1"), new JLabel("lbl2"), new JButton("btn1"), new JButton("btn2")};
		JComponent[][] comps = {comps1, comps2, comps3, comps4};
		panel = new TablePane(comps).getPanel();
	}
	
	public JPanel getPanel() {
		return panel;
	}

}
