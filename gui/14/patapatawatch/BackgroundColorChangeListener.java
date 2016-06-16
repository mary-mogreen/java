/**
 *
 */
package patapatawatch;

import java.awt.Choice;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * @author p000526463
 *
 */
public class BackgroundColorChangeListener implements ItemListener {
	private Choice choice;
	private Frame frame;
	
	public BackgroundColorChangeListener(Choice choice, Frame frame) {
		this.choice = choice;
		this.frame = frame;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setBgColor(ColorBuilder.toColor(choice.getSelectedItem()));
	}

}
