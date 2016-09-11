/**
 *
 */
package jpatapatawatch;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


/**
 * @author p000526463
 *
 */
public class JFlipColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public JFlipColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		System.out.println(e.getActionCommand() + ", " + (String) choice.getSelectedItem());
		props.setFlipColor(JColorBuilder.toColor((String) choice.getSelectedItem()));
	}

}
