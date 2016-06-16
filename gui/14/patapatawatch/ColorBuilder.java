/**
 *
 */
package patapatawatch;

import java.awt.Color;

/**
 * @author p000526463
 *
 */
public class ColorBuilder {
	static Color toColor(String color) {
		switch(color) {
		case "black":
			return Color.BLACK;
		case "white":
			return Color.WHITE;
		case "red":
			return Color.RED;
		case "blue":
			return Color.BLUE;
		case "yellow":
			return Color.YELLOW;
		case "green":
			return Color.GREEN;
		case "orange":
			return Color.ORANGE;
		case "pink":
			return Color.PINK;
		case "gray":
			return Color.GRAY;
		case "cyan":
			return Color.CYAN;
		case "light gray":
			return Color.LIGHT_GRAY;
		case "dark gray":
			return Color.DARK_GRAY;
		case "original":
			return new Color(100, 50, 200);
		default:
			throw new IllegalArgumentException("color " + color + "not found. ");
			//Nothing.
		}
	}
	
	static String toString(Color color) {
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
		else if(color.equals(new Color(100, 50, 200)))
			return "original";
		else
			throw new IllegalArgumentException("color " + color + "not found. ");	
	}
}
