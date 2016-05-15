/**
 *
 */
package src;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
public class FontStyleSelector extends Panel {

	/**
		 * @author p000526463
		 *
		 */
	public class CbItemListener implements ItemListener {

		/* (非 Javadoc)
		 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {
			Checkbox selected = checkboxGroup.getSelectedCheckbox();
			switch (selected.getLabel()) {
				case "Normal":
					props.setFontStyle(Font.PLAIN);
					break;
				case "Italic":
					props.setFontStyle(Font.ITALIC);
					break;
				case "Bold":
					props.setFontStyle(Font.BOLD);
					break;
				default:
					//Nothing
			}

		}

	}

	private CheckboxGroup checkboxGroup;
	private Checkbox[] cb;
	private WatchProperties props;

	public FontStyleSelector(WatchProperties props) {
		super();
		this.props = props;

		checkboxGroup = new CheckboxGroup();
		cb = new Checkbox[3];
		cb[Font.PLAIN] = new Checkbox("Normal");
		cb[Font.ITALIC] = new Checkbox("Italic");
		cb[Font.BOLD] = new Checkbox("Bold");

		cb[Font.PLAIN].setCheckboxGroup(checkboxGroup);
		cb[Font.ITALIC].setCheckboxGroup(checkboxGroup);
		cb[Font.BOLD].setCheckboxGroup(checkboxGroup);

		cb[props.getFontStyle()].setState(true);
		cb[Font.PLAIN].addItemListener(new CbItemListener());
		cb[Font.ITALIC].addItemListener(new CbItemListener());
		cb[Font.BOLD].addItemListener(new CbItemListener());
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 3));
		setLayout(new GridLayout(2, 1));
		p.add(cb[Font.PLAIN]);
		p.add(cb[Font.ITALIC]);
		p.add(cb[Font.BOLD]);
		add(new Label("font style"));
		add(p);
	}

}
