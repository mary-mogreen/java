/**
 *
 */
package patapatawatch;

import java.awt.Choice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * @author p000526463
 *
 */
public class FontSizeChangeListener implements ItemListener {

	private Choice choice;
	
	
	public FontSizeChangeListener(Choice fontSizeChoice) {
		choice = fontSizeChoice;
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setFontSize(Integer.valueOf(choice.getSelectedItem()));
	}

}
