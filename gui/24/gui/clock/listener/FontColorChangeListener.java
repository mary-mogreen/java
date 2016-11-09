package gui.clock.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;


import gui.clock.WatchProperties;
import gui.clock.color.ColorBuilder;

public class FontColorChangeListener implements ActionListener {

	private JComboBox<String> choice;
	// private Choice choice;
	
	public FontColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	public FontColorChangeListener() {
		this.choice = null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		if (choice == null)
			props.setColor(ColorBuilder.toColor(e.getActionCommand()));
		else
			props.setColor(ColorBuilder.toColor((String) choice.getSelectedItem()));	
	}

}
