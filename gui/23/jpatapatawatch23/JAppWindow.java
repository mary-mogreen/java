/**
 *
 */
package jpatapatawatch23;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;

import jpatapatawatch23.JAppCloseAdapter;
import jpatapatawatch23.JClockCanvas;
import jpatapatawatch23.JPropertiesDialog;
import jpatapatawatch23.JWatchProperties;



/**
 * @author mary-mogreen
 *
 */
@SuppressWarnings("serial")
public class JAppWindow extends JWindow implements ActionListener {
	JClockCanvas canvas;
	private JMenuItem exitMenu;
	private int pressedX;
	private int pressedY;
	private JPropertiesDialog dialog;
	private JMenuBar menubar;
	private JMenuItem menuitem;
	JWatchProperties props = JWatchProperties.getInstance();

	public JAppWindow(JClockCanvas canvas) {
		super(null, null);
		this.canvas = canvas;
		
		// MenuBar
		// menubar = new JMenuBar();
    	// JMenu menu = new JMenu("設定");
    	// JMenuItem menuitem = new JMenuItem("プロパティ");
    	// menuitem.addActionListener(e -> {
  		// 	dialog = new JPropertiesDialog(this);
  		// 	dialog.setVisible(true);
    	// });
    	// menu.add(menuitem);
    	// menubar.add(menu);
    	// setJMenuBar(menubar);

        // Frame configuration
        setLayout(new BorderLayout());
        addWindowListener(new JAppCloseAdapter());
        // setIgnoreRepaint(true);
        add(canvas, BorderLayout.CENTER);
        setAlwaysOnTop(true);

        // Menu configuration
        JWatchPopupMenu wp = new JWatchPopupMenu();
        JPopupMenu popupMenu = wp.getPopupMenu();

        // exitメニュー
        exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(this);
        popupMenu.add(exitMenu);

        pack();
        canvas.add(popupMenu);
        canvas.addMouseListener(new JAppMouseAdapter(popupMenu));
        canvas.addMouseMotionListener(new JAppMouseMotionAdapter());
        setLocationRelativeTo(null);
        setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
        if (source.equals(exitMenu)) {
        	props.setDimension(getSize());
    		props.setLocation(getLocation());
    		props.update();
        	System.exit(0);
        }
	}

	void resize() {
        pack();
    }

	class JAppMouseAdapter extends MouseAdapter {

        JPopupMenu popupMenu;

        public JAppMouseAdapter(JPopupMenu popupMenu) {
            this.popupMenu = popupMenu;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            pressedX = e.getX();
            pressedY = e.getY();
            if (e.isPopupTrigger())
                popupMenu.show(canvas, e.getX(), e.getY());
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mousePressed(e);
        }
    }

	class JAppMouseMotionAdapter extends MouseMotionAdapter {
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	setLocation(getX() + e.getX() - pressedX, getY() + e.getY()
            - pressedY);
	    }
	}
}

class JAppCloseAdapter extends WindowAdapter {
	@Override
    public void windowClosing(WindowEvent e) {
		JWatchProperties props = JWatchProperties.getInstance();
		props.setDimension(e.getWindow().getSize());
		props.setLocation(e.getWindow().getLocation());
		props.update();
        System.exit(0);
    }
}
