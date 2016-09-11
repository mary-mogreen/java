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
public class JFontSizeChangeListener implements ItemListener {

	private JComboBox choice;
	
	
	public JFontSizeChangeListener(JComboBox fontSizeJComboBox) {
		choice = fontSizeJComboBox;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		props.setFontSize(Integer.valueOf((String) choice.getSelectedItem()));
	}

}
