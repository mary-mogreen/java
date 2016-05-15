/**
 *
 */
package src;

import java.awt.Choice;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;



/**
 * @author p000526463
 *
 */
public class FontFamilySelector extends Panel {


	/**
		 * @author p000526463
		 *
		 */
	public class FontFamilySelectAction implements ItemListener {

		/* (非 Javadoc)
		 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			Choice choice = (Choice)e.getItemSelectable();
			switch (choice.getSelectedItem()) {
				case "Serif":
					props.setFontFamily(Font.SERIF);
					break;
				case "SansSerif":
					props.setFontFamily(Font.SANS_SERIF);
					break;
				case "Monospaced":
					props.setFontFamily(Font.MONOSPACED);
					break;
				default:
					//Nothing
			}
		}

	}

	private Choice selector;
	private WatchProperties props;
	public FontFamilySelector(WatchProperties props) {
		this.props = props;
		selector = new Choice();

		selector.add("Serif");
		selector.add("SansSerif");
	    selector.add("Monospaced");

	    selector.select(props.getFontFamily());
	    setLayout(new GridLayout(2, 1));
	    add(new Label("font family"));
	    add(selector);
	    selector.addItemListener(new FontFamilySelectAction());
	}
}
