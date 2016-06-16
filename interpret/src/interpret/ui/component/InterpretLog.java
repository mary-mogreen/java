/**
 * 
 */
package interpret.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class InterpretLog extends JPanel {
	private JLabel logLabel = new JLabel("Log: ");
	private JTextArea logArea = new JTextArea();
	private StringBuilder log = new StringBuilder();
	
	public InterpretLog() {
		setLayout(new BorderLayout());
		add(BorderLayout.NORTH, logLabel);
		setBackground(Color.BLACK);
		logLabel.setForeground(Color.WHITE);
		logArea.setForeground(Color.WHITE);
		logArea.setBackground(Color.BLACK);
		logArea.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane();
		add(BorderLayout.CENTER, logScrollPane);
		logScrollPane.setViewportView(logArea);
	}
	
	public void append(String str) {
		log.append(str);
	}
	
	public void show() {
		logArea.setText(log.toString());
	}

}
