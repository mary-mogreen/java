package gui.clock.util;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import gui.clock.color.ColorIcon;

public class ComboBoxRenderer extends JLabel implements ListCellRenderer {
	// private ColorIcon[] icons;
	// private String[] colors;
	private Map<String, ColorIcon> colors = new HashMap<>();
	
	
	public ComboBoxRenderer(ColorIcon[] icons, String[] colors) {
		setOpaque(true);
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		for (int i = 0; i < colors.length; i++)
			this.colors.put(colors[i], icons[i]);
		}
		 
		@Override
		public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus) {
		//Get the selected index. (The index param isn't
		//always valid, so just use the value.)
		String selectedColor = (String)value;
		 
		if (isSelected) {
		setBackground(list.getSelectionBackground());
		setForeground(list.getSelectionForeground());
		} else {
		setBackground(list.getBackground());
		setForeground(list.getForeground());
		}
		 
		//Set the icon and text.
		ColorIcon icon = colors.get(selectedColor);
		// String color = colors[selectedIndex];
		setIcon(icon);
		if (icon != null) {
		setText(selectedColor);
		setFont(list.getFont());
		}
		 
		return this;
	}
}