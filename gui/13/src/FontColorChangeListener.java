/**
 *
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author p000526463
 *
 */
public class FontColorChangeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setColor(ColorBuilder.toColor(e.getActionCommand()));
	}

}
