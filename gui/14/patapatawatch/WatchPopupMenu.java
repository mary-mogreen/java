/**
 *
 */
package patapatawatch;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import src.BackgroundColorChangeListener;
import src.FlipColorChangeListener;
import src.FontColorChangeListener;
import src.FontFamilyChangeListener;
import src.FontSizeChangeListener;

/**
 * @author p000526463
 *
 */
public class WatchPopupMenu {
	private PopupMenu popupMenu;
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray", "original"};
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}

	public WatchPopupMenu() {
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
        	mi.addActionListener(new FontFamilyChangeListener());
        	fontFamilyMenu.add(mi);
        }
        for (String s: sizes) {
        	MenuItem mi = new MenuItem(s);
        	mi.addActionListener(new FontSizeChangeListener());
        	fontSizeMenu.add(mi);
        }
        fontMenu.add(fontFamilyMenu);
        fontMenu.add(fontSizeMenu);
        popupMenu.add(fontMenu);

        // Colorメニュー
        Menu colorMenu = new Menu("Color Setting");
        Menu flipColorMenu = new Menu("Flip(PataPata) Color");
        Menu backgroundColorMenu = new Menu("Background Color");
        Menu fontColorMenu = new Menu("Font Color");
        for (String s: colors) {
        	MenuItem m1 = new MenuItem(s);
        	MenuItem m2 = new MenuItem(s);
        	MenuItem m3 = new MenuItem(s);
        	m1.addActionListener(new FlipColorChangeListener());
        	m2.addActionListener(new BackgroundColorChangeListener());
        	m3.addActionListener(new FontColorChangeListener());
        	flipColorMenu.add(m1);
        	backgroundColorMenu.add(m2);
        	fontColorMenu.add(m3);
        }


        colorMenu.add(flipColorMenu);
        colorMenu.add(backgroundColorMenu);
        colorMenu.add(fontColorMenu);
        popupMenu.add(colorMenu);

	}

	public PopupMenu getPopupMenu() {
		return popupMenu;
	}
}
