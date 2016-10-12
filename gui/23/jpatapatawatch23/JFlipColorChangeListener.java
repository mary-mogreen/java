/**
 *
 */
package jpatapatawatch23;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import jpatapatawatch23.JColorBuilder;
import jpatapatawatch23.JWatchProperties;


/**
 * @author p000526463
 *
 */
public class JFlipColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public JFlipColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public JFlipColorChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		if (choice == null)
			props.setFlipColor(JColorBuilder.toColor(e.getActionCommand()));
		else
			props.setFlipColor(JColorBuilder.toColor((String) choice.getSelectedItem()));
	}

}
