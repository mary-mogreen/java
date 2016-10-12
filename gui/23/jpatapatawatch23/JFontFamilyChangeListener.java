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

import jpatapatawatch23.JWatchProperties;



/**
 * @author p000526463
 *
 */
public class JFontFamilyChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public JFontFamilyChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public JFontFamilyChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		if (choice == null)
			props.setFontFamily(Font.decode(e.getActionCommand()));
		else
			props.setFontFamily(Font.decode((String) choice.getSelectedItem()));
	}

}
