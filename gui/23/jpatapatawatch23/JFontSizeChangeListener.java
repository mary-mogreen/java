/**
 *
 */
package jpatapatawatch23;

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
public class JFontSizeChangeListener implements ItemListener, ActionListener {

	private JComboBox choice;
	
	
	public JFontSizeChangeListener(JComboBox fontSizeJComboBox) {
		choice = fontSizeJComboBox;
	}
	public JFontSizeChangeListener() {
		choice = null;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		props.setFontSize(Integer.valueOf((String) choice.getSelectedItem()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		props.setFontSize(Integer.valueOf(e.getActionCommand()));
	}

}
