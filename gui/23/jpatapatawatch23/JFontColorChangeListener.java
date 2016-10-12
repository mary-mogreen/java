/**
 *
 */
package jpatapatawatch23;

import java.awt.Choice;
import java.awt.Font;
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
public class JFontColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	// private Choice choice;
	
	public JFontColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	public JFontColorChangeListener() {
		this.choice = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		if (choice == null)
			props.setColor(JColorBuilder.toColor(e.getActionCommand()));
		else
			props.setColor(JColorBuilder.toColor((String) choice.getSelectedItem()));	
	}

}
