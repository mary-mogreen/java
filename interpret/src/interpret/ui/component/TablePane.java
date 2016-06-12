/**
 * 
 */
package interpret.ui.component;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author katouyuuya
 *
 */
public class TablePane {
	private final JPanel panel;
	
	public TablePane(JComponent[][] comps) {
		panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		GridBagConstraints gbc = new GridBagConstraints();
		
		
		for (int i = 0; i < 4; i++) {
			gbc.gridy = i;
			for (int j = 0; j < 4; j++) {
				gbc.gridx = j;
				layout.setConstraints(comps[i][j], gbc);
			}
		}
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				panel.add(comps[i][j]);
			}
		}
		
				
	}

	public JPanel getPanel() {
		return panel;
	}
}
