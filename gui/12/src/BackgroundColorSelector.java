/**
 *
 */
package src;

import java.awt.Choice;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * @author p000526463
 *
 */
public class BackgroundColorSelector extends Panel implements ItemListener {
	private Choice selector;
	private Properties props;
	public BackgroundColorSelector(Properties props2) {
		this.props = props2;
		selector = new Choice();
		selector.add("black");
		selector.add("white");
	    selector.add("red");
	    selector.add("blue");
	    selector.add("yellow");
	    selector.add("green");
	    selector.add("pink");
	    selector.add("orange");
	    selector.add("gray");
	    selector.add("cyan");
	    selector.add("light gray");
	    selector.add("dark gray");
	    selector.select(getColorString(props2.getBgColor()));

	    selector.addItemListener(this);

	    setLayout(new GridLayout(2,1));
	    add(new Label("background color"));
	    add(selector);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice choice = (Choice)e.getItemSelectable();
		switch(choice.getSelectedItem()) {
			case "black":
				props.setBgColor(Color.BLACK);
				break;
			case "white":
				props.setBgColor(Color.WHITE);
				break;
			case "red":
				props.setBgColor(Color.RED);
				break;
			case "blue":
				props.setBgColor(Color.BLUE);
				break;
			case "yellow":
				props.setBgColor(Color.YELLOW);
				break;
			case "green":
				props.setBgColor(Color.GREEN);
				break;
			case "orange":
				props.setBgColor(Color.ORANGE);
				break;
			case "pink":
				props.setBgColor(Color.PINK);
				break;
			case "gray":
				props.setBgColor(Color.GRAY);
				break;
			case "cyan":
				props.setBgColor(Color.CYAN);
				break;
			case "light gray":
				props.setBgColor(Color.LIGHT_GRAY);
				break;
			case "dark gray":
				props.setBgColor(Color.DARK_GRAY);
				break;
			default:
				//Nothing.
		}
	}

	public Choice getSelector() {
		return selector;
	}

	public String getColorString(Color color) {
		if (color.equals(Color.BLACK))
			return "black";
		else if (color.equals(Color.BLUE))
			return "blue";
		else if (color.equals(Color.CYAN))
			return "cyan";
		else if (color.equals(Color.GRAY))
			return "gray";
		else if (color.equals(Color.GREEN))
			return "green";
		else if (color.equals(Color.ORANGE))
			return "orange";
		else if (color.equals(Color.PINK))
			return "pink";
		else if (color.equals(Color.RED))
			return "red";
		else if (color.equals(Color.WHITE))
			return "white";
		else if (color.equals(Color.YELLOW))
			return "yellow";
		else if (color.equals(Color.LIGHT_GRAY))
			return "light gray";
		else if (color.equals(Color.DARK_GRAY))
			return "dark gray";
		else
			return "black";
	}

}
