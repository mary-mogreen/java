/**
 *
 */
package jpatapatawatch;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import patapatawatch.ColorBuilder;


/**
 * @author p000526463
 *
 */
public class JBackgroundColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public JBackgroundColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		System.out.printf("item: %s", choice.getSelectedItem());
		props.setBgColor(JColorBuilder.toColor((String) choice.getSelectedItem()));
	}

}
