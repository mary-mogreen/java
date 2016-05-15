/**
 *
 */
package src;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;

/**
 * @author p000526463
 *
 */
public class WatchPopupMenu {
	private PopupMenu popupMenu;
	WatchPopupMenu() {
		// Menu configuration
        popupMenu = new PopupMenu("patapata");

        // fontメニュー
        Menu fontMenu = new Menu("Text Setting");
        Menu fontFamilyMenu = new Menu("Font Family");
        Menu fontSizeMenu = new Menu("Font Size");

        // LocalのFontを取得する
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (Font f: g.getAllFonts()) {
        	MenuItem mi = new MenuItem(f.getFontName());
        	fontFamilyMenu.add(mi);
        }
        fontMenu.add(fontFamilyMenu);
        fontMenu.add(fontSizeMenu);
        popupMenu.add(fontMenu);

        // Colorメニュー
        Menu colorMenu = new Menu("Color Setting");
        Menu flipColorMenu = new Menu("Flip(PataPata) Color");
        Menu backgroundColorMenu = new Menu("Background Color");
        Menu fontColorMenu = new Menu("Font Color");


        colorMenu.add(flipColorMenu);
        colorMenu.add(backgroundColorMenu);
        colorMenu.add(fontColorMenu);
        popupMenu.add(colorMenu);

	}

	public PopupMenu getPopupMenu() {
		return popupMenu;
	}
}
