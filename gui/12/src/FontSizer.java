/**
 *
 */
package src;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



/**
 * @author p000526463
 *
 */
public class FontSizer extends Panel {
	public class downButtonAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int size = Integer.parseInt(fontSize);
			if (size - 1 > 7) {
				size--;
				fontSize = "" + size;
				tf.setText(fontSize);
				props.setFontSize(size);
			}

		}

	}

	/**
		 * @author p000526463
		 *
		 */
	public class upButtonAction implements ActionListener {

		/* (非 Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			int size = Integer.parseInt(fontSize);
			if (size + 1 < 81) {
				size++;
				fontSize = "" + size;
				tf.setText(fontSize);
				props.setFontSize(size);
			}
		}

	}

	/**
		 * @author p000526463
		 *
		 */
	public class TextAction implements ActionListener {

		/* (非 Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				int size = Integer.parseInt(tf.getText());
				if (size < 7 || size > 80) {
					tf.setText(fontSize);
				} else {
					//変更成功
					props.setFontSize(size);
				}
			} catch (NumberFormatException ne) {
				tf.setText(fontSize);
			}
		}

	}

	private Properties props;
	private String fontSize;
	private TextField tf;
	private Button upButton;
	private Button downButton;

	public FontSizer(Properties props2) {
		super();
		this.props = props2;
		this.fontSize = "" + props2.getFontSize();
		//setSize(500, 50);
		Panel p = new Panel();
		p.setLayout(new GridLayout(1, 3));
		tf = new TextField(this.fontSize);
		upButton = new Button("↑");
		downButton = new Button("↓");
		setLayout(new GridLayout(2, 1));
		p.add(tf);
		p.add(upButton);
		p.add(downButton);

		add(new Label("font size"));
		add(p);

		tf.addActionListener(new TextAction());
		upButton.addActionListener(new upButtonAction());
		downButton.addActionListener(new downButtonAction());
	}
}
