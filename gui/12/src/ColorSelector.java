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
public class ColorSelector extends Panel implements ItemListener {
	private Choice selector;
	private Properties props;
	public ColorSelector(Properties props2) {
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
	    add(new Label("font color"));
	    add(selector);
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice choice = (Choice)e.getItemSelectable();
		switch(choice.getSelectedItem()) {
			case "black":
				props.setColor(Color.BLACK);
				break;
			case "white":
				props.setColor(Color.WHITE);
				break;
			case "red":
				props.setColor(Color.RED);
				break;
			case "blue":
				props.setColor(Color.BLUE);
				break;
			case "yellow":
				props.setColor(Color.YELLOW);
				break;
			case "green":
				props.setColor(Color.GREEN);
				break;
			case "orange":
				props.setColor(Color.ORANGE);
				break;
			case "pink":
				props.setColor(Color.PINK);
				break;
			case "gray":
				props.setColor(Color.GRAY);
				break;
			case "cyan":
				props.setColor(Color.CYAN);
				break;
			case "light gray":
				props.setColor(Color.LIGHT_GRAY);
				break;
			case "dark gray":
				props.setColor(Color.DARK_GRAY);
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
