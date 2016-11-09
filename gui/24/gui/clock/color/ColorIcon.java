package gui.clock.color;


import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

public class ColorIcon implements Icon {
	private Color color;
	private int width;
	private int height;
	
	public ColorIcon(Color color) {
		this.color = color;
		this.width = 10;
		this.height = 10;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.BLACK);
	}

	@Override
	public int getIconWidth() {
		return width;
	}

	@Override
	public int getIconHeight() {
		return height;
	}
	
}
