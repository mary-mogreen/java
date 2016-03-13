/**
 *
 */
package ch06.ex05;

/**
 * @author mary-mogreen
 * 色の取得の場合推奨はしない。
 * 特に何色だから何かが変わるわけではないので。
 * ぜんぜん違う色のオブジェクトを返すこともできてしまう。
 */
public enum TrafficSignalColor {
	RED(new Color("red")) {
		public Color getColor() {
			return color;
		}
	},
	AMBER(new Color("amber")) {
		public Color getColor() {
			return color;
		}
	},
	GREEN(new Color("green")) {
		public Color getColor() {
			return color;
		}
	};

	Color color;
	TrafficSignalColor(Color color) {
		this.color = color;
	}

	abstract public Color getColor();
}
