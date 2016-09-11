/**
 *
 */
package jpatapatawatch;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import patapatawatch.ColorBuilder;


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

	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		props.setColor(JColorBuilder.toColor((String) choice.getSelectedItem()));	
	}

}
