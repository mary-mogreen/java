/**
 *
 */
package src;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import patapatawatch.WatchProperties;

/**
 * @author p000526463
 *
 */
public class FontFamilyChangeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setFontFamily(Font.decode(e.getActionCommand()));
	}

}
