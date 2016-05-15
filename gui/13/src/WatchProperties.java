/**
 *
 */
package src;

import java.awt.Color;
import java.awt.Font;

/**
 * @author p000526463
 *
 */
public class WatchProperties {
	private Color color;
	private Color bgColor;
	private Color flipColor;
	private int fontSize;
	private String fontFamily;
	private int fontStyle;

	/**
	 * @return bgColor
	 */
	public Color getBgColor() {
		return bgColor;
	}

	/**
	 * @param bgColor セットする bgColor
	 */
	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

	public WatchProperties() {
		init();
	}

	public void init() {
		color = Color.LIGHT_GRAY;
		bgColor = Color.DARK_GRAY;
		flipColor = new Color(100, 50, 200);
		fontSize = 32;
		fontFamily = Font.MONOSPACED;
		fontStyle = Font.PLAIN;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getFontFamily() {
		return fontFamily;
	}

	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	/**
	 * @return fontStyle
	 */
	public int getFontStyle() {
		return fontStyle;
	}

	/**
	 * @param fontStyle セットする fontStyle
	 */
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}
}
