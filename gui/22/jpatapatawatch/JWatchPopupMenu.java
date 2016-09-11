/**
 *
 */
package jpatapatawatch;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import src.BackgroundColorChangeListener;
import src.FlipColorChangeListener;
import src.FontColorChangeListener;
import src.FontFamilyChangeListener;
import src.FontSizeChangeListener;

/**
 * @author p000526463
 *
 */
public class JWatchPopupMenu {
	private JPopupMenu popupMenu;
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray", "original"};
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}

	public JWatchPopupMenu() {
		// Menu configuration
        popupMenu = new JPopupMenu("patapata");

        // fontメニュー
        JMenu fontMenu = new JMenu("Text Setting");
        JMenu fontFamilyMenu = new JMenu("Font Family");
        JMenu fontSizeMenu = new JMenu("Font Size");

        // LocalのFontを取得する
        GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
        for (Font f: g.getAllFonts()) {
        	JMenuItem mi = new JMenuItem(f.getFontName());
        	mi.addActionListener(new FontFamilyChangeListener());
        	fontFamilyMenu.add(mi);
        }
        for (String s: sizes) {
        	JMenuItem mi = new JMenuItem(s);
        	mi.addActionListener(new FontSizeChangeListener());
        	fontSizeMenu.add(mi);
        }
        fontMenu.add(fontFamilyMenu);
        fontMenu.add(fontSizeMenu);
        popupMenu.add(fontMenu);

        // Colorメニュー
        JMenu colorMenu = new JMenu("Color Setting");
        JMenu flipColorMenu = new JMenu("Flip(PataPata) Color");
        JMenu backgroundColorMenu = new JMenu("Background Color");
        JMenu fontColorMenu = new JMenu("Font Color");
        for (String s: colors) {
        	JMenuItem m1 = new JMenuItem(s);
        	JMenuItem m2 = new JMenuItem(s);
        	JMenuItem m3 = new JMenuItem(s);
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

	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}
}
