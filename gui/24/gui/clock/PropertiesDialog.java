package gui.clock;
/**
 * 
 */


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.clock.color.ColorBuilder;
import gui.clock.color.ColorIcon;
import gui.clock.listener.BackgroundColorChangeListener;
import gui.clock.listener.FlipColorChangeListener;
import gui.clock.listener.FontColorChangeListener;
import gui.clock.listener.FontFamilyChangeListener;
import gui.clock.listener.FontSizeChangeListener;
import gui.clock.util.ComboBoxRenderer;




/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class PropertiesDialog extends JDialog implements ActionListener {
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray", "original"};
	private Integer[] index = new Integer[colors.length];
	private ColorIcon[] icons = new ColorIcon[colors.length];
	{
		for (int i = 0; i < colors.length; i++) {
			index[i] = i;
			icons[i] = new ColorIcon(ColorBuilder.toColor(colors[i]));
		}
	}
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}
	private JFrame frame;
	private WatchProperties props = WatchProperties.getInstance();
	private final Font f = props.getFontFamily();
	private final int sz = props.getFontSize();
	private final Color c = props.getColor();
	private final Color bg = props.getBgColor(); 
	private final Color flip = props.getFlipColor();
	
	
	public PropertiesDialog(JFrame owner) {
		super(owner, "Properties", true);
		frame = owner;
		this.setSize(new Dimension(400, 400));
		JPanel main = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		main.setLayout(layout);
		setResizable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.EAST;
		JLabel fontLabel = new JLabel("フォント");
		layout.setConstraints(fontLabel, gbc);
		gbc.gridy = 1;
		JLabel fontSizeLabel = new JLabel("フォントサイズ");
		layout.setConstraints(fontSizeLabel, gbc);
		gbc.gridy = 2;
		JLabel colorLabel = new JLabel("文字色");
		layout.setConstraints(colorLabel, gbc);
		gbc.gridy = 3;
		JLabel bgColorLabel = new JLabel("背景色");
		layout.setConstraints(bgColorLabel, gbc);
		gbc.gridy = 4;
		JLabel flipColorLabel = new JLabel("パタパタ色");
		layout.setConstraints(flipColorLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		// Choice fontChoice = new Choice();
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		List<String> fontNames = new ArrayList<>();
        for (Font f: g.getAllFonts()) {	
        	fontNames.add(f.getFontName());
        }
        JComboBox<String> fontChoice = new JComboBox<>(fontNames.toArray(new String[0]));
        fontChoice.addActionListener(new FontFamilyChangeListener(fontChoice));
        fontChoice.setSelectedItem(props.getFontFamily().getFontName());
		layout.setConstraints(fontChoice, gbc);
				
		gbc.gridy = 1;
		JComboBox<String> fontSizeChoice = new JComboBox<>(sizes);
		fontSizeChoice.addItemListener(new FontSizeChangeListener(fontSizeChoice));
		fontSizeChoice.setSelectedItem(props.getFontSize() + "");
		layout.setConstraints(fontSizeChoice, gbc);
		
		gbc.gridy = 2;
		JComboBox<String> colorChoice = new JComboBox<>(colors);
		ComboBoxRenderer renderer = new ComboBoxRenderer(icons, colors);
		// renderer.setPreferredSize(new Dimension(100, 30));
		colorChoice.setRenderer(renderer);
		// colorChoice.setMaximumRowCount(icons.length);
		colorChoice.addActionListener(new FontColorChangeListener(colorChoice));
		layout.setConstraints(colorChoice, gbc);
		
		gbc.gridy = 3;
		JComboBox<String> bgColorChoice = new JComboBox<>(colors);
		bgColorChoice.setRenderer(renderer);
		layout.setConstraints(bgColorChoice, gbc);
		bgColorChoice.addActionListener(new BackgroundColorChangeListener(bgColorChoice));
		
		gbc.gridy = 4;
		JComboBox<String> flipColorChoice = new JComboBox<>(colors);
		flipColorChoice.setRenderer(renderer);
		flipColorChoice.addActionListener(new FlipColorChangeListener(flipColorChoice));
		layout.setConstraints(flipColorChoice, gbc);
		
		colorChoice.setSelectedItem(ColorBuilder.toString(props.getColor()));
		bgColorChoice.setSelectedItem(ColorBuilder.toString(props.getBgColor()));
		flipColorChoice.setSelectedItem(ColorBuilder.toString(props.getFlipColor()));

		
		main.add(fontLabel);
		main.add(fontChoice);
		main.add(fontSizeLabel);
		main.add(fontSizeChoice);
		main.add(colorLabel);
		main.add(colorChoice);
		main.add(bgColorLabel);
		main.add(bgColorChoice);
		main.add(flipColorLabel);
		main.add(flipColorChoice);
		
		setLayout(new BorderLayout());
		add(BorderLayout.CENTER, main);
		JPanel bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(e -> {
			props.setFontFamily(f);
			props.setFontSize(sz);
			props.setColor(c);
			props.setBgColor(bg);
			props.setFlipColor(flip);
			setVisible(false);
		});
		JButton ok = new JButton("OK");
		ok.addActionListener(e -> {
			setVisible(false);
		});
		bottom.add(BorderLayout.WEST, cancel);
		bottom.add(BorderLayout.EAST, ok);
		add(BorderLayout.SOUTH, bottom);
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			setVisible(false);
    		}
    	});
		System.out.println(this.getComponentCount());
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

}
