/**
 * 
 */
package patapatawatch;

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



/**
 * @author katouyuuya
 *
 */
@SuppressWarnings("serial")
public class PropertiesDialog extends Dialog implements ActionListener {
	private String[] colors = {"black", "white", "red", "blue", "green", "yellow", "orange", "pink", "cyan", "gray", "light gray", "dark gray", "original"};
	private String[] sizes;
	{
		sizes = new String[24];
		for (int i = 0; i < 24; i++) {
			sizes[i] = Integer.toString((i + 1) * 10);
		}
	}
	private Frame frame;
	private WatchProperties props = WatchProperties.getInstance();
	private final Font f = props.getFontFamily();
	private final int sz = props.getFontSize();
	private final Color c = props.getColor();
	private final Color bg = props.getBgColor(); 
	private final Color flip = props.getFlipColor();
	
	
	public PropertiesDialog(Frame owner) {
		super(owner, "Properties", true);
		frame = owner;
		this.setSize(new Dimension(400, 400));
		Panel main = new Panel();
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		main.setLayout(layout);
		setResizable(false);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = gbc.EAST;
		Label fontLabel = new Label("フォント");
		layout.setConstraints(fontLabel, gbc);
		gbc.gridy = 1;
		Label fontSizeLabel = new Label("フォントサイズ");
		layout.setConstraints(fontSizeLabel, gbc);
		gbc.gridy = 2;
		Label colorLabel = new Label("文字色");
		layout.setConstraints(colorLabel, gbc);
		gbc.gridy = 3;
		Label bgColorLabel = new Label("背景色");
		layout.setConstraints(bgColorLabel, gbc);
		gbc.gridy = 4;
		Label flipColorLabel = new Label("パタパタ色");
		layout.setConstraints(flipColorLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.anchor = gbc.WEST;
		Choice fontChoice = new Choice();
		GraphicsEnvironment g = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontChoice.addItemListener(new FontFamilyChangeListener(fontChoice));

        for (Font f: g.getAllFonts()) {	
        	fontChoice.addItem(f.getFontName());
        }
        fontChoice.select(props.getFontFamily().getFontName());
		layout.setConstraints(fontChoice, gbc);
				
		gbc.gridy = 1;
		Choice fontSizeChoice = new Choice();
		fontSizeChoice.addItemListener(new FontSizeChangeListener(fontSizeChoice));
		for (String s: sizes) {
        	fontSizeChoice.addItem(s);
        }
		fontSizeChoice.select(props.getFontSize() + "");
		layout.setConstraints(fontSizeChoice, gbc);
		gbc.gridy = 2;
		Choice colorChoice = new Choice();
		colorChoice.addItemListener(new FontColorChangeListener(colorChoice));
		layout.setConstraints(colorChoice, gbc);
		gbc.gridy = 3;
		Choice bgColorChoice = new Choice();
		layout.setConstraints(bgColorChoice, gbc);
		bgColorChoice.addItemListener(new BackgroundColorChangeListener(bgColorChoice, frame));
		gbc.gridy = 4;
		Choice flipColorChoice = new Choice();
		flipColorChoice.addItemListener(new FlipColorChangeListener(flipColorChoice));
		layout.setConstraints(flipColorChoice, gbc);
		
		for (String s: colors) {
        	colorChoice.addItem(s);
        	bgColorChoice.addItem(s);
        	flipColorChoice.addItem(s);
        }
		colorChoice.select(ColorBuilder.toString(props.getColor()));
		bgColorChoice.select(ColorBuilder.toString(props.getBgColor()));
		flipColorChoice.select(ColorBuilder.toString(props.getFlipColor()));

		
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
		Panel bottom = new Panel();
		bottom.setLayout(new BorderLayout());
		Button cancel = new Button("Cancel");
		cancel.addActionListener(e -> {
			props.setFontFamily(f);
			props.setFontSize(sz);
			props.setColor(c);
			props.setBgColor(bg);
			props.setFlipColor(flip);
			setVisible(false);
		});
		Button ok = new Button("OK");
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
