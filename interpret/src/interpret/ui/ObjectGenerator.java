/**
 * 
 */
package interpret.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import interpret.actionlistener.GenerateInstanceActionListener;

/**
 * @author katouyuuya
 *
 */
public class ObjectGenerator {
	private JPanel panel;
	private JLabel insLabel;
	private JLabel clsLabel;
	private JTextField insNameField;
	private JTextField clsNameField;
	private static final String EXISTS = " is already exsits.";
	private static final String NOTFOUND = " is not found.";
	
	public ObjectGenerator() {
		panel = new JPanel();
		JPanel insPanel = new JPanel();
		JPanel clsPanel = new JPanel();
		//insPanel.setLayout(new BoxLayout(insPanel, BoxLayout.X_AXIS ));
		//clsPanel.setLayout(new BoxLayout(clsPanel, BoxLayout.X_AXIS ));
		
		JLabel insNameLabel = new JLabel("Instance Name: ");
		insNameField = new JTextField(20);
		insLabel = new JLabel();
		insLabel.setText("a" + EXISTS);
		
		JLabel clsNameLabel = new JLabel("Class Name: ");
		clsNameField = new JTextField(20);
		JButton generateClassButton = new JButton("Constructor");
		generateClassButton.addActionListener(new GenerateInstanceActionListener(this));
		clsLabel = new JLabel();
		clsLabel.setText("X" + NOTFOUND);
		
		clsNameLabel.setAlignmentY(0.5f);
		clsNameField.setAlignmentY(0.5f);
		generateClassButton.setAlignmentY(0.5f);
		
		clsNameField.setMaximumSize(clsNameField.getPreferredSize());
		
		insPanel.add(insNameLabel);
		insPanel.add(insNameField);
		insPanel.add(insLabel);
		
		clsPanel.add(clsNameLabel);
		clsPanel.add(clsNameField);
		clsPanel.add(generateClassButton);
		clsPanel.add(clsLabel);
		
		panel.add(insPanel);
		panel.add(clsPanel);
		
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

}
