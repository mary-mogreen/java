/**
 *
 */
package gui.clock.listener;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import gui.clock.WatchProperties;
import gui.clock.color.ColorBuilder;




/**
 * @author mary-mogreen
 *
 */
public class FlipColorChangeListener implements ActionListener {
	private JComboBox<String> choice;
	
	public FlipColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public FlipColorChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		if (choice == null)
			props.setFlipColor(ColorBuilder.toColor(e.getActionCommand()));
		else
			props.setFlipColor(ColorBuilder.toColor((String) choice.getSelectedItem()));
	}

}
