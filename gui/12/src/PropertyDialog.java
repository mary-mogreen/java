package src;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PropertyDialog
	extends Dialog
	implements ActionListener {

	Properties props;

	PropertyDialog(Frame frame, Properties props) {
		super(frame, "Property");
		this.props = props;
		setSize(500, 400);
		setVisible(true);
		setLayout(new GridLayout(1, 1));



		Panel font = new Panel();
		font.setLayout(new GridLayout(2, 1));

		Panel fontConfig = new Panel();
		fontConfig.setLayout(new GridLayout(5, 1));
		BackgroundColorSelector bcs = new BackgroundColorSelector(props);
		add(bcs);
		fontConfig.add(bcs);

		ColorSelector cs = new ColorSelector(props);
	    fontConfig.add(cs);


	    FontSizer fs = new FontSizer(props);
	    fontConfig.add(fs);

	    FontFamilySelector ffs = new FontFamilySelector(props);
	    fontConfig.add(ffs);

	    FontStyleSelector fss = new FontStyleSelector(props);
	    fontConfig.add(fss);

	    //font.add(new Label("Font"));
	    //font.add(fontConfig);

	    add(fontConfig);

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
}
