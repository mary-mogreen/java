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
public class FontSizeChangeListener implements ActionListener {

	/* (非 Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setFontSize(Integer.valueOf(e.getActionCommand()));
	}

}
