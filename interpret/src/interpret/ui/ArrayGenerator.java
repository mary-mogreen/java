/**
 * 
 */
package interpret.ui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.actionlistener.GenerateArrayInstanceActionListener;

/**
 * @author katouyuuya
 *
 */
public class ArrayGenerator {
	private JPanel panel;
	private JLabel insLabel;
	private JLabel clsLabel;
	private JLabel szLabel;
	private JTextField insNameField;
	private JTextField clsNameField;
	private JTextField arrSizeField;
	private static final String EXISTS = " is already exsits.";
	private static final String NOTFOUND = " is not found.";
	
	public ArrayGenerator() {
		panel = new JPanel();
		JPanel insPanel = new JPanel();
		JPanel clsPanel = new JPanel();
		JPanel arrPanel = new JPanel();
		//insPanel.setLayout(new BoxLayout(insPanel, BoxLayout.X_AXIS ));
		//clsPanel.setLayout(new BoxLayout(clsPanel, BoxLayout.X_AXIS ));
		
		JLabel insNameLabel = new JLabel("Instance Name: ");
		insNameField = new JTextField(20);
		insLabel = new JLabel();
		insLabel.setText("a" + EXISTS);
		
		JLabel clsNameLabel = new JLabel("Class Name: ");
		clsNameField = new JTextField(20);
		clsLabel = new JLabel();
		clsLabel.setText("X" + NOTFOUND);
		
		clsNameLabel.setAlignmentY(0.5f);
		clsNameField.setAlignmentY(0.5f);
		
		insNameField.setMaximumSize(insNameField.getPreferredSize());
		clsNameField.setMaximumSize(clsNameField.getPreferredSize());
		
		// Array Size
		JLabel sizeLabel = new JLabel("Array Size: ");
		arrSizeField = new JTextField(20);
		szLabel = new JLabel();
		szLabel.setText("too large size.");
		arrSizeField.setMaximumSize(arrSizeField.getPreferredSize());
		
		JButton createArrayBtn = new JButton("Create");
		createArrayBtn.addActionListener(new GenerateArrayInstanceActionListener(this));
		
		
		insPanel.add(insNameLabel);
		insPanel.add(insNameField);
		insPanel.add(insLabel);
		
		clsPanel.add(clsNameLabel);
		clsPanel.add(clsNameField);
		clsPanel.add(clsLabel);
		
		arrPanel.add(sizeLabel);
		arrPanel.add(arrSizeField);
		arrPanel.add(createArrayBtn);
		arrPanel.add(szLabel);
		
		panel.add(insPanel);
		panel.add(clsPanel);
		panel.add(arrPanel);
		
		panel.setBackground(Color.GREEN);
	}
	
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * テキストフィールドから取得したインスタンス名を返す
	 * @return
	 */
	public String getInsName() {
		return insNameField.getText();
	}
	
	/**
	 * テキストフィールドから取得したクラス名を返す
	 * @return
	 */
	public String getClsName() {
		return clsNameField.getText();
	}
	
	/**
	 * テキストフィールドから取得した配列サイズを返す。
	 * どっかでintにパースできることを保証しなければ・・・。
	 * @return
	 */
	public int getArrSize() {
		return Integer.parseInt(arrSizeField.getText());
	}
}
