/**
 * 
 */
package interpret.ui;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interpret.ui.component.TableLine;

/**
 * @author katouyuuya
 *
 */
public class ArrayElementTableLine implements TableLine {
	private JLabel idxLabel;
	private JComponent elmComp;
	private JButton addElmBtn;
	private JButton delElmBtn;
	
	public ArrayElementTableLine(int idx, String elmName) {
		idxLabel = new JLabel(String.valueOf(idx));
		if (elmName == null)
			elmComp = new JLabel("null");
		else
			elmComp = new JButton(elmName);
		
		addElmBtn = new JButton("+");
		delElmBtn = new JButton("-");
		
	}
	
	@Override
	public JComponent[] getLine() {
		JComponent[] line = {idxLabel, elmComp, addElmBtn, delElmBtn};
		return line;
	}

	
}
