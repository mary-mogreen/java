package src;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog
	extends Dialog
	implements ActionListener, ItemListener {

	Properties props;

	PropertyDialog(Frame frame, Properties props) {
		super(frame, "Property");
		this.props = props;
		setSize(300, 150);
		setVisible(true);
		Choice c = new Choice();
	    c.add("black");
	    c.add("white");
	    c.add("red");
	    c.add("blue");
	    c.add("yellow");
	    c.add("green");
	    c.add("pink");
	    c.add("orange");
	    c.add("gray");
	    add(c);
	    c.addItemListener(this);
		addWindowListener(new WindowAdapter() {
    		public void windowClosing(WindowEvent e) {
    			dispose();
    		}
    	});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Choice choice = (Choice)e.getItemSelectable();
		switch(choice.getSelectedItem()) {
			case "black":
				props.setColor(Color.BLACK);
				break;
			case "white":
				props.setColor(Color.WHITE);
				break;
			case "red":
				props.setColor(Color.RED);
				break;
			case "blue":
				props.setColor(Color.BLUE);
				break;
			case "yellow":
				props.setColor(Color.YELLOW);
				break;
			case "green":
				props.setColor(Color.GREEN);
				break;
			case "orange":
				props.setColor(Color.ORANGE);
				break;
			case "pink":
				props.setColor(Color.PINK);
				break;
			case "gray":
				props.setColor(Color.GRAY);
				break;
			default:
				//Nothing.
		}
	}
}
