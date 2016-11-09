package gui.clock.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.clock.WatchProperties;
import gui.clock.color.ColorBuilder;


public class BackgroundColorChangeListener implements ActionListener {

	private JComboBox<String> choice;
	
	public BackgroundColorChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public BackgroundColorChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		if (choice == null)
			props.setBgColor(ColorBuilder.toColor(e.getActionCommand()));
		else
			props.setBgColor(ColorBuilder.toColor((String) choice.getSelectedItem()));
	}
}
