/**
 *
 */
package jpatapatawatch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

/**
 * @author p000526463
 *
 */
public class JWatchProperties {
	private Color color;
	private Color bgColor;
	private Color flipColor;
	private int fontSize;
	private String fontFamily;
	private int fontStyle;
	private Font font;
	private int width, height, x, y;

	private static JWatchProperties instance;
	private JWatchPreferences prefs = new JWatchPreferences();

	private JWatchProperties() {
		init();
	}

	public static JWatchProperties getInstance() {
		if (instance == null) {
			instance = new JWatchProperties();
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
		color = JColorBuilder.toColor("light gray");
		bgColor = JColorBuilder.toColor("dark gray");
		flipColor = JColorBuilder.toColor("original");
		font = new Font(Font.SANS_SERIF, Font.BOLD, 120);
		// font = Font.decode(prefs.getWatchFont()).deriveFont(Font.BOLD, prefs.getWatchFontSize());
		fontSize = 120;
		width = 504;
		height = 300;
		x = 100;
		y = 100;
		fontFamily = Font.MONOSPACED;
		fontStyle = Font.PLAIN;
	}
	
	public void initPref() {
		color = JColorBuilder.toColor("light gray"/* prefs.getWatchColor() */);
		bgColor = JColorBuilder.toColor("dark gray");
		flipColor = JColorBuilder.toColor("original");
		//font = new Font(Font.SANS_SERIF, Font.BOLD, 120);
		font = Font.decode(prefs.getWatchFont()).deriveFont(Font.BOLD, prefs.getWatchFontSize());
		fontSize = prefs.getWatchFontSize();
		width = prefs.getWindowWidth();
		height = prefs.getWindowHeight();
		x = prefs.getWindowX();
		y = prefs.getWindowY();
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
	
	public int getWidth() {
		return width;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public void setLocation(Point location) {
		this.x = location.x;
		this.y = location.y;
	}
	
	public void setDimension(Dimension dimension) {
		this.width = dimension.width;
		this.height = dimension.height;
	}
	
	public void update() {
		prefs.setWindowConfig(new Point(x, y), width, height);
		prefs.setWatchConfig(font, fontSize, color, bgColor, flipColor);
	}


}
