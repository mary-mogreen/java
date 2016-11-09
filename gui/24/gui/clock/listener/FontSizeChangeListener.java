package gui.clock.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;

import gui.clock.WatchProperties;

public class FontSizeChangeListener implements ItemListener, ActionListener {

	private JComboBox<String> choice;
	WatchProperties props = WatchProperties.getInstance();
	
	
	public FontSizeChangeListener(JComboBox<String> fontSizeJComboBox) {
		choice = fontSizeJComboBox;
	}
	public FontSizeChangeListener() {
		choice = null;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		props.setFontSize(Integer.valueOf((String) choice.getSelectedItem()));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		props.setFontSize(Integer.valueOf(e.getActionCommand()));
	}
}
