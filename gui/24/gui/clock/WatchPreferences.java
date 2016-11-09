package gui.clock;
/**
 * 
 */


import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import gui.clock.color.ColorBuilder;



/**
 * @author katouyuuya
 *
 */
public class WatchPreferences {
	private Preferences prefs;
	private final String X = "window.x";
	private final String Y = "window.y";
	private final String WIDTH = "window.width";
	private final String HEIGHT = "window.height";
	private final String FONT = "watch.font";
	private final String SIZE = "watch.size";
	private final String COLOR_TEXT = "watch.color.text";
	private final String COLOR_BG = "watch.color.bg";
	private final String COLOR_FLIP = "watch.color.flip";
	
	public WatchPreferences() {
		prefs = Preferences.userNodeForPackage(this.getClass());
	}
	
	
	public void setWindowConfig(Point point, int width, int height) {
		prefs.putInt(X, point.x);
        prefs.putInt(Y, point.y);
        prefs.putInt(WIDTH, width);
        prefs.putInt(HEIGHT, height);
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            System.err.println(e.toString());
        }
	}
	
	public void setWatchConfig(Font font, int fontSize, Color color, Color bgColor, Color flipColor) {
		prefs.put(FONT, font.getFontName());
		prefs.putInt(SIZE, fontSize);
		prefs.put(COLOR_TEXT, ColorBuilder.toString(color));
		prefs.put(COLOR_BG, ColorBuilder.toString(bgColor));
		prefs.put(COLOR_FLIP, ColorBuilder.toString(flipColor));
		try {
            prefs.flush();
        } catch (BackingStoreException e) {
            System.err.println(e.toString());
        }
	}
	
	public int getWindowX() {
		return prefs.getInt(X, 100);
	}
	
	public int getWindowY() {
		return prefs.getInt(Y, 100);
	}
	
	public int getWindowWidth() {
		return prefs.getInt(WIDTH, 504);
	}
	
	public int getWindowHeight() {
		return prefs.getInt(HEIGHT, 300);
	}
	
	public int getWatchFontSize() {
		return prefs.getInt(SIZE, 120);
	}
	
	public String getWatchFont() {
		return prefs.get(FONT, "jokerman");
	}
	
	public String getWatchColor() {
		return prefs.get(COLOR_TEXT, "light gray");
	}
	
	public String getWatchBgColor() {
		return prefs.get(COLOR_BG, "dark gray");
	}
	
	public String getWatchFlipColor() {
		return prefs.get(COLOR_FLIP, "original");
	}
}
