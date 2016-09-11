/**
 * 
 */
package jpatapatawatch;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import patapatawatch.ColorBuilder;

/**
 * @author katouyuuya
 *
 */
public class JWatchPreferences {
	private Preferences prefs;
	
	public JWatchPreferences() {
		prefs = Preferences.userNodeForPackage(this.getClass());
	}
	
	
	public void setWindowConfig(Point point, int width, int height) {
		prefs.putInt("window.x", point.x);
        prefs.putInt("window.y", point.y);
        prefs.putInt("window.width", width);
        prefs.putInt("window.height", height);
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            System.err.println(e.toString());
        }
	}
	
	public void setWatchConfig(Font font, int fontSize, Color color, Color bgColor, Color flipColor) {
		prefs.put("watch.font", font.getFontName());
		prefs.putInt("watch.size", fontSize);
		prefs.put("watch.color.text", JColorBuilder.toString(color));
		prefs.put("watch.color.bg", JColorBuilder.toString(bgColor));
		prefs.put("watch.color.flip", JColorBuilder.toString(flipColor));
		try {
            prefs.flush();
        } catch (BackingStoreException e) {
            System.err.println(e.toString());
        }
	}
	
	public int getWindowX() {
		return prefs.getInt("window.x", 100);
	}
	
	public int getWindowY() {
		return prefs.getInt("window.y", 100);
	}
	
	public int getWindowWidth() {
		return prefs.getInt("window.width", 504);
	}
	
	public int getWindowHeight() {
		return prefs.getInt("window.height", 300);
	}
	
	public int getWatchFontSize() {
		return prefs.getInt("watch.size", 120);
	}
	
	public String getWatchFont() {
		return prefs.get("watch.font", "jokerman");
	}
	
	public String getWatchColor() {
		return prefs.get("watch.color.text", "light gray");
	}
	
	public String getWatchBgColor() {
		return prefs.get("watch.color.bg", "dark gray");
	}
	
	public String getWatchFlipColor() {
		return prefs.get("watch.color.flip", "original");
	}
}
