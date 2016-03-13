/**
 *
 */
package ch06.ex04;

/**
 * @author mary-mogreen
 *
 */
public enum TrafficSignalColor {
	RED(new Color("red")),
	AMBER(new Color("amber")),
	GREEN(new Color("green"));

	Color color;
	TrafficSignalColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
}
