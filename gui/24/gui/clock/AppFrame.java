package gui.clock;
/**
 *
 */


import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.WindowConstants;




/**
 * @author mary-mogreen
 *
 */
@SuppressWarnings("serial")
public class AppFrame extends JFrame implements ActionListener {
	ClockCanvas canvas;
	private JMenuItem exitMenu;
	private int pressedX;
	private int pressedY;
	private PropertiesDialog dialog;
	private JMenuBar menubar;
	private JMenuItem menuitem;
	WatchProperties props = WatchProperties.getInstance();

	public AppFrame(ClockCanvas canvas) {
		super(null, null);
		this.canvas = canvas;
		
		// MenuBar
		 menubar = new JMenuBar();
    	 JMenu menu = new JMenu("設定");
    	 JMenuItem menuitem = new JMenuItem("プロパティ");
    	 menuitem.addActionListener(e -> {
  		 	dialog = new PropertiesDialog(this);
  		 	dialog.setVisible(true);
    	 });
    	 menu.add(menuitem);
    	 menubar.add(menu);
    	 setJMenuBar(menubar);

        // Frame configuration
        setLayout(new BorderLayout());
        addWindowListener(new AppCloseAdapter());
        // setIgnoreRepaint(true);
        add(canvas, BorderLayout.CENTER);
        setAlwaysOnTop(true);

        // Menu configuration
        WatchPopupMenu wp = new WatchPopupMenu();
        JPopupMenu popupMenu = wp.getPopupMenu();

        // exitメニュー
        exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(this);
        popupMenu.add(exitMenu);

        pack();
        canvas.add(popupMenu);
        canvas.addMouseListener(new AppMouseAdapter(popupMenu));
        canvas.addMouseMotionListener(new AppMouseMotionAdapter());
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

	class AppMouseAdapter extends MouseAdapter {

        JPopupMenu popupMenu;

        public AppMouseAdapter(JPopupMenu popupMenu) {
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

	class AppMouseMotionAdapter extends MouseMotionAdapter {
	    @Override
	    public void mouseDragged(MouseEvent e) {
	    	setLocation(getX() + e.getX() - pressedX, getY() + e.getY()
            - pressedY);
	    }
	}
}

class AppCloseAdapter extends WindowAdapter {
	@Override
    public void windowClosing(WindowEvent e) {
		WatchProperties props = WatchProperties.getInstance();
		props.setDimension(e.getWindow().getSize());
		props.setLocation(e.getWindow().getLocation());
		props.update();
        System.exit(0);
    }
}
