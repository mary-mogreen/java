/**
 *
 */
package src;

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
}
