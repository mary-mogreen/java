package gui.clock.listener;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import gui.clock.WatchProperties;

public class FontFamilyChangeListener implements ActionListener {

private JComboBox<String> choice;
	
	public FontFamilyChangeListener(JComboBox<String> choice) {
		this.choice = choice;
	}
	
	public FontFamilyChangeListener() {
		this.choice = null;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		if (choice == null)
			props.setFontFamily(Font.decode(e.getActionCommand()));
		else
			props.setFontFamily(Font.decode((String) choice.getSelectedItem()));
	}

}
