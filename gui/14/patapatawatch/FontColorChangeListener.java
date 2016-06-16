/**
 *
 */
package patapatawatch;

import java.awt.Choice;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * @author p000526463
 *
 */
public class FontColorChangeListener implements ItemListener {
	private Choice choice;
	
	public FontColorChangeListener(Choice choice) {
		this.choice = choice;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setColor(ColorBuilder.toColor(choice.getSelectedItem()));
		
	}

}
