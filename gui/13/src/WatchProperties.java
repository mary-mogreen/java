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
	private Font font;

	private static WatchProperties instance;

	private WatchProperties() {
		init();
	}

	public static WatchProperties getInstance() {
		if (instance == null) {
			instance = new WatchProperties();
		}
		return instance;
	}

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


	public void init() {
		color = Color.LIGHT_GRAY;
		bgColor = Color.DARK_GRAY;
		flipColor = new Color(100, 50, 200);
		//font = new Font(Font.SANS_SERIF, Font.BOLD, 120);
		font = Font.decode("jokerman").deriveFont(Font.BOLD, 120.0f);
		fontSize = 120;
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

	public Font getFontFamily() {
		return font;
	}

	public void setFontFamily(Font font) {
		this.font = font;
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

	public Color getFlipColor() {
		return flipColor;
	}
	public void setFlipColor(Color color) {
		flipColor = color;
	}


}
