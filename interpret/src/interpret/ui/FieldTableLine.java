/**
 * 
 */
package interpret.ui;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import interpret.ui.component.TableLine;

/**
 * @author katouyuuya
 *
 * テーブルの各行。
 * 修飾子, 型名, フィールド名, 値（テキストフィールド or ボタン）
 */
public class FieldTableLine implements TableLine {
	private JLabel modLabel;
	private JLabel typeLabel;
	private JLabel fNameLabel;
	private JComponent valComp;
	
	public FieldTableLine(String field, Object value) {
		String[] strs = field.split(" ");
		modLabel = new JLabel(strs[0]);
		typeLabel = new JLabel(strs[1]);
		fNameLabel = new JLabel(strs[2]);
		JTextField tf = new JTextField(20);
		tf.setText(value.toString());
		valComp = tf;
	}
	
	@Override
	public JComponent[] getLine() {
		JComponent[] line = {modLabel, typeLabel, fNameLabel, valComp};
		return line;
	}

}
