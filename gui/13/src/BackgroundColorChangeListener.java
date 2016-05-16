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
public class BackgroundColorChangeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setBgColor(ColorBuilder.toColor(e.getActionCommand()));
	}

}
